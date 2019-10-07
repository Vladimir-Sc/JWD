DROP SCHEMA IF EXISTS banka;
CREATE SCHEMA banka DEFAULT CHARACTER SET utf8;
USE banka;

CREATE TABLE racuni (
	id BIGINT AUTO_INCREMENT, 
    sifra VARCHAR(20) UNIQUE NOT NULL, 
    vlasnik VARCHAR(50) NOT NULL, 
    stanje DECIMAL(10, 2) DEFAULT 0.0, 
    raspolozivoStanje DECIMAL(10, 2) DEFAULT 0.0, 

    PRIMARY KEY(id)
);

CREATE TABLE nalozi (
	id BIGINT AUTO_INCREMENT, 
    uplatilac BIGINT NOT NULL, 
    primalac BIGINT NOT NULL, 
    kreiran DATETIME NOT NULL, 
    iznos DECIMAL(10, 2) NOT NULL, 
    realizovan DATETIME, 

	PRIMARY KEY(id), 
    FOREIGN KEY(uplatilac) REFERENCES racuni(id), 
    FOREIGN KEY(primalac) REFERENCES racuni(id)
);

INSERT INTO racuni (id, sifra, vlasnik, stanje, raspolozivoStanje) VALUES (1, '1a', 'a', 200.0, 0.0);
INSERT INTO racuni (id, sifra, vlasnik, stanje, raspolozivoStanje) VALUES (2, '2b', 'b', 300.0, 0.0);
INSERT INTO racuni (id, sifra, vlasnik, stanje, raspolozivoStanje) VALUES (3, '3c', 'c', 0.0, 500.0);
INSERT INTO racuni (id, sifra, vlasnik, stanje, raspolozivoStanje) VALUES (4, '4d', 'd', 150.0, 150.0);
INSERT INTO racuni (id, sifra, vlasnik, stanje, raspolozivoStanje) VALUES (5, '5e', 'e', 0.0, 0.0);

INSERT INTO nalozi (uplatilac, primalac, kreiran, iznos, realizovan) VALUES (1, 2, '2017-09-01 01:00:00', 100.0, '2017-09-01 23:59:00');
INSERT INTO nalozi (uplatilac, primalac, kreiran, iznos, realizovan) VALUES (1, 3, '2017-09-02 02:00:00', 200.0, NULL);
INSERT INTO nalozi (uplatilac, primalac, kreiran, iznos, realizovan) VALUES (2, 3, '2017-09-03 03:00:00', 300.0, NULL);