package com.ftninformatik05.primer02;

import com.ftninformatik05.primer01.Tacka2D;

public class Pravougaonik extends Figura{

//	private double a;
//	private double b;
	Tacka2D prva, druga;
	
	public Pravougaonik(Tacka2D prva, Tacka2D druga) {
		super();
		this.prva = prva;
		this.druga = druga;
	}

	@Override
	public double izracunajPovrsinu() {
		double a = druga.getX() - prva.getX();
		double b = druga.getY() - prva.getY();
		
		return a*b;
	}

	@Override
	public double izracunajObim() {
		double a = druga.getX() - prva.getX();
		double b = druga.getY() - prva.getY();
		return 2*(a+b);
	}

}
