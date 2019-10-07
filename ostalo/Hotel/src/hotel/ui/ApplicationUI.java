package hotel.ui;

import hotel.dao.ConnectionManager;
import hotel.utils.PomocnaKlasaDatumi;

public class ApplicationUI {

	private static void ispisiMenu() {
		System.out.println();
		System.out.println("Hotel - Meni:");
		System.out.println("\t1 - Prikaz svih soba");
		System.out.println("\t2 - Prikaz svih rezervacija za zadati period");
		System.out.println("\t3 - Izmena datuma i vremena za postojecu rezervaciju");
		System.out.println("\t4 - Tabelarni prikaz");
		System.out.println("\t5 - Izvestaj");
		System.out.println("\tx - IZLAZ IZ PROGRAMA");
	}
	
	public static void main(String[] args) {
		try {
			ConnectionManager.open();
		} catch (Exception ex) {
			System.out.println("Neuspesna konekcija na bazu!");

			ex.printStackTrace();
			return;
		}

		String odluka = "";
		while (!odluka.equals("x")) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasaDatumi.ocitajTekst();
			switch (odluka) {				
				case "1":
					SobeUI.prikazSvih();
					break;
				case "2":
					RezervacijeUI.prikazSvih();
					break;
				case "3":
					RezervacijeUI.izmena();
					break;
				case "4":
					RezervacijeUI.tabelarniPrikaz();
					break;
				case "5":
					RezervacijeUI.izvestaj();
					break;
				case "x":
					System.out.println("Izlaz");
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}

		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
