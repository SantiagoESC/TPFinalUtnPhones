DROP TRIGGER IF EXISTS tbiCalculateInsertCall;

DELIMITER //

CREATE TRIGGER tbiCalculateInsertCall BEFORE INSERT ON calls FOR EACH ROW
BEGIN

    SET NEW.idCityOrigin = fCalculateCity(NEW.numberOrigin);
    SET NEW.idCityDestination = fCalculateCity(NEW.numberDestination);
    SET NEW.pricePerMinute = fCalculatePrice(NEW.idCityOrigin, NEW.idCityDestination);
    SET NEW.costPerMinute = fGetCostPerMinute();
    SET NEW.priceTotal = (NEW.durationInSeconds/60)*NEW.pricePerMinute;
    SET NEW.idLineOrigin = fCalculateLine(NEW.numberOrigin);
    SET NEW.IdLineDestination = fCalculateLine(NEW.numberDestination);


END//

DELIMITER ;
