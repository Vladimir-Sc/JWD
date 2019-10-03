package com.ftninformatik05.primer05.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.ftninformatik05.primer05.model.IspitnaPrijava;
import com.ftninformatik05.primer05.model.IspitniRok;
import com.ftninformatik05.primer05.model.Predmet;
import com.ftninformatik05.primer05.model.Student;
import com.ftninformatik05.primer05.utils.PomocnaKlasa;


public class IspitnaPrijavaUI {
	private static void ispisiMenu() {
		System.out.println("Rad sa ispitnim prijavama - opcije:");
		System.out.println("\tOpcija broj 1 - ispitne prijave za ispitni rok");
		System.out.println("\tOpcija broj 2 - ispitne prijave za studenta");
		System.out.println("\tOpcija broj 3 - ispitne prijave za predmet");
		System.out.println("\tOpcija broj 4 - dodavanje ispitne prijave");
		System.out.println("\tOpcija broj 5 - uklanjanje ispitne prijave");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");
	}

	public static void menuIspitnaPrijavaUI() {
		int odluka = -1;
		while (odluka != 0) {
			ispisiMenu();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				ispisiIspitnePrijaveZaIspitnirok();
				break;
			case 2:
//				ispisiIspitnePrijaveZaStudenta();
				break;
			case 3:
//				ispisiIspitnePrijaveZaPredmet();
				break;
			case 4:
//				dodajIspitnuPrijavu();
				break;
			case 5:
//				ukloniIspitnuPrijavu();
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}

	public static void ispisiIspitnePrijaveZaIspitnirok() {
		// najpre pronadjemo ispitni rok za kojeg zelimo ispis
		IspitniRok ir = IspitniRokUI.pronadjiIspitniRok();
		if (ir != null) {
			List<IspitnaPrijava> ispitnePrijave = ir.getIspitnePrijave();
	
			for (IspitnaPrijava isp : ispitnePrijave) {
				System.out.println(isp);
			}
		}
	}

	public static void dodajIspitnuPrijavu() {
		// najpre pronadjemo studenta za kojeg zelimo da dodamo na ispitnu prijavu

		//pronadjemo predmet za koji zelimo da dodamo na ispitnu prijavu

		//pronadjemo ispitni rok za koji zelimo da dodamo na ispitnu prijavu
		
	}
	
	public static void dodajIspitnuPrijavu(IspitniRok ispitniRok, Student student, Predmet predmet) {	

	}
	
	/** METODA ZA UCITAVANJE PODATAKA****/
	static void citajIzFajlaIspitnePrijave(File dokument) throws IOException {
		if(dokument.exists()){

			BufferedReader in = new BufferedReader(new FileReader(dokument));
			
			//workaround for UTF-8 files and BOM marker
			//BOM (byte order mark) marker may appear on the beginning of the file
			//BOM can signal which of several Unicode encodings (8-bit, 16-bit, 32-bit) that text is encoded as
			
			in.mark(1); //zapamti trenutnu poziciju u fajlu da mozes kasnije da se vratis na nju
			if(in.read()!='\ufeff'){
				in.reset();
			}
			
			String s2;
			while((s2 = in.readLine()) != null) {
				//I Nacin
				citajIspitnuPrijavu(s2);
				
				//II nacin
//				new IspitnaPrijava(s2);
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	private static IspitnaPrijava citajIspitnuPrijavu(String txt) {
		String[] tokeni=null;
		
		Student st;
		Predmet pr;
		IspitniRok ir;
		int teorija;
		int zadaci;
		
		IspitnaPrijava isp = null;
		
		tokeni = txt.split(",");
		st = StudentUI.pronadjiStudentaId(Integer.parseInt(tokeni[0]));
		pr = PredmetUI.pronadjiPredmetId(Integer.parseInt(tokeni[1]));
		ir = IspitniRokUI.pronadjiIspitniRokId(Integer.parseInt(tokeni[2]));
		teorija = Integer.parseInt(tokeni[3]);
		zadaci = Integer.parseInt(tokeni[4]);
		
		isp = new IspitnaPrijava(st, pr, ir, teorija, zadaci);
		
		//povezivanje
		st.getIspitnePrijave().add(isp);
		pr.getIspitnePrijave().add(isp);
		ir.getIspitnePrijave().add(isp);

		return isp;
	}

}
