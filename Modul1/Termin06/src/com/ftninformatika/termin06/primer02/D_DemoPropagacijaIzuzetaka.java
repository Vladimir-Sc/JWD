package com.ftninformatika.termin06.primer02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin06.primer02.model.Student;

public class D_DemoPropagacijaIzuzetaka {

//	public static List<Student> ucitaj() {
	public static List<Student> ucitaj() throws FileNotFoundException, IOException, IndexOutOfBoundsException { // delegiramo odgovornost hvatanja izuzetka pozivaocu funkcije
		List<Student> studenti = new ArrayList<>();
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "studenti.csv"));
//			in = new BufferedReader(new FileReader("data" + File.separator + "neispravniStudenti.csv"));
//			in = new BufferedReader(new FileReader("data" + File.separator + "nepostojecaDatoteka.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");
				
				Student student = new Student(tokeni[0], tokeni[1], tokeni[2]);
				studenti.add(student);
				
				linija = in.readLine();
			}
		} finally {
			in.close(); // BufferedReader se mora zatvoriti ovde jer definisan u okviru ove funkcije
		}

		return studenti;
	}
	
	public static void ispis(List<Student> studenti) {
		for (int it = 0; it < studenti.size(); it++) {
			Student itStudent = studenti.get(it);
			System.out.println((it + 1) + ". " + itStudent);
		}
	}
	
	public static void main(String[] args) {
		List<Student> studenti = null;
		try {
			studenti = ucitaj();
		} catch (FileNotFoundException ex) {
			System.out.println("Datoteka nije pronađena!");
		} catch (IOException ex) {
			System.out.println("Došlo je do greške u čitanju fajla!");
		} catch (IndexOutOfBoundsException ex) {
			System.out.println("Neispravan sadržaj datoteke!");
		} catch (Exception ex) {
			System.out.println("Došlo je do nepredviđene greške!");
		}

		ispis(studenti);
	}
	
}
