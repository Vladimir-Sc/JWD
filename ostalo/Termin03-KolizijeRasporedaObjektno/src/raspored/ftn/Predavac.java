package raspored.ftn;

public class Predavac {

	private String ime;
	private String prezime;
	
	public Predavac(String ime, String prezime) {
		this.ime = ime;
		this.prezime = prezime;
	}

	
	
	@Override
	public String toString() {
		return ime + " " + prezime;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Predavac other = (Predavac) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	
}
