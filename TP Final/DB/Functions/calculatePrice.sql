DROP FUNCTION IF EXISTS fCalculatePrice;

DELIMITER //
CREATE FUNCTION  fCalculatePrice (pIdOrigin INTEGER, pIdDestination INTEGER)
RETURNS INTEGER
NOT DETERMINISTIC READS SQL DATA
BEGIN
    
    DECLARE vPrice FLOAT;
    

    IF EXISTS (SELECT 1 FROM rates r WHERE r.idCityOrigin = pIdOrigin AND r.idCityDestination = pIdDestination ) THEN

        SELECT pricePerMinute FROM rates r WHERE r.idCityOrigin = pIdOrigin AND r.idCityDestination = pIdDestination
        INTO vPrice;

    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Error finding price', MYSQL_ERRNO = '1';
    END IF;

    RETURN vPrice;

END//
DELIMITER ; 