package svetskaPrvenstva.model;

public class SvetskoPrvenstvo {
	private int godina;
	private String naziv;
	private Drzava osvajac;
	private Drzava domacin;
	public SvetskoPrvenstvo(int godina, String naziv, Drzava osvajac, Drzava domacin) {
		super();
		this.godina = godina;
		this.naziv = naziv;
		this.osvajac = osvajac;
		this.domacin = domacin;
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
	public Drzava getOsvajac() {
		return osvajac;
	}
	public void setOsvajac(Drzava osvajac) {
		this.osvajac = osvajac;
	}
	public Drzava getDomacin() {
		return domacin;
	}
	public void setDomacin(Drzava domacin) {
		this.domacin = domacin;
	}
	
	
}
