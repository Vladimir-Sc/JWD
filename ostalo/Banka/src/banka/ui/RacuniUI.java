package banka.ui;

import java.sql.Date;
import java.util.List;

import banka.dao.RacuniDAO;
import banka.model.Nalog;
import banka.model.Racun;
import banka.utils.PomocnaKlasaDatumi;

public class RacuniUI {

	public static Racun pronadji() {
		System.out.println();
		System.out.print("Unesite sifru: ");
		String sifra = PomocnaKlasaDatumi.ocitajTekst();

		try {
			Racun racun = RacuniDAO.get(sifra);
			if (racun == null) {
				System.out.println("Racun nije pronadjen!");
			}

			return racun;
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		return null;
	}
	
	public static void prikazSvih() {
		try {
			List<Racun> racuni = RacuniDAO.getAll();
			for (Racun itRacun: racuni) {
				System.out.println(itRacun);
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");
			
			ex.printStackTrace();
		}
	}

	public static void izvestaj() {
		System.out.println();
		System.out.print("Unesite sifru: ");
		String sifra = PomocnaKlasaDatumi.ocitajTekst();	
		System.out.print("Unesite pocetak (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
		Date pocetak = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
		System.out.print("Unesite pocetak (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
		Date kraj = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());

		try {
			Racun racun = RacuniDAO.get(sifra, pocetak, kraj);
			if (racun == null) {
				System.out.println("Racun nije pronadjen!");
				return;
			}

			double prihodi = 0;
			for (Nalog itNalog: racun.getNaloziPrimalac()) {
				prihodi += itNalog.getIznos();
			}
			double rashodi = 0;
			for (Nalog itNalog: racun.getNaloziUplatilac()) {
				rashodi += itNalog.getIznos();
			}
			System.out.println();
			System.out.println(racun);
			System.out.println("Prihodi: " + prihodi);
			System.out.println("Rashodi: " + rashodi);
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");
			
			ex.printStackTrace();
		}
	}

}
