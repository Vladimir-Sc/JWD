package com.ftninformatika.termin08.primer03.ui;

import com.ftninformatika.termin08.primer03.dao.PredajeDAO;
import com.ftninformatika.termin08.primer03.model.Nastavnik;
import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.utils.PomocnaKlasaDatumi;

public class PredajeUI {
	private static void ispisiMenu() {
		System.out.println("Rad sa predavanjima nastavnika - opcije:");
		System.out.println("\tOpcija broj 1 - predmeti koje nastavnik predaje");
		System.out.println("\tOpcija broj 2 - nastavnici koji predaju predmet");
		System.out.println("\tOpcija broj 3 - dodavanje nastavnika na predmet");
		System.out.println("\tOpcija broj 4 - uklanjanje nastavnika sa predmeta");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");
	}

	public static void menu() {
		int odluka = -1;
		while (odluka != 0) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasaDatumi.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				ispisiPredmeteZaNastavnika();
				break;
			case 2:
				ispisiNastavnikeZaPredmet();
				break;
			case 3:
				dodajNastavnikaNaPredmet();
				break;
			case 4:
				ukloniNastavnikaSaPredmeta();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}

	private static void ispisiPredmeteZaNastavnika() {
		// najpre pronadjemo nastavnika za kojeg zelimo ispis predmeta
		Nastavnik nastavnik = NastavnikUI.pronadjiNastavnika();
		if (nastavnik != null) {
			System.out.println();
			System.out.printf("%-10s %-20s", 
					"id", 
					"naziv"); System.out.println();		
			System.out.println("========== ====================");
			try {
				for (Predmet itPredmet: PredajeDAO.getPredmetiByNastavnkID(nastavnik.getId())) {
					System.out.printf("%-10s %-20s", 
							itPredmet.getId(), 
							itPredmet.getNaziv()); System.out.println();
				}
				System.out.println("---------- --------------------");
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");
	
				ex.printStackTrace();
			}
		}
	}
	
	private static void ispisiNastavnikeZaPredmet() {
		// najpre pronadjemo predmet za koji zelimo ispis nastavnika
		Predmet predmet = PredmetUI.pronadjiPredmet();
		if (predmet != null) {
			System.out.println();
			System.out.printf("%-10s %-20s %-20s %-20s", 
					"id", 
					"ime", 
					"prezime", 
					"zvanje"); System.out.println();
			System.out.println("========== ==================== ==================== ====================");
			try {
				for (Nastavnik itNastavnik: PredajeDAO.getNastavniciByPredmetID(predmet.getId())) {
					System.out.printf("%-10s %-20s %-20s %-20s", 
							itNastavnik.getId(), 
							itNastavnik.getIme(), 
							itNastavnik.getPrezime(), 
							itNastavnik.getZvanje()); System.out.println();
				}
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");
	
				ex.printStackTrace();
			}
		}
	}

	private static void dodajNastavnikaNaPredmet() {
		// najpre pronadjemo nastavnika kojeg zelimo da dodamo na predmet
		Nastavnik nastavnik = NastavnikUI.pronadjiNastavnika();
		// pronadjemo predmet na koji zelimo da dodamo nastavnika
		Predmet predmet = PredmetUI.pronadjiPredmet();
		
		if (nastavnik != null && predmet != null) {
			try {
				// uspostavimo vezu izmedju nastavnika i predmeta
				PredajeDAO.add(nastavnik.getId(), predmet.getId());
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");
	
				ex.printStackTrace();
			}
		}
	}
	
	private static void ukloniNastavnikaSaPredmeta() {
		// najpre pronadjemo nastavnika kojeg zelimo da uklonimo sa predmeta
		Nastavnik nastavnik = NastavnikUI.pronadjiNastavnika();
		// pronadjemo predmet sa kojeg zelimo da uklonimo nastavnika
		Predmet predmet = PredmetUI.pronadjiPredmet();
		
		if (nastavnik != null && predmet != null) {
			try {
				// uklonimo vezu izmedju nastavnika i predmeta
				PredajeDAO.delete(nastavnik.getId(), predmet.getId());
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");
	
				ex.printStackTrace();
			}
		}
	}
}
