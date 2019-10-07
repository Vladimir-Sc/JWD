package autobuskastanica;

public class TipAutobus {
	
	private String sifraTipAutobus;
	private String nazivTipAutobus;
	
	public TipAutobus(String sifra, String naziv){
		sifraTipAutobus = sifra;
		nazivTipAutobus = naziv;
	}
	
	@Override
	public String toString() {
		return "TipAutobus " + nazivTipAutobus + "(" + sifraTipAutobus + ")";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sifraTipAutobus == null) ? 0 : sifraTipAutobus.hashCode());
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
		TipAutobus other = (TipAutobus) obj;
		if (sifraTipAutobus == null) {
			if (other.sifraTipAutobus != null)
				return false;
		} else if (!sifraTipAutobus.equals(other.sifraTipAutobus))
			return false;
		return true;
	}

	public String getSifraTipAutobus() {
		return sifraTipAutobus;
	}
	public void setSifraTipAutobus(String sifraTipAutobus) {
		this.sifraTipAutobus = sifraTipAutobus;
	}
	public String getNazivTipAutobus() {
		return nazivTipAutobus;
	}
	public void setNazivTipAutobus(String nazivTipAutobus) {
		this.nazivTipAutobus = nazivTipAutobus;
	}
	
	
}
