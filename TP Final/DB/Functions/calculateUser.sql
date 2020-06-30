DROP FUNCTION IF EXISTS fCalculateUser ;

DELIMITER //

CREATE FUNCTION fCalculateUser (pIdLine INTEGER)
RETURNS INTEGER
NOT DETERMINISTIC READS SQL DATA
BEGIN

    DECLARE vIdUser INTEGER DEFAULT 0;

    SELECT

        pl.idUser

    FROM

        phoneLines pl

    WHERE

        pl.idLine = pIdLine

    GROUP BY

        pl.idUser


    INTO

        vIdUser
    ;

    IF(vIdUser = 0) THEN
        SET @asd = CONCAT('Error findig user of line: ',pIdLine);
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = @asd , MYSQL_ERRNO = '1';  

    END IF;

    RETURN vIdUser;

END//

DELIMITER ;
