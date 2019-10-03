package com.ftninformatika.vezbe03.primer01;

public class Test {

	public static void main(String[] args) {
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
		stud.predmeti.add("Matematika");
		stud.predmeti.add("Fizika");
		stud.predmeti.add("Elektrotehnika");
		
		System.out.println("Student sa id " + stud.id + " čije je ime i prezime " 
				+ stud.ime + " " + stud.prezime + " ima indeks " 
				+ stud.indeks + " i zivi u gradu " + stud.grad);
		//pozivamo metode
		//System.out.println("Ispis studenta " + stud.vratiTekstualnuReprezentacijuZaIspis());
		
		Student stud2 = new Student();
		//2,E1 02/2012,Baki,Strahinja,Novi Sad
		stud2.id=2;
		stud2.indeks = "E1 02/2012";
		stud2.prezime = "Baki";
		stud2.ime = "Strahinja";
		stud2.grad = "Novi Sad";
		//student pohađa predmete
		stud2.predmeti.add("Matematika");
		stud2.predmeti.add("Elektrotehnika");
		
//		stud2 = stud;
//		stud = null;
//		stud2 = null;
		System.out.println("Ispis studenta " + stud2.vratiTekstualnuReprezentacijuZaIspisAll());
		
	}

}
