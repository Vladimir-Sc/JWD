package com.ftninformatika.termin08.primer03.ui;

import java.util.List;

import com.ftninformatika.termin08.primer03.dao.PredmetDAO;
import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.model.Student;
import com.ftninformatika.termin08.primer03.utils.PomocnaKlasa;

public class PredmetUI {

	public static void menu(){
		int odluka = -1;
		while (odluka != 0) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				ispisiSvePredmete();
				break;
			case 2:
				unosNovogPredmeta();
				break;
			case 3:
				izmenaPodatakaOPredmetu();
				break;
			case 4:
				brisanjePodatakaOPredmetu();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}
	
	public static void ispisiMenu() {
		System.out.println("Rad sa predmetima - opcije:");
		System.out.println("\tOpcija broj 1 - ispis svih Predmeta");
		System.out.println("\tOpcija broj 2 - unos novog Predmeta");
		System.out.println("\tOpcija broj 3 - izmena naziva Predmeta");
		System.out.println("\tOpcija broj 4 - brisanje Predmeta");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA ISPIS PREDMETA ****/
	// ispisi sve predmete
	public static void ispisiSvePredmete() {
		try {
			List<Predmet> sviPredmeti = PredmetDAO.getAll();

			System.out.println();
			System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
					"id", 
					"naziv", 
					"studenti", 
					"", 
					"", 
					""); System.out.println();
			System.out.println("========== ==================== ==================== ==================== ====================");
			for (Predmet itPredmet: sviPredmeti) {
				System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
						itPredmet.getId(), 
						itPredmet.getNaziv(), 
						"", 
						"", 
						""); System.out.println();
				for (Student itStudent: itPredmet.getStudenti()) {
					System.out.printf("%-10s %-20s %-20s %-20s %-20s", 
							"",
							"",
							itStudent.getIndeks(),
							itStudent.getIme(), 
							itStudent.getPrezime()); System.out.println();
				}
				System.out.println("---------- -------------------- -------------------- -------------------- --------------------");
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}
	
	/** METODE ZA PRETRAGU PREDMETA ****/
	// pronadji predmet
	public static Predmet pronadjiPredmet() {
		System.out.print("Unesi id predmeta: ");
		int id = PomocnaKlasa.ocitajCeoBroj();
		try {
			Predmet predmet = PredmetDAO.getPredmetByID(id);
			if (predmet == null) {
				System.out.println("Predmet sa id-om " + id + " ne postoji u evidenciji");
			}
			return predmet;
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		return null;
	}
	
	/** METODE ZA UNOS, IZMENU I BRISANJE PREDMETA ****/
	// unos novog predmeta
	public static void unosNovogPredmeta() {
		System.out.print("Naziv: ");
		String prNaziv= PomocnaKlasa.ocitajTekst();
		
		Predmet predmet = new Predmet(0, prNaziv);
		try {
			//ovde se moze proveravati i povratna vrednost i onda ispisivati poruka
			PredmetDAO.add(predmet);
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}
	
	// izmena predmeta
	public static void izmenaPodatakaOPredmetu() {
		Predmet predmet = pronadjiPredmet();
		if (predmet != null){
			System.out.print("Unesi novi naziv: ");
			String prNaziv = PomocnaKlasa.ocitajTekst();
			predmet.setNaziv(prNaziv);

			try {
				PredmetDAO.update(predmet);
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}

	// brisanje predmeta
	public static void brisanjePodatakaOPredmetu() {
		Predmet predmet = pronadjiPredmet();
		if (predmet != null) {
			try {
				PredmetDAO.delete(predmet.getId());
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}	
}
