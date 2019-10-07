package menjacnica.ui;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menjacnica.dao.KursnaListaDao;
import menjacnica.dao.ValutaDao;
import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;
import menjacnica.utils.PomocnaKlasaDatumi;
import menjacnica.utils.Statistika;

public class ValutaUI {

	public static Valuta pronadji() throws Exception{
		Valuta valuta;
		do {
			System.out.println("Unesite oznaku valute:");
			String oznaka=PomocnaKlasaDatumi.ocitajTekst();
			
			valuta =ValutaDao.pronadji(oznaka);
		}while(valuta==null);
		return valuta;
	}
	
	public static void prikazSvih() {
		try {
			List<Valuta> valute= ValutaDao.getAll();
			for(Valuta v:valute)
				System.out.println(v);
		}catch (SQLException e) {
			System.out.println("Greska sa bazom");
		}catch(Exception e) {
			System.out.println("Greska prilikom dobijanja vrednosti");
		}
	}

	public static void statistika() {
		try {
			System.out.println("Unesite datum od za kursnu listu(dd.MM.yyyy.):");
			Date datumOd= new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
			System.out.println("Unesite datum do za kursnu listu(dd.MM.yyyy.):");
			Date datumDo= new Date(PomocnaKlasaDatumi.ocitajDatum().getTime());
			Map<Valuta,Statistika> statValute=new HashMap<Valuta, Statistika>();
			Statistika s=null;
			Collection<KursnaLista> kursneListe=KursnaListaDao.getAll();
			for(KursnaLista lista:kursneListe)
			{
				if(lista.getDatum().after(datumOd)&&lista.getDatum().before(datumDo))
					for(VrednostValute vv:lista.getVrednostiValuta()) {
						double srednji=
						(vv.getKupovniKurs()+vv.getProdajniKurs())/2;
						
						Valuta v=vv.getValuta();
						Date datum=lista.getDatum();
						/*
						 * Da bi ova provera dobro radila,
						 * mora se u klasi Valuta redefinisati
						 * i hashCode i equals metoda, jer kad se
						 * ucitavaju kursne liste kreiramo samo jednu
						 * kursnu listu, ali imamo duplikate valuta.
						 */
						s=statValute.get(v);
						if(s==null)
						{
							s=new Statistika(srednji,datum);
							statValute.put(v, s);
						}else
						
							if(srednji<s.getSrednja())
							{
								s.setDatum(datum);
								s.setSrednja(srednji);
							}
					}
			}
			List<Valuta> valute= ValutaDao.getAll();
			
			for(Valuta v:statValute.keySet()) {
				valute.remove(valute.indexOf(v));
				s=statValute.get(v);
				System.out.println(v+" "+s.getDatum()+" "+s.getSrednja());
			}
			for(Valuta v:valute)
			{
				System.out.println("Valute nema u kursnim listama "+v);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Greska prilikom izracunavanja statistike");
		}
				
	}
	
}
