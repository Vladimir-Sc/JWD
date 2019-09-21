package svetskaPrvenstva.ui;

import svetskaPrvenstva.utility.PomocnaKlasa;

public class ApplicationUI {

	public static void ispisiTekstOsnovneOpcije(){	
		System.out.println("Svetska prvenstva - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Prikaz svih drzava");
		System.out.println("\tOpcija broj 2 - Prikaz svih prvenstava sa drzavama");
		System.out.println("\tOpcija broj 3 - Unos prvenstva");
		System.out.println("\tOpcija broj 4 - Izmena prvensva");
		System.out.println("\tOpcija broj 5 - Sortiranje prvenstava po nazivu");
		System.out.println("\tOpcija broj 6 - Sortiranje prvenstava po godini");
		System.out.println("\tOpcija broj 7 - Statistika");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void main(String[] args) {
		DrzavaUI.ucitaj();
		SvetskoPrvenstvoUI.ucitaj();

		int odluka = -1;
		while (odluka!= 0){
			ispisiTekstOsnovneOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					DrzavaUI.prikazSvihDrzava();
					break;
				case 2:
					SvetskoPrvenstvoUI.prikazSvihPrvenstavaSaDrzavama();
					break;
				case 3:
					SvetskoPrvenstvoUI.unosPrvenstva();
					break;
				case 4:
					SvetskoPrvenstvoUI.izmenaPrvenstva();
					break;
				case 5:
					SvetskoPrvenstvoUI.sortiranjePrvenstavaPoNazivu();
					break;
				case 6:
					SvetskoPrvenstvoUI.sortiranjePrvenstavaPoGodini();
					break;
				case 7:
					DrzavaUI.statistika();
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}
		
	}
	
}
