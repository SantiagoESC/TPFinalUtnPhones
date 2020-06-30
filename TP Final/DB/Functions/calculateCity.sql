DROP FUNCTION IF EXISTS fCalculateCity;

DELIMITER //
CREATE FUNCTION  fCalculateCity (pNumber VARCHAR(25) )
RETURNS INTEGER
 NOT DETERMINISTIC READS SQL DATA
BEGIN
    DECLARE vIdCity INTEGER DEFAULT 0;
    DECLARE vPrefix VARCHAR(5) DEFAULT '';


                SELECT
                    c.idCity, c.prefix  
                FROM
                    cities c
                WHERE
                    pNumber LIKE CONCAT(c.prefix, '%')

                GROUP BY

                    c.idCity,c.prefix  

                ORDER BY
                    LENGTH(c.prefix) DESC
                LIMIT
                    1
                INTO
                    vIdCity, vPrefix
                ;

        IF (vIdCity = 0) THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error finding city to match prefix of number', MYSQL_ERRNO = '1';
        END IF;

RETURN vIdCity;
END//
DELIMITER ; 
