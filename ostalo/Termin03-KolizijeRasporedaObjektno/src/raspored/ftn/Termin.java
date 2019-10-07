package raspored.ftn;

import utilities.Dan;

public class Termin {
	
	private static int brojac=1;
	private int redniBrojOglasa;
	
	private Dan dan;
	private String kabinet;
	private Predavac predavac;
	private int odSati;
	private int odMinuta;
	private int doSati;
	private int doMinuta;
	private String predmet;
	private String mesto;

	public Termin(Dan dan, String kabinet, Predavac predavac, int odSati, int odMinuta, int doSati, int doMinuta,
			String predmet, String mesto) {
		
		this.dan = dan;
		this.kabinet = kabinet;
		this.predavac = predavac;
		this.odSati = odSati;
		this.odMinuta = odMinuta;
		this.doSati = doSati;
		this.doMinuta = doMinuta;
		this.predmet = predmet;
		this.mesto = mesto;
		this.redniBrojOglasa = brojac++;
	}
		
	public String getMesto() {
		return mesto;
	}

	public void setMesto(String mesto) {
		this.mesto = mesto;
	}

	public Predavac getPredavac() {
		return predavac;
	}

	public void setPredavac(Predavac predavac) {
		this.predavac = predavac;
	}

	public int getOdSati() {
		return odSati;
	}

	public int getPocetnoVreme() {
		return odSati*60 + odMinuta;
	}
	
	public int getZavrsnoVreme() {
		return doSati*60 + doMinuta;
	}
	
	public Dan getDan() {
		return dan;
	}

	public String getKabinet() {
		return kabinet;
	}

	public int getRedniBrojOglasa() {
		return redniBrojOglasa;
	}
	
	

	@Override
	public String toString() {
		return "Termin " + redniBrojOglasa + ". Dan: " + dan + "; kabinet: " + kabinet + "; predavac: "
				+ predavac + "; od " + odSati + ":" + odMinuta + " do " + doSati + ":"
				+ doMinuta + "; predmet: " + predmet + "; mesto: " + mesto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Termin other = (Termin) obj;
		if (dan != other.dan)
			return false;
		if (doMinuta != other.doMinuta)
			return false;
		if (doSati != other.doSati)
			return false;
		if (kabinet == null) {
			if (other.kabinet != null)
				return false;
		} else if (!kabinet.equals(other.kabinet))
			return false;
		if (mesto == null) {
			if (other.mesto != null)
				return false;
		} else if (!mesto.equals(other.mesto))
			return false;
		if (odMinuta != other.odMinuta)
			return false;
		if (odSati != other.odSati)
			return false;
		if (predavac == null) {
			if (other.predavac != null)
				return false;
		} else if (!predavac.equals(other.predavac))
			return false;
		if (predmet == null) {
			if (other.predmet != null)
				return false;
		} else if (!predmet.equals(other.predmet))
			return false;
		if (redniBrojOglasa != other.redniBrojOglasa)
			return false;
		return true;
	}

	
	
	
	
}
