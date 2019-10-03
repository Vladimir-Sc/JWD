package com.ftninformatika.termin06.primer02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin06.primer02.model.Student;

public class C_DemoHijerarhijaIzuzetaka {

	public static void main(String[] args) {
		List<Student> studenti = new ArrayList<>();
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "studenti.csv"));
//			in = new BufferedReader(new FileReader("data" + File.separator + "neispravniStudenti.csv")); // jedan od studenata u datoteci nema dovoljan broj token-a
//			in = new BufferedReader(new FileReader("data" + File.separator + "nepostojecaDatoteka.csv")); // u finally bloku neće moći da se zatvori BufferedReader koji nije ni otvoren

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");
				
				Student student = new Student(tokeni[0], tokeni[1], tokeni[2]); // ova linija može da proizvede unchecked izuzetak: IndexOutOfBoundsException
				studenti.add(student);
				
				linija = in.readLine();
			}
//		} catch (Exception ex) { // najopštiji izuzeci moraju da se uhvate na kraju
//			System.out.println("Došlo je do nepredviđene greške!");
		} catch (FileNotFoundException ex) { // ovu klauzulu je moguće izostaviti
			System.out.println("Datoteka nije pronađena!");
		} catch (IOException ex) {
			System.out.println("Došlo je do greške u čitanju fajla!");
//		} catch (IndexOutOfBoundsException ex) {
//			System.out.println("Neispravan sadržaj datoteke!");
//		} catch (Exception ex) { // ako ova klauzula postoji, ostale nisu obavezne
//			System.out.println("Došlo je do nepredviđene greške!");
		} finally {
			try {in.close();} catch (IOException ex) {}
//			try {in.close();} catch (Exception ex) {} // rešava i problem sa nepostojećom datotekom
		}

		for (int it = 0; it < studenti.size(); it++) {
			Student itStudent = studenti.get(it);
			System.out.println((it + 1) + ". " + itStudent);
		}
	}
	
}
