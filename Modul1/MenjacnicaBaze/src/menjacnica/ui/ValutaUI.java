package menjacnica.ui;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menjacnica.dao.ValuteDao;
import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;
import menjacnica.utils.PomocnaKlasaDatumi;
import menjacnica.utils.Statistika;

public class ValutaUI {

	public static Valuta pronadji() throws Exception {
		Valuta valuta;
		do {

			System.out.println("unesite oznaku valute: ");
			String oznaka = PomocnaKlasaDatumi.ocitajTekst();

			valuta = ValuteDao.pronadji(oznaka);
		} while (valuta == null);

		return valuta;
	}

	public static void prikazSvih() {

		try {
			List<Valuta> valute = ValuteDao.getAll();

			for (Valuta v : valute)
				System.out.println(v);

		} catch (SQLException e) {
			System.out.println("GRESKA sa bazom");
		} catch (Exception e) {
			System.out.println("GRESKA");

		}

	}

	public static void statistika() {
		try {
			Map<Valuta, Statistika> statValute = new HashMap<Valuta, Statistika>();

			Statistika s = null;
			List<KursnaLista> kursneListe = null; // KursneListeDao.getAll();
			// Collection<Kursnalista> kursneliste = KrsnalistaDao.getAll()

			for (KursnaLista lista : kursneListe) {

				for (VrednostValute vv : lista.getVrednostiValuta()) {

					double srednji = (vv.getKupovniKurs() + vv.getProdajniKurs()) / 2;

					Valuta v = vv.getValuta();
					Date datum = lista.getDatum();
					s = statValute.get(v);
					if (s == null) {
						s = new Statistika(srednji, datum);
						statValute.put(v, s);
					}

					if (srednji < s.getSrednja()) {

						s.setDatum(datum);
						s.setSrednja(srednji);
					}

				}

			}

			List<Valuta> valute = ValuteDao.getAll();

			for (Valuta v : statValute.keySet()) {
				s = statValute.get(v);
				System.out.println(v + " " + s.getDatum() + " " + s.getSrednja());

			}
			for (Valuta v : valute) {

				System.out.println("Valute nema u kursnim listama " + v);
			}

		} catch (Exception e) {
			System.out.println("Greska");
		}

	}

}
