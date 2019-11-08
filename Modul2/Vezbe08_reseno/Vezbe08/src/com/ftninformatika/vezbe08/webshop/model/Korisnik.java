package com.ftninformatika.vezbe08.webshop.model;

public class Korisnik {

	private String korisnickoIme;
	private String lozinka;

	public Korisnik(String korisnickoIme, String lozinka) {
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
	}

	@Override
	public int hashCode() {
		return 31 + korisnickoIme.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		Korisnik other = (Korisnik) obj;
		return korisnickoIme.equals(other.korisnickoIme);
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

}
