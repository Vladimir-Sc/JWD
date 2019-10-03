package com.ftninformatika.vezbe02.primerDodatnoFormatiranjeIspisa;

public class FormatizovaniIspis {

	public static void main(String[] args) {

		//formatizovani ispis na ekran
		System.out.printf("Ispis celog broja %d \n", 10);
		System.out.printf("Ispis karaktera %c \n", 'A');
		System.out.printf("Ispis karaktera %c \n", 66);
		System.out.printf("Ispis razlomljenog broja %f \n", 3.14);
		System.out.printf("Ispis razlomljenog broja preciznosti 2 decimale %5.2f \n\n", 3.123456789);
		
		System.out.println("Ispis vise atributa");
		System.out.printf("%d,   %c,   %f 	%s \n\n", 10, 'A', 3.13, "ABCD");
		
		System.out.println("Poravnjanja");
		System.out.printf("%10d \n", 1);
		System.out.printf("%10d \n", 100);
		System.out.printf("%-10d\n", 100);
		System.out.printf("%10d \n", 1000000);
		
		System.out.println("\n\nKreiranje izgelda tabele\n\n");
		String [] nasloviOglasa = { "Audi A8 2004 godiste", "Fiat Stilo povoljno"	, "Punto 2005 sa 5 vrata", "Jugo za 200 eura", "Hitno prodajem nov Fiat 500L"};
		double [] cene = { 5000, 3300, 2600, 200, 10000};
		
		System.out.println("================================================");
		System.out.printf("%4s  %-30s  %10s\n", "Rbr.", "Naslov oglasa", "Cena");
		System.out.printf("%4s  %-30s  %10s\n", "====", "==============================", "==========");
		
		for (int i = 0; i < nasloviOglasa.length; i++) {
			System.out.printf("%4d  %-30s  %10s\n", i+1, nasloviOglasa[i], cene[i]);
		}
		System.out.println("================================================");
	}

}
