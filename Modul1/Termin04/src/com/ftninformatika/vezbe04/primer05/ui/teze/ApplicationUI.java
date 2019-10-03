package com.ftninformatika.vezbe04.primer05.ui.teze;

import java.io.File;
import java.io.IOException;

import com.ftninformatika.vezbe04.primer05.utils.PomocnaKlasa;

public class ApplicationUI {
	
	StudentUI stUI = new StudentUI();
	PredmetUI prUI = new PredmetUI();
	PohadjaUI pohUI = new PohadjaUI();
//	IspitniRokUI irUI = new IspitniRokUI();
//	IspitnaPrijavaUI ispUI = new IspitnaPrijavaUI();
	
	public void ispisiTekstOsnovneOpcije(){	
		System.out.println("Studentska Sluzba - Osnovne opcije:");
		System.out.println("\tOpcija broj 1 - Rad sa studentima");
		System.out.println("\tOpcija broj 2 - Rad sa predmetima");
		System.out.println("\tOpcija broj 3 - Rad sa nastavnicima");
		System.out.println("\tOpcija broj 4 - Rad sa ispitnim rokovima");
		System.out.println("\tOpcija broj 5 - Rad sa pohađa");
		System.out.println("\tOpcija broj 6 - Rad sa predaje");
		System.out.println("\tOpcija broj 7 - Rad sa ispitnim prijavama");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ IZ PROGRAMA");	
	}
	
	public static void main(String[] args) throws IOException {
		String sP = System.getProperty("file.separator");
		
		ApplicationUI appUI = new ApplicationUI();
		
		File studentiFajl = new File("."+sP+"data"+sP+"studenti.csv");
		appUI.stUI.citajIzFajlaStudente(studentiFajl);
		
		File predmetiFajl = new File("."+sP+"data"+sP+"predmeti.csv");
		appUI.prUI.citajIzFajlaPredmete(predmetiFajl);
		
		File pohadjaFajl = new File("."+sP+"data"+sP+"pohadja.csv");
		appUI.pohUI.citajIzFajlaPohadja(pohadjaFajl, appUI.stUI, appUI.prUI);
		
//		File ispitniRokFajl = new File("."+sP+"data"+sP+"ispitni_rokovi.csv");
//		appUI.irUI.citajIzFajlaIspitneRokove(ispitniRokFajl);
		
//		File ispitnePrijaveFajl = new File("."+sP+"data"+sP+"ispitne_prijave.csv");
//		appUI.ispUI.citajIzFajlaIspitnePrijave(ispitnePrijaveFajl);
		
		int odluka = -1;
		while(odluka!= 0){
			appUI.ispisiTekstOsnovneOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
				case 0:	
					System.out.println("Izlaz iz programa");	
					break;
				case 1:
					appUI.stUI.meniStudentUI(appUI.prUI, appUI.pohUI);
					break;
				case 2:
					appUI.prUI.meniPredmetUI(appUI.stUI, appUI.pohUI);
					break;
				case 5:
					appUI.pohUI.menuPohadjaUI(appUI.stUI, appUI.prUI);
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;
			}
		}
		
		appUI.stUI.pisiUFajlStudente(studentiFajl);
		appUI.prUI.pisiUFajlPredmete(predmetiFajl);
		appUI.pohUI.pisiUFajlPohadja(pohadjaFajl, appUI.stUI, appUI.prUI);
//		appUI.irUI.pisiUFajlIspitneRokove(ispitniRokFajl);
//		appUI.ispUI.pisiUFajlIspitnePrijave(ispitnePrijaveFajl, appUI.stUI, appUI.prUI, appUI.irUI);
		System.out.print("Program izvrsen");
	}
}
