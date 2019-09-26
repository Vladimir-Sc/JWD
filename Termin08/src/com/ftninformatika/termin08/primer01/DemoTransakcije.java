package com.ftninformatika.termin08.primer01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DemoTransakcije {

	// bez transakcije; nebezbedno!
	public static void test1() {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("Unesi ID uplatioca: ");
		int uplatilacID = scanner.nextInt();
		System.out.print("Unesi ID primaoca: ");
		int primalacID = scanner.nextInt();
		System.out.print("Unesi iznos: ");
		double iznos = scanner.nextDouble();

		scanner.close();		

		// ova funkcionalnost zahteva 2 SQL upita
		PreparedStatement stmt = null;
		try {
			// 1. SQL upit
			String sql = "UPDATE racuni SET stanje = stanje - ? WHERE id = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setDouble(index++, iznos);
			stmt.setInt(index++, uplatilacID);

//			if (true) throw new Exception(); // simulacija greske
			
			stmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
	    } finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		try {
			// 2. SQL upit
			String sql = "UPDATE racuni SET stanje = stanje + ? WHERE id = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setDouble(index++, iznos);
			stmt.setInt(index++, primalacID);

//			if (true) throw new Exception(); // simulacija greske
			
			stmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
	    } finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	// sa transakcijom; bezbedno!
	public static void test2() {
		Scanner scanner = new Scanner(System.in);

		System.out.println();
		System.out.print("Unesi ID uplatioca: ");
		int uplatilacID = scanner.nextInt();
		System.out.print("Unesi ID primaoca: ");
		int primalacID = scanner.nextInt();
		System.out.print("Unesi iznos: ");
		double iznos = scanner.nextDouble();

		scanner.close();		

		// ova funkcionalnost zahteva 2 SQL upita
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			String query;
			int index;

			conn = ConnectionManager.getConnection();	
			conn.setAutoCommit(false); // iskljucivanje automatske transakcije (pri cemu je svaki upit bio transakcija za sebe)
			conn.commit(); // pocetak transakcije
			
			// 1. SQL upit
			query = "UPDATE racuni SET stanje = stanje - ? WHERE id = ?";

			stmt = conn.prepareStatement(query);
			index = 1;
			stmt.setDouble(index++, iznos);
			stmt.setInt(index++, uplatilacID);

//			if (true) throw new Exception(); // simulacija greske
			
			stmt.executeUpdate();
			stmt.close();

			// 2. SQL upit
			query = "UPDATE racuni SET stanje = stanje + ? WHERE id = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(query);
			index = 1;
			stmt.setDouble(index++, iznos);
			stmt.setInt(index++, primalacID);

//			if (true) throw new Exception(); // simulacija greske
			
			stmt.executeUpdate();

			conn.commit(); // kraj transakcije
		} catch (Exception ex) {
			try {conn.rollback();} catch (Exception ex1) {ex1.printStackTrace();} // vratiti bazu u stanje pre pocetka transakcije

			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {conn.setAutoCommit(true);} catch (Exception ex) {ex.printStackTrace();} // ukljuciti automatsku tranaskciju
		}
	}

	public static void prikaz() {
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT id, vlasnik, stanje FROM racuni";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(query);

			System.out.println();
			System.out.printf("%-10s %-20s %-10s", "id", "vlasnik", "stanje"); System.out.println();
			System.out.println("========== ==================== ==========");
			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String vlasnik = rset.getString(index++);
				double stanje = rset.getDouble(index++);

				System.out.printf("%-10s %-20s %-10s", id, vlasnik, stanje); System.out.println();
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		} finally {
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


		prikaz();

//		test1();
		test2();

		prikaz();

		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
