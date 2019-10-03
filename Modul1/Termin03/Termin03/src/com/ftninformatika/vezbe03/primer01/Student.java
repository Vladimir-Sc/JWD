package com.ftninformatika.vezbe03.primer01;

import java.util.ArrayList;

//klasa
class Student {

	//atributi
	int id;
	String ime;
	String prezime;
	String grad;
	String indeks;
	//predmete koje pohađa student
	ArrayList<String> predmeti = new ArrayList<String>();
	
	//metode
	String vratiTekstualnuReprezentacijuZaIspis() {
		String ispis = "Student sa id " + id + " čije je ime i prezime " 
				+ ime + " " + prezime + " ima indeks " + indeks + " i zivi u gradu " + grad;
		return ispis;
	}
	
	String vratiTekstualnuReprezentacijuZaIspisAll() {
		StringBuilder sb = new StringBuilder("Student sa id " + id + " čije je ime i prezime " 
				+ ime + " " + prezime + " ima indeks " + indeks + " i zivi u gradu " + grad);
		
		if(predmeti != null){
			sb.append(" i pohađa predmete\n");
			for (int i = 0; i < predmeti.size(); i++) {
				sb.append("\t"+predmeti.get(i)+"\n");
			}
		}
		return sb.toString();
	}
	
	void postaviNovoStanje(String novoIme){
		ime = novoIme;
	}
	
	//greska , ne setuju se atributi klase
	//ime parametra bi trebalo biti razlicito nego ime atribut klase
	//u nastavku ćemo videti kako se može koristiti isto ime
	void postaviNovoStanje(String ime, String grad){
		ime = ime;
		grad = grad;
	}
}
