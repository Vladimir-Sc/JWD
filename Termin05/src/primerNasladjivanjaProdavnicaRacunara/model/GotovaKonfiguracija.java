package primerNasladjivanjaProdavnicaRacunara.model;

import java.util.ArrayList;

import primerNasladjivanjaProdavnicaRacunara.ProdavnicaRacunara;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class GotovaKonfiguracija extends ArtikalProdaje {

	public ArrayList<Komponenta> listaKomponenti;

	public GotovaKonfiguracija() {
	}

	public GotovaKonfiguracija(String sifra, String naziv, double cena,
			int kolicina, String opis, boolean obrisano,
			ArrayList<Komponenta> listeKomponent) {
		super(sifra, naziv, cena, kolicina, opis, obrisano);
		this.listaKomponenti = listeKomponent;
	}

	public GotovaKonfiguracija(String tekst) {
		String[] tokeni = tekst.split("\\|");

		// sifra|naziv|cena|kolicina|opis|obrisano|kompsifra;kompsifra;|
		// 0 1 2 3 4 5 6

		if (tokeni.length != 7) {
			System.out.println("Greska u ocitavanju gotove konfiguracije");
		}

		this.sifra = tokeni[0];
		this.naziv = tokeni[1];
		this.opis = tokeni[4];

		if (Utility.isDouble(tokeni[2])) {
			this.cena = Double.parseDouble(tokeni[2]);
		}
		if (Utility.isInteger(tokeni[3])) {
			this.kolicina = Integer.parseInt(tokeni[3]);
		}
		if (Utility.isBoolean(tokeni[5])) {
			this.obrisano = Boolean.parseBoolean(tokeni[5]);
		}
		this.listaKomponenti = new ArrayList<Komponenta>();
		Komponenta komp = null;
		String[] sifreKomponenti = tokeni[6].split("\\;");
		for (int i = 0; i < sifreKomponenti.length; i++) {
			komp = ProdavnicaRacunara
					.proveraPostojanjaKomponente(sifreKomponenti[i]);
			if (komp == null) {
				System.out
						.println("Greska pri ocitavanju komponenti - Komponenta ne postoji");
				System.exit(0);
			}
			listaKomponenti.add(komp);
		}
	}

	@Override
	public String toFile() {
		// sifra + "|" + naziv + "|" + cena + "|" + kolicina + "|" + opis
		// + "|" + obrisano + "|" + sifra;sifra2;sifra3;
		String retVal = super.toFile();
		String k = "";
		for (int i = 0; i < listaKomponenti.size(); i++) {
			Komponenta komp = listaKomponenti.get(i);
			if (komp == null) {
				System.out.println("neko je kreten");
			}
			k += komp.getSifra() + ";";

		}
		return retVal + "|" + k;
	}

	@Override
	public String toString() {
		String nazivi = "";
		for (Komponenta komp : listaKomponenti) {
			nazivi += komp.getNaziv()+", ";
		}
		String retVal = super.toString();
		return "Gotova konfiguracija: " + retVal + "Komponente: "
				+ nazivi;
	}

	public ArrayList<Komponenta> getListeKomponenti() {
		return listaKomponenti;
	}

	public void setListeKomponenti(ArrayList<Komponenta> listeKomponenti) {
		this.listaKomponenti = listeKomponenti;
	}

}
