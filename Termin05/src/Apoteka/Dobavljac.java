package Apoteka;

import java.util.ArrayList;

public class Dobavljac {

	protected String id;
	protected String naziv;
	protected String adresa;
	protected String mesto;
	protected String brojTelefona;
	
	//lista narudžbenica od dobavljača
	protected ArrayList<Narudzbenica> narudzbenice = new ArrayList<Narudzbenica>();
	
	public Dobavljac(String id, String naziv, String adresa, String mesto,
			String brojTelefona) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.mesto = mesto;
		this.brojTelefona = brojTelefona;
	}
	
	public Dobavljac(String id, String naziv, String adresa, String mesto, String brojTelefona,
			ArrayList<Narudzbenica> narudzbenice) {
		this.id = id;
		this.naziv = naziv;
		this.adresa = adresa;
		this.mesto = mesto;
		this.brojTelefona = brojTelefona;
		this.narudzbenice = narudzbenice;
	}

	public Dobavljac(String red) {
		//id, naziv, 		adresa,	  grad,	broj telefona
		//0		1				2		3		4
		//001,Hemofarm,Industriska BB,Vrsac,061222222
		String[] tokeni = red.split(",");

		this.id = tokeni[0];
		this.naziv = tokeni[1];
		this.adresa = tokeni[2];
		this.mesto = tokeni[3];
		this.brojTelefona = tokeni[4];
	}
	
	public String toFileRepresentation(){
		return id + "," + naziv+ ","+adresa + "," + mesto + "," + brojTelefona;
	}

	@Override
	public String toString() {
		return "Dobavljac [id=" + id + ", naziv=" + naziv + ", adresa="
				+ adresa + ", mesto=" + mesto + ", brojTelefona="
				+ brojTelefona + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
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
