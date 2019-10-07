package svetskaPrvenstva.utility;

import java.util.Comparator;

import svetskaPrvenstva.model.SvetskoPrvenstvo;

public class SvetskoPrvenstvoNazivComparator implements Comparator<SvetskoPrvenstvo> {

	private int smer = 1;

	public SvetskoPrvenstvoNazivComparator(int smer) {
		this.smer = smer;
	}

	@Override
	public int compare(SvetskoPrvenstvo prvenstvo1, SvetskoPrvenstvo prvenstvo2) {
		int rezultat = prvenstvo1.getNaziv().compareTo(prvenstvo2.getNaziv());
		return rezultat*smer;
	}

}
