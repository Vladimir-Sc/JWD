package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.SvetskoPrvenstvo;
import svetskaPrvenstva.utility.PomocnaKlasa;

public class DrzavaUI {

	private static Map<String, Drzava> sveDrzave = new LinkedHashMap<>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "drzave.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");

				Drzava drzava = new Drzava(tokeni[0]);
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
		System.out.println();
		System.out.print("Unesite pocetnu godinu: ");
		int pocetak = PomocnaKlasa.ocitajCeoBroj();
		System.out.print("Unesite krajnju godinu: ");
		int kraj = PomocnaKlasa.ocitajCeoBroj();	

		Collection<SvetskoPrvenstvo> prvenstvaUOpsegu = SvetskoPrvenstvoUI.prvenstvaUOpseguGodina(pocetak, kraj);

		Map<Drzava, Integer> domacini = new HashMap<>();
		Map<Drzava, Integer> osvajaci = new HashMap<>();
		for (SvetskoPrvenstvo itPrvenstvo: prvenstvaUOpsegu) {
			Drzava domacin = itPrvenstvo.getDomacin();
			Drzava osvajac = itPrvenstvo.getOsvajac();

			Integer brojPrvenstavaDomacin = domacini.get(domacin);
			if (brojPrvenstavaDomacin == null) {
				brojPrvenstavaDomacin = 0;
			}
			domacini.put(domacin, brojPrvenstavaDomacin + 1);

			Integer brojPrvenstavaOsvajac = osvajaci.get(osvajac);
			if (brojPrvenstavaOsvajac == null) {
				brojPrvenstavaOsvajac = 0;
			}
			osvajaci.put(osvajac, brojPrvenstavaOsvajac + 1);
		}
		
		System.out.println();
		System.out.println("----------------------------------------");
		System.out.println(String.format("%-10s %-10s %-10s %-10s", "R. br.", "Drzava", "Domacin", "Osvajac"));
		System.out.println("----------------------------------------");

		int redniBroj = 1;
		for (Drzava itDrzava: sveDrzave.values()) {
			Integer domacin = domacini.get(itDrzava);
			if (domacin == null) {
				domacin = 0;
			}
			Integer osvajac = osvajaci.get(itDrzava);
			if (osvajac == null) {
				osvajac = 0;
			}
			System.out.println(String.format("%-10d %-10s %-10s %-10s", redniBroj, itDrzava.getNaziv(), domacin > 0? domacin: "", osvajac > 0? osvajac: ""));

			redniBroj++;
		}
	}
	
}
