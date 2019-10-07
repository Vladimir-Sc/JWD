package svetskaPrvenstva.utility;

import java.util.Comparator;

import svetskaPrvenstva.model.SvetskoPrvenstvo;

public class SvetskoPrvenstvoGodinaComparator implements Comparator<SvetskoPrvenstvo> {

	private int smer = 1;

	public SvetskoPrvenstvoGodinaComparator(int smer) {
		this.smer = smer;
	}

	@Override
	public int compare(SvetskoPrvenstvo prvenstvo1, SvetskoPrvenstvo prvenstvo2) {
		int rezultat = Integer.compare(prvenstvo1.getGodina(), prvenstvo2.getGodina());
		return rezultat*smer;
	}

}
