package banka.ui;

import banka.dao.ConnectionManager;
import banka.utils.PomocnaKlasaDatumi;

public class ApplicationUI {

	private static void ispisiMenu() {
		System.out.println();
		System.out.println("Banka - Meni:");
		System.out.println("\t1 - Dodavanje naloga");
		System.out.println("\t2 - Prikaz svih naloga");
		System.out.println("\t3 - Prikaz svih racuna sa uplatama i isplatama");
		System.out.println("\t4 - Tabelarni prikaz");
		System.out.println("\t5 - Realizacija svih naloga");
		System.out.println("\t6 - Izvestaj po racunu");
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
					NaloziUI.dodavanje();
					break;
				case "2":
					NaloziUI.prikazSvih();
					break;
				case "3":
					RacuniUI.prikazSvih();
					break;
				case "4":
					NaloziUI.tabelarniPrikaz();
					break;
				case "5":
					NaloziUI.realizacija();
					break;
				case "6":
					RacuniUI.izvestaj();
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
