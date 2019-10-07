package savez;

import java.util.ArrayList;

public class TestKosarkaskogSaveza {
	
	public static Klub pratragaKluba(ArrayList<Klub> listaK, int sifraKluba){
		Klub obj = null;
		for (Klub klubovi : listaK) {
			if(klubovi.sifraKluba==sifraKluba){
				obj = klubovi;
				break;
			}	
		}
		return obj;
	}
	
	public static Sudija pratragaSudije(ArrayList<Sudija> listaS, int sifraSudije){
		Sudija obj = null;
		for (Sudija sud : listaS) {
			if(sud.sifraSudije==sifraSudije){
				obj = sud;
				break;
			}	
		}
		return obj;
	}
	public static Utakmica pretragaUtakmice(ArrayList<Utakmica> listaU, int sifraUtakmice){
		Utakmica obj = null;
		for (Utakmica uta : listaU) {
			if(uta.sifraUtakmice==sifraUtakmice){
				obj = uta;
				break;
			}	
		}
		return obj;
	}


	public static void ucitajIgrace(ArrayList<Igrac> lista, ArrayList<Klub> listeK){
	
		String text ="1,Vlade,Divac,1\n"
				+ "2,Predrag,Danilovic,1\n"
				+ "3,Zoran,Slavnic,2\n"
				+ "4,Toni,Kukoc,3\n"
				+ "5,Aleksandar,�?orđević,1\n"
				+ "6,Dejan,Bodiroga,4\n";
				
		String [] sviRedovi = text.split("\n");
		for (int i = 0; i < sviRedovi.length; i++) {
			lista.add(new Igrac(sviRedovi[i],  listeK));
			
		}
	}
	public static void ucitajKlubove(ArrayList<Klub> lista){
	
		String text ="1,Partizan\n"
				+ "2,Crvena zvezda\n"
				+ "3,Jugoplastika\n"
				+ "4,Real Madrid";								
				
		String [] sviRedovi = text.split("\n");
		for (int i = 0; i < sviRedovi.length; i++) {
			lista.add(new Klub(sviRedovi[i]));
			
		}
	}
	public static void ucitajSudije(ArrayList<Sudija> lista){
		
		String text ="1,Dragan, Petrovic\n"
				+ "2,Miodrag, Bubalo\n"
				+ "3,Simeon, Radovic\n"
				+ "4,Nebojsa, Mladenovic";								
				
		String [] sviRedovi = text.split("\n");
		for (int i = 0; i < sviRedovi.length; i++) {
			lista.add(new Sudija(sviRedovi[i]));
			
		}
	}
	public static void ucitajUtakmice(ArrayList<Utakmica> lista, ArrayList<Klub> listK){
		
		String text ="1,25.11.2016.,19:00,1,2,100,85\n"
				+ "2,27.11.2016.,19:30,3,4,98,97\n"
				+ "3,30.11.2016.,18:00,2,1,110,68\n"
				+ "4,12.12.2016.,21:00,4,3,80,80";								
				
		String [] sviRedovi = text.split("\n");
		for (int i = 0; i < sviRedovi.length; i++) {
			lista.add(new Utakmica(sviRedovi[i], listK));
			
		}
	}
	public static void ucitajPodatkeSudi(ArrayList<Sudija> listaSudija,
			ArrayList<Utakmica> listaUtakmica){
		
		String text =
				
				"1,1\n"
				+ "1,3\n"
				+ "1,4\n"				
				+ "2,1\n"				
				+ "2,3\n"				
				+ "3,2\n"
				+ "3,4\n"
				+ "3,1\n"				
				+ "4,2\n"
				+ "4,3";
				
		
		String [] sviRedovi = text.split("\n");
		for (int i = 0; i < sviRedovi.length; i++) {
			String [] sudiliUtakmiceTekst = sviRedovi[i].split(",");
			int sifraSudije = Integer.parseInt(sudiliUtakmiceTekst[0]);
			int sifraUtakmice = Integer.parseInt(sudiliUtakmiceTekst[1]);
			Sudija sud = pratragaSudije(listaSudija, sifraSudije);
			Utakmica uta = pretragaUtakmice(listaUtakmica, sifraUtakmice);
			
			if(sud!=null && uta!=null){
				uta.getSveSudije().add(sud);
			}
		}
	}
	public static void ispisiIgrace(ArrayList<Igrac> lista){
		for (Igrac st : lista) {
			System.out.println(st.vratiTekstualnuReprezentacijuZaIgraca());
		}
	}
	public static void ispisiIgraceALL(ArrayList<Igrac> lista){
		for (Igrac st : lista) {
			System.out.println(st.vratiTekstualnuReprezentacijuZaIgracaAll());
		}
	}
	public static void ispisiKlubove(ArrayList<Klub> lista){
		for (Klub st : lista) {
			System.out.println(st.vratiTekstualnuReprezentacijuZaKlub());
		}
	}
	public static void ispisiKluboveAll(ArrayList<Klub> lista){
		for (Klub st : lista) {
			System.out.println(st.vratiTekstualnuReprezentacijuZaKlubAll());
		}
	}
	public static void ispisiSudije(ArrayList<Sudija> lista){
		for (Sudija su : lista) {
			System.out.println(su.vratiTekstualnuReprezentacijuZaSudiju());
		}
	}
	public static void ispisiSudijeAll(ArrayList<Sudija> listaS, ArrayList<Utakmica> listaU){
		for (Sudija su : listaS) {
			System.out.println(su.vratiTekstualnuReprezentacijuZaSudiju());
			for (Utakmica ut : listaU) {
				if(ut.sveSudije.contains(su))
					System.out.println("\tSudijo je " + ut.vratiTekstualnuReprezentacijuZaUtakmicu());
			}
		}
	}
	public static void ispisiUtakmice(ArrayList<Utakmica> lista){
		for (Utakmica ut : lista) {
			System.out.println(ut.vratiTekstualnuReprezentacijuZaUtakmicu());
		}
	}
	public static void ispisiUtakmiceAll(ArrayList<Utakmica> lista){
		for (Utakmica ut : lista) {
			System.out.println(ut.vratiTekstualnuReprezentacijuZaUtakmicuAll());
		}
	}
	public static void main(String[] args) {

			ArrayList<Igrac> igraci = new ArrayList<Igrac>();
			ArrayList<Klub> klubovi = new ArrayList<Klub>();
			ArrayList<Sudija> sudije = new ArrayList<Sudija>();
			ArrayList<Utakmica> utakmice = new ArrayList<Utakmica>();
		
			ucitajKlubove(klubovi);
            ucitajIgrace(igraci, klubovi);
            ucitajSudije(sudije);
            ucitajUtakmice(utakmice, klubovi);
            ucitajPodatkeSudi(sudije, utakmice);
            
    		System.out.println("ISPIS SVIH IGRACA");
    		System.out.println("**************************************************************************");
    		ispisiIgraceALL(igraci);
    		System.out.println("**************************************************************************");
  		      		
 		    System.out.println("ISPIS SVIH KLUBOVA I IGRACA POD UGOVOROM");
 		    System.out.println("**************************************************************************");
 	    	ispisiKluboveAll(klubovi);
 		    System.out.println("**************************************************************************");  		    		
    		
    		System.out.println("ISPIS SVIH SUDIJA");
    		System.out.println("**************************************************************************");
    		ispisiSudije(sudije);
    		System.out.println("**************************************************************************");   		
    		
    		System.out.println("ISPIS REZULTATA ODIGRANIH UTAKMICA");
    		System.out.println("**************************************************************************");
    		ispisiUtakmiceAll(utakmice);
    		System.out.println("**************************************************************************");
    		
    		System.out.println("ISPIS SUDIJA i MECEVA KOJE SU SUDILI");
    		System.out.println("**************************************************************************");
    		ispisiSudijeAll(sudije, utakmice);
    		System.out.println("**************************************************************************"); 
	}

}
