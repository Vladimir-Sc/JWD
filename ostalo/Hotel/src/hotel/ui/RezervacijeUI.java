package hotel.ui;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import hotel.dao.RezervacijeDAO;
import hotel.model.Izvestaj;
import hotel.model.Rezervacija;
import hotel.utils.PomocnaKlasaDatumi;

public class RezervacijeUI {

	public static Rezervacija pronadji() {
		System.out.println();
		System.out.print("Unesite ID: ");
		long id = PomocnaKlasaDatumi.ocitajLong();

		try {
			Rezervacija rezervacija = RezervacijeDAO.get(id);
			if (rezervacija == null) {
				System.out.println("Rezervacija nije pronadjena!");
			}

			return rezervacija;
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		return null;
	}
	
	public static void prikazSvih() {
		System.out.println();
		System.out.print("Uneiste pocetak (" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.toPattern() + "): ");
		Timestamp pocetak = new Timestamp(PomocnaKlasaDatumi.ocitajDatumVreme().getTime());
		System.out.print("Uneiste kraj (" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.toPattern() + "): ");
		Timestamp kraj = new Timestamp(PomocnaKlasaDatumi.ocitajDatumVreme().getTime());

		try {
			List<Rezervacija> rezervacije = RezervacijeDAO.getAll(pocetak, kraj);

			System.out.println();
			for (Rezervacija itRezervacija: rezervacije) {
				System.out.println(itRezervacija);
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void izmena() {
		Rezervacija rezervacija = pronadji();
		if (rezervacija == null) {
			return;
		}

		System.out.print("Uneiste ulazak (" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.toPattern() + "): ");
		Timestamp ulazak = new Timestamp(PomocnaKlasaDatumi.ocitajDatumVreme().getTime());
		System.out.print("Uneiste izlazak (" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.toPattern() + "): ");
		Timestamp izlazak = new Timestamp(PomocnaKlasaDatumi.ocitajDatumVreme().getTime());
		if (izlazak.before(ulazak)) {
			System.out.println("Izlazak mora biti nakon ulaska!");
			return;
		}

		try {
			List<Rezervacija> rezervacije = RezervacijeDAO.getAll(ulazak, izlazak);
			for (Rezervacija itRezervacija: rezervacije) {
				if (!itRezervacija.equals(rezervacija) && itRezervacija.getSoba().equals(rezervacija.getSoba())) {
					System.out.println();
					System.out.println("Soba je zauzeta u tom periodu!");
					System.out.println(itRezervacija);
					return;
				}
			}

			rezervacija.setUlazak(ulazak);
			rezervacija.setIzlazak(izlazak);
			RezervacijeDAO.update(rezervacija);
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void tabelarniPrikaz() {
		System.out.println();
		System.out.print("Uneiste pocetak (" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.toPattern() + "): ");
		Timestamp pocetak = new Timestamp(PomocnaKlasaDatumi.ocitajDatumVreme().getTime());
		System.out.print("Uneiste kraj (" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.toPattern() + "): ");
		Timestamp kraj = new Timestamp(PomocnaKlasaDatumi.ocitajDatumVreme().getTime());

		try {
			List<Rezervacija> rezervacije = RezervacijeDAO.getAll(pocetak, kraj);

			System.out.println();
			System.out.println(String.format("%-5s %-17s %-17s %-30s %-5s", 
					"ID", 
					"ulazak", 
					"izlazak", 
					"gost", 
					"soba", 
					"vrednost"));
			System.out.println("===== ================= ================= ============================== =====");
			for (Rezervacija itRezervacija: rezervacije) {
				System.out.println(String.format("%-5s %-17s %-17s %-30s %-5s", 
						itRezervacija.getId(), 
						PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itRezervacija.getUlazak()), 
						PomocnaKlasaDatumi.DATE_TIME_FORMAT.format(itRezervacija.getIzlazak()), 
						itRezervacija.getGost(), 
						itRezervacija.getSoba().getId()));
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void izvestaj() {
		try {
			List<Rezervacija> rezervacije = RezervacijeDAO.getAll();

			Map<String, Izvestaj> izvestaji = new LinkedHashMap<>();
			for (Rezervacija itRezervacija: rezervacije) {
				Izvestaj izvestaj = izvestaji.get(itRezervacija.getGost());
				if (izvestaj == null) {
					izvestaj = new Izvestaj();
					izvestaji.put(itRezervacija.getGost(), izvestaj);
				}

				izvestaj.add(itRezervacija);
			}

			System.out.println();
			for (Entry<String, Izvestaj> itPar: izvestaji.entrySet()) {
				System.out.println(itPar.getKey() + ", trosak: " + itPar.getValue().trosak());
				System.out.println(itPar.getValue());
			}	
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

}
