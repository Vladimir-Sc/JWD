package svetskaPrvenstva.model;

public class Prvenstvo {

	protected final int id;
	protected int godina;
	protected String naziv;
	protected Drzava domacin;
	protected Drzava osvajac;

	public Prvenstvo(int id, int godina, String naziv, Drzava domacin, Drzava osvajac) {
		this.id = id;
		this.godina = godina;
		this.naziv = naziv;
		this.domacin = domacin;
		this.osvajac = osvajac;
	}

	public Prvenstvo(int godina, String naziv, Drzava domacin, Drzava osvajac) {
		this.id = 0;
		this.godina = godina;
		this.naziv = naziv;
		this.domacin = domacin;
		this.osvajac = osvajac;
	}

	@Override
	public String toString() {
		return "Prvenstvo [id=" + id + ", godina=" + godina + ", naziv=" + naziv + ", domacin=" + domacin + ", osvajac=" + osvajac + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj == this) return true;
		if (!(obj instanceof Prvenstvo)) return false;

		Prvenstvo that = (Prvenstvo) obj;
		return that.id == this.id;
	}

	public int getId() {
		return id;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Drzava getDomacin() {
		return domacin;
	}

	public void setDomacin(Drzava domacin) {
		this.domacin = domacin;
	}

	public Drzava getOsvajac() {
		return osvajac;
	}

	public void setOsvajac(Drzava osvajac) {
		this.osvajac = osvajac;
	}

}
