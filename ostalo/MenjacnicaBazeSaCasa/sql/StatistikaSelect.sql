select * from
(select k.id as kid,k.datum as datum,(vv.kupovniKurs+vv.prodajniKurs)/2 as srednji,
			v.id as vid,v.oznaka as voznaka,v.naziv as vnaziv
		from kursneListe k right join vrednostiValuta vv on k.id = vv.kursnaLista 
			right join valute v on v.id = vv.valuta 
            where (k.datum > '2012-12-21' and k.datum<'2019-09-29') or k.datum IS NULL) 
                as t2 right join 
(select MIN(p.srednji) as m2srednji,p.vid as v2id, v.oznaka,v.naziv from 

    (select k.id as kid,k.datum as datum,(vv.kupovniKurs+vv.prodajniKurs)/2 as srednji,
			v.id as vid,v.oznaka as voznaka,v.naziv as vnaziv
			from kursneListe k right join vrednostiValuta vv
				on k.id = vv.kursnaLista 
			    right join valute v on v.id = vv.valuta
                where (k.datum > '2012-12-21' and k.datum<'2019-09-29') or k.datum IS NULL
                ) as p
                
	left join valute v on v.id=p.vid group by p.vid
) as t3 on t3.m2srednji = t2.srednji && t2.vid = t3.v2id 