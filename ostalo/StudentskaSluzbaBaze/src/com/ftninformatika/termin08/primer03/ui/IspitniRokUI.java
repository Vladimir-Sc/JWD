package com.ftninformatika.termin08.primer03.ui;

import java.sql.Date;
import java.util.List;

import com.ftninformatika.termin08.primer03.dao.IspitniRokDAO;
import com.ftninformatika.termin08.primer03.model.IspitniRok;
import com.ftninformatika.termin08.primer03.utils.PomocnaKlasaDatumi;

public class IspitniRokUI {
	
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
				ispisiSveIspitneRokove();
				break;
			case 2:
				unosNovogIspitnogRoka();
				break;
			case 3:
				izmenaPodatakaOIspitnomRoku();
				break;
			case 4:
				brisanjePodatakaOIspitnomRoku();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}
	
	public static void ispisiMenu() {
		System.out.println("Rad sa ispitnim rokovima - opcije:");
		System.out.println("\tOpcija broj 1 - ispis svih Ispitnih rokova");
		System.out.println("\tOpcija broj 2 - unos novog Ispitnog roka");
		System.out.println("\tOpcija broj 3 - izmena Ispitnog Roka");
		System.out.println("\tOpcija broj 4 - brisanje Ispitnog Roka");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA ISPIS PREDMETA ****/
	// ispisi sve predmete
	public static void ispisiSveIspitneRokove() {
		try {
			List<IspitniRok> sviIspitniRokovi = IspitniRokDAO.getAll();
	
			System.out.println();
			System.out.printf("%-10s %-20s %-15s %-15s", 
					"id", 
					"naziv", 
					"pocetak", 
					"kraj"); System.out.println();
			System.out.println("========== ==================== =============== ===============");
			for (IspitniRok itIspitniRok: sviIspitniRokovi) {
				System.out.printf("%-10s %-20s %-15s %-15s", 
						itIspitniRok.getId(), 
						itIspitniRok.getNaziv(), 
						PomocnaKlasaDatumi.DATE_FORMAT.format(itIspitniRok.getPocetak()), 
						PomocnaKlasaDatumi.DATE_FORMAT.format(itIspitniRok.getKraj())); System.out.println();
				System.out.println("---------- -------------------- --------------- ---------------");
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}
	
	/** METODE ZA PRETRAGU ISPITNIH ROKOVA ****/
	// pronadji ispitni rok
	public static IspitniRok pronadjiIspitniRok() {
		System.out.print("Unesi id ispitnog roka: ");
		int id = PomocnaKlasaDatumi.ocitajCeoBroj();
		try {
			IspitniRok rok = IspitniRokDAO.getIspitniRokByID(id);
			if (rok == null) {
				System.out.println("Ispitni rok sa id-em " + id + " ne postoji u evidenciji");
			}
			return rok;
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		return null;
	}
	
	/** METODE ZA UNOS, IZMENU I BRISANJE ISPITNIH ROKOVA ****/
	// unos novog ispitnog roka
	public static void unosNovogIspitnogRoka() {
		System.out.print("Naziv: ");
		String naziv = PomocnaKlasaDatumi.ocitajTekst();	
		System.out.print("Unesi pocetak (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
		Date pocetak = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
		System.out.print("Unesi kraj (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
		Date kraj = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());

		IspitniRok ispRok = new IspitniRok(0, naziv, pocetak, kraj);
		try {
			//ovde se moze proveravati i povratna vrednost i onda ispisivati poruka
			IspitniRokDAO.add(ispRok);
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}
	
	// izmena ispitnog roka
	public static void izmenaPodatakaOIspitnomRoku() {
		IspitniRok ispRok = pronadjiIspitniRok();
		if (ispRok != null) {
			System.out.print("Unesi novi naziv: ");
			String naziv = PomocnaKlasaDatumi.ocitajTekst();
			System.out.print("Unesi novi pocetak (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
			Date pocetak = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
			System.out.print("Unesi novi kraj (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
			Date kraj = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());

			ispRok.setNaziv(naziv);
			ispRok.setPocetak(pocetak);
			ispRok.setKraj(kraj);
			try {
				IspitniRokDAO.update(ispRok);
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}

	// brisanje ispitnog roka
	public static void brisanjePodatakaOIspitnomRoku() {
		IspitniRok rok = pronadjiIspitniRok();
		if (rok != null) {
			try {
				IspitniRokDAO.delete(rok.getId());
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}	
}
