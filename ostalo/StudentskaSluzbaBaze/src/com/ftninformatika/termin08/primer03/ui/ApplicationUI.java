package com.ftninformatika.termin08.primer03.ui;

import com.ftninformatika.termin08.primer03.dao.ConnectionManager;
import com.ftninformatika.termin08.primer03.utils.PomocnaKlasaDatumi;

public class ApplicationUI {

	public static void main(String[] args)  {
		try {
			ConnectionManager.open();
		} catch (Exception ex) {
			System.out.println("Neuspesna konekcija na bazu!");

			ex.printStackTrace();
			return;
		}

		int odluka = -1;
		while (odluka != 0) {
			ApplicationUI.ispisiMenu();
			
			System.out.print("opcija:");
			odluka = PomocnaKlasaDatumi.ocitajCeoBroj();
			
			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa");
				break;
			case 1:
				StudentUI.menu();
				break;
			case 2:
				NastavnikUI.menu();
				break;
			case 3:
				PredmetUI.menu();
				break;
			case 4:
				IspitniRokUI.menu();
				break;
			case 5:
				PohadjaUI.menu();
				break;
			case 6:
				PredajeUI.menu();
				break;
			case 7:
				IspitnaPrijavaUI.menu();
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
	
	// ispis teksta osnovnih opcija
	public static void ispisiMenu() {
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\tOpcija broj 2 - Rad sa nastavnicima");
		System.out.println("\tOpcija broj 3 - Rad sa predmetima");
		System.out.println("\tOpcija broj 4 - Rad sa ispitnim rokovima");
		System.out.println("\tOpcija broj 5 - Rad sa pohadjanjem predmeta");
		System.out.println("\tOpcija broj 6 - Rad sa predavanjem nastavnika");
		System.out.println("\tOpcija broj 7 - Rad sa ispitnim prijavama studenta");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");
	}

}
