DROP SCHEMA IF EXISTS webshop;
CREATE SCHEMA webshop DEFAULT CHARACTER SET utf8;
USE webshop;

CREATE TABLE kategorije (
	id BIGINT AUTO_INCREMENT,
	naziv VARCHAR(45) NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE korisnici (
	korisnicko_ime VARCHAR(20),
	lozinka VARCHAR(20) NOT NULL,
	PRIMARY KEY(korisnicko_ime)
);

CREATE TABLE proizvodi (
	id BIGINT AUTO_INCREMENT,
	naziv VARCHAR(45) NOT NULL,
	cena DECIMAL(10, 2) NOT NULL,
	kategorija_id BIGINT NOT NULL,
	PRIMARY KEY(id),
	INDEX(kategorija_id),
	FOREIGN KEY(kategorija_id) REFERENCES kategorije(id)
		ON DELETE RESTRICT
);

CREATE TABLE korpe (
	korisnicko_ime VARCHAR(20),
	redni_broj_stavke INT, 
	proizvod_id BIGINT NOT NULL,
	komada INT NOT NULL,
	PRIMARY KEY(korisnicko_ime, redni_broj_stavke), 
	FOREIGN KEY(korisnicko_ime) REFERENCES korisnici(korisnicko_ime)
		ON DELETE RESTRICT,
	FOREIGN KEY(proizvod_id) REFERENCES proizvodi(id)
		ON DELETE RESTRICT
);

INSERT INTO kategorije (naziv) VALUES ('hrana');
INSERT INTO kategorije (naziv) VALUES ('napitak');
INSERT INTO kategorije (naziv) VALUES ('odelo');
INSERT INTO kategorije (naziv) VALUES ('cipele');

INSERT INTO korisnici (korisnicko_ime, lozinka) VALUES ('a', 'a');
INSERT INTO korisnici (korisnicko_ime, lozinka) VALUES ('b', 'b');

INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('mlad grašak', 75.00, 1);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('sok od jabuke', 90.00, 2);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('suncokretovo ulje', 120.00, 1);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('muške cipele', 5000.00, 4);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('muški sako', 7000.00, 3);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('dečije sandale', 2500.00, 4);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('sok od narandže', 100.00, 2);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('haljina', 8000.00, 3);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('ženske cipele', 5500.00, 4);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('džemper', 4000.00, 3);
INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES ('zelena salata', 50.00, 1);
