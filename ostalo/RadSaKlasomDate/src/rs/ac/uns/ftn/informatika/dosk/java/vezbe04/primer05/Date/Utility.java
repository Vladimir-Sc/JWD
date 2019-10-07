package rs.ac.uns.ftn.informatika.dosk.java.vezbe04.primer05.Date;

import java.util.Scanner;

public class Utility {

	static Scanner sc = new Scanner(System.in);
	
	//citanje promenljive String
	public static String ocitajTekst(){
		String tekst = "";
		while(tekst == null || tekst.equals(""))
			tekst = sc.nextLine();
		
		return tekst;
	}
}
