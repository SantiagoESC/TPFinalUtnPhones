CREATE INDEX idxPhoneLines ON
phoneLines (numberLine , idUser) USING HASH;


CREATE  INDEX idxCallDate ON calls(dateCall) USING BTREE;