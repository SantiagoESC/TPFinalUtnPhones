EXPLAIN
SELECT
    call0_.idCall AS idcall1_1_,
    call0_.idBill AS idbill9_1_,
    call0_.idCityDestination AS idcityd10_1_,
    call0_.idCityOrigin AS idcityo11_1_,
    call0_.costPerMinute AS costperm2_1_,
    call0_.dateCall AS datecall3_1_,
    call0_.durationInSeconds AS duration4_1_,
    call0_.idLineDestination AS idlined12_1_,
    call0_.idLineOrigin AS idlineo13_1_,
    call0_.numberDestination AS numberde5_1_,
    call0_.numberOrigin AS numberor6_1_,
    call0_.pricePerMinute AS priceper7_1_,
    call0_.priceTotal AS pricetot8_1_
FROM
    calls CALL0_
    CROSS JOIN phoneLines phoneline1_
WHERE
    call0_.idLineOrigin = phoneline1_.idLine
    AND phoneline1_.idUser = 1;