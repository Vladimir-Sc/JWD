package com.ftninformatik05.primer02;

import com.ftninformatik05.primer01.Tacka2D;

public class Zad02 {

	public static void main(String[] args) {

		Krug kr = new Krug(new Tacka2D(0, 0), 3);
		
		System.out.println("Povrsina kruga je " + kr.izracunajPovrsinu());
		System.out.println("Obim kruga je " + kr.izracunajObim());
		System.out.println(kr.toString());
		
		Figura fig; //neka greska ovde 
		
		//apstraktna klasa ne moze se instancirati
		/*
		fig = new Figura(); 
		System.out.println("-----------");
		System.out.println("Povrsina figure je " + fig.izracunajPovrsinu());
		System.out.println(fig.toString());
		System.out.println("-----------");
		 */
		
		/*
		Pravougaonik pra = new Pravougaonik(new Tacka2D(0, 0),new Tacka2D(5, 5));
		System.out.println("Povrsina pravougaonika je " + pra.izracunajPovrsinu());
		System.out.println("Obim pravougaonika je " + pra.izracunajObim());
		System.out.println(pra.toString());
		*/
		
		System.out.print("Program izvrsen");
	}

}
