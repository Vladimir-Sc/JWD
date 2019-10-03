package com.ftninformatika.vezbe02.primer03;


public class Strings02 {

	
	public static void main(String[] args) {

		//Sadrzaj csv fajla koji cuva podatke o studentima i njihovim ocenama
		String text = 	"Е1 01/11,Срђанов Конcтантин,Лозница,Математика;9!Физика;7!" + "\n" +
							"Е1 02/12,Баки Страхиња,Нови Сад,Физика;7!" + "\n" +
							"Е1 03/13,Трајковић Небојша,Инђија,Математика;10!" + "\n" +
							"Е2 01/11,Синиша Николић,Вршац,Математика;9!Електроника;9!Информатика;10!" + "\n" +
							"Е2 02/12,Аскин Вук,Нови Сад,Физика;5!Електроника;6!" + "\n" +
							"Е2 03/13,Калинић Марко,Сомбор,Електроника;5!" + "\n" +
							"Е2 04/11,Марко Панић,Зрењанин,!";
		
		//Alternativa ovome je upotreba StringTokenizer-a, koji radi nesto drugacije
		// zasto je dva puta slash pre n?
		// parametar split metode je regularni izraz, sta je regularni izraz?
		String [] sviRedovi = text.split("\n");
		
//		String [] indeksiSt = new String [sviRedovi.length];
//		String [] imenaIPrezimenaSt = new String [sviRedovi.length];
//		String [] gradoviSt = new String [sviRedovi.length];
//		String [] [] [] polozeniPredmetiSt = new String [sviRedovi.length] [] [];
		
		//popunjavanje podataka
		for (int i = 0; i < sviRedovi.length; i++) {
			System.out.println("************************************");
			System.out.println("Red ->" + sviRedovi[i]);
			
			String [] studentPodaciTekst = sviRedovi[i].split(",");
			System.out.println("Preuzimanje i ispis podataka o studentu");
			
			String indeks = studentPodaciTekst[0];
			String imeIPrezime = studentPodaciTekst[1];
			String grad = studentPodaciTekst[2];
			
//			indeksiSt[i] = indeks;
//			imenaIPrezimenaSt[i]= imeIPrezime;
//			gradoviSt[i] = grad;
			
			System.out.println("Student " + imeIPrezime + " sa indeksom " + indeks + " iz grada " + grad + " ima ocene");
			
			String [] studentSveOceneTekst = studentPodaciTekst[3].split("!");
			
//			polozeniPredmetiSt[i] = new String [studentSveOceneTekst.length] [];

			for (int j = 0; j < studentSveOceneTekst.length; j++) {
				String [] studentOceneTekst = studentSveOceneTekst[j].split(";");
				
//				polozeniPredmetiSt[i][j] = new String [studentOceneTekst.length];
				
				String predmet = studentOceneTekst[0];
				String ocenaTekst = studentOceneTekst[1];
				
//				polozeniPredmetiSt[i][j][0] = predmet;
//				polozeniPredmetiSt[i][j][1] = ocenaTekst;
				
				System.out.println("\tOcena iz " + predmet + " je " + ocenaTekst);
				
//				int ocena = Integer.parseInt(studentOceneTekst[1]);
//				System.out.println("\tOcena iz " + predmet + " je " + ocena);
			}
			System.out.println("\n");
		}
		System.out.println("\n\n");
		System.out.println("-------------------------------------------");
//		ispisiSvePodatkeOStudentu(indeksiSt, imenaIPrezimenaSt, gradoviSt, polozeniPredmetiSt);
	}
	
	static void ispisiSvePodatkeOStudentu(String [] indeksiSt, String [] imenaIPrezimenaSt, String [] gradoviSt, String [] [] [] polozeniPredmetiSt){
		
		System.out.println("Ispis svih studenata 2");
		for (int i = 0; i < polozeniPredmetiSt.length; i++) {
			System.out.println("Student " + imenaIPrezimenaSt[i] 
					+ " sa indeksom " + indeksiSt[i] + " iz grada " + gradoviSt[i] + " ima ocene");
			for (int j = 0; j < polozeniPredmetiSt[i].length; j++) {
				System.out.println("\tOcena iz " + polozeniPredmetiSt[i][j][0] + " je " + polozeniPredmetiSt[i][j][1]);
			}
			System.out.println("\n");
		}	
	}
}
