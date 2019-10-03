package com.ftninformatika.vezbe02.primer04;

public class WraperKlasePrimitivnihTipova {
	
	public static void izmeni(Integer a){
		a+=10;
//		a=10;
	}
	
	public static void main(String[] args) {
		System.out.println("Za svaki primitivni tip postoji i odgovaraju\u0107a Wrapper klasa");
		
		Integer intObjVrednost = new Integer(10);
		System.out.println("Vrednost Wrapper objekta je " + intObjVrednost);
		
		Double b = new Double(13.3);
		Boolean c = new Boolean(true);
		
		//parsiranje teksta u vrednosti primitivnih tipova
		double pi = Double.parseDouble("3.14");
		System.out.println("vrednost pi je "+pi);
		//moramo biti obazrivi jer može doći do greške
//		int i = Integer.parseInt("3.14");
		
		//automatski boxing i unboxing
		int primitivniTip = new Integer(20); //unboxing
		Integer objekatWraperKlase = 30; //boxing
		
		izmeni(objekatWraperKlase);
		//Wraperi primitivnih tipova su Immutable Objects
		System.out.println("Izmenjena vrednost " + objekatWraperKlase);
	}

}
