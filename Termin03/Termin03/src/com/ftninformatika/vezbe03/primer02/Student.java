package com.ftninformatika.vezbe03.primer02;

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
	ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	
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
				sb.append("\t"+predmeti.get(i).vratiTekstualnuReprezentacijuZaIspis()+"\n");
			}
		}
		return sb.toString();
	}

	//set i get metode
	int getId() {
		return id;
	}

	void setId(int id) {
		this.id = id;
	}
}
