DROP FUNCTION IF EXISTS fCalculatePrice;

DELIMITER //
CREATE FUNCTION  fCalculatePrice (pIdOrigin INTEGER, pIdDestination INTEGER)
RETURNS INTEGER
NOT DETERMINISTIC READS SQL DATA
BEGIN
    
    DECLARE vPrice FLOAT DEFAULT 0;

        SELECT 
            r.pricePerMinute 
            
        FROM 
                rates r 
                
        WHERE
        
         r.idCityOrigin = pIdOrigin AND r.idCityDestination = pIdDestination

        GROUP BY

            r.pricePerMinute

        INTO vPrice;

    IF (vPrice = 0) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error finding price per minute to apply to new call', MYSQL_ERRNO = '1';
    END IF;

    RETURN vPrice;

END//
DELIMITER ; 
