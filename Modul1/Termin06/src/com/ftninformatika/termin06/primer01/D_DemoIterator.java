package com.ftninformatika.termin06.primer01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.ftninformatika.termin06.primer01.model.Student;
import com.ftninformatika.termin06.primer01.util.StudentImeComparator;

public class D_DemoIterator {

	private static final Scanner in = new Scanner(System.in);
	
	public static void ispis(Collection<Student> studenti) {
		for (Student itStudent: studenti) { // jedini način
			System.out.println(itStudent);
		}

//		// ekvivalent kodu iznad sa dodatnom fleksibilnošću koja je demonstrirana na primeru uklanjanja
//		Iterator<Student> it = studenti.iterator();
//		while (it.hasNext()) {
//			Student itStudent = it.next();
//			System.out.println(itStudent);
//		}
	}

	public static void dodaj(Collection<Student> studenti) {
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
	
	public static void pronadji(Collection<Student> studenti) {
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

//		// ekvivalent kodu iznad sa dodatnom fleksibilnošću koja je demonstrirana na primeru uklanjanja
//		Student pronadjeniStudent = null;
//		Iterator<Student> it = studenti.iterator();
//		while (it.hasNext()) {
//			Student itStudent = it.next();
//			if (itStudent.getIndeks().equals(indeks)) {
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

	public static List<Student> sortiraj(Collection<Student> studenti) {
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

	public static void ukloni(Collection<Student> studenti) {
		System.out.println();
		System.out.println("Uklanjanje...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();

		// 1. način
		boolean uklonjen = false;
		for (Student itStudent: studenti) {
			if (itStudent.getIndeks().equals(indeks)) {
				uklonjen = studenti.remove(itStudent); // uklanjanje po vrednosti, ali se kolekcija ponovo pretražuje od početka
				break; // obavezno! Ako se iteracija nastavi nakon modifikacije, proizvešće izuzetak
			}
		}

//		// 2. način
//		boolean uklonjen = false;
//		Iterator<Student> it = studenti.iterator();
//		while (it.hasNext()) {
//			Student itStudent = it.next();
//			if (itStudent.getIndeks().equals(indeks)) {
//				uklonjen = true;
//				it.remove(); // direktno uklanjanje bez suvišne pretrage kolekcije po vrednosti
//				break; // NIJE OBAVEZNO (ako se očekuje više rezultata)!
//			}
//		}
		
		if (!uklonjen) {
			System.out.println("Student nije pronađen!");
		}
	}
	
	public static void main(String[] args) {
		Collection<Student> studenti = new ArrayList<>();
//		Collection<Student> studenti = new HashSet<>(); // primetiti da je u svim funkcionalnostima korišćen pristup sa iterator-om, te da odabir drugačije kolekcije ne utiče na ostatak koda (ovo ne važi za mape!)
		studenti.add(new Student("0001", "A", "A"));
		studenti.add(new Student("0002", "B", "B"));
		studenti.add(new Student("0003", "C", "C"));

		ispis(studenti);

		dodaj(studenti);
		ispis(studenti);

		pronadji(studenti);

		List<Student> sortiraniStudenti = sortiraj(studenti);
		A_DemoList.ispis(sortiraniStudenti);

		ukloni(studenti);
		ispis(studenti);
	}

}
