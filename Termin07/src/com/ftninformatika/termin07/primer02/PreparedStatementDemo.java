package com.ftninformatika.termin07.primer02;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDemo {

	// dodavanje novog grada; hardkodirani podaci
	public static void test1() throws Exception {
		Statement stmt = null;
		try {
			// SQL upit
			String sql = "INSERT INTO grad (ptt, naziv) values (26300, 'Vrsac')"; // ' tekst u sql-u

			// kreiranje SQL naredbe
			stmt = ConnectionManager.getConnection().createStatement();
			// izvrsavanje SQL naredbe bez prihvatanja rezultata (INSERT, UPDATE, DELETE)
			stmt.executeUpdate(sql);
		} finally {
			// zatvaranje naredbe
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	// dodavanje novog grada; korisnik unosi podatke; nebezbedno!
	public static void test2() throws Exception {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Unesite ptt: ");
		String ptt = scanner.nextLine();
		// SQL injection: a'), (200, 'b
		System.out.print("Unesite naziv: ");
		String naziv = scanner.nextLine();

		scanner.close();		
		
		Statement stmt = null;
		try {
			// SQL upit
			String sql = "INSERT INTO grad (ptt, naziv) VALUES (" + ptt + ", '" + naziv + "')"; // ' za tekst u sql
			System.out.println(sql);

			// kreiranje SQL naredbe
			stmt = ConnectionManager.getConnection().createStatement(); // moze vise naredbi da se salje
			// izvrsavanje SQL naredbe bez prihvatanja rezultata (INSERT, UPDATE, DELETE)
			stmt.executeUpdate(sql);
		} finally {
			// zatvaranje naredbe
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	// dodavanje novog grada; korisnik unosi podatke; PreparedStatement, bezbedno!
	public static void test3() throws Exception {
		// dodavanje novog grada. Korisnik unosi podatke
		Scanner scanner = new Scanner(System.in);

		System.out.print("Unesite ptt: ");
		int ptt = Integer.valueOf(scanner.nextLine());
		System.out.print("Unesite naziv: ");
		String naziv = scanner.nextLine();

		scanner.close();		
		
		PreparedStatement stmt = null;
		try {
			// SQL upit
			String sql = "INSERT INTO grad (ptt, naziv) VALUES (?, ?)";

			// pripremljeni upit sadrzi parametre koji se naknadno postave
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setInt(1, ptt);
			stmt.setString(2, naziv);
			System.out.println(stmt);

			// izvrsavanje SQL naredbe bez prihvatanja rezultata (INSERT, UPDATE, DELETE)
			stmt.executeUpdate();
		} finally {
			// zatvaranje naredbe
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static void prikaz() throws Exception {
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT ptt, naziv FROM grad";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			System.out.println();
			System.out.printf("%-5s %-20s", "ptt", "naziv"); System.out.println();
			System.out.println("===== ====================");
			while (rset.next()) {
				int ptt = rset.getInt(1);
				String naziv = rset.getString(2);

				System.out.printf("%-5s %-20s", ptt, naziv); System.out.println();
			}
		} finally {
			// zatvaranje naredbe i rezultata
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static void main(String args[]) {
		try {
			// otvaranje konekcije, jednom na pocetku aplikacije
			ConnectionManager.open();
		} catch (Exception ex) {
			System.out.println("Neuspesna konekcija na bazu!");

			ex.printStackTrace();
			// kraj aplikacije
			return;
		}

		try {
		//	test1(); // pokusati izvrsavanje 2x
		//	test2();
			test3();

			prikaz();
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
