DROP SCHEMA IF EXISTS studentskasluzba;
CREATE SCHEMA studentskasluzba DEFAULT CHARACTER SET utf8;
USE studentskasluzba;

CREATE TABLE grad (
	ptt INT,
    naziv VARCHAR(20) NOT NULL, 
    PRIMARY KEY (ptt)
);

CREATE TABLE studenti (
	student_id INT AUTO_INCREMENT,
    ime VARCHAR(20) NOT NULL, 
    prezime VARCHAR(20) NOT NULL, 
    indeks VARCHAR(10) UNIQUE NOT NULL, # obično indeksiranje bi se napravilo ključnom rečju INDEX
    PRIMARY KEY (student_id)
);

INSERT INTO grad (ptt, naziv) VALUES (21000, 'Novi Sad');
INSERT INTO grad (ptt, naziv) VALUES (24000, 'Subotica');
INSERT INTO grad (ptt, naziv) VALUES (34000, 'Kragujevac');

INSERT INTO studenti (ime, prezime, indeks) VALUES ('a', 'a', 'a'); # auto-increment primarni ključ ne mora da se navede
INSERT INTO studenti (ime, prezime, indeks) VALUES ('b', 'b', 'b');
INSERT INTO studenti (ime, prezime, indeks) VALUES ('c', 'c', 'c');
