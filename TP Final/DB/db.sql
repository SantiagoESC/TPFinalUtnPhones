DROP DATABASE IF EXISTS test;

CREATE DATABASE IF NOT EXISTS test;


USE test;

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



DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
    idUser INTEGER AUTO_INCREMENT,
    username VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    firstName VARCHAR(25) NOT NULL,
    lastName VARCHAR(25) NOT NULL,
    dni VARCHAR(25) NOT NULL,
    userType ENUM('CLIENT','EMPLOYEE') NOT NULL,
    idCity INTEGER NOT NULL, 


    CONSTRAINT pk_users PRIMARY KEY (idUser),
    CONSTRAINT unq_username UNIQUE(username),
    CONSTRAINT unq_dni UNIQUE(dni),
    CONSTRAINT fk_cities_rates FOREIGN KEY (idCity) REFERENCES cities(idCity)
    
);


DROP TABLE IF EXISTS phoneLines ;
CREATE TABLE IF NOT EXISTS phoneLines (
    idLine INTEGER AUTO_INCREMENT,
    numberLine VARCHAR(50) NOT NULL,
    typeLine ENUM('RESIDENTIAL', 'MOVILE') NOT NULL DEFAULT 'MOVILE',
    statusLine ENUM('ACTIVE', 'SUSPENDED') NOT NULL DEFAULT 'ACTIVE', 
    idUser INTEGER NOT NULL,

    CONSTRAINT pk_phonelines PRIMARY KEY (idLine),      
    CONSTRAINT unq_numberLine UNIQUE (numberLine),
    CONSTRAINT fk_user_phoneLines FOREIGN KEY (idUser) REFERENCES users(idUser)  
);



DROP TABLE IF EXISTS bills;
CREATE TABLE IF NOT EXISTS bills (
    idBill INTEGER AUTO_INCREMENT,
    idUser INTEGER NOT NULL ,
    idLine INTEGER NOT NULL,
    quantityOfCalls INTEGER NOT NULL DEFAULT 0,
    totalCost FLOAT NOT NULL DEFAULT 0,
    totalPrice FLOAT NOT NULL DEFAULT 0,
    dateBill DATETIME NOT NULL DEFAULT NOW(),
    dateExpiration DATETIME NOT NULL DEFAULT (CURRENT_DATE + INTERVAL 15 DAY),
    isPaidBill BOOLEAN NOT NULL DEFAULT FALSE,


    CONSTRAINT pk_bills PRIMARY KEY (idBill),
    CONSTRAINT fk_users_bills FOREIGN KEY(idUser) REFERENCES users(idUser),
    CONSTRAINT fk_line_bills FOREIGN KEY(idLine) REFERENCES phoneLines(idLine)
);


DROP TABLE IF EXISTS calls;
CREATE TABLE IF NOT EXISTS calls (
    idCall INTEGER AUTO_INCREMENT,
    idBill INTEGER ,
    numberOrigin VARCHAR(15) NOT NULL,
    numberDestination  VARCHAR(15) NOT NULL,
   
    idCityOrigin INTEGER NOT NULL,
    idCityDestination INTEGER NOT NULL,
    durationInSeconds INTEGER NOT NULL,
    pricePerMinute FLOAT NOT NULL,
    costPerMinute FLOAT NOT NULL DEFAULT 0.5,
    priceTotal FLOAT NOT NULL,
    dateCall DATETIME NOT NULL DEFAULT NOW(),

    CONSTRAINT pk_calls PRIMARY KEY (idCall),
    CONSTRAINT fk_bills_calls FOREIGN KEY (idBill) REFERENCES bills(idBill),
    CONSTRAINT fk_origin_cities_calls FOREIGN KEY (idCityOrigin) REFERENCES cities(idCity),
    CONSTRAINT fk_destination_cities_calls FOREIGN KEY (idCityDestination) REFERENCES cities(idCity)
    

);



SET FOREIGN_KEY_CHECKS = 1;
