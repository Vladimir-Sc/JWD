package autobuskastanica;

import java.util.ArrayList;

public class Peron {

	private int redBrPerona;
	private AutobuskaStanica au;
	private ArrayList<Dogadjaj> dogadjaji = new ArrayList<Dogadjaj>();

	public Peron(int redBrPerona, AutobuskaStanica au, ArrayList<Dogadjaj> dogadjaji) {
		this.redBrPerona = redBrPerona;
		this.au = au;
		this.dogadjaji = dogadjaji;
	}

	@Override
	public String toString() {
		return "Peron " + redBrPerona;
	}

	public String toStringSaDogadjajima() {
		StringBuilder sb = new StringBuilder("Na peronu " + redBrPerona + " raspored je:");
		for (int i = 0; i < dogadjaji.size(); i++) {
			sb.append("\t\t" + (i + 1) + ". " + dogadjaji.get(i).toString() + "\n");
		}
		return super.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((au == null) ? 0 : au.hashCode());
		result = prime * result + redBrPerona;
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
		Peron other = (Peron) obj;
		if (au == null) {
			if (other.au != null)
				return false;
		} else if (!au.equals(other.au))
			return false;
		if (redBrPerona != other.redBrPerona)
			return false;
		return true;
	}

	public int getRedBrPerona() {
		return redBrPerona;
	}

	public void setRedBrPerona(int redBrPerona) {
		this.redBrPerona = redBrPerona;
	}

	public AutobuskaStanica getAu() {
		return au;
	}

	public void setAu(AutobuskaStanica au) {
		this.au = au;
	}

	public ArrayList<Dogadjaj> getDogadjaji() {
		return dogadjaji;
	}

	public void setDogadjaji(ArrayList<Dogadjaj> dogadjaji) {
		this.dogadjaji = dogadjaji;
	}

}
