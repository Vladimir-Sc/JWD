package primerNasladjivanjaProdavnicaRacunara.model;

import primerNasladjivanjaProdavnicaRacunara.ProdavnicaRacunara;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class MemorijaRacunara extends Komponenta {
	
	protected String kapacitet;

	public MemorijaRacunara() {
		super();
	}

	public MemorijaRacunara(String sifra, String naziv, double cena, int kolicina,
			String opis, boolean obrisano, KategorijeKomponenti kategorija,
			String kapacitet) {
		super(sifra, naziv, cena, kolicina, opis, obrisano, kategorija);
		this.kapacitet = kapacitet;
	}
	
	
	public MemorijaRacunara(String tekst){
		super();
		String tokeni[] = tekst.split("\\|");
//		sifra | naziv | cena | kolicina | opis | obrisano | kategorija | kapacitet
//		 0       1       2        3			4 		5			6		7
		if(tokeni.length != 8){
			System.out.println("Greska u ocitavanju memorija");
		}
		
		
		if(Utility.isDouble(tokeni[2])){
			cena = Double.parseDouble(tokeni[2]);
		}
		if(Utility.isInteger(tokeni[3])){
			kolicina = Integer.parseInt(tokeni[3]);
		}
		if(Utility.isBoolean(tokeni[5])){
			obrisano = Boolean.parseBoolean(tokeni[5]);
		}
		
		
		sifra = tokeni[0];
		naziv = tokeni[1];
		opis = tokeni[4];
		kategorija = ProdavnicaRacunara.pronadjiKatPoSifri(tokeni[6]);
		this.kapacitet = tokeni[7];
		
	}
	@Override
	public String toString(){
		String retVal = super.toString();
		return "Memorija: "+retVal+" ;Kapacitet: "+kapacitet;
	}
	@Override
	public String toFile(){
		String retVal = super.toFile();
		return retVal+"|"+kapacitet;
	}
		
	
	public String getKapacitet() {
		return kapacitet;
	}

	public void setKapacitet(String kapacitet) {
		this.kapacitet = kapacitet;
	}

}
