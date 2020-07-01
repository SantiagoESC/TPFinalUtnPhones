USE test;

SET FOREIGN_KEY_CHECKS = 0;

SELECT
    Concat('TRUNCATE TABLE ', TABLE_NAME, ';')
FROM
    INFORMATION_SCHEMA.TABLES
WHERE
    table_schema = 'test';




INSERT INTO provinces (nameProvince) VALUES ('Buenos Aires');
INSERT INTO provinces (nameProvince) VALUES ('Cordoba');

INSERT INTO cities (nameCity, prefix, idProvince) VALUES ( 'Mar del Plata', '223', 1),
 ( 'Miramar ', '2234', 1),
 ( 'CABA', '11', 1),
 ( 'Cordoba', '543', 2);


INSERT INTO rates (idCityOrigin, idCityDestination, pricePerMinute)
SELECT  O.idCity, D.idCity, 10
from cities as O, cities as D;

INSERT INTO users (username, password, firstName,lastName, dni, userType,idCity) VALUES ('abulzomi', '1234', 'Agustin', 'Bulzomi', '42587965', 'EMPLOYEE',1),
( 'sescribas', '1234', 'Santiago', 'Escribas', '40256492', 'EMPLOYEE',1);

INSERT INTO phoneLines (numberLine, typeLine,statusLine, idUser) VALUES ( '2235863779', 'MOVILE', 'ACTIVE', 1),
( '2234211434', 'MOVILE', 'ACTIVE', 2);




INSERT INTO calls (numberOrigin, numberDestination, durationInseconds, dateCall)
VALUES  ('2235863779', '2234211434', 180, '2020-03-15'),
        ('2234211434','2235863779',  240, NOW()),
        ('2235863779', '2234211434', 60, NOW()),
        ('2235863779', '2234211434', 120, NOW());