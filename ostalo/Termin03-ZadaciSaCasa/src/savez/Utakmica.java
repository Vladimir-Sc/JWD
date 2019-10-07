package savez;

import java.util.ArrayList;

public class Utakmica {
	protected int sifraUtakmice;
	protected String datumOdigravanja;
	protected String vremeOdigravanja;
	protected Klub klubDomacin;
	protected Klub klubGost;
	protected int brojKosevaDomacin;
	protected int brojKosevaGost;
	protected ArrayList<Sudija> sveSudije = new ArrayList<Sudija>();	
	
	public Utakmica(int sifraUtakmice, String datumOdigravanja, String vremeOdigravanja, Klub klubDomacin, Klub klubGost, int brojKosevaDomacin, int brojKosevaGost, ArrayList<Sudija> sveSudije ){
		
		     this.sifraUtakmice = sifraUtakmice;
		     this.datumOdigravanja = datumOdigravanja;
		     this.vremeOdigravanja = vremeOdigravanja;
		     this.klubDomacin = klubDomacin;
		     this.klubGost = klubGost;
		     this.brojKosevaDomacin = brojKosevaDomacin;
		     this.brojKosevaGost = brojKosevaGost;
		     this.sveSudije = sveSudije;			
	}
	public Utakmica(String tekst, ArrayList<Klub> listaK){
		String [] tokeni = tekst.split(",");
				
		if(tokeni.length != 7){
			System.out.println("Greska pri ucitavanju utakmice "+ tekst);
			
			System.exit(0);
		}		
		 sifraUtakmice = Integer.parseInt(tokeni[0]);
		 datumOdigravanja = tokeni[1];
		 vremeOdigravanja = tokeni[2];
		 int sifraKlubDomacin = Integer.parseInt(tokeni[3]);
		 int sifraKlubGost = Integer.parseInt(tokeni[4]);
		 klubDomacin = TestKosarkaskogSaveza.pratragaKluba(listaK, sifraKlubDomacin);
		    if (klubDomacin == null) {
		    	
		    	System.out.println(" Nije moguce ucitati podatke o klubu domacinu !!!");
		    }
		 klubGost = TestKosarkaskogSaveza.pratragaKluba(listaK, sifraKlubGost);
		    if (klubGost == null) {
		    	
		    	System.out.println(" Nije moguce ucitati podatke o gostujucem klubu !!!");
		    }   
		 brojKosevaDomacin = Integer.parseInt(tokeni[5]);
		 brojKosevaGost = Integer.parseInt(tokeni[6]);	 
	}
	
	public String vratiTekstualnuReprezentacijuZaUtakmicu() {
	   
		String ispis = "Sifra utakmice : " + sifraUtakmice + " odigrana : "+datumOdigravanja.toUpperCase()+" u "+vremeOdigravanja.toUpperCase()+" casova "
				        +"izmedu "+klubDomacin.nazivKluba.toUpperCase()+" i "+klubGost.nazivKluba.toUpperCase()+"."+" \n\t\tDomaca ekipa je postigla "+ brojKosevaDomacin + " poena " + " gostujuca ekipa je postigla : " + brojKosevaGost + " poena.\n" ; 				
		return ispis;
	}
	public String vratiTekstualnuReprezentacijuZaUtakmicuAll() {
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
		StringBuilder sb= new StringBuilder("Utakmica sa sifrom utakmice : " + sifraUtakmice + " zakazana je za : "+datumOdigravanja.toUpperCase()+" u "+vremeOdigravanja.toUpperCase()+" casova."
				        +" \nTim domacin je "+ klubDomacin.nazivKluba.toUpperCase()+" a gostujuci tim je "+ klubGost.nazivKluba.toUpperCase()+"."
				        +" Domacin je postigao "+ brojKosevaDomacin + " poena" + " gostujuca ekipa je postigla : " + brojKosevaGost + " poena.\n");
		sveSudije.get(0);
		for (int i = 0; i < sveSudije.size(); i++) {
			if(i==0){
				sb.append("Sudile su sudije:\n");
			}
			sb.append("\t"+sveSudije.get(i).vratiTekstualnuReprezentacijuZaSudiju()+"\n");
		}
		
		
		return sb.toString();
		
	}

	public int getSifraUtakmice() {
		return sifraUtakmice;
	}
	public void setSifraUtakmice(int sifraUtakmice) {
		this.sifraUtakmice = sifraUtakmice;
	}
	public String getDatumOdigravanja() {
		return datumOdigravanja;
	}
	public void setDatumOdigravanja(String datumOdigravanja) {
		this.datumOdigravanja = datumOdigravanja;
	}
	public String getVremeOdigravanja() {
		return vremeOdigravanja;
	}
	public void setVremeOdigravanja(String vremeOdigravanja) {
		this.vremeOdigravanja = vremeOdigravanja;
	}
	public Klub getKlubDomacin() {
		return klubDomacin;
	}
	public void setKlubDomacin(Klub klubDomacin) {
		this.klubDomacin = klubDomacin;
	}
	public Klub getKlubGost() {
		return klubGost;
	}
	public void setKlubGost(Klub klubGost) {
		this.klubGost = klubGost;
	}
	public int getBrojKosevaDomacin() {
		return brojKosevaDomacin;
	}
	public void setBrojKosevaDomacin(int brojKosevaDomacin) {
		this.brojKosevaDomacin = brojKosevaDomacin;
	}
	public int getBrojKosevaGost() {
		return brojKosevaGost;
	}
	public void setBrojKosevaGost(int brojKosevaGost) {
		this.brojKosevaGost = brojKosevaGost;
	}
	public ArrayList<Sudija> getSveSudije() {
		return sveSudije;
	}
	public void setSveSudije(ArrayList<Sudija> sveSudije) {
		this.sveSudije = sveSudije;
	}
}
