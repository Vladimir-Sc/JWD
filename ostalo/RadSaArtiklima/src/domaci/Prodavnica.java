package domaci;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Prodavnica {

	public static ArrayList<Artikl> sviArtikli = new ArrayList<Artikl>();

	public static void ocitajPodatkeIzFajla() throws FileNotFoundException, IOException{
		System.out.println("--OCITAVAM--");
		String sP = System.getProperty("file.separator");
		File rezultati = new File("."+sP+"materijali"+sP+"artikli.txt");

		String s3;
		if(!rezultati.exists()){
			System.exit(0);
		}else{
			BufferedReader br = new BufferedReader(new FileReader(rezultati));
			while((s3 = br.readLine()) !=null){
				//ocitavanje iz fajla i kreiranje artikla
				Artikl ar = new Artikl(s3) ;
				//dodavanje ocitanog artikla u listu svih artikala
				sviArtikli.add(ar);			
			}
			br.close();
		}
		
		for (int i = 0; i < sviArtikli.size(); i++) { 
			 System.out.println(sviArtikli.get(i).toStringDetail());
		}
	}
	
	public static void sacuvaPodatkeUFajl() throws FileNotFoundException, IOException{
		System.out.println("--SNIMAM--");
		
		String sP = System.getProperty("file.separator");	
		File rezultati = new File("."+sP+"materijali"+sP+"artikli.txt");
		PrintWriter out = new PrintWriter(new FileWriter(rezultati));
		for (int i = 0; i < sviArtikli.size(); i++) {
			Artikl ar = sviArtikli.get(i);	
			out.println(ar.toFile());
		}
		out.flush();
		out.close();
	}
	
	public static void ispisiSveArtikle(){
		for (int i = 0; i < sviArtikli.size(); i++) { 
			 System.out.println(sviArtikli.get(i).toString());
		}
	}
	
	public static Artikl pronadjiArtikal(){
		Artikl retVal = null;
		System.out.println("Unesi sifru artikla:");
		String arIndex = Utility.ocitajTekst();
		retVal = pronadjiArtikal(arIndex);
		if(retVal == null)
			System.out.println("Artikal sa sifrom: " +arIndex + " ne postoji u evidenciji");
		return retVal;
	}
	
	private static Artikl pronadjiArtikal(String arIndex) {
		Artikl retVal = null;
		for (int i = 0; i < sviArtikli.size(); i++) {
			Artikl ar = sviArtikli.get(i);
			if (ar.getSifra().equals(arIndex)) {
				retVal = ar;
				break;
			}
		}
		return retVal;
	}
	
	public static void izmenaArtikla() throws IOException{
		Artikl  ar= pronadjiArtikal();
		if(ar !=null){
			//sifra artikla ne sme da se menja
			
			System.out.print("Unesite proizvod:");
			String arNaziv = Utility.ocitajTekst();
			System.out.print("Unesi proizvodjaca:");
			String arProizvodjaca  = Utility.ocitajTekst();
			System.out.print("Unesi cenu:");
			double arCena  = Utility.ocitajRealanBroj();
			String arAkcija = "akcija";
			if(Utility.ocitajOdlukuOPotvrdi("proizvod na akciji")=='N'){
				arAkcija = "nije na akciji";
			}
			System.out.print("Unesi datum:");
			String arDatum = Utility.ocitajTekst();
			
			ar.setNaziv(arNaziv);
			ar.setProizvodjac(arProizvodjaca);
			ar.setCena(arCena);
			ar.setAkcija(arAkcija);
			ar.setDatum(arDatum);
		}
	}
	
	public static void unosNovogArtikla() throws IOException{
	
		System.out.println("Unesi sifru:");
		String nSifra = Utility.ocitajTekst();
		System.out.println(nSifra);
		while(pronadjiArtikal(nSifra) !=null){
			System.out.println("Proizvod sa sifrom : "+nSifra +" vec postoji.");
			nSifra = Utility.ocitajTekst();
		}
		System.out.print("Unesi ime proizvoda:");
		String nNaziv = Utility.ocitajTekst();
		System.out.print("Unesi novog proizvodjaca:");
		String nProizvodjac  = Utility.ocitajTekst();
		System.out.print("Unesi cenu:");
		double nCena = Utility.ocitajRealanBroj();
		String nAkcija = "akcija";
		if(Utility.ocitajOdlukuOPotvrdi("proizvod na akciji")=='N'){
			nAkcija = "nije na akciji";
		}
		System.out.print("Unesi datum:");
		String nDatum = Utility.ocitajTekst();
			
		//kreiranje novog artikla
		Artikl ar  = new Artikl(nSifra, nNaziv,nProizvodjac,nCena, nAkcija,nDatum);
		//dodavanje ocitanog artikla u listu svih artikala
		sviArtikli.add(ar);
	}
	
	public static void ispisiSveArtikleNaAkciji(){
		boolean found = false;
		for (int i = 0; i < sviArtikli.size(); i++) {
			if(sviArtikli.get(i).getAkcija().equalsIgnoreCase("akcija")){
				System.out.println(sviArtikli.get(i).toString());
				found = true;
			}	 
		}
		if(found == false)
			System.out.println("Nema artikla na akciji");
	}
	
	public static void ispisiSveArtikleOdProizvodjaca(){
		System.out.print("Unesi proizvodjaca:");
		String arProizvodjaca  = Utility.ocitajTekst();
		
		boolean found = false;
		for (int i = 0; i < sviArtikli.size(); i++) {
			if(sviArtikli.get(i).getProizvodjac().equalsIgnoreCase(arProizvodjaca)){
				System.out.println(sviArtikli.get(i).toString());
				found = true;
			}	 
		}
		if(found == false)
			System.out.println("Nema artikla od proizvodjaca"+arProizvodjaca);
	}
	
	public static void ispisiPocetniTekst(){	
		System.out.println("\tOpcija broj 1 - unos podataka o novom proizvodu");
		System.out.println("\tOpcija broj 2 - izmena podataka o proizvodu");
		System.out.println("\tOpcija broj 3 - ispis podataka svih proizvoda");
		System.out.println("\tOpcija broj 4 - pronadji proizvod po njegovoj sifri");
		System.out.println("\tOpcija broj 5 - ispis podataka o proizvodima na akciji");
		System.out.println("\tOpcija broj 6 - ispis podataka o proizvodima odredjenog proizvodjaca");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}
}
