package hotel.model;

import java.sql.Timestamp;

import hotel.utils.PomocnaKlasaDatumi;

public class Rezervacija {

	private long id;
	private Timestamp ulazak;
	private Timestamp izlazak;
	private String gost;

	private Soba soba;

	public Rezervacija(long id, Timestamp ulazak, Timestamp izlazak, String gost, Soba soba) {
		this.id = id;
		this.ulazak = ulazak;
		this.izlazak = izlazak;
		this.gost = gost;
		this.soba = soba;
	}

	public int getNocenja() {
		return (int) Math.ceil((izlazak.getTime() - ulazak.getTime())/1000.0/60.0/60.0/60.0/24.0);
	}
	
	public double getVrednost() {
		return getNocenja()*soba.getCenaNocenja();
	}
	
	@Override
	public String toString() {
		return "Rezervacija [id=" + id + ", ulazak=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(ulazak) + ", izlazak=" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(izlazak) + ", gost=" + gost + ", soba="
				+ soba.getId() + ", vrednost=" + getVrednost() + "]";
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
		Rezervacija other = (Rezervacija) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Timestamp getUlazak() {
		return ulazak;
	}

	public void setUlazak(Timestamp ulazak) {
		this.ulazak = ulazak;
	}

	public Timestamp getIzlazak() {
		return izlazak;
	}

	public void setIzlazak(Timestamp izlazak) {
		this.izlazak = izlazak;
	}

	public String getGost() {
		return gost;
	}

	public void setGost(String gost) {
		this.gost = gost;
	}

	public Soba getSoba() {
		return soba;
	}

	public void setSoba(Soba soba) {
		this.soba = soba;
	}

	public long getId() {
		return id;
	}

}
