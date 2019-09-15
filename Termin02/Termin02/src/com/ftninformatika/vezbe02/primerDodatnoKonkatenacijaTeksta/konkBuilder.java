package com.ftninformatika.vezbe02.primerDodatnoKonkatenacijaTeksta;

import java.util.Date;

public class konkBuilder {

	public static void main(String[] args) {
		System.out.println("zapoceo");
		System.out.println(new Date());
		StringBuilder build = new StringBuilder();
		for (int i = 0; i < 10000000; i++) { //10 miliona konkatenacija
			build.append(i);
		}
		System.out.println(new Date());
		String spojeniTekst = build.toString(); //vrati Tekst iz String Buildera
//		System.out.println(spojeniTekst); //u konzoli bas i ne moze da se ispise ceo tekst
		System.out.println(spojeniTekst.substring(spojeniTekst.length()-21)); //ispisi zadnjih 20 karaktera
		System.out.println("zavrsio primer String String Builder");

	}

}
