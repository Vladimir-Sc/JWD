package menjacnica.ui;

import java.sql.Date;

import menjacnica.dao.KursnaListaDao;
import menjacnica.model.KursnaLista;
import menjacnica.utils.PomocnaKlasaDatumi;

public class KursnaListaUI {

	public static void prikaz() {
		System.out.println("Unesi datum kursne liste(dd.MM.yyyy.):");
		Date datum=new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
		try {
			KursnaLista kl=KursnaListaDao.pronadji(datum);
			System.out.println(kl);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Greska prilikom pronalazenja kursne liste");
		}
	}

	public static void unos() {
		try {
		System.out.println("Unesite datum za kursnu listu(dd.MM.yyyy.):");
		Date datum= new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
		int id=KursnaListaDao.slobodanKljuc();
		KursnaLista kl=new KursnaLista(id, datum);
		KursnaListaDao.add(kl);
		VrednostValuteUI.unos(kl);
		}catch (Exception e) {
			System.out.println("Greska prilikom unosa kursne liste");
		}
	}

}
