package com.ftninformatika.vezbe06.webshop.model;

public class Proizvod {

	private long id;
	private String naziv;
	private double cena;

	private Kategorija kategorija;

	public Proizvod(long id, String naziv, double cena, Kategorija kategorija) {
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
		this.kategorija = kategorija;
	}

	@Override
	public int hashCode() {
		return 31 + (int) (id ^ (id >>> 32));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass()) 
			return false;

		Proizvod other = (Proizvod) obj;
		return id == other.id;
	}

	public long getID() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public Kategorija getKategorija() {
		return kategorija;
	}

	public void setKategorija(Kategorija kategorija) {
		this.kategorija = kategorija;
	}

}
