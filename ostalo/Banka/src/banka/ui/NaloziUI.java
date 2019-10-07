package banka.ui;

import java.sql.Timestamp;
import java.util.List;

import banka.dao.NaloziDAO;
import banka.model.Nalog;
import banka.model.Racun;
import banka.utils.PomocnaKlasaDatumi;

public class NaloziUI {

	public static void dodavanje() {
		System.out.println();
		System.out.println("Unos uplatioca...");
		Racun uplatilac = RacuniUI.pronadji();
		if (uplatilac == null) {
			return;
		}
		System.out.println();
		System.out.println("Unos primaoca...");
		Racun primalac = RacuniUI.pronadji();
		if (primalac == null) {
			return;
		}
		System.out.print("Unesite iznos: ");
		double iznos = PomocnaKlasaDatumi.ocitajRealanBroj();

		Timestamp kreiran = new Timestamp(new java.util.Date().getTime());

		if (uplatilac.getRaspolozivoStanje() < iznos) {
			System.out.println("Nema dovoljno sredstava na racunu uplatioca!");
			return;
		}

		Nalog nalog = new Nalog(kreiran, iznos, uplatilac, primalac);
		uplatilac.setRaspolozivoStanje(uplatilac.getRaspolozivoStanje() - iznos);
		primalac.setRaspolozivoStanje(primalac.getRaspolozivoStanje() + iznos);
		try {
			NaloziDAO.add(nalog);
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void prikazSvih() {
		try {
			List<Nalog> nalozi = NaloziDAO.getAll();

			System.out.println();
			for (Nalog itNalog: nalozi) {
				System.out.println(itNalog);
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");
			ex.printStackTrace();
		}
	}

	public static void tabelarniPrikaz() {
		try {
			List<Nalog> nalozi = NaloziDAO.getAll();

			System.out.println();
			System.out.println(String.format("%-17s %-10s %-17s %-10s %-10s", 
					"kreiran", 
					"iznos", 
					"realizovan", 
					"uplatilac", 
					"primalac"));
			System.out.println("================= ========== ================= ========== ==========");
			for (Nalog itNalog: nalozi) {
				System.out.println(String.format("%-17s %-10s %-17s %-10s %-10s", 
						PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itNalog.getKreiran()), 
						itNalog.getIznos(), 
						PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itNalog.getRealizovan()), 
						itNalog.getUplatilac().getSifra(), 
						itNalog.getPrimalac().getSifra()));
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");
			ex.printStackTrace();
		}
	}

	public static void realizacija() {
		System.out.println();
		System.out.println("Realizacija...");
		try {
			NaloziDAO.realizacija(new Timestamp(new java.util.Date().getTime()));

			System.out.println("Realizacija uspesna!");
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

}
