DROP VIEW vCallReport;
CREATE VIEW vCallReport AS
SELECT
    ca.numberOrigin, co.nameCity as cityOrigin, ca.numberDestination, cd.nameCity as cityDestination,
    ca.priceTotal, ca.durationInSeconds as DurationCall, ca.dateCall, pl.idUser
FROM
calls ca INNER JOIN cities co ON ca.idCityOrigin = co.idCity 
    INNER JOIN cities cd ON ca.idCityDestination = cd.idCity
    INNER JOIN phoneLines pl ON pl.numberLine = ca.numberOrigin
;


SELECT  cityDestination, count(cityDestination) as cant from vCallReport vc where vc.idUser  = 1 group by cityDestination order by cant desc limit 10;

SELECT *  from vCallReport vc where vc.idUser  = 1 AND vc.dateCall BETWEEN '2019-12-03' AND '2020-12-03';