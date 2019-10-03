package com.ftninformatika.termin06.primer01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.ftninformatika.termin06.primer01.model.Student;
import com.ftninformatika.termin06.primer01.util.StudentImeComparator;

public class A_DemoList {

	private static final Scanner in = new Scanner(System.in);
	
	public static void ispis(List<Student> studenti) {
		// 1. način
		for (Student itStudent: studenti) { // najćešći slučaj upotrebe, tipično radi ispisa
			System.out.println(itStudent);
		}

//		// 2. način
//		for (int it = 0; it < studenti.size(); it++) { // ako je pored sa entitetom potrebno nešto uraditi i sa njegovim rednim brojem u listi
//			Student itStudent = studenti.get(it);
//			System.out.println((it + 1) + ". " + itStudent);
//		}
	}

	public static void dodaj(List<Student> studenti) {
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
	
	public static void pronadji(List<Student> studenti) {
		// 1. način
		System.out.println();
		System.out.println("Pronalaženje po indeksu...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();

		Student pronadjeniStudent = null;
		for (int it = 0; it < studenti.size(); it++) { // ako je poznato obeležje entiteta
			Student itStudent = studenti.get(it);
			if (itStudent.getIndeks().equals(indeks)) {
				pronadjeniStudent = itStudent;
				break;
			}
		}

//		// 2. način
//		System.out.println();
//		System.out.println("Pronalaženje po rednom broju...");
//		System.out.print("Unesite redni broj studenta: ");
//		int redniBroj = in.nextInt();
//		in.nextLine();
//
//		Student pronadjeniStudent = studenti.get(redniBroj - 1); // ako je poznat redni broj entiteta
		
		if (pronadjeniStudent != null) {
			System.out.print("Pronađeni student: ");
			System.out.println(pronadjeniStudent);
		} else {
			System.out.println("Student nije pronađen!");
		}
	}

	public static void sortiraj(List<Student> studenti) {
		System.out.println();
		System.out.println("Sortiranje...");
		System.out.println("1. sortiranje u rastućem redosledu");
		System.out.println("2. sortiranje u opadajućem redosledu");
		System.out.println("------------------------------------");
		System.out.print("Unesite izbor: ");
		int izbor = in.nextInt();
		in.nextLine();

		Collections.sort(studenti, new StudentImeComparator(izbor == 2? -1: 1));
	}

	public static void ukloni(List<Student> studenti) {
		// 1. način
		System.out.println();
		System.out.println("Uklanjanje...");
		System.out.print("Unesite indeks studenta: ");
		String indeks = in.nextLine();

		Student uklonjeniStudent = null;
		for (int it = 0; it < studenti.size(); it++) { // ako je poznato obeležje entiteta
			Student itStudent = studenti.get(it);
			if (itStudent.getIndeks().equals(indeks)) {
				uklonjeniStudent = studenti.remove(it);
		//		break; // obavezno! Ako se iteracija nastavi nakon modifikacije, proizvešće izuzetak
			}
			else it++;
			
		}

//		// 2. način
//		System.out.println();
//		System.out.println("Uklanjanje...");
//		System.out.print("Unesite redni broj studenta: ");
//		int redniBroj = in.nextInt() ;
//		in.nextLine();
//
//		Student uklonjeniStudent = studenti.remove(redniBroj - 1); // ako je poznat redni broj entiteta

		if (uklonjeniStudent == null) {
			System.out.println("Student nije pronađen!");
		}
	}
	
	public static void main(String[] args) {
		List<Student> studenti = new ArrayList<>();
		studenti.add(new Student("0001", "A", "A"));
		studenti.add(new Student("0002", "B", "B"));
		studenti.add(new Student("0003", "C", "C"));

		ispis(studenti);
		
		dodaj(studenti);
		ispis(studenti);

		pronadji(studenti);

		sortiraj(studenti);
		ispis(studenti);

		ukloni(studenti);
		ispis(studenti);
	}

}
