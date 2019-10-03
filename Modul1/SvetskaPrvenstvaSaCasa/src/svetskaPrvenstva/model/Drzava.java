package svetskaPrvenstva.model;

import java.util.ArrayList;

public class Drzava {
	
	private String naziv;
	
	private ArrayList<Drzava> osvajaci;
	private ArrayList<Drzava> domacini;
	
	public Drzava(String naziv) {
		super();
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

}
