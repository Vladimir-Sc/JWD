package menjacnica.ui;

import java.sql.Date;

import menjacnica.dao.KursnaListaDAO;
import menjacnica.model.KursnaLista;
import menjacnica.utils.PomocnaKlasaDatumi;

public class KursnaListaUI {

	public static void prikaz() {
		System.out.println("Unesite datum kursne liste (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
		Date datum = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());

		try {
			KursnaLista kursnaLista = KursnaListaDAO.get(datum);
			System.out.println(kursnaLista);
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void unos() {
		boolean uspeh = false;
		while (!uspeh) {
			System.out.println("Unesite datum kursne liste (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
			Date datum = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());

			KursnaLista kursnaLista = new KursnaLista(0, datum); // nije poznat ID. Baza ce ga generisati
			try {
				uspeh = KursnaListaDAO.add(kursnaLista);
				if (uspeh) {
					kursnaLista = KursnaListaDAO.get(datum); // citanje iz baze, radi dobavljanja ID-a, odnosno povezivanja
					while (PomocnaKlasaDatumi.ocitajOdlukuOPotvrdi("Da li zelite da dodate vrednost valute?") != 'N') {
						VrednostValuteUI.unos(kursnaLista);
					}
				} else {
					System.out.println("Dodavanje neuspesno!");
				}
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}
	}

}
