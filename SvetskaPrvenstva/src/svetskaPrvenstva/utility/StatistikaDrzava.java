package svetskaPrvenstva.utility;

public class StatistikaDrzava {
	
	private String drzava;
	private int osvajac;
	private int domacin;
	
	public StatistikaDrzava(String drzava, int osvajac, int domacin) {
		super();
		this.drzava = drzava;
		this.osvajac = osvajac;
		this.domacin = domacin;
	}
	public String getDrzava() {
		return drzava;
	}
	public void setDrzava(String drzava) {
		this.drzava = drzava;
	}
	public int getOsvajac() {
		return osvajac;
	}
	public void setOsvajac(int osvajac) {
		this.osvajac = osvajac;
	}
	public int getDomacin() {
		return domacin;
	}
	public void setDomacin(int domacin) {
		this.domacin = domacin;
	}
	
	

}
