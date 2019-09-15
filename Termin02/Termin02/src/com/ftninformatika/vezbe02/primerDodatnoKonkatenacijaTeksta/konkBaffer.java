package com.ftninformatika.vezbe02.primerDodatnoKonkatenacijaTeksta;

import java.util.Date;

public class konkBaffer {

	public static void main(String[] args) {

		System.out.println("zapoceo");
		System.out.println(new Date());
		StringBuffer buf = new StringBuffer("Pocetni tekst ");
		for (int i = 0; i < 10000000; i++) {//10 miliona konkatenacija
			buf.append(i);
		}
		System.out.println(new Date());
		String spojeniTekst = buf.toString(); //vrati Tekst iz String Buffera
//		System.out.println(spojeniTekst); //u konzoli bas i ne moze da se ispise ceo tekst
		System.out.println(spojeniTekst.substring(spojeniTekst.length()-21)); //ispisi zadnjih 20 karaktera
		System.out.println("zavrsio primer String Buffer");
	}

}
