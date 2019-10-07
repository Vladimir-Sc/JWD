package banka.model;

import java.util.ArrayList;
import java.util.List;

import banka.utils.PomocnaKlasaDatumi;

public class Racun {

	private long id;
	private String sifra;
	private String vlasnik;
	private double stanje;
	private double raspolozivoStanje;

	private List<Nalog> naloziUplatilac = new ArrayList<>();
	private List<Nalog> naloziPrimalac = new ArrayList<>();

	public Racun(long id, String sifra, String vlasnik, double stanje, double raspolozivoStanje) {
		this.id = id;
		this.sifra = sifra;
		this.vlasnik = vlasnik;
		this.stanje = stanje;
		this.raspolozivoStanje = raspolozivoStanje;
	}

	@Override
	public String toString() {
		StringBuilder racun = new StringBuilder();
		racun.append("Racun [sifra=" + sifra + ", vlasnik=" + vlasnik + ", stanje=" + stanje
				+ ", raspolozivoStanje=" + raspolozivoStanje + "]" + System.lineSeparator());

		for (Nalog itUplata: naloziPrimalac) {
			racun.append("Uplata [kreiran=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itUplata.getKreiran()) + ", iznos=" + itUplata.getIznos() + ", realizovan=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itUplata.getRealizovan()) + ", uplatilac="
					+ itUplata.getUplatilac().getSifra() + "]" + System.lineSeparator());
		}
		for (Nalog itIsplata: naloziUplatilac) {
			racun.append("Isplata [kreiran=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itIsplata.getKreiran()) + ", iznos=" + itIsplata.getIznos() + ", realizovan=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itIsplata.getRealizovan()) + ", primalac="
					+ itIsplata.getPrimalac().getSifra() + "]" + System.lineSeparator());
		}	
		return racun.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Racun other = (Racun) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getVlasnik() {
		return vlasnik;
	}

	public void setVlasnik(String vlasnik) {
		this.vlasnik = vlasnik;
	}

	public double getStanje() {
		return stanje;
	}

	public void setStanje(double stanje) {
		this.stanje = stanje;
	}

	public double getRaspolozivoStanje() {
		return raspolozivoStanje;
	}

	public void setRaspolozivoStanje(double raspolozivoStanje) {
		this.raspolozivoStanje = raspolozivoStanje;
	}

	public long getId() {
		return id;
	}

	public List<Nalog> getNaloziUplatilac() {
		return naloziUplatilac;
	}

	public List<Nalog> getNaloziPrimalac() {
		return naloziPrimalac;
	}

}
