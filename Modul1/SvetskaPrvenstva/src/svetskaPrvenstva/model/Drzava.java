package svetskaPrvenstva.model;

import java.util.ArrayList;
import java.util.List;

public class Drzava {

	private String naziv;

	private List<SvetskoPrvenstvo> prvenstvaDomacin = new ArrayList<>();
	private List<SvetskoPrvenstvo> prvenstvaOsvajac = new ArrayList<>();

	public Drzava(String naziv) {
		this.naziv = naziv;
	}
	
	public List<SvetskoPrvenstvo> getPrvenstvaDomacin() {
		return prvenstvaDomacin;
	}

	public List<SvetskoPrvenstvo> getPrvenstvaOsvajac() {
		return prvenstvaOsvajac;
	}

	public String getNaziv() {
		return naziv;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naziv == null) ? 0 : naziv.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Drzava [naziv=" + naziv + ", prvenstvaDomacin=" + prvenstvaDomacin + ", prvenstvaOsvajac="
				+ prvenstvaOsvajac + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drzava other = (Drzava) obj;
		if (naziv == null) {
			if (other.naziv != null)
				return false;
		} else if (!naziv.equals(other.naziv))
			return false;
		return true;
	}

	
	
}
