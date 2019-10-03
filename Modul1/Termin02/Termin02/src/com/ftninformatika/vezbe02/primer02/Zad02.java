package com.ftninformatika.vezbe02.primer02;

public class Zad02 {

	//izracunavanje kvadrata hipotrenuze pravouglog trougla
	//ulazni parametri su duzine kateta a i b
	static double vrednostHipotenuzePravouglogTrougla(double a, double b){
		double c = 0;
		c = Math.sqrt(a*a + b*b);
		return c;
	}
	
	//ne mogu se razlikovati samo po povratnom tipu
//	static String vrednostHipotenuzePravouglogTrougla(double a, double b){
//		double c = 0;
//		c = Math.sqrt(a*a + b*b);
//		return Double.toString(c);
//	}
	
	//izracunavanje kvadrata hipotrenuze pravouglog trougla, koji ima katete istih velicina
	//ulazni parametri je duzina katete a
	static double vrednostHipotenuzePravouglogTrougla(double a){
		double c = 0;
		c = Math.sqrt(a*a + a*a);
		
		return c;		
//		a = 5;
	}
	
	//izmena vrednosti ulaznih parametara
	static void izmenaVrednostiUlaznihParametara(int sF, int [] MF){

		sF += -100;
		System.out.println("\t\t izmenjena vrednost promenljive sF u funkciji je "+ sF);
		if(MF != null){
			MF[0] += -200;
			System.out.println("\t\t izmenjena vrednost promenljive MF[0] u funkciji je "+ MF[0]);
		}
//		MF= new int [100]; //
	}
	
	public static void main(String[] args){
		
		double vrednost = 0;
		vrednost = vrednostHipotenuzePravouglogTrougla(3, 4);
		System.out.println("Vrednost hipotenuze je:"+vrednost);
		
		vrednost = vrednostHipotenuzePravouglogTrougla(3);
		System.out.println("Vrednost hipotenuze je:"+vrednost+"\n\n");
		
		int s = 3;
		int[] M = new int [2];
		M[0]=10;
		System.out.println("vrednost promenljive s je "+ s);
		System.out.println("vrednost promenljive M[0] je "+ M[0]);
		//promenljiva vrednosti primenljivih unutar fukcije 
		//ukoliko su promenljive primitivni tipovi ili reference na objekte
		izmenaVrednostiUlaznihParametara(s, M);
		System.out.println("vrednost promenljive s je "+ s);
		System.out.println("vrednost promenljive M[0] je "+ M[0] + " velicina " + M.length);	
	}
}
