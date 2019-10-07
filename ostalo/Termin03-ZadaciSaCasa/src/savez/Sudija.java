package savez;

public class Sudija {
	
	protected int sifraSudije;
	protected String imeSudije;
	protected String prezimeSudije;
	
	public Sudija(int sifraSudije,String imeSudije, String prezimeSudije ){	

		this.sifraSudije = sifraSudije;
		this.imeSudije = imeSudije;
		this.prezimeSudije = prezimeSudije;									
	}


	public Sudija(String tekst){
		String [] tokeni = tekst.split(",");
		//2,Miodrag, Bubalo
		//0   1        2
		if(tokeni.length !=3){
			System.out.println("Greska pri ucitavanju sudije "+tekst);			
			System.exit(0);
		}

		sifraSudije = Integer.parseInt(tokeni[0]);
		imeSudije = tokeni[1];
		prezimeSudije = tokeni[2];		

	}
	public String vratiTekstualnuReprezentacijuZaSudiju() {
		String ispis = "Sudija sa sifrom sudije : " + sifraSudije + " zove se : "+imeSudije+""+prezimeSudije+".";    				
		return ispis;
	}

	public int getSifraSudije() {
		return sifraSudije;
	}


	public void setSifraSudije(int sifraSudije) {
		this.sifraSudije = sifraSudije;
	}


	public String getImeSudije() {
		return imeSudije;
	}

	public void setImeSudije(String imeSudije) {
		this.imeSudije = imeSudije;
	}

	public String getPrezimeSudije() {
		return prezimeSudije;
	}

	public void setPrezimeSudije(String prezimeSudije) {
		this.prezimeSudije = prezimeSudije;
	}
}
