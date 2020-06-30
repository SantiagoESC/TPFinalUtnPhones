explain select
    call0_.idCall as idcall1_1_,
    call0_.idBill as idbill9_1_,
    call0_.idCityDestination as idcityd10_1_,
    call0_.idCityOrigin as idcityo11_1_,
    call0_.costPerMinute as costperm2_1_,
    call0_.dateCall as datecall3_1_,
    call0_.durationInSeconds as duration4_1_,
    call0_.idLineDestination as idlined12_1_,
    call0_.idLineOrigin as idlineo13_1_,
    call0_.numberDestination as numberde5_1_,
    call0_.numberOrigin as numberor6_1_,
    call0_.pricePerMinute as priceper7_1_,
    call0_.priceTotal as pricetot8_1_
from
    calls call0_
    cross join phoneLines phoneline1_
where
    call0_.idLineOrigin = phoneline1_.idLine
    and phoneline1_.idUser = 1;