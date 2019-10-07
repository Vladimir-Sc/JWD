package svetskaPrvenstva.UI;

import svetskaPrvenstva.dao.ConnectionManager;
import svetskaPrvenstva.utils.PomocnaKlasa;

public class ApplicationUI {

	private static void ispisiTekstOpcije() {	
		System.out.println("Svetska prvenstva - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa drzavama");
		System.out.println("\tOpcija broj 2 - Rad sa prvenstvima");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}

	public static void meni() {
		int odluka = -1;
		while (odluka!= 0) {
			ispisiTekstOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					DrzavaUI.meni();
					break;
				case 2:
					PrvenstvoUI.meni();
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}
	}

	public static void main(String[] args) {
		try {
			// otvaranje konekcije, jednom na pocetku aplikacije
			ConnectionManager.open();
		} catch (Exception ex) {
			System.out.println("Neuspesna konekcija na bazu!");

			ex.printStackTrace();
			// kraj aplikacije
			return;
		}

		meni();

		// zatvaranje konekcije, jednom na kraju aplikacije
		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.print("Program izvrsen");
	}
	
}
