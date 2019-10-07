package raspored.ftn;

import utilities.Dan;

public class Main {

	public static void main(String[] args) {

		Predavac predavac1 = new Predavac("Zeljko", "Vukovic");
		Predavac predavac2 = new Predavac("Sinisa", "Nikolic");
		Predavac predavac3 = new Predavac("Aleksandar", "Kaplar");
		Predavac predavac4 = new Predavac("Valentin", "Penca");
		Predavac predavac5 = new Predavac("Segedinac", "Milan");
			
		Termin termin1 = new Termin(Dan.PONEDELJAK,"L6", predavac1, 7, 0, 8, 30, "Internet Mreze", "FTN");
		Termin termin2 = new Termin(Dan.PONEDELJAK,"MI2", predavac1, 9, 45, 11, 15, "Internet Mreze", "FTN");
		Termin termin3 = new Termin(Dan.PONEDELJAK,"L6", predavac2, 17, 30, 19, 0, "Internet Mreze", "FTN");
		Termin termin4 = new Termin(Dan.PONEDELJAK,"PC6", predavac3, 17, 30, 20, 0, "Web Programiranje", "FTN");
		Termin termin5 = new Termin(Dan.PONEDELJAK,"PC5", predavac2, 9, 45, 10, 15, "Sistemi bazirani na znanju", "FTN");
		Termin termin6 = new Termin(Dan.PONEDELJAK,"PC5", predavac2, 15, 15, 17, 45, "Sistemi bazirani na znanju", "FTN");
		Termin termin7 = new Termin(Dan.PONEDELJAK,"K1", predavac3, 9, 0, 11, 45, "Web Programiranje", "Loznica");
		Termin termin8 = new Termin(Dan.PONEDELJAK,"K2", predavac3, 12, 15, 15, 0, "Web Programiranje", "Loznica");
		
		Termin termin9 = new Termin(Dan.UTORAK,"MI2", predavac1, 10, 30, 12, 0, "Internet Mreze", "FTN");
		Termin termin10 = new Termin(Dan.UTORAK,"MI2", predavac4, 9, 45, 11, 15, "Web Programiranje", "FTN");
		Termin termin11 = new Termin(Dan.UTORAK,"K2", predavac5, 14, 15, 16, 0, "XML I Web Servisi", "FTN");
		Termin termin12 = new Termin(Dan.UTORAK,"K2", predavac5, 16, 10, 17, 30, "Web Programiranje", "FTN");
		
		Termin termin13 = new Termin(Dan.SREDA,"L6", predavac2, 12, 30, 16, 0, "Objektno Programiranje", "FTN");
		Termin termin14 = new Termin(Dan.SREDA,"L3", predavac2, 7, 0, 8, 30, "Internet Mreze", "FTN");
		Termin termin15 = new Termin(Dan.SREDA,"MI2", predavac1, 10, 30, 12, 0, "Internet Mreze", "FTN");
		Termin termin16 = new Termin(Dan.SREDA,"L3", predavac2, 10, 30, 12, 0, "Internet Mreze", "FTN");
		Termin termin17 = new Termin(Dan.SREDA,"MI2", predavac1, 11, 30, 13, 0, "Internet Mreze", "FTN");
		Termin termin18 = new Termin(Dan.SREDA,"L6", predavac1, 14, 0, 15, 30, "XML I Web Servisi", "FTN");
		
		KatalogTermina katalog = new KatalogTermina();
		
		katalog.dodajTermin(termin1);
		katalog.dodajTermin(termin2);
		katalog.dodajTermin(termin3);
		katalog.dodajTermin(termin4);
		katalog.dodajTermin(termin5);
		katalog.dodajTermin(termin6);
		katalog.dodajTermin(termin7);
		katalog.dodajTermin(termin8);
		katalog.dodajTermin(termin9);
		katalog.dodajTermin(termin10);
		katalog.dodajTermin(termin11);
		katalog.dodajTermin(termin12);
		katalog.dodajTermin(termin13);
		katalog.dodajTermin(termin14);
		katalog.dodajTermin(termin15);
		katalog.dodajTermin(termin16);
		katalog.dodajTermin(termin17);
		katalog.dodajTermin(termin18);
	
		
		
		katalog.preklapanjeZauzecaKabineta();
		System.out.println(" ");
		katalog.preklapanjeZauzecaNastavnika();

	
	}

}
