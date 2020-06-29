DROP PROCEDURE IF EXISTS pliquidateActiveLines;
DELIMITER //
CREATE PROCEDURE  pliquidateActiveLines ()
BEGIN
    
    DECLARE vIdLine INTEGER;
    DECLARE vFinished INTEGER DEFAULT 0;
    DECLARE curLines CURSOR FOR SELECT idLine FROM phoneLines pl WHERE pl.statusLine ='ACTIVE' GROUP BY idLine ;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET vFinished = 1;
 

    OPEN curLines;
    FETCH curLines INTO vIdLine ;
    WHILE (vFinished=0) DO
        START TRANSACTION;
            CALL pliquidateLine(vIdLine);
        COMMIT;
        FETCH curLines INTO vIdLine;
    END WHILE;

    CLOSE curLines;
END//

DELIMITER ;
