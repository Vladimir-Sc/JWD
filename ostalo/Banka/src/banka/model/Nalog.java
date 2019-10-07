package banka.model;

import java.sql.Timestamp;

import banka.utils.PomocnaKlasaDatumi;

public class Nalog {

	private long id;
	private Timestamp kreiran;
	private double iznos;
	private Timestamp realizovan;

	private Racun uplatilac;
	private Racun primalac;
	
	public Nalog(long id, Timestamp kreiran, double iznos, Timestamp realizovan, Racun uplatilac, Racun primalac) {
		this.id = id;
		this.kreiran = kreiran;
		this.iznos = iznos;
		this.realizovan = realizovan;
		this.uplatilac = uplatilac;
		this.primalac = primalac;
	}

	public Nalog(Timestamp kreiran, double iznos, Racun uplatilac, Racun primalac) {
		this.kreiran = kreiran;
		this.iznos = iznos;
		this.uplatilac = uplatilac;
		this.primalac = primalac;
	}
	
	@Override
	public String toString() {
		return "Nalog [kreiran=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(kreiran) + ", iznos=" + iznos + ", realizovan=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(realizovan) + ", uplatilac="
				+ uplatilac.getSifra() + ", primalac=" + primalac.getSifra() + "]";
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
		Nalog other = (Nalog) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Timestamp getKreiran() {
		return kreiran;
	}

	public void setKreiran(Timestamp kreiran) {
		this.kreiran = kreiran;
	}

	public double getIznos() {
		return iznos;
	}

	public void setIznos(double iznos) {
		this.iznos = iznos;
	}

	public Timestamp getRealizovan() {
		return realizovan;
	}

	public void setRealizovan(Timestamp realizovan) {
		this.realizovan = realizovan;
	}

	public Racun getUplatilac() {
		return uplatilac;
	}

	public void setUplatilac(Racun uplatilac) {
		this.uplatilac = uplatilac;
	}

	public Racun getPrimalac() {
		return primalac;
	}

	public void setPrimalac(Racun primalac) {
		this.primalac = primalac;
	}

	public long getId() {
		return id;
	}

}
