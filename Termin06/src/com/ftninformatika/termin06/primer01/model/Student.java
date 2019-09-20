package com.ftninformatika.termin06.primer01.model;

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

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime*result + indeks.hashCode();
//		result = prime*result + ime.hashCode();
//		result = prime*result + prezime.hashCode();
//		return result;
//	}
//	
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj) return true;
//		if (obj == null) return false;
//		if (!(obj instanceof Student)) return false;
//
//		Student that = (Student) obj;
//		return indeks.equals(that.indeks) && ime.equals(that.ime) && prezime.equals(that.prezime); 
//	}

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
