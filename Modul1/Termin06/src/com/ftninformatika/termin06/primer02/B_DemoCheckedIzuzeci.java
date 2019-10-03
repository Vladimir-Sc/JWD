package com.ftninformatika.termin06.primer02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin06.primer02.model.Student;

public class B_DemoCheckedIzuzeci {

	public static void main(String[] args) {
		List<Student> studenti = new ArrayList<>();
		
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "studenti.csv")); // ova linija može da proizvede checked izuzetak: FileNotFoundException

			String linija = in.readLine(); // ova linija može da proizvede checked izuzetak: IOException
			while (linija != null) {
				String[] tokeni = linija.split(",");
				
				Student student = new Student(tokeni[0], tokeni[1], tokeni[2]);
				studenti.add(student);
				
				linija = in.readLine(); // ova linija može da proizvede checked izuzetak: IOException
			}
		} catch (FileNotFoundException ex) {
			System.out.println("Datoteka nije pronađena!");
		} catch (IOException ex) {
			System.out.println("Došlo je do greške u čitanju fajla!");
		} finally {
			try {in.close();} catch (IOException ex) {ex.printStackTrace();} // moguće je i da try, catch ili finally blok sadrže novi try-catch blok u sebi
		}

		for (int it = 0; it < studenti.size(); it++) {
			Student itStudent = studenti.get(it);
			System.out.println((it + 1) + ". " + itStudent);
		}
	}
	
}
