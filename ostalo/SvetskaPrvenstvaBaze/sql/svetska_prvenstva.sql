DROP SCHEMA IF EXISTS svetskaprvenstva;
CREATE SCHEMA svetskaprvenstva DEFAULT CHARACTER SET utf8;
USE svetskaprvenstva;

CREATE TABLE drzave (
	id INT AUTO_INCREMENT, 
	naziv VARCHAR(30) UNIQUE NOT NULL, 
	PRIMARY KEY(id), 
	INDEX(naziv)
);

CREATE TABLE prvenstva (
	id INT AUTO_INCREMENT, 
	godina INT UNIQUE NOT NULL, 
	naziv VARCHAR(30) NOT NULL, 
	domacin INT NOT NULL, 
	osvajac INT NOT NULL, 

	PRIMARY KEY(id), 
	INDEX(godina), 
	FOREIGN KEY (domacin) REFERENCES drzave(id)
		ON DELETE RESTRICT, 
	FOREIGN KEY (osvajac) REFERENCES drzave(id)
		ON DELETE RESTRICT
);
	
INSERT INTO drzave (id, naziv) VALUES (1, 'Srbija');
INSERT INTO drzave (id, naziv) VALUES (2, 'Nemačka');
INSERT INTO drzave (id, naziv) VALUES (3, 'Italija');
INSERT INTO drzave (id, naziv) VALUES (4, 'Makedonija');
INSERT INTO drzave (id, naziv) VALUES (5, 'Francuska');
INSERT INTO drzave (id, naziv) VALUES (6, 'Brazil');
INSERT INTO drzave (id, naziv) VALUES (7, 'Južna Afrika');
INSERT INTO drzave (id, naziv) VALUES (8, 'Španija');

INSERT INTO prvenstva (godina, naziv, domacin, osvajac) VALUES (1998, 'France98', 5, 5);
INSERT INTO prvenstva (godina, naziv, domacin, osvajac) VALUES (2006, 'Nemačka06', 2, 3);
INSERT INTO prvenstva (godina, naziv, domacin, osvajac) VALUES (2010, 'Africa10', 7, 8);
INSERT INTO prvenstva (godina, naziv, domacin, osvajac) VALUES (2014, 'Brasil14', 6, 2);
