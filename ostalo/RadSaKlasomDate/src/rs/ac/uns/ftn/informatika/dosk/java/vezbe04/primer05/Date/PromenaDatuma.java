package rs.ac.uns.ftn.informatika.dosk.java.vezbe04.primer05.Date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PromenaDatuma {

	public static void ispisiDatum(String tekst,SimpleDateFormat formatter, Date date) {
		String formatedDate = formatter.format(date);
		System.out.printf("%-22s %s \n",tekst,formatedDate);
	}
	
	public static void main(String[] args) {
		// Kreiramo SimpleDateFormat da bi uvek imali isti format datuma prikazan
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		// Datum mozemo da menjamo koristeci GregorianCalendar objekat 
		//  i potrebno je da kreiramo novi objekat za datum koji zelimo da menjamo
		GregorianCalendar calendar=new GregorianCalendar(2014, 1, 14);
		
		ispisiDatum("Originalni datum", formatter, calendar.getTime());
		
		// Dodajemo dve godine na originalni datum
		calendar.add(Calendar.YEAR, 2);
		
		ispisiDatum("Povecan za 2 godine", formatter, calendar.getTime());
		
		// Dodajemo 13 meseci na prethodno povecan datum, menja se i vrednost za godinu
        calendar.add(Calendar.MONTH, 13);
		
        ispisiDatum("Povecan za 13 meseci", formatter, calendar.getTime());
		
        // Dodajemo 40 dana na prethodno povecan datum, menja se i vrednost za mesec
        calendar.add(Calendar.DAY_OF_MONTH, 40);
		
        ispisiDatum("Povecan za 40 dana", formatter, calendar.getTime());
		
        // Dodajemo 40 sati na prethodno izmenjen datumm, menja se i vrednost za dan
        calendar.add(Calendar.HOUR_OF_DAY, 40);
		
        ispisiDatum("Povecan za 40 sati", formatter, calendar.getTime());
		
        // Dodajemo 75 minuta na prethodno izmenjen datumm, menja se i vrednost za sate
        calendar.add(Calendar.MINUTE, 75);
		
        ispisiDatum("Povecan za 75 minuta", formatter, calendar.getTime());
		
        // Dodajemo 84 sekunde na prethodno izmenjen datumm, menja se i vrednost za minute
        calendar.add(Calendar.SECOND, 84);
		
        ispisiDatum("Povecan za 84 sekundi", formatter, calendar.getTime());
        
        // Ista add metoda se moze koristiti i za smanjivanje vrednosti datuma
        //  tako sto se prosledi negativno vrednost, ali nije sigurno da ce
        //  rezultat uvek biti odgovarajuci datum
	}
}
