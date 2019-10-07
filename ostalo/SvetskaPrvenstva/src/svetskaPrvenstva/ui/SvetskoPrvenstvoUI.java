package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.SvetskoPrvenstvo;
import svetskaPrvenstva.utility.PomocnaKlasa;
import svetskaPrvenstva.utility.SvetskoPrvenstvoGodinaComparator;
import svetskaPrvenstva.utility.SvetskoPrvenstvoNazivComparator;

public class SvetskoPrvenstvoUI {

	public static Map<Integer, SvetskoPrvenstvo> svaPrvenstva = new LinkedHashMap<>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "prvenstva.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");

				int godina = Integer.parseInt(tokeni[0]);
				String naziv = tokeni[1];
				Drzava domacin = DrzavaUI.getByNaziv(tokeni[2]);
				Drzava osvajac = DrzavaUI.getByNaziv(tokeni[3]);
				SvetskoPrvenstvo prvenstvo = new SvetskoPrvenstvo(godina, naziv, domacin, osvajac);
				svaPrvenstva.put(prvenstvo.getGodina(), prvenstvo);

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
		return svaPrvenstva.get(godina);
	}
	
	public static void prikazSvihPrvenstavaSaDrzavama() {
		for (SvetskoPrvenstvo itPrvenstvo: svaPrvenstva.values()) {
			System.out.println(itPrvenstvo);
		}
	}

	public static void unosPrvenstva() {
		System.out.println("");
		System.out.print("Unesite godinu: ");
		int godina = PomocnaKlasa.ocitajCeoBroj();
		if (svaPrvenstva.containsKey(godina)) {
			System.out.println("Godina ne sme biti ponovljena!");
			return;
		}

		System.out.print("Unesite naziv: ");
		String naziv = PomocnaKlasa.ocitajTekst();

		System.out.print("Unesite naziv drzave domacina: ");
		String nazivDomacina = PomocnaKlasa.ocitajTekst();

		Drzava domacin = DrzavaUI.getByNaziv(nazivDomacina);
		if (domacin == null) {
			System.out.println("Drzava nije pronadjena!");
			return;
		}

		System.out.print("Unesite naziv drzave domacina: ");
		String nazivOsvajaca = PomocnaKlasa.ocitajTekst();

		Drzava osvajac = DrzavaUI.getByNaziv(nazivOsvajaca);
		if (osvajac == null) {
			System.out.println("Drzava nije pronadjena!");
			return;
		}

		SvetskoPrvenstvo prvenstvo = new SvetskoPrvenstvo(godina, naziv, domacin, osvajac);
		svaPrvenstva.put(prvenstvo.getGodina(), prvenstvo);
	}

	public static void izmenaPrvenstva() {
		System.out.println("");
		System.out.print("Unesite godinu: ");
		int godina = PomocnaKlasa.ocitajCeoBroj();

		SvetskoPrvenstvo prvenstvo = svaPrvenstva.get(godina);
		if (prvenstvo == null) {
			System.out.println("Prvenstvo nije pronadjeno!");
			return;
		}

		System.out.print("Unesite naziv: ");
		String naziv = PomocnaKlasa.ocitajTekst();

		System.out.print("Unesite naziv drzave domacina: ");
		String nazivDomacina = PomocnaKlasa.ocitajTekst();

		Drzava domacin = DrzavaUI.getByNaziv(nazivDomacina);
		if (domacin == null) {
			System.out.println("Drzava nije pronadjena!");
			return;
		}

		System.out.print("Unesite naziv drzave domacina: ");
		String nazivOsvajaca = PomocnaKlasa.ocitajTekst();

		Drzava osvajac = DrzavaUI.getByNaziv(nazivOsvajaca);
		if (osvajac == null) {
			System.out.println("Drzava nije pronadjena!");
			return;
		}

		prvenstvo.setNaziv(naziv);
		prvenstvo.setDomacin(domacin);
		prvenstvo.setOsvajac(osvajac);
	}

	public static void sortiranjePrvenstavaPoNazivu() {
		System.out.println();
		System.out.println("Sortiranje...");
		System.out.println("1. sortiranje u rastućem redosledu");
		System.out.println("2. sortiranje u opadajućem redosledu");
		System.out.println("------------------------------------");
		System.out.print("Unesite izbor: ");
		int smer = PomocnaKlasa.ocitajCeoBroj();
		
		List<SvetskoPrvenstvo> sortiranaPrvenstva = new ArrayList<>(svaPrvenstva.values());
		Collections.sort(sortiranaPrvenstva, new SvetskoPrvenstvoNazivComparator(smer == 2? -1: 1));

		for (SvetskoPrvenstvo itPrvenstvo: sortiranaPrvenstva) {
			System.out.println(itPrvenstvo);
		}
	}

	public static void sortiranjePrvenstavaPoGodini() {
		System.out.println();
		System.out.println("Sortiranje...");
		System.out.println("1. sortiranje u rastućem redosledu");
		System.out.println("2. sortiranje u opadajućem redosledu");
		System.out.println("------------------------------------");
		System.out.print("Unesite izbor: ");
		int smer = PomocnaKlasa.ocitajCeoBroj();
		
		List<SvetskoPrvenstvo> sortiranaPrvenstva = new ArrayList<>(svaPrvenstva.values());
		Collections.sort(sortiranaPrvenstva, new SvetskoPrvenstvoGodinaComparator(smer == 2? -1: 1));

		for (SvetskoPrvenstvo itPrvenstvo: sortiranaPrvenstva) {
			System.out.println(itPrvenstvo);
		}
	}

	public static Collection<SvetskoPrvenstvo> prvenstvaUOpseguGodina(int pocetak, int kraj) {
		Collection<SvetskoPrvenstvo> prvenstvaUOpsegu = new ArrayList<>();
		for (SvetskoPrvenstvo itPrvenstvo: svaPrvenstva.values()) {
			int godina = itPrvenstvo.getGodina();
			if (pocetak <= godina && godina <= kraj) {
				prvenstvaUOpsegu.add(itPrvenstvo);
			}
		}

		return prvenstvaUOpsegu;
	}
	
}
