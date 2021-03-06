package com.ftninformatika.termin06.primerDodatnoStudentskaSluzba.model.ui.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import com.ftninformatika.termin06.primerDodatnoStudentskaSluzba.model.Predmet;
import com.ftninformatika.termin06.primerDodatnoStudentskaSluzba.model.utils.PomocnaKlasa;

public class PredmetUI_Ver_HashMap {

	/** ATRIBUTI KLASE ****/
	public static HashMap<Integer, Predmet>  sviPredmeti = new HashMap<Integer, Predmet>();
	
	public static void meniPredmetUI(){
		int odluka = -1;
		while (odluka != 0) {
			ispisiTekstStudentOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
			case 0:
				System.out.println("Izlaz");
				break;
			case 1:
				unosNovogPredmeta();
				break;
			case 2:
				izmenaPodatakaOPredmetu();
				break;
			case 3:
				brisanjePodatakaOPredmetu();
				break;
			case 4:
				ispisiSvePredmete();
				break;
			case 5:
				Predmet pr = pronadjiPredmet();
				if(pr!=null){
					System.out.println(pr.toStringAllStudent());
				}	
				break;
			case 6:
				ArrayList<Predmet> sortiraniPredmeti = sortirajPredmetePoNazivu();
				ispisiSvePredmete(sortiraniPredmeti);
				break;
			default:
				System.out.println("Nepostojeca komanda");
				break;
			}
		}
	}
	
	public static void ispisiTekstStudentOpcije() {
		System.out.println("Rad sa predmetima - opcije:");
		System.out.println("\tOpcija broj 1 - unos podataka o novom Predmetu");
		System.out.println("\tOpcija broj 2 - izmena podataka o Predmetu");
		System.out.println("\tOpcija broj 3 - brisanje podataka o Predmetu");
		System.out.println("\tOpcija broj 4 - ispis podataka svih predmeta");
		System.out.println("\tOpcija broj 5 - ispis podataka o odredenom Predmetu i svih studenta koji pohađaju predmet");
		System.out.println("\tOpcija broj 6 - sortiranje i ispis predmeta po nazivu");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
	
	/** METODE ZA ISPIS PREDMETA ****/
	// ispisi sve predmete
	public static void ispisiSvePredmete() {
		//I nacin
		for (Integer id : sviPredmeti.keySet()) {
			System.out.println(sviPredmeti.get(id));
		}
		
		//II nacin
		/*
		for (Predmet pr : sviPredmeti.values()) {
			System.out.println(pr);
		}*/
		
		//III nacin
		/*
		Set<Integer> setPr = sviPredmeti.keySet(); //nije kao ArrayList
		for (Iterator iterator = setPr.iterator(); iterator.hasNext();) {
			Integer id = (Integer) iterator.next();
			System.out.println(sviPredmeti.get(id));	
		}*/
	}
	
	public static void ispisiSvePredmete(ArrayList<Predmet> sortiraniPredmeti){
		for (int i = 0; i < sortiraniPredmeti.size(); i++) {
			System.out.println(sortiraniPredmeti.get(i));
		}
	}
	
	/** METODE ZA PRETRAGU PREDMETA ****/
	// pronadji predmet
	public static Predmet pronadjiPredmet() {
		Predmet retVal = null;
		System.out.print("Unesi id predmeta:");
		int id = PomocnaKlasa.ocitajCeoBroj();
		retVal = pronadjiPredmetId(id);
		if (retVal == null)
			System.out.println("Predmet sa id-om " + id
					+ " ne postoji u evidenciji");
		return retVal;
	}

	// pronadji predmet
	public static Predmet pronadjiPredmetId(Integer id) {
		return sviPredmeti.get(id);
	}
	
	/** METODA ZA SORTIRANJE PREDMETA****/
	public static ArrayList<Predmet> sortirajPredmetePoNazivu(){
		//kako mapa predmeta ne može da se sortira tako 
		//sve predmete moramo prebaciti u listu čiji elementi mogu da se sortiraju
		ArrayList<Predmet> sortiraniPredmeti = new ArrayList<Predmet>(sviPredmeti.values());
		System.out.println("Premete je moguće sortirati\n\t1 - Naziv Rastuće\n\t2- Naziv Opadajuće\nIzaberi opciju:");
		int sortOpcija=PomocnaKlasa.ocitajCeoBroj();
		switch (sortOpcija) {
		case 1:
			//TO DO
			break;
		case 2:
			//TO DO
			break;
		default:
			break;
		}
		return sortiraniPredmeti;
	}
	
	/** METODE ZA UNOS, IZMENU I BRISANJE PREDMETA ****/
	// unos novog predmeta
	public static void unosNovogPredmeta() {
		System.out.print("Naziv:");
		String prNaziv= PomocnaKlasa.ocitajTekst();
		
		Predmet pred = new Predmet(0, prNaziv);
		sviPredmeti.put(pred.getId(), pred);
		
		while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati studente da pohađaju predmet") == 'Y') {
			PohadjaUI_Ver_HashMap.dodajStudentaNaPredmet(pred);
		}
	}
	
	// izmena predmeta
	public static void izmenaPodatakaOPredmetu() {
		Predmet pred = pronadjiPredmet();
		if(pred != null){
			System.out.print("Unesi novi naziv :");
			String prNaziv = PomocnaKlasa.ocitajTekst();
			pred.setNaziv(prNaziv);
			
			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("ukloniti studente da ne pohađaju predmet") == 'Y') {
				PohadjaUI_Ver_HashMap.dodajStudentaNaPredmet(pred);
			}
			
			while (PomocnaKlasa.ocitajOdlukuOPotvrdi("upisati studente da pohađaju predmet") == 'Y') {
				PohadjaUI_Ver_HashMap.dodajStudentaNaPredmet(pred);
			}
		}
	}

	//brisanje predmeta
	public static void brisanjePodatakaOPredmetu(){
		Predmet pr = pronadjiPredmet();
		if(pr!=null){
			sviPredmeti.remove(pr.getId());
			System.out.println("Podaci obrisani iz evidencije");
		}
	}	
	
	/** METODA ZA UCITAVANJE PODATAKA****/
	static void citajIzFajlaPredmete(File dokument) throws IOException {
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
				Predmet pr = new Predmet(s2);
				sviPredmeti.put(pr.getId(), pr);
			}
			in.close();
		} else {
			System.out.println("Ne postoji fajl!");
		}
	}
	
	static void pisiUFajlPredmete(File dokument) throws IOException {
		PrintWriter out2 = new PrintWriter(new FileWriter(dokument));
		for (Predmet predmet : sviPredmeti.values()) {
			out2.println(predmet.toFileRepresentation());
		}
		
		out2.flush();
		out2.close();
	}
}
