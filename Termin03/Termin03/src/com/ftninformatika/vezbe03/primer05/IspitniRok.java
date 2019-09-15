package com.ftninformatika.vezbe03.primer05;


import java.util.ArrayList;
import java.util.Date;

public class IspitniRok {

	private int id;
	private String naziv;
	private Date pocetak;
	private Date kraj;
	private ArrayList<IspitnaPrijava> IspitniRokImaPrijavljeneIspitnePrijave;

	public IspitniRok() {}

	public IspitniRok(int id, String naziv, Date pocetak, Date kraj,
			ArrayList<IspitnaPrijava> ispitniRokImaPrijavljeneIspitnePrijave) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.pocetak = pocetak;
		this.kraj = kraj;
		IspitniRokImaPrijavljeneIspitnePrijave = ispitniRokImaPrijavljeneIspitnePrijave;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Date getPocetak() {
		return pocetak;
	}

	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}

	public Date getKraj() {
		return kraj;
	}

	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}

	public ArrayList<IspitnaPrijava> getIspitniRokImaPrijavljeneIspitnePrijave() {
		return IspitniRokImaPrijavljeneIspitnePrijave;
	}

	public void setIspitniRokImaPrijavljeneIspitnePrijave(
			ArrayList<IspitnaPrijava> ispitniRokImaPrijavljeneIspitnePrijave) {
		IspitniRokImaPrijavljeneIspitnePrijave = ispitniRokImaPrijavljeneIspitnePrijave;
	}

}

