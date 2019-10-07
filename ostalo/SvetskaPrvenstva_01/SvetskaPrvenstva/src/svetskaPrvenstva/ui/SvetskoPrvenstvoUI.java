package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.SvetskoPrvenstvo;

public class SvetskoPrvenstvoUI {

	private static Map<Integer, SvetskoPrvenstvo> svaPrvenstva = new LinkedHashMap<>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "prvenstva.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");
				String naziv = tokeni[0];
				int godina = Integer.parseInt(tokeni[1]);
				String nazivDomacina = tokeni[2];
				String nazivOsvajaca = tokeni[3];

				Drzava domacin = DrzavaUI.getByNaziv(nazivDomacina);
				Drzava osvajac = DrzavaUI.getByNaziv(nazivOsvajaca);
				SvetskoPrvenstvo prvenstvo = new SvetskoPrvenstvo(naziv, godina, domacin, osvajac);
				svaPrvenstva.put(prvenstvo.getGodina(), prvenstvo);

				domacin.getPrvenstvaDomacin().add(prvenstvo);
				osvajac.getPrvenstvaOsvajac().add(prvenstvo);
				
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
		for (SvetskoPrvenstvo itPrvenstvo: svaPrvenstva.values()) {
			System.out.println(itPrvenstvo);
		}
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
