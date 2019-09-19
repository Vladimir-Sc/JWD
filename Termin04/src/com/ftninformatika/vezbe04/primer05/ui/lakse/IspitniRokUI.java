package com.ftninformatika.vezbe04.primer05.ui.lakse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.ftninformatika.vezbe04.primer05.model.IspitnaPrijava;
import com.ftninformatika.vezbe04.primer05.model.IspitniRok;
import com.ftninformatika.vezbe04.primer05.model.Predmet;
import com.ftninformatika.vezbe04.primer05.model.Student;
import com.ftninformatika.vezbe04.primer05.utils.PomocnaKlasa;

public class IspitniRokUI {

	public static ArrayList<IspitniRok> sviIspitniRokovi = new ArrayList<IspitniRok>();

	public static void meniIspitniRokUI() {

		int odluka = -1;
		while (odluka != 0) {
			ispisiTekstIspitniRokOpcije();
			System.out.println("opcija: ");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				unosNovogIspitnogRoka();
				break;
			case 2:
				izmenaPodatakaIspitnogRoka();
				break;
			case 3:
				ispisiSveIspitneRokove();
				break;
			case 4:
				IspitniRok ir = pronadiIspitniRokId();
				if(ir!=null){
					System.out.println(ir.toString());
				}	
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;		

			}
		}
	}

	
	/** METODE ZA ISPIS OPCIJA ****/
	//ispis teksta osnovnih opcija
	public static void ispisiTekstIspitniRokOpcije() {
		System.out.println("Rad sa Ispitnim Rokovima - opcije: ");
		System.out.println("\tOpcija broj 1 - unos podataka o novom ispitnom roku");
		System.out.println("\tOpcija broj 2 - izmena podataka o ispitnom rokuu");
		System.out.println("\tOpcija broj 3 - ispis podataka svih ispitnih rokova ");
		System.out.println("\tOpcija broj 4 - ispis podataka o određenom ispitnom roku");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");

	}
	
	
	/** METODE ZA ISPIS ROKOVA ****/
	//ispisi sve rokove
	public static void ispisiSveIspitneRokove() {
		for (int i = 0; i < sviIspitniRokovi.size(); i++) {
			System.out.println(sviIspitniRokovi.get(i));
		}
	}
	
	
	/** METODE ZA PRETRAGU ROKOVA****/
	//pronadji ispitni rok
	public static IspitniRok pronadiIspitniRokId(int id) {
		IspitniRok retVal = null;

		for (int i = 0; i < sviIspitniRokovi.size(); i++) {
			IspitniRok ir = sviIspitniRokovi.get(i);
			if (ir.getId() == id) {
				retVal = ir;
				break;
			}
		}

		return retVal;
	}
	
	public static IspitniRok pronadiIspitniRokId() {
		IspitniRok retVal = null;
		System.out.print("Unesi naziv ispitnog roka:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		retVal = pronadiIspitniRokId(id);
		if (retVal == null)
			System.out.println("Ispitni rok sa id-om " + id
					+ " ne postoji u evidenciji");
		return retVal;
	}
	
	public static int pronadjiPozicijuRoka() {
		int retVal = -1;
		System.out.println("Unesi naziv roka: ");
		String irNaziv = PomocnaKlasa.ocitajTekst();
		for (int i = 0; i < sviIspitniRokovi.size(); i++) {
			IspitniRok ir = sviIspitniRokovi.get(i);
			if (ir.getNaziv().equals(irNaziv)) {
				retVal = i;
				break;
			}
		}
		if(retVal == -1)
			System.out.println("Roka sa nazivom " +irNaziv + " ne postoji u evidenciji");
		return retVal;
		
	}
	
	
	/** METODE ZA UNOS i IZMENU ROKOVA****/
	//upis novog roka
	public static void unosNovogIspitnogRoka() {
		System.out.println("Unesi naziv ispitnog roka: ");
		String irNaziv = PomocnaKlasa.ocitajTekst();
		System.out.println("Unesi pocetak ispitnog roka: ");
		String irPocetak = PomocnaKlasa.ocitajTekst();
		System.out.println("unesi kraj ispitnog roka: ");
		String irKraj = PomocnaKlasa.ocitajTekst();

		IspitniRok ir = new IspitniRok(0, irNaziv, irPocetak, irKraj);
		sviIspitniRokovi.add(ir);
	}


	//izmena ispitnog roka
	public static void izmenaPodatakaIspitnogRoka() {
		IspitniRok ir = pronadiIspitniRokId();
		if (ir != null) {
			System.out.print("Unesi ime:");
			String irNaziv = PomocnaKlasa.ocitajTekst();
			System.out.print("Unesi prezime:");
			String irPocetak = PomocnaKlasa.ocitajTekst();
			System.out.print("Unesi grad:");
			String irkraj  = PomocnaKlasa.ocitajTekst();
		
			ir.setNaziv(irNaziv);
			ir.setPocetak(irPocetak);
			ir.setKraj(irkraj);
			
		}
	}

	//brisanje roka
	public static void brisanjeRoka(){
		int pozicija = pronadjiPozicijuRoka();
		if(pozicija!=-1){
			sviIspitniRokovi.remove(pozicija);
			System.out.println("Podaci obrisani iz evidencije");
		}
	}	
	
	
	/** METODA ZA UCITAVANJE PODATAKA****/
	static void citajIzFajlaIspitneRokove(File dokument) throws IOException {
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
				sviIspitniRokovi.add(new IspitniRok(s2));
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	static void pisiUFajlIspitneRokove(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (IspitniRok ir : sviIspitniRokovi) {
			out2.println(ir.toFileRepresentation());
		}
		
		out2.flush();
		out2.close();
	}
//	/** METODA ZA UCITAVANJE PODATAKA****/
//	public static void citajIzFajlaIspitneRokove(File dokument) throws IOException {
//
//		if (dokument.exists()) {
//			System.out.println("Dokument postoji");
//			BufferedReader in = new BufferedReader(new FileReader(dokument));
//
//			in.mark(1); // zapamti trenutnu poziciju u fajlu da mozes kasnije da se vratis na nju
//			if (in.read() != '\ufeff') {
//				in.reset();
//			}
//
//			String s2;
//			while ((s2 = in.readLine()) != null) {
//
//				sviIspitniRokovi.add(new IspitniRok(s2));
//			}
//			
//			in.close();
//
//		} else {
//			System.out.println("Ne postoji fajl!");
//		}
//
//	}
//	
//	static void pisiUFajlIspitneRokove(File dokument) throws IOException {
//		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
//		for (IspitniRok rok : sviIspitniRokovi) {
//			out2.println(rok.toFileRepresentation());
//		}
//		
//		out2.flush();
//		out2.close();
//	}
}
