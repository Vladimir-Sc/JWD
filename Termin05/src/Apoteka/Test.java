package Apoteka;

import java.util.ArrayList;

public class Test {

	public static ArrayList<Apotekar> sviApotekari = new ArrayList<Apotekar>();
	public static ArrayList<Dobavljac> sviDobavljaci =  new ArrayList<Dobavljac>();
	public static ArrayList<Lek> sviLekovi =  new ArrayList<Lek>();
	public static ArrayList<Narudzbenica> sveNarudzbenice = new ArrayList<Narudzbenica>();
	
	//pronadji Apotekara
	public static Apotekar pronadjiApotekara(String id){
		Apotekar retVal = null;
		for (int i = 0; i < sviApotekari.size(); i++) {
			Apotekar ap = sviApotekari.get(i);
			if (ap.getId().equals(id)) {
				retVal = ap;
				break;
			}
		}
		return retVal;
	}
	//pronadji Dobavljaca
	public static Dobavljac pronadjiDobavljaca(String id){
		Dobavljac retVal = null;
		for (int i = 0; i < sviDobavljaci.size(); i++) {
			Dobavljac dob = sviDobavljaci.get(i);
			if (dob.getId().equals(id)) {
				retVal = dob;
				break;
			}
		}
		return retVal;
	}
	
	//pronadji Lek
	public static Lek pronadjiLek(String sifra){
		Lek retVal = null;
		for (int i = 0; i < sviLekovi.size(); i++) {
			Lek le = sviLekovi.get(i);
			if (le.getSifra().equals(sifra)) {
				retVal = le;
				break;
			}
		}
		return retVal;
	}
	
	//pronadji Lek
	public static Narudzbenica pronadjiNarudzbenicu(String sifra){
		Narudzbenica retVal = null;
		for (int i = 0; i < sveNarudzbenice.size(); i++) {
			Narudzbenica nar = sveNarudzbenice.get(i);
			if (nar.getSifra().equals(sifra)) {
				retVal = nar;
				break;
			}
		}
		return retVal;
	}
	
	public static void ispisiSveApotekare(){
		for (int i = 0; i < sviApotekari.size(); i++) {
			System.out.println(sviApotekari.get(i));
		}
		System.out.println();
	}

	public static void ispisiSveDobavljace(){
		for (int i = 0; i < sviDobavljaci.size(); i++) {
			System.out.println(sviDobavljaci.get(i));
		}
		System.out.println();
	}
	
	public static void ispisiSveLekove(){
		for (int i = 0; i < sviLekovi.size(); i++) {
			System.out.println(sviLekovi.get(i));
		}
		System.out.println();
	}
	
	public static void ispisiSveNarudzbenice(){
		for (int i = 0; i < sveNarudzbenice.size(); i++) {
			System.out.println(sveNarudzbenice.get(i) + "\n"+
					sveNarudzbenice.get(i).toStringStavke());
		}
		System.out.println();
	}
	
	/** METODA ZA UCITAVANJE PODATAKA****/
	static void citajIzFajlaApotekare (){
		//redovi iz aptekari.csv
		sviApotekari.add(new Apotekar("001,Petar,Petrovic,064555555"));
		sviApotekari.add(new Apotekar("002,Marko,Markovic,060111111"));
	}
	
	static void citajIzFajlaDobavljace (){
		//redovi iz dobavljaci.csv
		sviDobavljaci.add(new Dobavljac("001,Hemofarm AD,Beogradski put bb,Vrsac,061222222"));
		sviDobavljaci.add(new Dobavljac("002,Galenika,Neka BB,Beograd,061222222"));
	}
	
	static void citajIzFajlaLekove (){
		//redovi iz lekovi.csv
		sviLekovi.add(new Lek("001,Vitamin C"));
		sviLekovi.add(new Lek("002,Brufen"));
		sviLekovi.add(new Lek("003,Caj od nane"));
		sviLekovi.add(new Lek("004,Antibiotik 1"));
		sviLekovi.add(new Lek("005,Antibiotik 2"));
	}
	
	static void citajIzFajlaNarudzbenice (){
		//redovi iz narudzbenice.csv
		
		//I nacin
		citajNarudzbenice("001,002,001,2015-02-11,26960.00");
		citajNarudzbenice("002,002,002,2015-02-11,555.00");
		citajNarudzbenice("003,001,001,2015-02-12,462.00");
						
		/*
		//II nacin
		sveNarudzbenice.add(new Narudzbenica("001,002,001,2015-02-11,26960.00"));
		sveNarudzbenice.add(new Narudzbenica("002,002,002,2015-02-11,555.00"));
		sveNarudzbenice.add(new Narudzbenica("003,001,001,2015-02-12,462.00"));	
		*/
		
	}
	
	private static Narudzbenica citajNarudzbenice(String txt) {
		String[] tokeni=null;
		
		String	sifra = null;
		Apotekar apot=null;
		Dobavljac dob = null;
		String 	datum = null;
		double ukupnaCena = 0;
		
		Narudzbenica nar = null;
		
		tokeni = txt.split(",");
		sifra = tokeni[0];
		apot = pronadjiApotekara(tokeni[1]);
		dob = pronadjiDobavljaca(tokeni[2]);
		datum = tokeni[3];
		ukupnaCena = Double.parseDouble(tokeni[4]);
		
		nar = new Narudzbenica(sifra, apot, dob, datum, ukupnaCena);
		
		
		//povezivanje
		sveNarudzbenice.add(nar);
		apot.getNarudzbenice().add(nar);
		dob.getNarudzbenice().add(nar);
		return nar;
	}
	
	static void citajIzFajlaNarudzbeniceStavke (){
		//redovi iz narudzbenice_stavke.csv
		
		//I Nacin
		citajStavku("001,004,333.00,5");
		citajStavku("001,002,16.00,20");
		citajStavku("002,004,555.00,1");
		citajStavku("003,001,154.00,3");
		
		/*
		//II NACIN DA SE UCITA
			//za narudžbenicu 001 naručuje se 5 pakovanja Antibiotik 1 po ceni od 333.00 
		new NarudzbenicaStavka("001,004,333.00,5");
			//za narudžbenicu 001 naručuje se 20 pakovanja Brufen po ceni od 16.00
		new NarudzbenicaStavka("001,002,16.00,20");
			//za narudžbenicu 002 naručuje se 1 pakovanja Antibiotik 1 po ceni od 555.00
		new NarudzbenicaStavka("002,004,555.00,1");
			//za narudžbenicu 003 naručuje se 3 pakovanja Vitamin C po ceni od 154.00
		new NarudzbenicaStavka("003,001,154.00,3");
		
		//NI U JEDNU LISTU SE NE UBACUJU NOVOKREIRANI OBJEKTI NarudzbenicaStavka
		//KAKO TO, ŠTA MISLITE???
		//AKO ZNATE DA NarudzbenicaStavka MORA DA SE UVEŽE SA OBJEKTOM Narudzbenica
		*/
	}
	
	private static NarudzbenicaStavka citajStavku(String txt) {
		String[] tokeni=null;
		
		Narudzbenica nar = null;
		Lek lk=null;
		double cena = 0;
		int kolicina = 0;
		
		NarudzbenicaStavka stavka = null;
		
		tokeni = txt.split(",");
		nar = pronadjiNarudzbenicu(tokeni[0]);
		lk = pronadjiLek(tokeni[1]);
		cena = Double.parseDouble(tokeni[2]);
		kolicina = Integer.parseInt(tokeni[3]);
		stavka = new NarudzbenicaStavka(nar,lk,cena,kolicina);
		
		//povezivanje
		nar.getStavke().add(stavka);
		lk.getStavkeNarudzbenice().add(stavka);
		
		return stavka;
	}
	
	public static void main(String[] args) {
		
		citajIzFajlaApotekare();
		citajIzFajlaDobavljace();
		citajIzFajlaLekove();
		citajIzFajlaNarudzbenice();
		citajIzFajlaNarudzbeniceStavke();
		
		
		
		System.out.println("Svi Apotekari");
		ispisiSveApotekare();
		System.out.println("Svi Dobavljaci");
		ispisiSveDobavljace();
		System.out.println("Svi Lekovi");
		ispisiSveLekove();
		System.out.println("Sve Narudzbenice");
		ispisiSveNarudzbenice();
	}

}
