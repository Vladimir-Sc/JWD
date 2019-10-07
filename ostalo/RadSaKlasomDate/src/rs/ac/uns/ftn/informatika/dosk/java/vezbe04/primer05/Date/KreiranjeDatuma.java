package rs.ac.uns.ftn.informatika.dosk.java.vezbe04.primer05.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class KreiranjeDatuma {

	public static void main(String[] args) {
		
		System.out.printf("%4$10s %3$5s %2$10s %1$5s", "a", "b", "c", "d");
		
		Date date = null;
		
		//pribavljanje aktuelnog datuma i vremena
		System.out.println("\nPribavljanje aktuelnog datuma i vremena");
		date = new Date();
		System.out.println(date);	//Mon Feb 09 15:19:42 CET 2015
		
		/*Date
		year - the year minus 1900.
		month - the month between 0-11.
		date - the day of the month between 1-31.
		hrs - the hours between 0-23.
		min - the minutes between 0-59.
		sec - the seconds between 0-59 */
		
		//zastarelo setovanje vrednosti
		System.out.println("\nSetovanje vrednosti datuma");
		date.setYear(120);
		System.out.println(date);
		System.out.println(date.getYear());
			
		//ovako se vise ne radi, zastarelo je
		//mogu se postaviuti pojedine vrednosti ali samo preko klase Calendar i GregorianCalendar
		System.out.println("\nKreiranje proizvoljnog datuma preko konstruktora Date");
		Date date2 = new Date(110, 01, 15); 
		System.out.println(date2);
		
		System.out.println("\nKreiranje proizvoljnog datuma preko kalendara");
		date2 = new GregorianCalendar(2012, 0, 14).getTime();
		System.out.println(date2);
		
		//ispis datuma
		System.out.println("\nFormatizovan ispis datuma");
		System.out.print("Moj datum:");
		
		System.out.printf("%1$4tY-%1$2tm-%1$2td\n", date);
		
		//t oznacava date/time
		//tY oznacava godinu od podatka date/time
		//tm i te oznacava mesec od podatka date/time
		//td oznacava dan od podatka date/time
	}
}
