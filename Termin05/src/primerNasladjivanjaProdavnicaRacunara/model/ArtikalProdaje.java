package primerNasladjivanjaProdavnicaRacunara.model;


public abstract class ArtikalProdaje {

	protected String sifra;
	protected String naziv;
	protected double cena;
	protected int kolicina;
	protected String opis;
	protected boolean obrisano;

	public ArtikalProdaje() {
		obrisano = false;
	}

	public ArtikalProdaje(String sifra, String naziv, double cena,
			int kolicina, String opis, boolean obrisano) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.cena = cena;
		this.kolicina = kolicina;
		this.opis = opis;
		this.obrisano = obrisano;
	}

	public ArtikalProdaje(ArtikalProdaje original) {
		this.sifra = original.sifra;
		this.naziv = original.naziv;
		this.cena = original.cena;
		this.kolicina = original.kolicina;
		this.opis = original.opis;
		obrisano = false;
	}

	// Za pisanje u fajl
	public String toFile() {
		return sifra + "|" + naziv + "|" + cena + "|" + kolicina + "|" + opis
				+ "|" + obrisano;
	}

	@Override
	public String toString() {
		return "Sifra: " + sifra + "; Naziv: " + naziv + "; Cena: " + cena
				+ "; Kolicina: " + kolicina + "; ("
				+ ((obrisano == false) ? "neobrisan" : "obrisan") + ") ";
	}

	@Override
	public boolean equals(Object obj) {
		boolean isti = false;
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof ArtikalProdaje) {
			ArtikalProdaje objArtikal = (ArtikalProdaje) obj;
			if (this.sifra == objArtikal.sifra)
				return true;
		}
		return isti;

	}

	// getteri i setteri

	public String getSifra() {
		return sifra;
	}

	public double compareCena(ArtikalProdaje o) {
		return this.cena - o.cena;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

}
