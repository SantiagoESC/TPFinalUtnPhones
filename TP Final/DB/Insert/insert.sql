USE test;

SET FOREIGN_KEY_CHECKS = 0;

SELECT
    Concat('TRUNCATE TABLE ', TABLE_NAME, ';')
FROM
    INFORMATION_SCHEMA.TABLES
WHERE
    table_schema = 'test';




INSERT INTO provinces VALUES (NULL, 'Buenos Aires');
INSERT INTO provinces VALUES (NULL, 'Cordoba');

INSERT INTO cities VALUES (NULL, 'Mar del Plata', '223', 1); 
INSERT INTO cities VALUES (NULL, 'Miramar ', '2234', 1); 
INSERT INTO cities VALUES(NULL, 'CABA', '11', 1); 
INSERT INTO cities VALUES (NULL, 'Cordoba', '543', 2);


INSERT INTO rates
SELECT NULL, O.idCity, D.idCity, 10
from cities as O, cities as D;

INSERT INTO users VALUES (null, 'abulzomi', '1234', 'Agustin', 'Bulzomi', '42587965', 'EMPLOYEE',1);
INSERT INTO users VALUES (null, 'sescribas', '1234', 'Santiago', 'Escribas', '40256492', 'EMPLOYEE',1);

INSERT INTO phoneLines VALUES (null, '2235863779', 'MOVILE', 'ACTIVE', 1);

INSERT INTO phoneLines VALUES (null, '2234211434', 'MOVILE', 'ACTIVE', 2);

INSERT INTO calls (numberOrigin, numberDestination, durationInseconds, dateCall)
VALUES  ('2235863779', '2234211434', 180, NOW()),
        ('2234211434','2235863779',  240, NOW()),
        ('2235863779', '2234211434', 60, NOW()),
        ('2235863779', '2234211434', 120, NOW());