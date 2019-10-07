package savez;

import java.util.ArrayList;

public class Klub {
	
	protected int sifraKluba;
	protected String nazivKluba;
	protected ArrayList<Igrac> igraci = new ArrayList<Igrac>();
	
	public Klub(int sifraKluba, String nazivKluba ){
		
		this.sifraKluba = sifraKluba;
		this.nazivKluba = nazivKluba;		
	}
	
	public Klub(int sifraKluba, String nazivKluba, ArrayList<Igrac> igraci ){
		this.sifraKluba = sifraKluba;
		this.nazivKluba = nazivKluba;
		this.igraci = igraci;
				
	}
	
	public Klub(String tekst){
		String [] tokeni = tekst.split(",");
		//4,Real Madrid
		//0    1
		if(tokeni.length != 2){
			System.out.println("Greska pri ucitavanju kluba "+ tekst);
			
			System.exit(0);
		}		
		sifraKluba = Integer.parseInt(tokeni[0]);
		nazivKluba = tokeni[1];				
	}
	
	public String vratiTekstualnuReprezentacijuZaKlub() {
		String ispis = "Klub sa sifrom kluba : " + sifraKluba + " ima naziv " 
				+ nazivKluba+".";
		return ispis;
	}
	
	public String vratiTekstualnuReprezentacijuZaKlubAll() {
		StringBuilder sb = new StringBuilder("Klub sa sifrom kluba:  " + sifraKluba + " i nazivom kluba " + nazivKluba );
		
		if(igraci != null){
			sb.append(" ima sledece igrace pod ugovorm :");
			for (int i = 0; i < igraci.size(); i++) {
				sb.append("\n\t"+igraci.get(i).vratiTekstualnuReprezentacijuZaIgraca());
			}
		}
		return sb.toString();
	}
	
	public int getSifraKluba() {
		return sifraKluba;
	}

	public void setSifraKluba(int sifraKluba) {
		this.sifraKluba = sifraKluba;
	}

	public String getNazivKluba() {
		return nazivKluba;
	}

	public void setNazivKluba(String nazivKluba) {
		this.nazivKluba = nazivKluba;
	}

	public ArrayList<Igrac> getIgraci() {
		return igraci;
	}

	public void setIgraci(ArrayList<Igrac> igraci) {
		this.igraci = igraci;
	}
}
