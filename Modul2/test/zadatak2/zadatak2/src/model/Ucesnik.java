package model;

public class Ucesnik {
	
	String imePrezime;
	int brKm;
	int vremeMin;
	String tipUcesnika;
	String zavrsioTrku;
	String napomena;
	TipUcesca tipUcesca;
	
	//public static int brojUcesnika = 0;
	
	public Ucesnik() {}

	public Ucesnik(String imePrezime, int brKm, int vremeMin, String tipUcesnika, String zavrsioTrku, String napomena,
			TipUcesca tipUcesca) {
		super();
		this.imePrezime = imePrezime;
		this.brKm = brKm;
		this.vremeMin = vremeMin;
		this.tipUcesnika = tipUcesnika;
		this.zavrsioTrku = zavrsioTrku;
		this.napomena = napomena;
		this.tipUcesca = tipUcesca;
	}


	public String getImePrezime() {
		return imePrezime;
	}


	public void setImePrezime(String imePrezime) {
		this.imePrezime = imePrezime;
	}


	public int getBrKm() {
		return brKm;
	}


	public void setBrKm(int brKm) {
		this.brKm = brKm;
	}


	public int getVremeMin() {
		return vremeMin;
	}


	public void setVremeMin(int vremeMin) {
		this.vremeMin = vremeMin;
	}


	public String getTipUcesnika() {
		return tipUcesnika;
	}


	public void setTipUcesnika(String tipUcesnika) {
		this.tipUcesnika = tipUcesnika;
	}


	public String getZavrsioTrku() {
		return zavrsioTrku;
	}


	public void setZavrsioTrku(String zavrsioTrku) {
		this.zavrsioTrku = zavrsioTrku;
	}


	public String getNapomena() {
		return napomena;
	}


	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}


	public TipUcesca getTipUcesca() {
		return tipUcesca;
	}


	public void setTipUcesca(TipUcesca tipUcesca) {
		this.tipUcesca = tipUcesca;
	}


	@Override
	public String toString() {
		return "Ucesnik [imePrezime=" + imePrezime + ", brKm=" + brKm + ", vremeMin=" + vremeMin + ", tipUcesnika="
				+ tipUcesnika + ", zavrsioTrku=" + zavrsioTrku + ", napomena=" + napomena + ", tipUcesca=" + tipUcesca
				+ "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + brKm;
		result = prime * result + ((imePrezime == null) ? 0 : imePrezime.hashCode());
		result = prime * result + ((napomena == null) ? 0 : napomena.hashCode());
		result = prime * result + ((tipUcesca == null) ? 0 : tipUcesca.hashCode());
		result = prime * result + ((tipUcesnika == null) ? 0 : tipUcesnika.hashCode());
		result = prime * result + vremeMin;
		result = prime * result + ((zavrsioTrku == null) ? 0 : zavrsioTrku.hashCode());
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
		Ucesnik other = (Ucesnik) obj;
		if (brKm != other.brKm)
			return false;
		if (imePrezime == null) {
			if (other.imePrezime != null)
				return false;
		} else if (!imePrezime.equals(other.imePrezime))
			return false;
		if (napomena == null) {
			if (other.napomena != null)
				return false;
		} else if (!napomena.equals(other.napomena))
			return false;
		if (tipUcesca == null) {
			if (other.tipUcesca != null)
				return false;
		} else if (!tipUcesca.equals(other.tipUcesca))
			return false;
		if (tipUcesnika == null) {
			if (other.tipUcesnika != null)
				return false;
		} else if (!tipUcesnika.equals(other.tipUcesnika))
			return false;
		if (vremeMin != other.vremeMin)
			return false;
		if (zavrsioTrku == null) {
			if (other.zavrsioTrku != null)
				return false;
		} else if (!zavrsioTrku.equals(other.zavrsioTrku))
			return false;
		return true;
	}
	
	
	
	
}
