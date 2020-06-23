DROP PROCEDURE IF EXISTS pLiquidateLine ;

DELIMITER //

CREATE PROCEDURE pLiquidateLine(pIdLine INTEGER)
BEGIN
    
    DECLARE vFinished INTEGER DEFAULT 0;

    DECLARE unliquidatedCalls CURSOR FOR

    SELECT

        *

    FROM

        calls c

    WHERE 

        c.idLineOrigin = pIdLine AND c.idBill IS NULL

    
    ;        

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET vFinished = 1;


    INSERT INTO bills ()

    
    

END//
DELIMITER ;


call pLiquidateLine(1)