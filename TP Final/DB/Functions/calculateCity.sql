DROP FUNCTION IF EXISTS fCalculateCity;

DELIMITER //
CREATE FUNCTION  fCalculateCity (pNumber VARCHAR(25) )
RETURNS INTEGER
 NOT DETERMINISTIC READS SQL DATA
BEGIN
    DECLARE vIdCity INTEGER;
    DECLARE vCount INTEGER;

    SELECT

        COUNT(*)

    FROM

        cities c

    WHERE

        pNumber LIKE CONCAT(c.prefix, '%')

    ORDER BY

        LENGTH(c.prefix) DESC
        
    LIMIT
        1
    INTO
        vCount
    ;


    IF (vCount = 0) THEN

        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error finding city', MYSQL_ERRNO = '1';

    ELSE

        SELECT
            idCity 
        FROM
            cities c
        WHERE
            pNumber LIKE CONCAT(c.prefix, '%')
        ORDER BY
            LENGTH(c.prefix) DESC
        LIMIT
            1
        INTO
            vIdCity
        ;

    END IF;
RETURN vIdCity;
END//
DELIMITER ; 