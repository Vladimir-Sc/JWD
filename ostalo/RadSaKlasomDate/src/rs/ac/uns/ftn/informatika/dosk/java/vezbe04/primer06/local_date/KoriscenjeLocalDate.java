package rs.ac.uns.ftn.informatika.dosk.java.vezbe04.primer06.local_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class KoriscenjeLocalDate {
	public static void main(String[] args) {
		LocalDate datum=LocalDate.of(2013, 10, 30);
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy MM dd");
		
		// Kada upisujemo vrednosti u txt fajl formatiramo datum po predvidjenom formatu
		String datumFormatiran=datum.format(formatter);
		System.out.println("Datum formatiran "+datumFormatiran);
		
		try {
			// Kada ucitavamo vrednosti iz txt fajla parsiramo datum
			//  koji mora biti u predvidjenom formatu
			LocalDate parsiranDatum=LocalDate.parse("2014 12 31",formatter);
			System.out.println("Parsiran datum " + parsiranDatum.format(formatter));
		}catch (DateTimeParseException e) {
			// Ako nije moguce parsirati datum
		}
		
		// Poredjenje LocalDate objekata
		LocalDate trenutni=LocalDate.now();
		// Poredimo trenutni datum da li je posle datum kreiranog na pocetku
		boolean posle=trenutni.isAfter(datum);
		System.out.printf("Da li je datum %s posle datuma %s %s \n",trenutni.format(formatter),datum.format(formatter),posle);
		
		// Poredimo trenutni datum da li je posle datum kreiranog na pocetku
		boolean pre=trenutni.isBefore(datum);
	    System.out.printf("Da li je datum %s pre datuma %s %s \n",trenutni.format(formatter),datum.format(formatter),pre);
	    
	    // Poredimo da li su datumi jednaki
	    LocalDate noviObjekat=LocalDate.of(2013, 10, 30);
	    boolean isti=noviObjekat.isEqual(datum);
	    System.out.printf("Da li je datum %s isti kao datum %s %s \n",noviObjekat.format(formatter),datum.format(formatter),isti);
	    
	    // Ako su datimu iz razlicitih kalendara za poredjenje treba da se koristi
	    //  compareTo metoda
	    int compareToVeci=trenutni.compareTo(datum);
	    System.out.printf("CompareTo datum %s sa datumom %s rezultat je %s \n",trenutni.format(formatter),datum.format(formatter),compareToVeci);
	    int compareToManji=datum.compareTo(trenutni);
	    System.out.printf("CompareTo datum %s sa datumom %s rezultat je %s \n",datum.format(formatter),trenutni.format(formatter),compareToManji);
	    int compareToIsti=noviObjekat.compareTo(datum);
	    System.out.printf("CompareTo datum %s sa datumom %s rezultat je %s \n",noviObjekat.format(formatter),datum.format(formatter),compareToIsti);
	    // equals metoda isto koristi compareTo u pozadini
	    //  samo sto rezultat pretvara u boolean vrednost true ili false
	    boolean equalsIstiDatum=noviObjekat.equals(datum);
	    System.out.printf("equals datum %s sa datumom %s rezultat je %s \n",noviObjekat.format(formatter),datum.format(formatter),equalsIstiDatum);
	    
	    System.out.println("\nPromena vrednosti datuma");
	    System.out.println("Originalni datum "+noviObjekat.format(formatter));
	    
	    LocalDate dodanaGodina=noviObjekat.plusYears(2);
	    System.out.println("Dodano 2 godine "+dodanaGodina.format(formatter));
	    
	    LocalDate dodaniMeseci=noviObjekat.plusMonths(14);
	    System.out.println("Dodano 14 meseci "+dodaniMeseci.format(formatter));
	    
	    LocalDate dodaniDani=noviObjekat.plusDays(44);
	    System.out.println("Dodano 44 dana "+dodaniDani.format(formatter));
	    
        LocalDate oduzetaGodina=noviObjekat.minusYears(2);
        System.out.println("Oduzeto 2 godine "+oduzetaGodina.format(formatter));
	    
        LocalDate oduzetiMeseci=noviObjekat.minusMonths(14);
	    System.out.println("Oduzeto 14 meseci "+oduzetiMeseci.format(formatter));
	    
	    LocalDate oduzetiDani=noviObjekat.minusDays(44);
	    System.out.println("Oduzeto 44 dana "+oduzetiDani.format(formatter));
  		
  		// Kreiramo formate za java.util.Date da bi mogli da vidimo konvertovani datum
  		//  formatiranje datuma u tekst
  		System.out.println("\nFormiranje tekstualne reprezentacije datuma");
  		SimpleDateFormat utilDateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //definisanje formata "yyyy-MM-dd HH:mm:ss"
  		try {
  		    // Konvertovanje iz LocalDate u java.util.Date
  	  		Date utilDate=Date.from(noviObjekat.atStartOfDay(ZoneId.systemDefault()).toInstant());
  			String tekstDatum = utilDateFormater.format(utilDate);
  			System.out.println("LocalDate konvertovan u Date");
  	  		System.out.println(tekstDatum);
		} catch (IllegalArgumentException e) {
			// Ako je datum veci ili manji nego sto se moze
			//  sacuvati klasom Date
		}
  		
  		
  		// Konvertovanje iz java.util.Date u LocalDate
  		
  		try {
  			// Prvo parsiramo tekst da dobijemo java.util.Date
  			Date utilDateFromString=utilDateFormater.parse("2019-11-29 16:54");
  			
  			// Konvertujemo java.util.Date u LocalDate
   			LocalDate dateFromUtilDate=utilDateFromString.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
   			System.out.println("Date konvertovan u LocalDate");
   			System.out.println(dateFromUtilDate.format(formatter));
  		} catch (ParseException e) {
  			e.printStackTrace();
  		}
	}
}
