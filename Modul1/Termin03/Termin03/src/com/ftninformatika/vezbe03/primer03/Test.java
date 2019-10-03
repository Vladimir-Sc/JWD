package com.ftninformatika.vezbe03.primer03;



public class Test {

	public static void main(String[] args) {
		
		/////////////modifikatorima pristupa

		//pozivanje konstruktora bez parametra
		//zakomentariši
		ModifikatoriPristupa ob1 = new ModifikatoriPristupa();
		//otkomentarisi
//		com.ftninformatika.vezbe03.primer03drugiPaket.ModifikatoriPristupa ob1 = new com.ftninformatika.vezbe03.primer03drugiPaket.ModifikatoriPristupa();
		
		//atribut1 je public, pa moze svuda da mu se pristupi
		ob1.atribut1 = "javno";
		
		//atribut2 je protected, moze u klasi koja nasledjuje ili u klasi koja je u istom paketu
//		ob1.atribut2 = "zasticeno";
		
		//atribut3 je unspecified (package-private) moze samo iz istog paketa
//		ob1.atribut3 = "nedefinisano";
		
		//atribut4 je private zabranjen pristup
//		ob1.atribut4 = "privatno";

		//ako je metoda public poziv je moguc uvek iz bilo koje klase
		ob1.publicMogucPoziv();
		
		//ako je metoda protected poziv je moguc samo u okviru klasa koje nasledjuju ili u okviru klasa iz istog paketa
//		ob1.protectedMogucPoziv();
		
		//ako je metoda private poziv je moguc samo u okviru same klase u kojoj je metoda napisana
//		ob1.privateNemogucPoziv();
		ob1.publicMetodaUmetodi();

		System.out.println("Zavrsen rad sa modifikatorima pristupa");
		
		/*
		Kopirajte klasu ModifikatoriPristupa iz ovog paketa u paket primer03drugiPaket
		vratite se pocetak main metode i izvrsite odgovarajuce izmene
		*/
		
		System.out.println("-------------------------------------------");
	}
	
}
