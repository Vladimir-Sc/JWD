package rs.ac.uns.ftn.informatika.dosk.java.vezbe04.primer05.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class OperacijeSaDatumima {

	public static void main(String[] args) {
		
		//poredjenje datuma
		System.out.println("\nPoredjenje datuma");
		Date date = new Date();
		Date date2 = new GregorianCalendar(2012, 0, 14).getTime();
		if(date.after(date2)){
			System.out.println("Datum1 posle datuma2");
		}
		
		date = new GregorianCalendar(2012, 1, 14).getTime();
		date2 = new GregorianCalendar(2012, 1, 14).getTime(); 
		if(date.compareTo(date)==0){
			System.out.println("Isti datumi");
		}
		
		SimpleDateFormat formatter = null;
		
		//formatiranje datuma u tekst
		System.out.println("\nFormiranje tekstualne reprezentacije datuma");
		formatter = new SimpleDateFormat("yyyy-MM-dd"); //definisanje formata "yyyy-MM-dd HH:mm:ss"
		String tekstDatum = formatter.format(date);
		System.out.println(tekstDatum);
		
		//rekonstrukcija datuma iz teksta
		System.out.println("\nRekonstrukcija datuma iz teksta");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter.parse("2014-02-08"); //zgodno za citanje iz fajla
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//unos datuma preko tastature
		System.out.println("Unesite datum u obliku godina-mesec-dan");
		formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter.parse(Utility.ocitajTekst());
			System.out.println(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
