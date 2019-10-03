package menjacnica.utils;

import java.sql.Date;

public class Statistika {
	
	private double srednja;
	private Date datum;
	public Statistika(double srednja, Date datum) {
		super();
		this.srednja = srednja;
		this.datum = datum;
	}
	public double getSrednja() {
		return srednja;
	}
	public void setSrednja(double srednja) {
		this.srednja = srednja;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	
	

}

//
//select * from valute v 
//left join vrednostiValuta vv 
//on v.id = vv.valuta
//left join kursneListe k on k.id = vv.kursnaLista