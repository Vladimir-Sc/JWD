package menjacnica.ui;

import menjacnica.dao.VrednostValuteDAO;
import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;
import menjacnica.utils.PomocnaKlasaDatumi;

public class VrednostValuteUI {

	public static void unos(KursnaLista kursnaLista) {
		boolean uspeh = false;
		while (!uspeh) {
			Valuta valuta = ValutaUI.pronadji();

			System.out.println("Unesite kupovni kurs: ");
			double kupovniKurs = PomocnaKlasaDatumi.ocitajRealanBroj();
			System.out.println("Unesite prodajni kurs: ");
			double prodajniKurs = PomocnaKlasaDatumi.ocitajRealanBroj();

			VrednostValute vrednostValute = new VrednostValute(valuta, kursnaLista, kupovniKurs, prodajniKurs);
//			valuta.getVrednostiValuta().add(vrednostValute);
//			kursnaLista.getVrednostiValuta().add(vrednostValute); // azurirati vezu u suprotnom smeru odmah nakon kreiranja veze u jednom smeru 
			try {
				uspeh = VrednostValuteDAO.add(vrednostValute);
				if (!uspeh) {
					System.out.println("Dodavanje neuspensno!");
				}
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");

				ex.printStackTrace();
			}
 		}
	}
	
}
