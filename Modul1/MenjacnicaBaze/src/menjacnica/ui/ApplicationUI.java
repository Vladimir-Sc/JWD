package menjacnica.ui;

import menjacnica.dao.ConnectionManager;
import menjacnica.utils.PomocnaKlasaDatumi;

public class ApplicationUI {
	
	public static void main(String[] args) {
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
			
			System.out.print("opcija: ");
			odluka = PomocnaKlasaDatumi.ocitajCeoBroj();	
			switch (odluka) {
				case 0:
					System.out.println("Izlaz iz programa");
					break;
				case 1:
					ValutaUI.prikazSvih();
					break;
				case 2:
					KursnaListaUI.prikaz();
					break;
				case 3:
					KursnaListaUI.unos();
					break;
				case 4:
					ValutaUI.statistika();
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

	public static void ispisiMenu() {
		System.out.println("Menjacnica - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Prikaz svih valuta");
		System.out.println("\tOpcija broj 2 - Prikaz određene kursne liste sa spiskom svih valuta");
		System.out.println("\tOpcija broj 3 - Kreiranje nove kursne liste");
		System.out.println("\tOpcija broj 4 - Statistika");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");
	}

}
