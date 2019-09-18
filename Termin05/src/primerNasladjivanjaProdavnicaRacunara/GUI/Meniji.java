package primerNasladjivanjaProdavnicaRacunara.GUI;


public abstract class Meniji {
	
	
	public static void pocetniMeniZaMenadzera(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Unos entiteta");
		System.out.println("\tOpcija broj 2 - Izmena entiteta");
		System.out.println("\tOpcija broj 3 - Brisanje entiteta");	
		System.out.println("\tOpcija broj 4 - Pretraga i pregled entiteta");	
		System.out.println("\tOpcija broj 5 - Sortiranje entiteta");
		System.out.println("\tOpcija broj 6 - Izvestaj i pregled svih racuna");
		System.out.println("\tOpcija broj 7 - Snimanje podataka u fajl");
		System.out.println("\tOpcija broj 8 - Citanje podataka iz fajla");
		System.out.println("\tOpcija broj 0 - Izlaz");
		
	}
	public static void pocetniMeniZaProdavce(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Unos entiteta");
		System.out.println("\tOpcija broj 2 - Izmena entiteta");
		System.out.println("\tOpcija broj 3 - Brisanje entiteta");	
		System.out.println("\tOpcija broj 4 - Pretraga i pregled entiteta");	
		System.out.println("\tOpcija broj 5 - Sortiranje entiteta");
		System.out.println("\tOpcija broj 6 - Izdavanje racuna");
		System.out.println("\tOpcija broj 7 - Snimanje podataka u fajl");
		System.out.println("\tOpcija broj 8 - Citanje podataka iz fajla");
		System.out.println("\tOpcija broj 0 - Izlaz");
	}
	
	public static void podMeniZaUnosIzmenuIBrisanje(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Komponenti");
		System.out.println("\tOpcija broj 2 - Gotovih Konfiguracija");
		System.out.println("\tOpcija broj 3 - Kategorija");
		System.out.println("\tOpcija broj 4 - Memorije racunara");
		System.out.println("\tOpcija broj 5 - Procesora");
		System.out.println("\tOpcija broj 0 - Nazad");
		
	}
	public static void podMeniZaPretragu(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Pretraga Artikala");
		System.out.println("\tOpcija broj 2 - Pretraga Komponenti");
		System.out.println("\tOpcija broj 3 - Pretraga Gotova Konfiguracija");
		System.out.println("\tOpcija broj 4 - Pretraga Kategorija");
		System.out.println("\tOpcija broj 5 - Pregled svih entiteta");
		System.out.println("\tOpcija broj 6 - Pregled neobrisanih entiteta");
		System.out.println("\tOpcija broj 7 - Pregled obrisanih entiteta");
		System.out.println("\tOpcija broj 0 - Nazad");
		
	}
	public static void podMeniZaPretraguArtikala(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Sifri");
		System.out.println("\tOpcija broj 2 - Nazivu");
		System.out.println("\tOpcija broj 3 - Opsegu cene");
		System.out.println("\tOpcija broj 0 - Nazad");
	}
	public static void podMeniZaPretraguKategorija(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Sifri");
		System.out.println("\tOpcija broj 2 - Nazivu");
		System.out.println("\tOpcija broj 0 - Nazad");
	}
	public static void podMeniZaPretraguGotovihKonfiguracija(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Sifri");
		System.out.println("\tOpcija broj 2 - Nazivu");
		System.out.println("\tOpcija broj 3 - Opsegu cene");
		System.out.println("\tOpcija broj 4 - Opsegu kolicina");
		System.out.println("\tOpcija broj 0 - Nazad");
	}
	public static void podMeniZaPretraguKomponenti(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Sifri");
		System.out.println("\tOpcija broj 2 - Nazivu");
		System.out.println("\tOpcija broj 3 - Opsegu cene");
		System.out.println("\tOpcija broj 4 - Opsegu kolicina");
		System.out.println("\tOpcija broj 5 - Kategoriji");
		System.out.println("\tOpcija broj 0 - Nazad");
	}
	public static void podMeniZaSortiranje(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - po nazivu opadajuce");
		System.out.println("\tOpcija broj 2 - po nazivu rastuce");
		System.out.println("\tOpcija broj 3 - po ceni opadajuce");
		System.out.println("\tOpcija broj 4 - po ceni rastuce");
		System.out.println("\tOpcija broj 0 - Nazad");
	}
	public static void podMeniZaIzvestaj(){
		System.out.println("Unesi broj opcije:");
		System.out.println("\tOpcija broj 1 - Pregled svih racuna(bez stavki)");
		System.out.println("\tOpcija broj 2 - Pregled svih racuna odredjnog datuma (bez stavki)");
		System.out.println("\tOpcija broj 3 - Pregled kompletnih informacija odredjenog racuna (sa stavkama)");
		System.out.println("\tOpcija broj 4 - Izvestaj o ukupnoj prodaji po datumima");
		System.out.println("\tOpcija broj 0 - Nazad");
	}

	

}
