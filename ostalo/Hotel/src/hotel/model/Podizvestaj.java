package hotel.model;

public class Podizvestaj {

	private String tip;
	private int brojNocenja = 0;
	private double trosak = 0.0;

	public Podizvestaj(String tip) {
		this.tip = tip;
	}

	public void add(Rezervacija rezervacija) {
		brojNocenja += rezervacija.getNocenja();
		trosak += rezervacija.getVrednost();
	}
	
	@Override
	public String toString() {
		return "[tip=" + tip + ", brojNocenja=" + brojNocenja + ", trosak=" + trosak + "]";
	}

	public String getTip() {
		return tip;
	}

	public int getBrojNocenja() {
		return brojNocenja;
	}

	public double getTrosak() {
		return trosak;
	}
	
}
