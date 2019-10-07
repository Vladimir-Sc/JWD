package menjacnica.ui;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

import menjacnica.dao.KursnaListaDAO;
import menjacnica.dao.ValutaDAO;
import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;
import menjacnica.utils.PomocnaKlasaDatumi;

public class ValutaUI {

	public static Valuta pronadji() {
		Valuta valuta = null;
		while (valuta == null) {
			System.out.println("Unesite oznaku valute: ");
			String oznaka = PomocnaKlasaDatumi.ocitajTekst();
			try {
				valuta = ValutaDAO.get(oznaka);
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
		}

		return valuta;
	}
	
	public static void prikazSvih() {
		try {
			List<Valuta> valute = ValutaDAO.getAll();
			for (Valuta itValuta: valute) {
				System.out.println(itValuta);
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void statistika() {
		System.out.println("Unesite početak perioda: ");
		Date pocetak = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
		System.out.println("Unesite kraj perioda: ");
		Date kraj = new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());

		try {
			List<Valuta> valute = ValutaDAO.getAll();
			Collection<KursnaLista> kursneListe = KursnaListaDAO.getAll();
			for (Valuta itValuta: valute) {
				double minVrednost = Double.MAX_VALUE;
				Date minDatum = null;
				for (KursnaLista itKursnaLista: kursneListe) {
					Date datum = itKursnaLista.getDatum();
					if (datum.after(pocetak) && datum.before(kraj)) {
						for (VrednostValute itVrednostValute: itKursnaLista.getVrednostiValuta()) {
							if (itVrednostValute.getValuta().equals(itValuta)) {
								double srednjiKurs = itVrednostValute.getSrednjiKurs();
								if (srednjiKurs < minVrednost) {
									minVrednost = srednjiKurs;
									minDatum = datum;
								}
								break;
							}
						}
					}
				}
				System.out.print(itValuta);
				if (minVrednost < Double.MAX_VALUE) {
					System.out.println(", datum: " + PomocnaKlasaDatumi.DATE_FORMAT.format(minDatum) + ", min. vrednost: " + minVrednost);
				} else {
					System.out.println("Nema podataka!");
				}
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}
	
}
