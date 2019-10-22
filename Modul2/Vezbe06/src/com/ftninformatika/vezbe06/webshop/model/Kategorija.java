package com.ftninformatika.vezbe06.webshop.model;

public class Kategorija {

	private long id;
	private String naziv;

	public Kategorija(long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
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

		Kategorija other = (Kategorija) obj;
		return id == other.id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public long getID() {
		return id;
	}

}
