package menjacnica.ui;

import menjacnica.dao.VrednostValuteDao;
import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;
import menjacnica.utils.PomocnaKlasaDatumi;

public class VrednostValuteUI {

	public static void unos(KursnaLista kursnaLista) throws Exception{
		char odluka;
		do {
		System.out.println("unesite kupovni kurs: ");
		double kupovni = PomocnaKlasaDatumi.ocitajRealanBroj();
		System.out.println("unesite prodajni kurs: ");
		double prodajni = PomocnaKlasaDatumi.ocitajRealanBroj();
		
		Valuta v = ValutaUI.pronadji();
		
		VrednostValute vv = new VrednostValute (v, kursnaLista, kupovni, prodajni );
		
		VrednostValuteDao.add(vv);
		
		System.out.println("da li zelite novu vrednost valute: ");
		 odluka = PomocnaKlasaDatumi.ocitajOdlukuOPotvrdi("novu vrednost valute");
	}while (odluka == 'Y');
	
	}
	
}
