package com.ftninformatika.vezbe02.primerDodatnoKonkatenacijaTeksta;

import java.util.Date;

public class konkString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("zapoceo");
		System.out.println(new Date());
		String tekst = "";
		for (int i = 0; i < 100000; i++) {
			tekst=tekst+i;
		}
		System.out.println(new Date());
		System.out.println("zavrsio konkString");
	}

}
