DROP SCHEMA IF EXISTS pregledi;
CREATE SCHEMA pregledi DEFAULT CHARACTER SET utf8;
USE pregledi;

CREATE TABLE pregledi (
	id BIGINT NOT NULL AUTO_INCREMENT, 
	lboPacijenta VARCHAR(11) UNIQUE NOT NULL, 
	imePacijenta VARCHAR(20) NOT NULL, 
	prezimePacijenta VARCHAR(20) NOT NULL, 
    datumVremeRodjenjaPacijenta DATETIME NOT NULL, 
    datumPregleda DATE NOT NULL, 
    zakazanoVremePregleda TIME NOT NULL, 
    tacanDatumVremePregleda DATETIME, 
    izvestaj VARCHAR(1000), 
    PRIMARY KEY (id)
);

INSERT INTO pregledi (lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda, tacanDatumVremePregleda, izvestaj) VALUES ('a', 'a', 'a', '1950-01-01 00:30', '2018-09-01', '12:00', '2018-09-01 12:30', 'a');
INSERT INTO pregledi (lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda) VALUES ('b', 'b', 'b', '1960-01-01 01:30', '2018-10-01', '13:00');
INSERT INTO pregledi (lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda) VALUES ('c', 'c', 'c', '1970-01-01 02:30', '2018-11-01', '14:00');
