package com.ftninformatika.termin06.primer01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.ftninformatika.termin06.primer01.model.Student;
import com.ftninformatika.termin06.primer01.util.StudentImeComparator;

public class C_DemoMap {

	private static final Scanner in = new Scanner(System.in);
	
	public static void ispis(Map<String, Student> studenti) {
		// 1. način
		for (Student itStudent: studenti.values()) { // najćešći slučaj upotrebe, tipično radi ispisa
			System.out.println(itStudent);
		}

		// 2. način i kljuc i vrednost
		for (Entry<String, Student> par: studenti.entrySet()) { // za slučajeve kada ključ nije sadržan u entitetu, a potrebno je nešto uraditi i sa ključem i sa entitetom
			String indeks = par.getKey();
			Student itStudent = par.getValue();
			System.out.println("indeks: " + indeks + ", " + itStudent);
		}
		
		// 3. način kroz kljuceve
		for (String indeks: studenti.keySet()) { // za slučajeve kada ključ nije sadržan u entitetu, a potrebno je nešto uraditi sa entitetom tek ako ključ zadovoljava neki uslov
			Student itStudent = studenti.get(indeks);
			System.out.println("indeks: " + indeks + ", " + itStudent);
		}
	}

	public static void dodaj(Map<String, Student> studenti) {
		System.out.println();
		System.out.println("Dodavanje...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();
		System.out.print("Unesite ime studenta: ");
		String ime = in.nextLine();
		System.out.print("Unesite prezime studenta: ");
		String prezime = in.nextLine();

		Student student = new Student(indeks, ime, prezime);
		studenti.put(student.getIndeks(), student); // dodaju se parovi (ključ, vrednost); ključ je tipično neko obeležje entiteta, a ne mora da bude
	}
	
	public static void pronadji(Map<String, Student> studenti) {
		// 1. način
		System.out.println();
		System.out.println("Pronalaženje po indeksu...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();

		Student pronadjeniStudent = studenti.get(indeks); // ako je mapiranje kreirano po obeležju po kome se pretražuje

//		// 2. način
//		System.out.println();
//		System.out.println("Pronalaženje po imenu...");
//		System.out.print("Unesite ime studenta: ");
//		String ime = in.nextLine();
//
//		Student pronadjeniStudent = null;
//		for (Student itStudent: studenti.values()) { // ako je mapiranje kreirano po nekom drugom obeležju
//			if (itStudent.getIme().equals(ime)) {
//				pronadjeniStudent = itStudent;
//				break;
//			}
//		}

		if (pronadjeniStudent != null) {
			System.out.print("Pronađeni student: ");
			System.out.println(pronadjeniStudent);
		} else {
			System.out.println("Student nije pronađen!");
		}
	}

	public static List<Student> sortiraj(Map<String, Student> studenti) {
		System.out.println();
		System.out.println("Sortiranje...");
		System.out.println("1. sortiranje u rastućem redosledu");
		System.out.println("2. sortiranje u opadajućem redosledu");
		System.out.println("------------------------------------");
		System.out.print("Unesite izbor: ");
		int izbor = in.nextInt();
		in.nextLine();

		List<Student> sortiraniStudenti = new ArrayList<>(studenti.values()); // privremena lista entiteta
		Collections.sort(sortiraniStudenti, new StudentImeComparator(izbor == 2? -1: 1)); // moguće je sortirati samo listu

		return sortiraniStudenti; // sortirana lista entiteta se vraća pozivaocu
	}

	public static void ukloni(Map<String, Student> studenti) {
		System.out.println();
		System.out.println("Uklanjanje...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();

		Student uklonjeniStudent = studenti.remove(indeks); // element se uvek uklanja po ključu
		if (uklonjeniStudent == null) {
			System.out.println("Student nije pronađen!");
		}
	}
	
	public static void main(String[] args) {
		Map<String, Student> studenti = new HashMap<>(); // svaka iteracija kroz elemente može da se odvija u potpuno drugačijem nasumičnom redosledu
//		Map<String, Student> studenti = new LinkedHashMap<>(); // svaka iteracija kroz elemente se uvek odvija u redosledu dodavanja, ali su dodavanje i uklanjanje nešto sporiji i mapa zauzima malo više memorije
		// dodaju se parovi (ključ, vrednost); ključ je tipično neko obeležje entiteta, a ne mora da bude
		studenti.put("0001", new Student("0001", "A", "A"));
		studenti.put("0002", new Student("0002", "B", "B"));
		studenti.put("0003", new Student("0003", "C", "C"));

		ispis(studenti);

		dodaj(studenti); // ponovljeni ključ prepisuje postojeći unos
		ispis(studenti);

		pronadji(studenti);

		List<Student> sortiraniStudenti = sortiraj(studenti);
		A_DemoList.ispis(sortiraniStudenti);

		ukloni(studenti);
		ispis(studenti);
	}

}
