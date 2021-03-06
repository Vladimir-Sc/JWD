select ptt, naziv
from studentskasluzba.grad
where ptt=21000 or naziv like '%o'%
group by ptt
order by naziv desc


#za student tabelu
select *
from studentskasluzba.studenti
where student_id >=2 and student_id <= 3 # student_id between 2 and 3
where ime in ('b', 'c')

#update
UPDATE `studentskasluzba`.`grad`
SET
`ptt` = 21210
WHERE `ptt` = 21000;

#delete
DELETE FROM `studentskasluzba`.`grad`
WHERE <{where_expression}>;

biblioteke za rad sa mysql bazom , klase koje predstavljaju drajver


#Termin08

SELECT id, naziv FROM graddrzava.grad where drzava_id =1;

UPDATE `graddrzava`.`grad`
SET `drzava_id` = 3
WHERE `id` = 5;

#inner join 

use studentskasluzba;
select * from studenti inner join pohadja on studenti.student_id = pohadja.student_id


#left join

use studentskasluzba;
select * from studenti left join pohadja on studenti.student_id = pohadja.student_id

use studentskasluzba;
select * from studenti left join pohadja on studenti.student_id = pohadja.student_id 
left join predmeti on pohadja.predmet_id = predmeti.predmet_id

use studentskasluzba;
select indeks, ime, prezime, naziv from studenti left join pohadja on studenti.student_id = pohadja.student_id 
left join predmeti on pohadja.predmet_id = predmeti.predmet_id

#agregacija
use graddrzava;
select d.naziv as 'drzava naziv', sum(populacija) as populacija
from drzava d inner join grad g on d.id = g.drzava_id group by d.id

#right join

use studentskasluzba;
select * from pohadja right join predmeti on pohadja.predmet_id = predmeti.predmet_id



#sa predavanj join vise tabela

select * from nastavnici left join predaje on nastavnici.nastavnik_id = predaje.nastavnici_id
inner join predmeti on predaje.predmeti_id = predmet_id

select * from predmeti left join ispitne_prijave ip on p.predmet_id left join studenti s on ip.student_id = student_id left join ispitni_rokovi ir on ir.rok_id = ip.rok_id


#Termin09

select * from valute v 
left join vrednostiValuta vv 
on v.id = vv.valuta
left join kursneListe k on k.id = vv.kursnaLista




select * from valute v 
left join vrednostiValuta vv 
on v.id = vv.valuta
left join kursneListe k on k.id = vv.kursnaLista


use menjacnica

select *
from valute v left join vrednostiValuta vv on 

select * from valute v 
right join vrednostiValuta vv 
on v.id = vv.valuta
right join kursneListe k on k.id = vv.kursnaLista


select k.id, k.datum, vv.valuta, vv.kupovniKurs, vv.prodajniKurs, v.id, v.oznaka, v.naziv 
from kursneListe k 
left join vrednostiValuta vv 
on k.id = vv.kursnaLista
left join valute v on v.id = vv.valuta where k.datum = '2013-12-23'

SELECT * FROM menjacnica.kursneListe;

use menjacnica;
select id, oznaka, naziv from valute where oznaka = 'USD'

use menjacnica;

INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (4, 1, 20.2, 30.4);

use menjacnica;
select MAX(id) as id from kursneListe 

SELECT * FROM menjacnica.vrednostiValuta;

SELECT * FROM menjacnica.kursneListe;