DROP DATABASE IF EXISTS test;

CREATE DATABASE IF NOT EXISTS test;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS provinces; 

CREATE TABLE IF NOT EXISTS provinces (
    idProvince INTEGER AUTO_INCREMENT,
    nameProvince VARCHAR(50) NOT NULL,
    CONSTRAINT pk_provinces PRIMARY KEY (idProvince),
    CONSTRAINT unq_name_province UNIQUE  (nameProvince)
);



DROP TABLE IF EXISTS cities;
CREATE TABLE IF NOT EXISTS cities(
    idCity INTEGER AUTO_INCREMENT,
    nameCity VARCHAR(50) NOT NULL,
    prefix VARCHAR(5) NOT NULL,
    idProvince INTEGER NOT NULL,

    CONSTRAINT pk_cities PRIMARY KEY (idCity),
    CONSTRAINT unq_prefix_city UNIQUE(prefix),
    CONSTRAINT fk_city_province FOREIGN KEY (idProvince) REFERENCES provinces (idProvince)
);



DROP TABLE IF EXISTS rates ;
CREATE TABLE IF NOT EXISTS rates(
    idRate INTEGER AUTO_INCREMENT,
    idCityOrigin INTEGER NOT NULL,
    idCityDestination INTEGER NOT NULL,
    pricePerMinute FLOAT NOT NULL,

    CONSTRAINT pk_rates PRIMARY KEY(idRate),
    CONSTRAINT fk_origin_cities FOREIGN KEY (idCityOrigin) REFERENCES cities(idCity), 
    CONSTRAINT fk_destination_cities FOREIGN KEY (idCityDestination) REFERENCES cities(idCity)
);



SET FOREIGN_KEY_CHECKS = 1;