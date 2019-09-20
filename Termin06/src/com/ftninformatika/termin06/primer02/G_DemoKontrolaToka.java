package com.ftninformatika.termin06.primer02;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.ftninformatika.termin06.primer01.model.Student;

public class G_DemoKontrolaToka {

	private static final Scanner in = new Scanner(System.in);
	
	public static void ispis(List<Student> studenti) {
		for (int it = 0; it < studenti.size(); it++) {
			Student itStudent = studenti.get(it);
			System.out.println((it + 1) + ". " + itStudent);
		}
	}

	public static void ukloni(List<Student> studenti) {
		System.out.println();
		System.out.println("Uklanjanje...");

		// 1. način
		String greska = "";
		
		int redniBroj = -1;
		try {
			System.out.print("Unesite redni broj studenta: ");
			redniBroj = in.nextInt();
		} catch (InputMismatchException ex) {
			greska = "Niste uneli ceo broj!";
		} finally {
			in.nextLine();
		}
		if (greska.equals("") && redniBroj <= 0) {
			greska = "Niste uneli pozitivan broj!";
		}
		if (greska.equals("") && redniBroj > studenti.size()) {
			greska = "Redni broj ne postoji!";
		}

		if (!greska.equals("")) {
			System.out.println(greska);
			return;
		}
		studenti.remove(redniBroj - 1);
		
//		// 2. način
//		try {
//			int redniBroj = -1;
//			try {
//				System.out.print("Unesite redni broj studenta: ");
//				redniBroj = in.nextInt();
//			} catch (InputMismatchException ex) {
//				throw new Exception("Niste uneli ceo broj!"); // skok na liniju 70
//			} finally {
//				in.nextLine();
//			}
//			if (redniBroj <= 0) {
//				throw new Exception("Niste uneli pozitivan broj!"); // skok na liniju 70
//			}
//			if (redniBroj > studenti.size()) {
//				throw new Exception("Redni broj ne postoji!"); // skok na liniju 70
//			}
//			
//			studenti.remove(redniBroj - 1);
//		} catch (Exception ex) {
//			System.out.println(ex.getMessage());
//		}
	}
	
	public static void main(String[] args) {
		List<Student> studenti = new ArrayList<>();
		studenti.add(new Student("0001", "A", "A"));
		studenti.add(new Student("0002", "B", "B"));
		studenti.add(new Student("0003", "C", "C"));

		ispis(studenti);

		ukloni(studenti);
		ispis(studenti);
	}
	
}
