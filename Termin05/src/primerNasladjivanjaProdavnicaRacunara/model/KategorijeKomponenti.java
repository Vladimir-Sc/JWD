package primerNasladjivanjaProdavnicaRacunara.model;

import primerNasladjivanjaProdavnicaRacunara.ProdavnicaRacunara;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class KategorijeKomponenti {

	protected String sifra;
	public String naziv;
	protected String opis;
	protected KategorijeKomponenti nadKategorija;
	protected boolean obrisano;

	public KategorijeKomponenti() {
		obrisano = false;
	}

	public KategorijeKomponenti(String sifra, String naziv, String opis,
			KategorijeKomponenti nadKategorija, boolean obrisano) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.opis = opis;
		this.nadKategorija = nadKategorija;
		this.obrisano = obrisano;
	}

	// citanje iz fajla
	public KategorijeKomponenti(String tekst) {
		String tokeni[] = tekst.split("\\|");
//		sifra|naziv|opis|nadkategorija|obrisano
//		 0 		1     2			3			4
		if (tokeni.length != 5) {
			System.out.println("Greska, pogresan format " + tekst);
		}

		if (Utility.isBoolean(tokeni[4])) {
			obrisano = Boolean.parseBoolean(tokeni[4]);
		}

		else {
			System.out.println("Greska format u fajlu nije dobar");
		}
		sifra = tokeni[0];
		naziv = tokeni[1];
		opis = tokeni[2];
		nadKategorija = ProdavnicaRacunara.pronadjiKatPoSifri(tokeni[3]);
		// asistenta.

	}
//	funkcija da vraca kategoriju unosom sifre

	// pisanje u fajl!
	public String toFile() {
		if (nadKategorija == null){
		return sifra + "|" + naziv + "|" + opis + "|" + null + "|"
				+ obrisano;}
		return sifra + "|" + naziv + "|" + opis + "|" + nadKategorija.getSifra() + "|"
		+ obrisano;
	}

	@Override
	public boolean equals(Object obj) {
		boolean isti = false;

		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (obj instanceof KategorijeKomponenti) {
			KategorijeKomponenti objKateg = (KategorijeKomponenti) obj;
			if (this.sifra == objKateg.sifra)
				return true;
		}
		return isti;
	}

	@Override
	public String toString() {
		return naziv;
	}

	public String getSifra() {
		return sifra;
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

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public KategorijeKomponenti getNadKategorija() {
		return nadKategorija;
	}

	public void setNadKategorija(KategorijeKomponenti nadKategorija) {
		this.nadKategorija = nadKategorija;
	}

	public boolean isObrisano() {
		return obrisano;
	}

	public void setObrisano(boolean obrisano) {
		this.obrisano = obrisano;
	}

}
