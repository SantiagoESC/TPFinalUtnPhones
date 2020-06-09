DROP TRIGGER IF EXISTS tbiCalculateInsertCall;

DELIMITER //

CREATE TRIGGER tbiCalculateInsertCall BEFORE INSERT ON calls FOR EACH ROW
BEGIN

    SET NEW.idCityOrigin = fCalculateCity(NEW.numberOrigin);
    SET NEW.idCityDestination = fCalculateCity(NEW.numberDestination);
    SET NEW.pricePerMinute = fCalculatePrice(NEW.idCityOrigin, NEW.idCityDestination);
    SET NEW.priceTotal = (NEW.duration/60)*NEW.priceMinute; 


END//

DELIMITER ;