package com.ftninformatika.vezbe06.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class Korpa {

	private List<Stavka> stavke = new ArrayList<>();
	
	public void dodaj(Proizvod proizvod, int komada) {
		stavke.add(new Stavka(proizvod, komada));
	}

	public void ukloni(int redni_broj_stavke) {
		stavke.remove(redni_broj_stavke);
	}

	public double getCena() {
		double cena = 0;
		for (Stavka itStavka: stavke) {
			cena += itStavka.getCena();
		}

		return cena;
	}
	
	public List<Stavka> getStavke() {
		return stavke;
	}

}
