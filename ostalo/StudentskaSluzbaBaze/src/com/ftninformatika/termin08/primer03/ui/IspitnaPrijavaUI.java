package com.ftninformatika.termin08.primer03.ui;

import com.ftninformatika.termin08.primer03.dao.IspitnaPrijavaDAO;
import com.ftninformatika.termin08.primer03.model.IspitnaPrijava;
import com.ftninformatika.termin08.primer03.model.IspitniRok;
import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.model.Student;
import com.ftninformatika.termin08.primer03.utils.PomocnaKlasaDatumi;

public class IspitnaPrijavaUI {
	private static void ispisiMenu() {
		System.out.println("Rad sa ispitnim prijavama studenta - opcije:");
		System.out.println("\tOpcija broj 1 - ispitne prijave studenta");
		System.out.println("\tOpcija broj 2 - ispitne prijave za predmet");
		System.out.println("\tOpcija broj 3 - ispitne prijave u roku");
		System.out.println("\tOpcija broj 4 - dodavanje ispitne prijave");
		System.out.println("\tOpcija broj 5 - izmena ispitne prijave");
		System.out.println("\tOpcija broj 6 - uklanjanje ispitne prijave");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");
	}

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
				ispisiIspitnePrijaveZaStudenta();
				break;
			case 2:
				ispisiIspitnePrijaveZaPredmet();
				break;
			case 3:
				ispisiIspitnePrijaveZaRok();
				break;
			case 4:
				dodajIspitnuPrijavu();
				break;
			case 5:
				izmeniIspitnuPrijavu();
				break;
			case 6:
				ukloniIspitnuPrijavu();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}

	private static void ispisiIspitnePrijaveZaStudenta() {
		Student student = StudentUI.pronadjiStudenta();
		if (student != null) {
			System.out.println();
			System.out.printf("%-10s %-20s %-10s %-20s %-12s %-12s %-10s %-10s", 
					"predmet", 
					"", 
					"rok", 
					"", 
					"", 
					"", 
					"teorija", 
					"zadaci"); System.out.println();
			System.out.println("========== ==================== ========== ==================== ============ ============ ========== ==========");
			try {
				for (IspitnaPrijava itIspPrijava: IspitnaPrijavaDAO.getPrijaveByStudent(student)) {
					System.out.printf("%-10s %-20s %-10s %-20s %-12s %-12s %-10s %-10s", 
							itIspPrijava.getPredmet().getId(), 
							itIspPrijava.getPredmet().getNaziv(), 
							itIspPrijava.getRok().getId(), 
							itIspPrijava.getRok().getNaziv(), 
							PomocnaKlasaDatumi.DATE_FORMAT.format(itIspPrijava.getRok().getPocetak()), 
							PomocnaKlasaDatumi.DATE_FORMAT.format(itIspPrijava.getRok().getKraj()), 
							itIspPrijava.getTeorija(), 
							itIspPrijava.getZadaci()); System.out.println();
				}
				System.out.println("---------- -------------------- ---------- -------------------- ------------ ------------ ---------- ----------");
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}
	
	private static void ispisiIspitnePrijaveZaPredmet() {
		Predmet predmet = PredmetUI.pronadjiPredmet();
		if (predmet != null) {
			System.out.println();
			System.out.printf("%-10s %-20s %-20s %-10s %-20s %-12s %-12s %-10s %-10s", 
					"student", 
					"", 
					"", 
					"rok", 
					"", 
					"", 
					"", 
					"teorija", 
					"zadaci"); System.out.println();
			System.out.println("========== ==================== ==================== ========== ==================== ============ ============ ========== ==========");
			try {		
				for (IspitnaPrijava itIspPrijava: IspitnaPrijavaDAO.getPrijaveByPredmet(predmet)) {
					System.out.printf("%-10s %-20s %-20s %-10s %-20s %-12s %-12s %-10s %-10s", 
							itIspPrijava.getStudent().getIndeks(), 
							itIspPrijava.getStudent().getIme(), 
							itIspPrijava.getStudent().getPrezime(), 
							itIspPrijava.getRok().getId(), 
							itIspPrijava.getRok().getNaziv(), 
							PomocnaKlasaDatumi.DATE_FORMAT.format(itIspPrijava.getRok().getPocetak()), 
							PomocnaKlasaDatumi.DATE_FORMAT.format(itIspPrijava.getRok().getKraj()), 
							itIspPrijava.getTeorija(), 
							itIspPrijava.getZadaci()); System.out.println();
				}
				System.out.println("---------- -------------------- -------------------- ---------- -------------------- ------------ ------------ ---------- ----------");
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}

	private static void ispisiIspitnePrijaveZaRok() {
		IspitniRok ispRok = IspitniRokUI.pronadjiIspitniRok();
		if (ispRok != null) {
			System.out.println();
			System.out.printf("%-10s %-20s %-20s %-10s %-20s %-10s %-10s", 
					"student", 
					"", 
					"", 
					"predmet", 
					"", 
					"teorija", 
					"zadaci"); System.out.println();
			System.out.println("========== ==================== ==================== ========== ==================== ========== ==========");
			try {		
				for (IspitnaPrijava itIspPrijava: IspitnaPrijavaDAO.getPrijaveByIspRok(ispRok)) {
					System.out.printf("%-10s %-20s %-20s %-10s %-20s %-10s %-10s", 
							itIspPrijava.getStudent().getIndeks(), 
							itIspPrijava.getStudent().getIme(), 
							itIspPrijava.getStudent().getPrezime(), 
							itIspPrijava.getPredmet().getId(), 
							itIspPrijava.getPredmet().getNaziv(), 
							itIspPrijava.getTeorija(), 
							itIspPrijava.getZadaci()); System.out.println();
				}
				System.out.println("---------- -------------------- -------------------- ---------- -------------------- ---------- ----------");
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}
	
	private static void dodajIspitnuPrijavu() {
		Student student = StudentUI.pronadjiStudenta();
		Predmet predmet = PredmetUI.pronadjiPredmet();
		IspitniRok ispRok = IspitniRokUI.pronadjiIspitniRok();

		System.out.println();
		System.out.println("Bodovi sa teorije: ");
		int teorija = PomocnaKlasaDatumi.ocitajCeoBroj();
		System.out.println("Bodovi za zadatke: ");
		int zadaci = PomocnaKlasaDatumi.ocitajCeoBroj();
		
		if (student != null && predmet != null && ispRok != null) {
			try {
				IspitnaPrijavaDAO.add(student.getId(), predmet.getId(), ispRok.getId(), teorija, zadaci);			
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}

		}
	}

	private static void izmeniIspitnuPrijavu() {
		Student student = StudentUI.pronadjiStudenta();
		Predmet predmet = PredmetUI.pronadjiPredmet();
		IspitniRok ispRok = IspitniRokUI.pronadjiIspitniRok();

		System.out.println();
		System.out.println("Novi bodovi sa teorije: ");
		int teorija = PomocnaKlasaDatumi.ocitajCeoBroj();
		System.out.println("Novi bodovi za zadatke: ");
		int zadaci = PomocnaKlasaDatumi.ocitajCeoBroj();
		
		if (student != null && predmet != null && ispRok != null) {
			try {
				IspitnaPrijavaDAO.update(student.getId(), predmet.getId(), ispRok.getId(), teorija, zadaci);
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}

	private static void ukloniIspitnuPrijavu() {
		Student student = StudentUI.pronadjiStudenta();
		Predmet predmet = PredmetUI.pronadjiPredmet();
		IspitniRok ispRok = IspitniRokUI.pronadjiIspitniRok();
		
		if (student != null && predmet != null && ispRok != null) {
			try {
				IspitnaPrijavaDAO.delete(student.getId(), predmet.getId(), ispRok.getId());
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
			
		}
	}

}
