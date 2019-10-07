package hotel.model;

import java.util.ArrayList;
import java.util.List;

public class Soba {

	private int id;
	private String tip;
	private int brojKreveta;
	private double cenaNocenja;

	private List<Rezervacija> rezervacije = new ArrayList<>();

	public Soba(int id, String tip, int brojKreveta, double cenaNocenja) {
		this.id = id;
		this.tip = tip;
		this.brojKreveta = brojKreveta;
		this.cenaNocenja = cenaNocenja;
	}
	
	@Override
	public String toString() {
		return "Soba [id=" + id + ", tip=" + tip + ", brojKreveta=" + brojKreveta + ", cenaNocenja=" + cenaNocenja
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Soba other = (Soba) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getBrojKreveta() {
		return brojKreveta;
	}

	public void setBrojKreveta(int brojKreveta) {
		this.brojKreveta = brojKreveta;
	}

	public double getCenaNocenja() {
		return cenaNocenja;
	}

	public void setCenaNocenja(double cenaNocenja) {
		this.cenaNocenja = cenaNocenja;
	}

	public int getId() {
		return id;
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

}
