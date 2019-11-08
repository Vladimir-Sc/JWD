CREATE SCHEMA IF NOT EXISTS `maraton` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci ;
use maraton;

CREATE TABLE `maraton`.`tip_ucesca` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

  
 CREATE TABLE `maraton`.`ucesnik` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ime_i_prezime` VARCHAR(100) NOT NULL,
  `broj_predjenih_kilometara` INT NULL,
  `vreme_u_minutima` INT NULL,
  `tip_ucesnika` VARCHAR(45) NOT NULL,  
  `zavrsio_trku` VARCHAR(10) NOT NULL,
  `napomena` VARCHAR(200) NULL,
  `tip_ucesca` INT NOT NULL ,
  PRIMARY KEY (`id`),
  CONSTRAINT `tip_ucesca_fk`
  FOREIGN KEY (`tip_ucesca`)
  REFERENCES `maraton`.`tip_ucesca` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION);
  
  CREATE TABLE `maraton`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

insert into tip_ucesca values (1, 'trka zadovljstva 5km');
insert into tip_ucesca values (2, 'polumaraton 21km');
insert into tip_ucesca values (3, 'maraton 42km');
insert into tip_ucesca values (4, 'ultramaraton 100km');

insert into ucesnik values(1, 'Petar Petrovic', 5, 30, 'Rekreativac', 'DA', 'Došao sa decom da uživa', 1);
insert into ucesnik values(2, 'Marko Marković', 15, 60, 'Rekreativac', 'NE', 'Pozlilo mi na 15km', 2);
insert into ucesnik values(3, 'Jovan Jovanović', 21, 100, 'Profesionalac', 'DA', 'Pržilo je sunce mogu i bolji rezultat', 2);
insert into ucesnik values(4, 'Ivan Ivanović', 21, 140, 'Rekreativac', 'DA', 'Lepo se provero', 2);
insert into ucesnik values(5, 'Ognjen Ognjenović', 21, 90, 'Profesionalac', 'DA', 'Naporna trka', 2);
insert into ucesnik values(6, 'Danijel Danilovič', 90, 1920, 'Profesionalac', 'NE', 'Veteran trke', 4);

INSERT INTO user (`id`, `username`, `password`) VALUES (NULL, 'pera', 'peric');
INSERT INTO user (`id`, `username`, `password`) VALUES (NULL, 'steva', 'stevic');



