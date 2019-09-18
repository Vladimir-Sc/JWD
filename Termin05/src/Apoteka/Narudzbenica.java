package Apoteka;

import java.util.ArrayList;

public class Narudzbenica {
	
	protected String	sifra;
	protected Apotekar 	apot;
	protected Dobavljac dob;
	protected String 	datum;
	protected ArrayList<NarudzbenicaStavka> stavke = new ArrayList<NarudzbenicaStavka>();;
	protected double ukupnaCena;
	
	public Narudzbenica(String sifra, Apotekar apot, Dobavljac dob, String datum, double ukupnaCena) {
		super();
		this.sifra = sifra;
		this.apot = apot;
		this.dob = dob;
		this.datum = datum;
		this.ukupnaCena = ukupnaCena;
	}
	
	public Narudzbenica(String sifra, Apotekar apot, Dobavljac dob, String datum,
			double ukupnaCena, ArrayList<NarudzbenicaStavka> stavke) {
		super();
		this.sifra = sifra;
		this.apot = apot;
		this.dob = dob;
		this.datum = datum;
		this.stavke = stavke;
		this.ukupnaCena = ukupnaCena;
	}
	/**
	 * NAPOMENA!!!!!!!!!!
	 * U klasi imamo zavisnost od objekata drugih klasa
	  	protected Apotekar apot; //atribut koji sadrzi referencu ka objektu klase Apotekar
		protected Dobavljac dob; //atribut koji sadrzi referencu ka objektu klase Dobavljac
		protected ArrayList<NarudzbenicaStavka> stavke; //lista stavki, stavka sadrzi referencu ka objektu klase Lek
		
		Zbog zavisnosti narudzbenice od apotekara i dobavljaca
		moramo da u Test klasi da ucitavamo podatke po odredjenom rasporedu 
		1. ucitaj Apotekare
		2. ucitaj Dobavljace
		3. ucitaj Lekove
		4. ucitaj Narudzbenice
	 */
	public Narudzbenica(String red) {
		//id, id apotekara, id dobavljaca, datum kupovine, ukupna cena
		//0		1				2				3				4
		//001,001,001,2015-02-11,26960.00;
		String[] tokeni = red.split(",");

		this.sifra = tokeni[0];
		this.apot = Test.pronadjiApotekara(tokeni[1]);
		this.dob = Test.pronadjiDobavljaca(tokeni[2]);
		this.datum = tokeni[3];
		this.ukupnaCena = Double.parseDouble(tokeni[4]);
		
		this.apot.getNarudzbenice().add(this);
		this.dob.getNarudzbenice().add(this);
	}
	
	public String toFileRepresentation(){
		StringBuffer buf = new StringBuffer(sifra+ ","+apot.getId()+ 
				","+dob.getId()+ ","+datum+"," + ukupnaCena);
		return buf.toString();
	}

	@Override
	public String toString() {
		return "Narudzbenica [sifra=" + sifra + ", apot=" 
				+ apot.getIme()+ " "+apot.getPrezime() + 
				", dob="+ dob.getNaziv() + ", datum=" + datum 
				+ ", ukupnaCena=" + ukupnaCena + "]";
	}

	public String toStringStavke() {
		StringBuffer buf = new StringBuffer();
		for (NarudzbenicaStavka nas : stavke) {
			buf.append("\t"+nas + "\n");
		}
		return buf.toString();
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Apotekar getApot() {
		return apot;
	}

	public void setApot(Apotekar apot) {
		this.apot = apot;
	}

	public Dobavljac getDob() {
		return dob;
	}

	public void setDob(Dobavljac dob) {
		this.dob = dob;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public ArrayList<NarudzbenicaStavka> getStavke() {
		return stavke;
	}

	public void setStavke(ArrayList<NarudzbenicaStavka> stavke) {
		this.stavke = stavke;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}
}
