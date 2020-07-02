select concat(uo.firstName," ",uo.lastName) as full_name_o ,uo.dni as dni_user_origin, concat(co.prefix,po.numberLine) as origin_line, pro.nameProvince as origin_province, co.nameCity as origin_city, 
concat(ud.firstName," ",ud.lastName) as full_name_d, ud.dni as dni_user_destination, concat(cd.prefix,pd.numberLine) as destination_line, cd.nameCity as destination_city, c.durationInSeconds, c.priceTotal, (c.costPerMinute*c.durationInSeconds/60), c.dateCall, c.idBill
from calls c 
inner join phoneLines po on c.idLineOrigin = po.idLine 
inner join users uo on po.idUser = uo.idUser 
inner join cities co on uo.idCity = co.idCity
inner join provinces pro on pro.idProvince = co.idProvince
inner join phoneLines pd on c.idLineDestination = pd.idLine
inner join users ud on pd.idUser = ud.idUser 
inner join cities cd on ud.idCity = cd.idCity order by dateCall;


/*Hacer el parse exception en la advice*/


SELECT
    idCall,
    priceTotal,
    (costPerMinute * durationInSeconds / 60) AS costTotal
FROM
    calls c
    INNER JOIN phoneLines pl ON c.numberOrigin = pl.numberLine
WHERE
    idBill IS NULL && pl.idLine = 1
GROUP BY
    idCall,
    priceTotal;


    SELECT
    idCall,
    priceTotal,
    (costPerMinute * durationInSeconds / 60) AS costTotal
FROM
    calls c
    INNER JOIN phoneLines pl ON c.numberOrigin = pl.numberLine
WHERE
    idBill IS NULL && pl.idLine = 2
GROUP BY
    idCall,
    priceTotal;


    SELECT * FROM calls c INNER JOIN phoneLines pl ON pl.numberLine = c.numberOrigin WHERE idUser = 1;
