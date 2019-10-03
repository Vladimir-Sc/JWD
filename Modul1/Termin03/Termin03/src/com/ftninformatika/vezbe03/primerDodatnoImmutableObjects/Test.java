package com.ftninformatika.vezbe03.primerDodatnoImmutableObjects;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test {

	public static void main(String[] args) {
		
		Calendar calendar =GregorianCalendar.getInstance();
		calendar.set(Calendar.ERA,GregorianCalendar.BC);
		calendar.set(Calendar.YEAR, 45000000);
		Date datum = calendar.getTime();
		DateFormat df = new SimpleDateFormat("yyyy GG");
		System.out.println(df.format(datum));
		
		Planeta zemlja = new Planeta(5.972 * Math.pow(10, 24), "Zemlja", datum);
		System.out.println(zemlja.toString());
		
		//izmene objekta datum iz maina i datum iz objketa zemlja nemaju iticaja
		//jer smo napravili da je klasa Planeta immutable
		datum.setYear(200);
		Date datum2 = zemlja.getDateOfDiscovery();
		datum2.setYear(200);
		
		System.out.println(zemlja.toString());

	}

}
