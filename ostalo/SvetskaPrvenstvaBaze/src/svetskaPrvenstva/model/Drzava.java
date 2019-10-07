package svetskaPrvenstva.model;

import java.util.ArrayList;
import java.util.List;

public class Drzava {

	protected final int id;
	protected String naziv;

	protected List<Prvenstvo> listaOsvojenihPrvenstava = new ArrayList<>();
	protected List<Prvenstvo> listaDomacinPrvenstava = new ArrayList<>();

	public Drzava(int id, String naziv) {
		this.id = id;
		this.naziv = naziv;
	}

	public Drzava(String naziv) {
		this.id = 0;
		this.naziv = naziv;
	}

	@Override
	public String toString() {
		return "Drzava [id=" + id + ", naziv=" + naziv + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Drzava)) return false;

		Drzava that = (Drzava) obj;
		return that.id == this.id;
	}

	public int getID() {
		return id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public List<Prvenstvo> getListaOsvojenihPrvenstava() {
		return listaOsvojenihPrvenstava;
	}

	public List<Prvenstvo> getListaDomacinPrvenstava() {
		return listaDomacinPrvenstava;
	}
	
}
