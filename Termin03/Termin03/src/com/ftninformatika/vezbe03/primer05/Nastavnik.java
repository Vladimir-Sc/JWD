package com.ftninformatika.vezbe03.primer05;


import java.util.ArrayList;

public class Nastavnik {
	
	private int id;
	private String ime;
	private String prezime;
	private String zvanje;
	private ArrayList<Predmet> nastavnikPredajePredmete;
	
	public Nastavnik() {
		
	}
	
	public Nastavnik(int id, String ime, String prezime, String zvanje) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
	}



	public Nastavnik(int id, String ime, String prezime, String zvanje, ArrayList<Predmet> nastavnikPredajePredmete) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.zvanje = zvanje;
		this.nastavnikPredajePredmete = nastavnikPredajePredmete;
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

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getNastavnikPredajePredmete() {
		return nastavnikPredajePredmete;
	}

	public void setNastavnikPredajePredmete(ArrayList<Predmet> nastavnikPredajePredmete) {
		this.nastavnikPredajePredmete = nastavnikPredajePredmete;
	}

	@Override
	public String toString() {
		return "Nastavnik [id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", zvanje=" + zvanje + "]";
	}
	
//	@Override
//	public String toString() {
//		return "id=" + id + "\n" + "ime=" + ime + "\n" + "prezime=" + prezime + "\n" + "zvanje=" + zvanje + "\n";
//		
//	}

}

