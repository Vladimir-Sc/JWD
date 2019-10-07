package menjacnica.model;

import java.util.ArrayList;
import java.util.List;

public class Valuta {

	private int id;
	private String oznaka;
	private String naziv;
	
	private List<VrednostValute> vrednostiValute= new ArrayList<VrednostValute>();
	
	public Valuta(int id, String oznaka, String naziv) throws Exception {
		this.id = id;
		setOznaka(oznaka);
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Valuta [id=" + id + ", oznaka=" + oznaka + ", naziv=" + naziv + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Valuta other = (Valuta) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public String getOznaka() {
		return oznaka;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setOznaka(String oznaka) throws Exception {
		if(oznaka != null && oznaka.length()!=3)
			throw new Exception("Oznaka moze da ima samo tri karaktera");
		this.oznaka = oznaka;
	}
	

}
