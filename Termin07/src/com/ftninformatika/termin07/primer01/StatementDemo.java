package com.ftninformatika.termin07.primer01;

import java.sql.ResultSet;
import java.sql.Statement;

public class StatementDemo {

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

		Statement stmt = null;
		ResultSet rset = null;
		try {
			// SQL upit
			// OBAVEZNO PISATI NAZIVE TABELA I KOLONA IDENTICNO (cak i po case-u) KAO U SKRIPTI ZA KREIRANJE BAZE!
			String sql = "SELECT ptt, naziv FROM grad";

			// kreiranje SQL naredbe, jednom za svaki SQL upit
			stmt = ConnectionManager.getConnection().createStatement();
			// izvrsavanje naredbe i prihvatanje rezultata (SELECT), jednom za svaki SQL upit
			rset = stmt.executeQuery(sql);

			System.out.printf("%-5s %-20s", "ptt", "naziv"); System.out.println();
			System.out.println("===== ====================");
			// citanje rezultata upita
			while (rset.next()) {
				int ptt = rset.getInt(1);
				String naziv = rset.getString(2);
//				int ptt = rset.getInt("ptt");
//				String naziv = rset.getString("naziv");

				System.out.printf("%-5s %-20s", ptt, naziv); System.out.println();
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		} finally {
			// zatvaranje naredbe i rezultata
//			try {
//				rset.close();
//				stmt.close();
//			} catch (Exception ex1) {
//				ex1.printStackTrace();
//			}
			try {rset.close();} catch (Exception ex1) {ex1.printStackTrace();}
			try {stmt.close();} catch (Exception ex1) {ex1.printStackTrace();}
		}

		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
