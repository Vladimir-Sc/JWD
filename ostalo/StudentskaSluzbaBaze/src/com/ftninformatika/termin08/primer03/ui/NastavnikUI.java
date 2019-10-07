package com.ftninformatika.termin08.primer03.ui;

import java.util.List;

import com.ftninformatika.termin08.primer03.dao.NastavnikDAO;
import com.ftninformatika.termin08.primer03.model.Nastavnik;
import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.utils.PomocnaKlasaDatumi;

public class NastavnikUI {

	public static void menu() {
		int odluka = -1;
		while (odluka != 0) {
			ispisiMenu();
			System.out.print("opcija: ");
			odluka = PomocnaKlasaDatumi.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				ispisiSveNastavnike();
				break;
			case 2:
				unosNovogNastavnika();
				break;
			case 3:
				izmenaPodatakaONastavniku();
				break;
			case 4:
				brisanjePodatakaONastavniku();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}

	public static void ispisiMenu() {
		System.out.println("Rad sa nastavnicima - opcije:");
		System.out.println("\tOpcija broj 1 - ispis svih Nastavnika");
		System.out.println("\tOpcija broj 2 - unos novog Nastavnika");
		System.out.println("\tOpcija broj 3 - izmena Nastavnika");
		System.out.println("\tOpcija broj 4 - brisanje Nastavnika");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");
	}

	/** METODE ZA ISPIS NASTAVNIKA ****/
	// ispisi sve nastavnike
	public static void ispisiSveNastavnike() {
		try {
			List<Nastavnik> sviNastavnici = NastavnikDAO.getAll();

			System.out.println();
			System.out.printf("%-5s %-20s %-20s %-20s %-20s", 
					"id", 
					"ime", 
					"prezime", 
					"zvanje", 
					"predmeti"); System.out.println();
			System.out.println("===== ==================== ==================== ==================== ====================");
			for (Nastavnik itNastavnik: sviNastavnici) {
				System.out.printf("%-5s %-20s %-20s %-20s", 
						itNastavnik.getId(), 
						itNastavnik.getIme(), 
						itNastavnik.getPrezime(), 
						itNastavnik.getZvanje()); System.out.println();
				for (Predmet itPredmet: itNastavnik.getPredmeti()) {
					System.out.printf("%-5s %-20s %-20s %-20s %-20s", 
							"", "", "", "", 
							itPredmet.getNaziv()); System.out.println();
				}
				System.out.println("----- -------------------- -------------------- -------------------- --------------------");
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	/** METODE ZA PRETRAGU STUDENATA ****/
	// pronadji studenta
	public static Nastavnik pronadjiNastavnika() {
		System.out.print("Unesi id nastavnika: ");
		int id = PomocnaKlasaDatumi.ocitajCeoBroj();
		try {
			Nastavnik nastavnik = NastavnikDAO.getNastavnikByID(id);
			if (nastavnik == null) {
				System.out.println("Nastavnik sa id-om " + id + " ne postoji u evidenciji");
			}
			return nastavnik;
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		return null;
	}

	/** METODE ZA UNOS, IZMENU I BRISANJE NASTAVNIKA ****/
	// unos novog nastavnika
	public static void unosNovogNastavnika() {
		System.out.print("Unesi ime: ");
		String naIme = PomocnaKlasaDatumi.ocitajTekst();
		System.out.print("Unesi prezime: ");
		String naPrezime = PomocnaKlasaDatumi.ocitajTekst();
		System.out.print("Unesi zvanje: ");
		String naZvanje = PomocnaKlasaDatumi.ocitajTekst();

		Nastavnik nast = new Nastavnik(0, naIme, naPrezime, naZvanje);
		try {
			// ovde se moze proveravati i povratna vrednost i onda ispisivati poruka
			NastavnikDAO.add(nast);
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}	

	// izmena nastavnika
	public static void izmenaPodatakaONastavniku() {
		Nastavnik nast = pronadjiNastavnika();
		if (nast != null) {
			System.out.print("Unesi ime: ");
			String naIme = PomocnaKlasaDatumi.ocitajTekst();
			nast.setIme(naIme);

			System.out.print("Unesi prezime: ");
			String naPrezime = PomocnaKlasaDatumi.ocitajTekst();
			nast.setPrezime(naPrezime);
	
			System.out.print("Unesi zvanje: ");
			String naZvanje = PomocnaKlasaDatumi.ocitajTekst();
			nast.setZvanje(naZvanje);

			try {
				NastavnikDAO.update(nast);
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}	
		}
	}

	// brisanje nastavnika
	public static void brisanjePodatakaONastavniku() {
		Nastavnik nast = pronadjiNastavnika();
		if (nast != null) {
			try {
				NastavnikDAO.delete(nast.getId());
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}

}
