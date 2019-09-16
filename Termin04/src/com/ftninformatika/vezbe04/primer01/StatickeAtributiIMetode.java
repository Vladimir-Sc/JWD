package com.ftninformatika.vezbe04.primer01;



public class StatickeAtributiIMetode {
	
	int c = 0;
	
	//staticki atribut koji se moze menjati
	public static int indexCounter = 1;
	public static int stat = 1;
	//staticki atribut koji se ne moze menjati, ovo je zapravo konstanta
	//obicno se konstante pisu velikim slovima
	public static final String INDEX_LETTER = "e"; 
	
	public StatickeAtributiIMetode() { stat=3; }

	public static void statickaMetoda(){
		System.out.println("poziv staticke funkcije");
	}
	
	static {
		System.out.println("ABC");
		indexCounter = 2;
		stat=2;
//		c=2; //zabranjeno
		statickaMetoda();
		int a = 10;//nema smisla jer je a lokalna promenljiva koja postoji samo u statickom bloku
	}
}
