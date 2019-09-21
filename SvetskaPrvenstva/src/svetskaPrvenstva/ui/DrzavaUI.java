package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import svetskaPrvenstva.model.Drzava;

public class DrzavaUI {
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "drzave.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");

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
		return null;
	}
	
	public static void prikazSvihDrzava() {

	}

	public static void statistika() {
		
	}
	
}
