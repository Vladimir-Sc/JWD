package com.ftninformatika.vezbe01.primer05;

public class DebugPrimer {
	
	public static int metoda1(int a, int b) {
		
		metoda2(10);
		
		int c = a + b;
		return c;
	}
	
	public static int metoda2(int x) {
		
		int [] niz = { 0, 1, 2};
		
		return niz[x];
	}
	
	public int metoda3(int x) {
		
		int [] niz = { 0, 1, 2};
		
		return niz[x];
	}
	
	public static void main(String args[]) {
		int a = 8;
		int b = ++a;
		
		double c = b/2; 
		double rez = -1;
		if (c > 4) {
			rez = 10;
		} else {
			rez = 20;
		}
		
		metoda1(a, b);
//		metoda2(0);
		
//		metoda3(0);
//		DebugPrimer deb = new DebugPrimer();
//		deb.metoda3(0);
		
		System.out.println(rez);
	}
}
