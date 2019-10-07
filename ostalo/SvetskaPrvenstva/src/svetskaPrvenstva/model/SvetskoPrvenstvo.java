package svetskaPrvenstva.model;

public class SvetskoPrvenstvo {

	private int godina;
	private String naziv;

	private Drzava domacin;
	private Drzava osvajac;

	public SvetskoPrvenstvo(int godina, String naziv, Drzava domacin, Drzava osvajac) {
		this.godina = godina;
		this.naziv = naziv;
		this.domacin = domacin;
		this.osvajac = osvajac;
	}

	@Override
	public String toString() {
		return "SvetskoPrvenstvo [godina=" + godina + ", naziv=" + naziv + ", domacin=" + domacin.getNaziv() + ", osvajac=" + osvajac.getNaziv() + "]";
	}

	public int getGodina() {
		return godina;
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
