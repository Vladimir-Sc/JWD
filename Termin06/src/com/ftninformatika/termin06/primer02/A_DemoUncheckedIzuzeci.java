package com.ftninformatika.termin06.primer02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class A_DemoUncheckedIzuzeci {

	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			System.out.println();
			System.out.println("1. Opcija 1");
			System.out.println("2. Opcija 2");
			System.out.println("3. Opcija 3");
			System.out.println("-----------");
			System.out.print("Unesite izbor: ");

			try {
				int izbor = in.nextInt(); // ako korisnik unese tekst, nastaje unchecked izuzetak: InputMismatchException, i bez try-catch bloka program se prekida!
				in.nextLine();

				System.out.println();
				switch (izbor) {
					case 1: System.out.println("Odabrali ste opciju 1"); break;
					case 2: System.out.println("Odabrali ste opciju 2"); break;
					case 3: System.out.println("Odabrali ste opciju 3"); break;
					default: System.out.println("Opcija nije ponuđena!");
				}
			} catch (InputMismatchException ex) { // ako korisnik unese tekst, izuzetak biva uhvaćen i obrađen u ovom bloku koda, ali se program nastavlja!
				System.out.println("Neispravan unos!");
				//ex.printStackTrace();
			}
			finally {
				in.nextLine(); // neke naredbe je potrebno izvršiti u oba slučaja, pa se one smeštaju u finally klauzulu da se ne bi duplirale i u try i u catch klauzulama
			}
		}

	}
	
}
