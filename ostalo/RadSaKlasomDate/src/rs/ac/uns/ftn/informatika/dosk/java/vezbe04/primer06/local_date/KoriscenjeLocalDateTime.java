package rs.ac.uns.ftn.informatika.dosk.java.vezbe04.primer06.local_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class KoriscenjeLocalDateTime {

	public static void main(String[] args) {
		LocalDateTime datum=LocalDateTime.of(2011, 11, 30, 13, 30, 50);
		// Ispis datuma po ISO-8601 formatu
		System.out.println(datum.toString());
		
		//formatiranje datuma u tekst
		System.out.println("\nFormiranje tekstualne reprezentacije datuma");
		// Kreiramo format u kojem zelimo da se prikaze trenutni datum
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss");
		
		// Kada upisujemo vrednosti u txt fajl formatiramo vreme po predvidjenom formatu
		String formatiranDatum=datum.format(formatter);
		System.out.println("Formatiran datum "+formatiranDatum);
		
		try {
			// Kada ucitavamo vrednosti iz txt fajla parsiramo datum
			//  koji mora biti u predvidjenom formatu
			LocalDateTime date2=LocalDateTime.parse("2018 11 30 14:23:40", formatter);
			System.out.println("Parsiran datum "+date2.format(formatter));
		}catch (DateTimeParseException e) {
			// Ako nije moguce parsirati datum
		}
		
		// Poredjenje LocalDateTime objekata
		LocalDateTime trenutni=LocalDateTime.now();
		// Poredimo trenutni datum da li je posle datum kreiranog na pocetku
		boolean posle=trenutni.isAfter(datum);
		System.out.printf("Da li je datum %s posle datuma %s %s \n",trenutni.format(formatter),datum.format(formatter),posle);
		
		// Poredimo trenutni datum da li je posle datum kreiranog na pocetku
		boolean pre=trenutni.isBefore(datum);
	    System.out.printf("Da li je datum %s pre datuma %s %s \n",trenutni.format(formatter),datum.format(formatter),pre);
	    
	    // Poredimo da li su datumi jednaki
	    LocalDateTime noviObjekat=LocalDateTime.of(2011, 11, 30, 13, 30, 50);
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
	    
	    System.out.println("\nPromena datuma i vremena");
	    System.out.println("Originalni datum je "+noviObjekat.format(formatter));
	    
		LocalDateTime dodanaGodina=noviObjekat.plusYears(2);
		System.out.println("Dodano 2 godine "+dodanaGodina.format(formatter));
		
		LocalDateTime dodatMesec=noviObjekat.plusMonths(13);
		System.out.println("Dodano 13 meseci "+dodatMesec.format(formatter));
		
		LocalDateTime dodaniDani=noviObjekat.plusDays(40);
		System.out.println("Dodano 40 dana "+dodaniDani.format(formatter));
		
		LocalDateTime dodaniSati=noviObjekat.plusHours(30);
		System.out.println("Dodano 30 sati "+dodaniSati.format(formatter));
		
		LocalDateTime dodaniMinuti=noviObjekat.plusMinutes(70);
		System.out.println("Dodano 70 minuta "+dodaniMinuti.format(formatter));
		// mogu se pozvati i metode plusSeconds plusNanos
		
		LocalDateTime oduzetaGodina=noviObjekat.minusYears(2);
		System.out.println("Oduzeto 2 godine "+oduzetaGodina.format(formatter));
		
		LocalDateTime oduzetMesec=noviObjekat.minusMonths(13);
		System.out.println("Oduzeto 13 meseci "+oduzetMesec.format(formatter));
		
		LocalDateTime oduzetiDani=noviObjekat.minusDays(40);
		System.out.println("Oduzeto 48 dana "+oduzetiDani.format(formatter));
		
		LocalDateTime oduzetiSati=noviObjekat.minusHours(30);
		System.out.println("Oduzeto 30 sati "+oduzetiSati.format(formatter));
		
		LocalDateTime oduzetiMinuti=noviObjekat.minusMinutes(70);
		System.out.println("Oduzeto 70 minuta "+oduzetiMinuti.format(formatter));
	    // mogu se pozivati i metode minusSeconds i minusNanos
		
		// Kreiramo formate za java.util.Date da bi mogli da vidimo konvertovani datum
		//  formatiranje datuma u tekst
		System.out.println("\nFormiranje tekstualne reprezentacije datuma");
		SimpleDateFormat utilDateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm"); //definisanje formata "yyyy-MM-dd HH:mm:ss"
		
		//Konvertovanje iz LocalDateTime u java.util.Date
		try {
			Date utilDate=Date.from(noviObjekat.atZone(ZoneId.systemDefault()).toInstant());
			String tekstDatum = utilDateFormater.format(utilDate);
			System.out.println("LocalDateTime konvertovan u Date");
			System.out.println(tekstDatum);
		}catch(IllegalArgumentException e) {
			// Ako je datum i vreme vece ili manje nego sto se moze
			//  sacuvati klasom Date
		}
		
		// Konvertovanje iz java.util.Date u LocalDateTime
		try {
			// Prvo parsiramo tekst da dobijemo java.util.Date
			Date utilDateFromString=utilDateFormater.parse("2019-11-29 16:54");
			
			// Konvertujemo java.util.Date u LocalDateTime
 			LocalDateTime dateFromUtilDate=utilDateFromString.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
 			System.out.println("Date konvertovan u LocalDateTime");
			System.out.println(dateFromUtilDate.format(formatter));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
