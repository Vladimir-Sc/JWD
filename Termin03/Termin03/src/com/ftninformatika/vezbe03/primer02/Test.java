package com.ftninformatika.vezbe03.primer02;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		//kreiramo objekat predmet koji je instanca klase Predmet
		Predmet matematika =  new Predmet();
		matematika.id = 1;
		matematika.naziv = "Matematika";
		
		ArrayList<Student> sviStudenti = new ArrayList<Student>();
		
		//kreiramo objekat student koji je instanca klase Student
		Student stud = new Student();
		//postavimo atribute na odredjene vrednosti
		//1,E1 01/2011,Srđanov,Konstantin,Loznica
		stud.id=1;
		stud.indeks = "E1 01/2011";
		stud.prezime = "Srđanov";
		stud.ime = "Konstantin";
		stud.grad = "Loznica";
		
		//student pohađa predmete
		//kreiranje pojedinacnih objekata za predmete
		//predmet 1
		stud.predmeti.add(matematika);
		//predmet 2
		stud.predmeti.add(new Predmet());
		stud.predmeti.get(1).id = 2;
		stud.predmeti.get(1).naziv = "Fizika";
		//predmet 3
		stud.predmeti.add(new Predmet());
		stud.predmeti.get(2).id = 3;
		stud.predmeti.get(2).naziv = "Elektrotehnika";
		
		//STA DA SE RADI AKO DVA STUDENTA SLUŠAJU ISTI PREDMET???
		//DA LI KREIRATI NOVI OBJEKAT KOJI ĆE SADRŽATI ISTE ODATKE ILI...
		
		Student stud2 = new Student();
		//2,E1 02/2012,Baki,Strahinja,Novi Sad
		stud2.id=2;
		stud2.indeks = "E1 02/2012";
		stud2.prezime = "Baki";
		stud2.ime = "Strahinja";
		stud2.grad = "Novi Sad";
		//student pohađa predmete
		//kreiranje pojedinacnih objekata za predmete
		//predmet 1
		stud2.predmeti.add(new Predmet());
		stud2.predmeti.get(0).id = 1;
		stud2.predmeti.get(0).naziv = "Matematika";

//		stud2.predmeti.add(matematika);
		
		//dodavanje studenata
		sviStudenti.add(stud);
		sviStudenti.add(0, stud2);
		
		//ispis svih
		for (Student st : sviStudenti) {
			//pozivamo metode
			System.out.println("Ispis studenta " + st.vratiTekstualnuReprezentacijuZaIspisAll());	
		}
	}

}
