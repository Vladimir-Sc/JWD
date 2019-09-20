package com.ftninformatika.termin06.primer01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.ftninformatika.termin06.primer01.model.Student;
import com.ftninformatika.termin06.primer01.util.StudentImeComparator;

public class B_DemoSet {

	private static final Scanner in = new Scanner(System.in);
	
	public static void ispis(Set<Student> studenti) {
		for (Student itStudent: studenti) { // jedini način
			System.out.println(itStudent);
		}
	}

	public static void dodaj(Set<Student> studenti) {
		System.out.println();
		System.out.println("Dodavanje...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();
		System.out.print("Unesite ime studenta: ");
		String ime = in.nextLine();
		System.out.print("Unesite prezime studenta: ");
		String prezime = in.nextLine();

		Student student = new Student(indeks, ime, prezime);
		studenti.add(student);
	}
	
	public static void pronadji(Set<Student> studenti) {
		System.out.println();
		System.out.println("Pronalaženje po indeksu...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();

		Student pronadjeniStudent = null;
		for (Student itStudent: studenti) {
			if (itStudent.getIndeks().equals(indeks)) {
				pronadjeniStudent = itStudent;
				break;
			}
		}

		if (pronadjeniStudent != null) {
			System.out.print("Pronađeni student: ");
			System.out.println(pronadjeniStudent);
		} else {
			System.out.println("Student nije pronađen!");
		}
	}

	public static List<Student> sortiraj(Set<Student> studenti) {
		System.out.println();
		System.out.println("Sortiranje...");
		System.out.println("1. sortiranje u rastućem redosledu");
		System.out.println("2. sortiranje u opadajućem redosledu");
		System.out.println("------------------------------------");
		System.out.print("Unesite izbor: ");
		int izbor = in.nextInt();
		in.nextLine();

		List<Student> sortiraniStudenti = new ArrayList<>(studenti); // privremena lista entiteta
		Collections.sort(sortiraniStudenti, new StudentImeComparator(izbor == 2? -1: 1)); // moguće je sortirati samo listu

		return sortiraniStudenti; // sortirana lista entiteta se vraća pozivaocu
	}

	public static void ukloni(Set<Student> studenti) {
		System.out.println();
		System.out.println("Uklanjanje...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();

		boolean uklonjen = false;
		for (Student itStudent: studenti) {
			if (itStudent.getIndeks().equals(indeks)) {
				uklonjen = studenti.remove(itStudent); // uklanjanje po vrednosti
				break; // obavezno! Ako se iteracija nastavi nakon modifikacije, proizvešće izuzetak
			}
		}

		if (!uklonjen) {
			System.out.println("Student nije pronađen!");
		}
	}
	
	public static void main(String[] args) {
		Set<Student> studenti = new HashSet<>(); // svaka iteracija kroz elemente može da se odvija u potpuno drugačijem nasumičnom redosledu
//		Set<Student> studenti = new LinkedHashSet<>(); // svaka iteracija kroz elemente se uvek odvija u redosledu dodavanja, ali su dodavanje i uklanjanje nešto sporiji i set zauzima malo više memorije
		studenti.add(new Student("0001", "A", "A"));
		studenti.add(new Student("0002", "B", "B"));
		studenti.add(new Student("0003", "C", "C"));

		ispis(studenti);

		dodaj(studenti); // DA BI DUPLIKATI BILI SPREČENI, potrebno je otkomentarisati hashCode() i equals(Object obj) metodu klase Student
		ispis(studenti);

		pronadji(studenti);

		List<Student> sortiraniStudenti = sortiraj(studenti);
		A_DemoList.ispis(sortiraniStudenti);

		ukloni(studenti);
		ispis(studenti);
	}

}
