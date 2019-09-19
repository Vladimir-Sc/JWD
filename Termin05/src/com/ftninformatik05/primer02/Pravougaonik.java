package com.ftninformatik05.primer02;

public class Pravougaonik extends Figura{

	private double a;
	private double b;
	
	
	@Override
	public double izracunajPovrsinu() {
		double povrsina = a*b;
		return povrsina;
	}

	@Override
	public double izracunajObim() {
		double obim = 2*(a+b);
		return obim;
	}

}
