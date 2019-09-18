package primerNasladjivanjaProdavnicaRacunara.model;

import primerNasladjivanjaProdavnicaRacunara.ProdavnicaRacunara;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class Komponenta extends ArtikalProdaje {
	
	protected KategorijeKomponenti kategorija;

	public Komponenta() {
		super();
	}

	public Komponenta(String sifra, String naziv, double cena, int kolicina,
			String opis, boolean obrisano, KategorijeKomponenti kategorija) {
		super(sifra, naziv, cena, kolicina, opis, obrisano);
		this.kategorija = kategorija;
	}

	public Komponenta(Komponenta original) {
		super(original);
		this.kategorija = original.kategorija;
	}

	public Komponenta(String tekst) {
		super();
		String[] tokeni = tekst.split("\\|");
		if (tokeni.length != 7) {
			System.out.println("Greska pri ocitavanju komponenti");
			return;
		}

		if (Utility.isDouble(tokeni[2])) {
			cena = Double.parseDouble(tokeni[2]);
		}
		if (Utility.isInteger(tokeni[3])) {
			kolicina = Integer.parseInt(tokeni[3]);
		}
		if (Utility.isBoolean(tokeni[5])) {
			obrisano = Boolean.parseBoolean(tokeni[5]);
		}
		sifra = tokeni[0];
		naziv = tokeni[1];
		opis = tokeni[4];
		kategorija = ProdavnicaRacunara.pronadjiKatPoSifri(tokeni[6]);
	}

	public String toFile() {
		String retVal = sifra + "|" + naziv + "|" + cena + "|" + kolicina + "|"
				+ opis + "|" + obrisano + "|" + kategorija.getSifra();
		return retVal;
	}


	
	@Override
	public String toString(){
		String retVal = super.toString();
		return retVal+ "Kategorija: "+ kategorija.getSifra();
		
	}

	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public KategorijeKomponenti getKategorija() {
		return kategorija;
	}

	public void setKategorija(KategorijeKomponenti kategorija) {
		this.kategorija = kategorija;
	}
}
