package com.ftninformatika.termin06.primer02.model;

public class Student {

	private String indeks;
	private String ime;
	private String prezime;

	public Student(String indeks, String ime, String prezime) {
		this.indeks = indeks;
		this.ime = ime;
		this.prezime = prezime;
	}

	@Override
	public String toString() {
		return "Student [indeks=" + indeks + ", ime=" + ime + ", prezime=" + prezime + "]";
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
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

}
