package com.ftninformatika.termin07.primer04.model;

import com.ftninformatika.termin07.primer04.utils.PomocnaKlasaDatumi;

public class Pregled {

	private long id;

	private String lboPacijenta;
	private String imePacijenta;
	private String prezimePacijenta;
	private java.sql.Timestamp datumVremeRodjenjaPacijenta;

	private java.sql.Date datumPregleda;
	private java.sql.Time zakazanoVremePregleda;
	private java.sql.Timestamp tacanDatumVremePregleda;

	private String izvestaj;

	public Pregled(String lboPacijenta, String imePacijenta, String prezimePacijenta,
			java.sql.Timestamp datumVremeRodjenjaPacijenta, java.sql.Date datumPregleda, java.sql.Time zakazanoVremePregleda) {
		this.lboPacijenta = lboPacijenta;
		this.imePacijenta = imePacijenta;
		this.prezimePacijenta = prezimePacijenta;
		this.datumVremeRodjenjaPacijenta = datumVremeRodjenjaPacijenta;
		this.datumPregleda = datumPregleda;
		this.zakazanoVremePregleda = zakazanoVremePregleda;
	}
	
	public Pregled(long id, String lboPacijenta, String imePacijenta, String prezimePacijenta,
			java.sql.Timestamp datumVremeRodjenjaPacijenta, java.sql.Date datumPregleda, java.sql.Time zakazanoVremePregleda) {
		this.id = id;
		this.lboPacijenta = lboPacijenta;
		this.imePacijenta = imePacijenta;
		this.prezimePacijenta = prezimePacijenta;
		this.datumVremeRodjenjaPacijenta = datumVremeRodjenjaPacijenta;
		this.datumPregleda = datumPregleda;
		this.zakazanoVremePregleda = zakazanoVremePregleda;
	}

	@Override
	public String toString() {
		String pregled = "Pregled [";
		pregled += "id=" + id + ", ";
		pregled += "lboPacijenta=" + lboPacijenta + ", ";
		pregled += "imePacijenta=" + imePacijenta + ", ";
		pregled += "prezimePacijenta=" + prezimePacijenta + ", ";
		pregled += "datumVremeRodjenjaPacijenta=" +  PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(datumVremeRodjenjaPacijenta) + ", ";
		pregled += "datumPregleda=" + PomocnaKlasaDatumi.DATE_FORMAT.format(datumPregleda) + ", ";
		pregled += "zakazanoVremePregleda=" + PomocnaKlasaDatumi.TIME_FORMAT.format(zakazanoVremePregleda) + ", ";
		try {
			pregled += "tacanDatumVremePregleda=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(tacanDatumVremePregleda) + ", ";
		} catch (Exception ex) {
			pregled += "tacanDatumVremePregleda=, ";
		}	
		pregled += "izvestaj=" + izvestaj + "]";

		return pregled;
	}

	@Override
	public int hashCode() {
		return 31 + (int) (id ^ (id >>> 32));
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;

		Pregled other = (Pregled) obj;
		return id == other.id;
	}

	public long getID() {
		return id;
	}

	public String getLboPacijenta() {
		return lboPacijenta;
	}

	public String getImePacijenta() {
		return imePacijenta;
	}

	public String getPrezimePacijenta() {
		return prezimePacijenta;
	}

	public java.sql.Timestamp getDatumVremeRodjenjaPacijenta() {
		return datumVremeRodjenjaPacijenta;
	}

	public java.sql.Date getDatumPregleda() {
		return datumPregleda;
	}

	public java.sql.Time getZakazanoVremePregleda() {
		return zakazanoVremePregleda;
	}

	public java.sql.Timestamp getTacanDatumVremePregleda() {
		return tacanDatumVremePregleda;
	}

	public void setTacanDatumVremePregleda(java.sql.Timestamp tacanDatumVremePregleda) {
		this.tacanDatumVremePregleda = tacanDatumVremePregleda;
	}

	public String getIzvestaj() {
		return izvestaj;
	}

	public void setIzvestaj(String izvestaj) {
		this.izvestaj = izvestaj;
	}

}
