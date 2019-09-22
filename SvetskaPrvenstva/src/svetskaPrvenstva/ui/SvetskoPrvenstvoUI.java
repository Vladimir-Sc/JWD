package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import svetskaPrvenstva.model.SvetskoPrvenstvo;

public class SvetskoPrvenstvoUI {
	
	private static Map<Integer, SvetskoPrvenstvo> prvenstva = new HashMap<Integer, SvetskoPrvenstvo>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "prvenstva.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");
				
				int godina = Integer.parseInt(tokeni[1]);
				Drzava domacin = DrzavaUI.getByNaziv(tokeni[3]);
				Drzava osvajac = DrzavaUI.getByNaziv(tokeni[2]);
				
				new SvetskoPrvenstvo(godina, tokeni[0], osvajac, domacin);
				
				linija = in.readLine();
			}
			in.close();
		} catch (Exception ex) {
			System.out.println("Greska u ucitavanju prvenstava!");
		} finally {
			try {in.close();} catch (Exception ex) {}
		}
	}

	public static SvetskoPrvenstvo getByGodina(int godina) {
		return null;
	}
	
	public static void prikazSvihPrvenstavaSaDrzavama() {
		
	}

	public static void unosPrvenstva() {
		
	}

	public static void izmenaPrvenstva() {
		
	}

	public static void sortiranjePrvenstavaPoNazivu() {
		
	}

	public static void sortiranjePrvenstavaPoGodini() {
		
	}

}
