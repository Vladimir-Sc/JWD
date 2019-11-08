package com.ftninformatika.vezbe08.webshop.model;

public class Stavka {

	private Proizvod proizvod;
	private int komada;

	public Stavka(Proizvod proizvod, int komada) {
		this.proizvod = proizvod;
		this.komada = komada;
	}

	public double getCena() {
		return komada*proizvod.getCena();
	}
	
	public Proizvod getProizvod() {
		return proizvod;
	}

	public int getKomada() {
		return komada;
	}

}
