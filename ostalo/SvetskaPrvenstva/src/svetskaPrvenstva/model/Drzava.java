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

	@Override
	public String toString() {
		return "Drzava [naziv=" + naziv + "]";
	}

	public String getNaziv() {
		return naziv;
	}

	public List<SvetskoPrvenstvo> getPrvenstvaDomacin() {
		return prvenstvaDomacin;
	}

	public List<SvetskoPrvenstvo> getPrvenstvaOsvajac() {
		return prvenstvaOsvajac;
	}

}
