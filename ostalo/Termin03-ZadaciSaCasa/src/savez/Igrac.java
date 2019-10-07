package savez;

import java.util.ArrayList;

public class Igrac {
	
	protected int sifraIgraca;
	protected String imeIgraca;
	protected String prezimeIgraca;
	protected Klub klub ;
	
	public Igrac (int sifraIgraca, String imeIgraca, String prezimeIgraca, Klub klub ){
		this.sifraIgraca = sifraIgraca;
		this.imeIgraca = imeIgraca;
		this.prezimeIgraca = prezimeIgraca;
		this.klub = klub;						
	}
	
	public Igrac(String tekst, ArrayList<Klub> lista){
		String [] tokeni = tekst.split(",");
		//1,Vlade,Divac,1
		//0   1    2    3
		if(tokeni.length !=4){
			System.out.println("Greska pri ucitavanju igraca "+tekst);			
			System.exit(0);
		}
		
		sifraIgraca = Integer.parseInt(tokeni[0]);
		imeIgraca = tokeni[1];
		prezimeIgraca = tokeni[2];
		int sifraKluba = Integer.parseInt(tokeni[3]);
        klub = TestKosarkaskogSaveza.pratragaKluba(lista, sifraKluba); 
               
        if (klub == null) {
        	
        	System.out.println(" Nije moguce ucitati sifru kluba !!!");
        }
        
        klub.getIgraci().add(this);
        
	}
	public String vratiTekstualnuReprezentacijuZaIgraca() {
		String ispis = "Igrac sa sifrom igraca : " + sifraIgraca + " zove se : " 
				+ imeIgraca + " " + prezimeIgraca + "."  ;
		return ispis;
	}
	
	public String vratiTekstualnuReprezentacijuZaIgracaAll() {
		StringBuilder sb = new StringBuilder("Igrac sa sifrom : " + sifraIgraca + " Ä?ije je ime i prezime " 
				+ imeIgraca + " " + prezimeIgraca );
		
		if(klub != null){
			sb.append(" igra za klub : " + klub.nazivKluba+ ".");			
		}
		return sb.toString();
	}

	public int getSifraIgraca() {
		return sifraIgraca;
	}

	public void setSifraIgraca(int sifraIgraca) {
		this.sifraIgraca = sifraIgraca;
	}

	public String getImeIgraca() {
		return imeIgraca;
	}

	public void setImeIgraca(String imeIgraca) {
		this.imeIgraca = imeIgraca;
	}

	public String getPrezimeIgraca() {
		return prezimeIgraca;
	}

	public void setPrezimeIgraca(String prezimeIgraca) {
		this.prezimeIgraca = prezimeIgraca;
	}

	public Klub getKlub() {
		return klub;
	}

	public void setKlub(Klub klub) {
		this.klub = klub;
	}
	

}
