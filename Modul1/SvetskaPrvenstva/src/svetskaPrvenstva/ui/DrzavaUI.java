package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import svetskaPrvenstva.model.Drzava;

public class DrzavaUI {

	private static Map<String, Drzava> sveDrzave = new LinkedHashMap<>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "drzave.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");
				String naziv = tokeni[0];

				Drzava drzava = new Drzava(naziv);
				sveDrzave.put(drzava.getNaziv(), drzava);

				linija = in.readLine();
			}
			in.close();
		} catch (Exception ex) {
			System.out.println("Greska u ucitavanju drzava!");
		} finally {
			try {in.close();} catch (Exception ex) {}
		}
	}

	public static Drzava getByNaziv(String naziv) {
		return sveDrzave.get(naziv);
	}
	
	public static void prikazSvihDrzava() {
		for (Drzava itDrzava: sveDrzave.values()) {
			System.out.println(itDrzava);
		}
	}

	public static void statistika() {
		
	}
	
}
