package primerNasladjivanjaProdavnicaRacunara.model;

import primerNasladjivanjaProdavnicaRacunara.ProdavnicaRacunara;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class Procesor extends Komponenta {

	protected double radniTakt;
	protected int brojJezgara;

	public Procesor() {
	}

	public Procesor(String sifra, String naziv, double cena, int kolicina,
			String opis, boolean obrisano, KategorijeKomponenti kategorija,
			double radniTakt, int brojJezgara) {
		super(sifra, naziv, cena, kolicina, opis, obrisano, kategorija);
		this.radniTakt = radniTakt;
		this.brojJezgara = brojJezgara;
	}

	public Procesor(String tekst) {
		super();
		String tokeni[] = tekst.split("\\|");

		if (tokeni.length != 9) {
			System.out.println("Greska u ocitavanju memorija");
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
		if (Utility.isDouble(tokeni[7])) {
			radniTakt = Double.parseDouble(tokeni[7]);
		}
		if (Utility.isInteger(tokeni[8])) {
			brojJezgara = Integer.parseInt(tokeni[8]);
		}
		sifra = tokeni[0];
		naziv = tokeni[1];
		opis = tokeni[4];
		kategorija = ProdavnicaRacunara.pronadjiKatPoSifri(tokeni[6]);

	}
	@Override
	public String toString(){
		String retVal = super.toString();
		return "Procesor: "+retVal+" ;Radni takt: "+radniTakt+" ;Broj jezgara: "+brojJezgara;
	}
	@Override
	public String toFile(){
		String retVal = super.toFile();
		return retVal+"|"+radniTakt+"|"+brojJezgara;
	}

	public double getRadniTakt() {
		return radniTakt;
	}

	public void setRadniTakt(double radniTakt) {
		this.radniTakt = radniTakt;
	}

	public int getBrojJezgara() {
		return brojJezgara;
	}

	public void setBrojJezgara(int brojJezgara) {
		this.brojJezgara = brojJezgara;
	}

}
