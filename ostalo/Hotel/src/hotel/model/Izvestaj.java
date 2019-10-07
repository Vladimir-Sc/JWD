package hotel.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Izvestaj {

	private Map<String, Podizvestaj> podizvestaji = new LinkedHashMap<>();

	public Izvestaj() {
		podizvestaji.put("studio", new Podizvestaj("studio"));
		podizvestaji.put("suite", new Podizvestaj("suite"));
		podizvestaji.put("family room", new Podizvestaj("family room"));
		podizvestaji.put("interconnected rooms", new Podizvestaj("interconnected rooms"));
	}
	
	public void add(Rezervacija rezervacija) {
		podizvestaji.get(rezervacija.getSoba().getTip()).add(rezervacija);
	}

	public double trosak() {
		double trosak = 0.0;
		for (Podizvestaj itPodizvestaj: podizvestaji.values()) {
			trosak += itPodizvestaj.getTrosak();
		}
		return trosak;
	}
	
	@Override
	public String toString() {
		StringBuilder izvestaj = new StringBuilder();
		for (Podizvestaj itPodizvestaj: podizvestaji.values()) {
			izvestaj.append(itPodizvestaj + System.lineSeparator());
		}
		return izvestaj.toString();
	}

}
