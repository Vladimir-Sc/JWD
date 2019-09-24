package com.ftninformatika.termin07.primer03.ui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin07.primer03.model.Student;
import com.ftninformatika.termin07.primer03.utils.PomocnaKlasa;

public class StudentskaSluzbaUI {

	// ispis teksta osnovnih opcija
	private static void ispisiMenu() {
		System.out.println();
		System.out.println("Studentska Sluzba - Meni:");
		System.out.println("\t1 - Spisak studenata");
		System.out.println("\t2 - Unos studenta");
		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}
	
	public static void main(String[] args) {
		try {
			// otvaranje konekcije, jednom na pocetku aplikacije
			ConnectionManager.open();
		} catch (Exception ex) {
			System.out.println("Neuspesna konekcija na bazu!");

			ex.printStackTrace();
			// kraj aplikacije
			return;
		}

		// prikaz menija
		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajTekst();
			switch (odluka) {				
				case "1":
					prikaziSveStudente();
					break;
				case "2":
					unosStudenta();
					break;
				case "x":
					System.out.println("Izlaz");
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}

		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private static void prikaziSveStudente() {
		List<Student> studenti = new ArrayList<>(); // lista studenata u memoriji

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT student_id, indeks, ime, prezime FROM studenti";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(query);

			// citanje rezultata upita i punjenje liste
			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String indeks = rset.getString(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);	

				// kreiramo objekat u memoriji na osnovu preuzetog sloga iz baze
				Student student = new Student(id, indeks, ime, prezime);
				studenti.add(student); // dodamo objekat Student u listu svih studenata
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");
			ex.printStackTrace();
		} finally {
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		// sada imamo napunjenu listu studenata u memoriji 
		// prolazimo kroz listu i ispisujemo podatke o svakom studentu
		System.out.println();
		System.out.printf("%-10s %-20s %-20s", 
				"indeks", 
				"ime", 
				"prezime"); System.out.println();
		System.out.println("========== ==================== ====================");
		for (Student itStudent: studenti) {
			System.out.printf("%-10s %-20s %-20s", 
					itStudent.getIndeks(), 
					itStudent.getIme(), 
					itStudent.getPrezime()); System.out.println();
		}
	}
	
	private static void unosStudenta() {
		System.out.println();
		System.out.print("Unesi indeks:");
		String stIndex = PomocnaKlasa.ocitajTekst();
		System.out.print("Unesi ime:");
		String stIme = PomocnaKlasa.ocitajTekst();
		System.out.print("Unesi prezime:");
		String stPrezime = PomocnaKlasa.ocitajTekst();

		// kreiramo objekat student u memoriji
		Student student = new Student(0, stIndex, stIme, stPrezime);

		// sadrzaj objekta ubacimo u bazu podataka
		PreparedStatement stmt = null;
		try {
			String query = "INSERT INTO studenti (indeks, ime, prezime) VALUES (?, ?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(query);
			int index = 1;
			stmt.setString(index++, student.getIndeks());
			stmt.setString(index++, student.getIme());
			stmt.setString(index++, student.getPrezime());

			if (stmt.executeUpdate() != 1)
				System.out.println("Greska u radu sa bazom!");
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");
			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		System.out.println("Student je uspesno dodat.");
	}

}
