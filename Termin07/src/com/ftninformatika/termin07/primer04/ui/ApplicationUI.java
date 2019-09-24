package com.ftninformatika.termin07.primer04.ui;

import com.ftninformatika.termin07.primer04.utils.PomocnaKlasaDatumi;

public class ApplicationUI {

	public static void ispisiTekstOsnovneOpcije(){	
		System.out.println("Pregledi - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Prikaz svih pregleda");
		System.out.println("\tOpcija broj 2 - Zakazivanje pregleda");
		System.out.println("\tOpcija broj 3 - Popunjavanje pregleda");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
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
			ispisiTekstOsnovneOpcije();

			System.out.print("opcija:");
			odluka = PomocnaKlasaDatumi.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					PregledUI.prikazSvih();
					break;
				case 2:
					PregledUI.zakazivanje();
					break;
				case 3:
					PregledUI.popunjavanje();
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
