package com.ftninformatika.vezbe03.primer04;

import java.util.ArrayList;


public class Test {

	/*** ISPIS***/
	public static void ispisiStudente(ArrayList<Student> lista){
		
		//ispis svih studenata I NACIN
		for (int i = 0; i < lista.size(); i++) {
			Student obj = lista.get(i);
			//ispis vrednosti
			//TODO u narednoj liniji ispisati sve podatke o studentima (osim predmeta koje pohađa student)
			System.out.println(obj.vratiTekstualnuReprezentacijuZaIspis());
//			System.out.println(obj.vratiTekstualnuReprezentacijuZaIspisAll());
		}
		
		//ispis svih studenata II NACIN
//		for (Student st : lista) {
//			System.out.println(st.vratiTekstualnuReprezentacijuZaIspis());
//		}
	}

	public static void main(String[] args) {
		
		ArrayList<Student> sviStudenti = new ArrayList<Student>();
		ArrayList<Predmet> sviPredmeti = new ArrayList<Predmet>();
		
		//popunjavanje liste svih mogućih predmeta u aplikaciji
		//predmet 1
		sviPredmeti.add(new Predmet(1, "Matematika"));
		//predmet 2
		sviPredmeti.add(new Predmet(2, "Fizika"));
		//predmet 3
		sviPredmeti.add(new Predmet(3, "Elektrotehniku"));
		//predmet 4
		sviPredmeti.add(new Predmet(4, "Informatiku"));
		
		//pozivanje konstruktora bez parametra
		Student student1 = new Student();
		//1,E1 01/2011,Srđanov,Konstantin,Loznica
		student1.id=1;
		student1.indeks = "E1 01/2011";
		student1.prezime = "Srđanov";
		student1.ime = "Konstantin";
		student1.grad = "Loznica";
			
		//pozivanje konstruktora sa vise parametara
		//2,E1 02/2012,Baki,Strahinja,Novi Sad
		Student student2 = new Student(2,"Strahinja","Baki","Novi Sad","E1 02/2012");
		
		//pozivanje konstruktora sa 1 parametrom tipa String koji predstavlja očitani red iz csv fajla
		//3,E1 03/2013,Trajković,Nebojša,Inđija
		Student student3 = new Student("3,E1 03/2013,Trajković,Nebojša,Inđija");
		
		//pozivanje konstruktora sa vise parametara od kojih je jedan niz predmeta
		//4,E2 01/2011,Sekulić,Miloš,Vršac
		//Sekulić Miloš pohađa Matematiku,Elektrotehniku i Informatiku
		ArrayList<Predmet> predmetiStudent4 = new ArrayList<Predmet>();
		//predmet 1
		predmetiStudent4.add(sviPredmeti.get(0)); //Matematiku
		//predmet 2
		predmetiStudent4.add(sviPredmeti.get(2)); //Elektrotehnika
		//predmet 3
		predmetiStudent4.add(sviPredmeti.get(3)); //Informatika
		
		Student student4 = new Student(4,"Miloš","Sekulić","Vršac", "E2 01/2011", predmetiStudent4);
		
		
		//dodavanje studenata
		sviStudenti.add(student1);
		sviStudenti.add(0, student2);
		sviStudenti.add(student3);
		
		ispisiStudente(sviStudenti);
		System.out.println("***************************************");
		sviStudenti.remove(2);
		sviStudenti.set(0, student4);
		System.out.println("Broj studenata je:"+sviStudenti.size());
		ispisiStudente(sviStudenti);
		
		System.out.println("Zavrsen rad sa konstruktorima");
	}

}
