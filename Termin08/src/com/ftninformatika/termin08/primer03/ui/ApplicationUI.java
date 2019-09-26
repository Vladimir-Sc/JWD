package com.ftninformatika.termin08.primer03.ui;

import com.ftninformatika.termin08.primer03.dao.ConnectionManager;
import com.ftninformatika.termin08.primer03.utils.PomocnaKlasa;

public class ApplicationUI {

	public static void main(String[] args)  {
		try {
			// otvaranje konekcije, jednom na pocetku aplikacije
			ConnectionManager.open();
		} catch (Exception ex) {
			System.out.println("Neuspesna konekcija na bazu!");

			ex.printStackTrace();
			// kraj aplikacije
			return;
		}

		int odluka = -1;
		while (odluka != 0) {
			ApplicationUI.ispisiMenu();
			
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			
			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa");
				break;
			case 1:
				StudentUI.menu();
				break;
			case 2:
				PredmetUI.menu();
				break;
			case 3:
				PohadjaUI.menu();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}

		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	// ispis teksta osnovnih opcija
	public static void ispisiMenu() {
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\tOpcija broj 2 - Rad sa predmetima");
		System.out.println("\tOpcija broj 3 - Rad sa pohadjanjem predmeta");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");
	}

}
