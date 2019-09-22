package svetskaPrvenstva.model;

public class SvetskoPrvenstvo {

	private String naziv;
	private int godina;

	private Drzava domacin;
	private Drzava osvajac;

	public SvetskoPrvenstvo(String naziv, int godina, Drzava domacin, Drzava osvajac) {
		this.naziv = naziv;
		this.godina = godina;
		this.domacin = domacin;
		this.osvajac = osvajac;
	}

	@Override
	public String toString() {
		return "SvetskoPrvenstvo [naziv=" + naziv + ", godina=" + godina + ", domacin=" + domacin.getNaziv() + ", osvajac="
				+ osvajac.getNaziv() + "]";
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

	public int getGodina() {
		return godina;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + godina;
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
		SvetskoPrvenstvo other = (SvetskoPrvenstvo) obj;
		if (godina != other.godina)
			return false;
		return true;
	}

	
	
}
