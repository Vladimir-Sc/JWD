package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import svetskaPrvenstva.model.Drzava;

public class DrzavaUI {
	
	private static Map<String, Drzava> drzave = new HashMap<String, Drzava>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "drzave.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");
				
				drzave.put(tokeni[0], new Drzava(tokeni[0]);
				
				// new Drzava();
				
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
		
		return drzave.get(naziv);
	}
	
	public static void prikazSvihDrzava() {

		for(Drzava d: drzave.values()) {
			System.out.println(d.getNaziv);
		}
		
	}

	public static void statistika() {
		
	}
	
}
