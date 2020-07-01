DROP PROCEDURE IF EXISTS pliquidateLine;

#CREAR bill CURSORES
DELIMITER / / CREATE PROCEDURE pliquidateLine (pIdline int) BEGIN DECLARE vTotal float;

DECLARE vTotalCost float;

DECLARE vIdbill int;

DECLARE vIdcall int;

DECLARE vCant int DEFAULT 0;

DECLARE vFinished int DEFAULT 0;

DECLARE vSuma float DEFAULT 0;

DECLARE vSumaCost float DEFAULT 0;

DECLARE vDummy int;

DECLARE curbill CURSOR FOR
SELECT
    idCall,
    priceTotal,
    (costPerMinute * durationInSeconds / 60) AS costTotal
FROM
    calls c
WHERE
    idBill IS NULL & & c.idLineOrigin = pIdline
GROUP BY
    idCall,
    priceTotal;

DECLARE CONTINUE HANDLER FOR NOT FOUND
SET
    vFinished = 1;

#Se inserta la bill pero en 0 asi se puede updatear luego
INSERT INTO
    bills(idLine, dateBill, idUser, totalPrice)
VALUES
    (pIdline, NOW(), fCalculateUser(pIdline), 0);

#Se toma el idbill
SET
    vIdbill = LAST_INSERT_ID();

OPEN curbill;

FETCH curbill INTO vIdcall,
vTotal,
vTotalCost;

WHILE (vFinished = 0) DO #se suman los datos de las calls
SET
    vSumaCost = vSumaCost + vTotalCost;

SET
    vSuma = vSuma + vTotal;

SET
    vCant = vCant + 1;

UPDATE
    calls
SET
    idBill = vIdbill
WHERE
    idCall = vIdcall;

FETCH curbill INTO vIdcall,
vTotal,
vTotalCost;

END while;

UPDATE
    bills
SET
    quantityOfCalls = vCant,
    totalPrice = vSuma,
    totalCost = vSumaCost
WHERE
    idbill = vIdbill;

CLOSE curbill;

END / / DELIMITER;