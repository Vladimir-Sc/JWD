package com.ftninformatika.termin07.primer03.model;

public class Student {

	protected int id;
	protected String ime;
	protected String prezime;
	protected String indeks;

	public Student(int id, String indeks, String ime, String prezime) {
		this.id = id;
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", indeks=" + indeks + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String index) {
		this.indeks = index;
	}

}
