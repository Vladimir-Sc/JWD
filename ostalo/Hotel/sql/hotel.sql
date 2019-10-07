DROP SCHEMA IF EXISTS hotel;
CREATE SCHEMA hotel DEFAULT CHARACTER SET utf8;
USE hotel;

CREATE TABLE sobe (
	id INT AUTO_INCREMENT, 
    tip ENUM('studio', 'suite', 'family room', 'interconnected rooms') NOT NULL, 
    brojKreveta INT NOT NULL, 
    cenaNocenja DECIMAL(10, 2)  NOT NULL, 

    PRIMARY KEY(id)
);

CREATE TABLE rezervacije (
	id BIGINT AUTO_INCREMENT, 
    soba INT NOT NULL, 
    ulazak DATETIME, 
    izlazak DATETIME, 
    gost VARCHAR(50) NOT NULL, 

	PRIMARY KEY(id), 
    FOREIGN KEY(soba) REFERENCES sobe(id)
);

INSERT INTO sobe (id, tip, brojKreveta, cenaNocenja) VALUES (1, 'studio', 2, 2000.0);
INSERT INTO sobe (id, tip, brojKreveta, cenaNocenja) VALUES (2, 'suite', 1, 2500.0);
INSERT INTO sobe (id, tip, brojKreveta, cenaNocenja) VALUES (3, 'family room', 4, 3500.0);
INSERT INTO sobe (id, tip, brojKreveta, cenaNocenja) VALUES (4, 'interconnected rooms', 2, 2500.0);
INSERT INTO sobe (id, tip, brojKreveta, cenaNocenja) VALUES (5, 'interconnected rooms', 2, 2000.0);
INSERT INTO sobe (id, tip, brojKreveta, cenaNocenja) VALUES (6, 'suite', 2, 3000.0);

INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (6, '2017-11-01 12:00:00', '2017-11-10 10:00:00', 'Petar Petrović');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (3, '2017-11-05 13:00:00', '2017-11-10 08:00:00', 'Marko Marković');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (6, '2017-11-19 03:00:00', '2017-11-22 03:00:00', 'Jovan Jovanović');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (3, '2017-11-10 12:30:00', '2017-11-20 07:00:00', 'Petar Petrović');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (4, '2017-11-10 12:00:00', '2017-12-02 08:00:00', 'Marko Marković');
INSERT INTO rezervacije (soba, ulazak, izlazak, gost) VALUES (5, '2017-11-10 12:00:00', '2017-12-02 08:00:00', 'Marko Marković');