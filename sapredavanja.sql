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