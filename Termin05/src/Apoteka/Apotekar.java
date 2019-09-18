package Apoteka;

import java.util.ArrayList;

public class Apotekar {

	protected String id;
	protected String ime;
	protected String prezime;
	protected String brojTelefona;
	
	//lista narudžbenica od apotekara
	protected ArrayList<Narudzbenica> narudzbenice = new ArrayList<Narudzbenica>();

	public Apotekar(String id, String ime, String prezime, String brojTelefona) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
	}
	
	public Apotekar(String id, String ime, String prezime, String brojTelefona,
			ArrayList<Narudzbenica> narudzbenice) {
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.brojTelefona = brojTelefona;
		this.narudzbenice = narudzbenice;
	}

	public Apotekar(String red) {
		//id, ime, prezime, broj telefona
		//0		1		2		3
		//001,Petar,Petrovic,064123456 
		String[] tokeni = red.split(",");

		this.id = tokeni[0];
		this.ime = tokeni[1];
		this.prezime = tokeni[2];
		this.brojTelefona = tokeni[3];
	}
	
	public String toFileRepresentation(){
		return id + "," + ime+ ","+prezime + "," + brojTelefona;
	}

	@Override
	public String toString() {
		return "Apotekar [id=" + id + ", ime=" + ime + ", prezime=" + prezime
				+ ", brojTelefona=" + brojTelefona + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public ArrayList<Narudzbenica> getNarudzbenice() {
		return narudzbenice;
	}

	public void setNarudzbenice(ArrayList<Narudzbenica> narudzbenice) {
		this.narudzbenice = narudzbenice;
	}
}
