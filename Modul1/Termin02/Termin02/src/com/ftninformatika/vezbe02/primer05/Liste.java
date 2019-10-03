package com.ftninformatika.vezbe02.primer05;

import java.util.ArrayList;

public class Liste {
	
	public static void ucitajPodatkeNastavnik(String [] sviRedoviNastavnici, ArrayList<Integer> nastavniciIdentifikatori, 
			ArrayList<String> nastavniciImena, ArrayList<String> nastavniciPrezimena, 
			ArrayList<String> nastavniciZvanje){
		
		System.out.println("\n\nNASTAVNICI---------------------------------");
		for (int i = 0; i < sviRedoviNastavnici.length; i++) {
			System.out.println("\n************************************");
			System.out.println("Red ->" + sviRedoviNastavnici[i]);
			
			String [] nastavnikPodaciTekst = sviRedoviNastavnici[i].split(",");
//			System.out.println("Preuzimanje i ispis podataka o nastavniku");
			
			nastavniciIdentifikatori.add(Integer.parseInt(nastavnikPodaciTekst[0]));
			nastavniciImena.add(nastavnikPodaciTekst[1]);
			nastavniciPrezimena.add(nastavnikPodaciTekst[2]);
			nastavniciZvanje.add(nastavnikPodaciTekst[3]);
		}
		
		ispisiSvePodatkeNastavnika(nastavniciIdentifikatori, nastavniciImena, nastavniciPrezimena, nastavniciZvanje);
		
	}
	
	
	public static void ispisiSvePodatkeNastavnika(ArrayList<Integer> nastavniciIdentifikatori, 
			ArrayList<String> nastavniciImena, ArrayList<String> nastavniciPrezimena, 
			ArrayList<String> nastavniciZvanje) {
		
		System.out.println("\n\nNASTAVNICI---------------------------------");
		for (int i = 0; i < nastavniciIdentifikatori.size(); i++) {
			System.out.println("Nastavnik " + nastavniciImena.get(i) + " " + nastavniciPrezimena.get(i) + " sa id " 
					+ nastavniciIdentifikatori.get(i) + " ima zvanje " + nastavniciZvanje.get(i));
		}
	}
	
	public static void ispisiPodatkeNastavnika(ArrayList<Integer> nastavniciIdentifikatori, 
			ArrayList<String> nastavniciImena, ArrayList<String> nastavniciPrezimena, 
			ArrayList<String> nastavniciZvanje) {
		
		System.out.println("\n\nUNESI ID NASTAVNIKA:");
		int unetiID = 0;
		int brojac = 0;
		
		boolean nasao = false;
		while (nasao==false) {
			unetiID = (int)(Math.random()*10/Math.random()); //treba zameniti sa skenerom
			for (int i = 0; i < nastavniciIdentifikatori.size(); i++) {
				if(nastavniciIdentifikatori.get(i)==unetiID){
					nasao = true;
					brojac=i;
					break;
				}
			}
		}
		
		System.out.println("Nastavnik " + nastavniciImena.get(brojac) + " " + nastavniciPrezimena.get(brojac) + " sa id " 
				+ nastavniciIdentifikatori.get(brojac) + " ima zvanje " + nastavniciZvanje.get(brojac));
	}

	
	public static void main(String[] args) {

		ArrayList<Integer> nastavniciIdentifikatori = new ArrayList<Integer>();
		ArrayList<String> nastavniciImena = new ArrayList<String>();
		ArrayList<String> nastavniciPrezimena = new ArrayList<String>();
		ArrayList<String> nastavniciZvanje = new ArrayList<String>();
		
		String textNastavnici 	= "1,Petar,Petrovi\u0107,Docent\n"
				+ "2,Jovan,Jovanovi\u0107,Docent\n"
				+ "3,Marko,Markovi\u0107,Asistent\n"
				+ "4,Nikola,Nikoli\u0107,Redovni Profesor\n"
				+ "5,Lazar,Lazi\u0107,Asistent";
		
		String [] sviRedoviNastavnici = textNastavnici.split("\n");
		
		//pod 1
		System.out.println("1. U\u010Ditaj podatke");
		ucitajPodatkeNastavnik(sviRedoviNastavnici, nastavniciIdentifikatori, nastavniciImena, nastavniciPrezimena, nastavniciZvanje);
		
		//pod 2
		System.out.println("2. Ispi\u0161i sve podatke");
		ispisiSvePodatkeNastavnika(nastavniciIdentifikatori, nastavniciImena, nastavniciPrezimena, nastavniciZvanje);
		
		//pod 3
		System.out.println("3. Ispi\u0161i podatak u donosu na identifikator (predmet_id, nastavnik_id,...)");
		ispisiPodatkeNastavnika(nastavniciIdentifikatori, nastavniciImena, nastavniciPrezimena, nastavniciZvanje);
		
	}
}
