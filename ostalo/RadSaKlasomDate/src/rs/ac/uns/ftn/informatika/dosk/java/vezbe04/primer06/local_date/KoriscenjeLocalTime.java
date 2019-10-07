package rs.ac.uns.ftn.informatika.dosk.java.vezbe04.primer06.local_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class KoriscenjeLocalTime {

	public static void main(String[] args) {
		LocalTime vreme=LocalTime.of(15, 45, 23);
		
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("HH:mm:ss");
		
		// Kada upisujemo vrednosti u txt fajl formatiramo vreme po predvidjenom formatu
		String vremeFormatirano=vreme.format(formatter);
		System.out.println("Vreme formatirano "+vremeFormatirano);
		
		try {
			// Kada ucitavamo vrednosti iz txt fajla parsiramo vreme
			//  koje mora biti u predvidjenom formatu
			LocalTime parsiranoVreme=LocalTime.parse("13:50:54",formatter);
			System.out.println("Parsirano vreme " + parsiranoVreme.format(formatter));
		}catch (DateTimeParseException e) {
			// Ako nije moguce parsirati vreme
		}
		
		// Poredjenje LocalTime objekata
		LocalTime trenutno=LocalTime.now();
		// Poredimo trenutno vreme da li je posle vremena kreiranog na pocetku
		boolean posle=trenutno.isAfter(vreme);
		System.out.printf("Da li je vreme %s posle vremena %s %s \n",trenutno.format(formatter),vreme.format(formatter),posle);
		
		// Poredimo trenutno vreme da li je posle vremena kreiranog na pocetku
		boolean pre=trenutno.isBefore(vreme);
	    System.out.printf("Da li je vreme %s pre vremena %s %s \n",trenutno.format(formatter),vreme.format(formatter),pre);
	    
	    // Poredimo da li su datumi jednaki
	    LocalTime noviObjekat=LocalTime.of(15, 45, 23);
	    boolean isti=noviObjekat.equals(vreme);
	    System.out.printf("Da li je vreme %s isto kao vreme %s %s \n",noviObjekat.format(formatter),vreme.format(formatter),isti);
	    
	    // Ako su vremena iz razlicitih kalendara za poredjenje treba da se koristi
	    //  compareTo metoda
	    int compareToVeci=trenutno.compareTo(vreme);
	    System.out.printf("compareTo vreme %s sa vremenom %s rezultat je %s \n",trenutno.format(formatter),vreme.format(formatter),compareToVeci);
	    int compareToManji=vreme.compareTo(trenutno);
	    System.out.printf("compareTo vreme %s sa vremenom %s rezultat je %s \n",vreme.format(formatter),trenutno.format(formatter),compareToManji);
	    int compareToIsti=noviObjekat.compareTo(vreme);
	    System.out.printf("compareTo vreme %s sa vremenom %s rezultat je %s \n",noviObjekat.format(formatter),vreme.format(formatter),compareToIsti);
	    // equals metoda isto koristi compareTo u pozadini
	    //  samo sto rezultat pretvara u boolean vrednost true ili false
	    boolean equalsIstoVreme=noviObjekat.equals(vreme);
	    System.out.printf("equals vreme %s sa vremenom %s rezultat je %s \n",noviObjekat.format(formatter),vreme.format(formatter),equalsIstoVreme);
	    
	    
	    System.out.println("\nPromena vremena");
        System.out.println("Originalno vreme "+noviObjekat.format(formatter));
	    
	    LocalTime dodaniSati=noviObjekat.plusHours(25);
	    System.out.println("Dodano 25 sati "+dodaniSati.format(formatter));
	    
	    LocalTime dodaniMinuti=noviObjekat.plusMinutes(70);
	    System.out.println("Dodano 70 minuta "+dodaniMinuti.format(formatter));
	    
	    LocalTime dodaneSekunde=noviObjekat.plusSeconds(78);
	    System.out.println("Dodano 78 sekundi "+dodaneSekunde.format(formatter));
	    // moze se pozvati i plusNanos
	    
	    LocalTime oduzetiSati=noviObjekat.minusHours(28);
        System.out.println("Oduzeto 28 sati "+oduzetiSati.format(formatter));
	    
        LocalTime oduzetiMinuti=noviObjekat.minusMinutes(87);
	    System.out.println("Oduzeto 87 minuta "+oduzetiMinuti.format(formatter));
	    
	    LocalTime oduzeteSekunde=noviObjekat.minusSeconds(80);
	    System.out.println("Oduzeto 80 sekundi "+oduzeteSekunde.format(formatter));
	    // moze se pozvati i minusNanos
	    
	    // Kreiramo formate za java.util.Date da bi mogli da vidimo konvertovano vreme
	    // formatiranje datuma u tekst
  		System.out.println("\nFormiranje tekstualne reprezentacije datuma");
  		SimpleDateFormat utilDateFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //definisanje formata "yyyy-MM-dd HH:mm:ss"
  		
	    //Konvertovanje iz LocalTime u java.util.Date
	    try {
	    	Date utilDate=Date.from(noviObjekat.atDate(LocalDate.now()).atZone(ZoneId.systemDefault()).toInstant());
	    	String tekstDatum = utilDateFormater.format(utilDate);
	    	System.out.println("LocalTime konvertovan u Date");
	  		System.out.println(tekstDatum);
	    }catch(IllegalArgumentException e) {
			// Ako je vreme vece ili manje nego sto se moze
			//  sacuvati klasom Date
		}  		
  		
  		try {
  			// Prvo parsiramo tekst da dobijemo java.util.Date
  			Date utilDateFromString=utilDateFormater.parse("2019-11-29 16:54:34");
  			
  			// Konvertujemo java.util.Date u LocalTime
   			LocalTime vremeIzUtilDate=utilDateFromString.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
   			System.out.println("Date konvertovan u LocalTime");
   			System.out.println(vremeIzUtilDate.format(formatter));
  		} catch (ParseException e) {
  			e.printStackTrace();
  		}
	}
}
