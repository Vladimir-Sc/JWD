package com.ftninformatika.vezbe03.primer02;

import java.util.ArrayList;

public class Predmet {
	int id;
	String naziv;
	//studenti koje pohađaju predmet
	ArrayList<Student> studenti = new ArrayList<Student>();
	
	//metode
	String vratiTekstualnuReprezentacijuZaIspis() {
		String ispis = "Predmet sa id " + id + " ima naziv " 
				+ naziv;
		return ispis;
	}
	
	String vratiTekstualnuReprezentacijuZaIspisAll() {
		StringBuilder sb = new StringBuilder("Predmet sa id " + id + " ima naziv " 
				+ naziv);
		
		if(studenti != null){
			sb.append(" i pohađaju ga studenti\n");
			for (int i = 0; i < studenti.size(); i++) {

				sb.append("\t"+studenti.get(i).vratiTekstualnuReprezentacijuZaIspis()+"\n");

			}
		}

		return sb.toString();
	}
}
