package Apoteka;

import java.util.ArrayList;

public class Lek {

	protected String sifra;
	protected String naziv;
	
	//lista stavki narudžbenica u kojima se naručuje lek
	protected ArrayList<NarudzbenicaStavka> stavkeNarudzbenice = new ArrayList<NarudzbenicaStavka>();

	public Lek(String sifra, String naziv) {
		this.sifra = sifra;
		this.naziv = naziv;
	}
	
	public Lek(String sifra, String naziv, ArrayList<NarudzbenicaStavka> stavkeNarudzbenice) {
		this.sifra = sifra;
		this.naziv = naziv;
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}

	public Lek(String red) {
		//id, naziv
		//0		1	
		//001,Vitamin C
		String[] tokeni = red.split(",");

		this.sifra = tokeni[0];
		this.naziv = tokeni[1];
	}
	
	public String toFileRepresentation(){
		return sifra + "," + naziv;
	}

	@Override
	public String toString() {
		return "Lek [sifra=" + sifra + ", naziv=" + naziv + "]";
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<NarudzbenicaStavka> getStavkeNarudzbenice() {
		return stavkeNarudzbenice;
	}

	public void setStavkeNarudzbenice(ArrayList<NarudzbenicaStavka> stavkeNarudzbenice) {
		this.stavkeNarudzbenice = stavkeNarudzbenice;
	}
	
}
