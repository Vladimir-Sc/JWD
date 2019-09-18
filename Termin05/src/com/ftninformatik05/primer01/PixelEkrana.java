package com.ftninformatik05.primer01;

public class PixelEkrana extends Tacka2D{

	protected String color;
	
	/*
	public PixelEkrana() {
//		super();
		
	}
	*/
	
	public PixelEkrana(double x, double y, String color) {
		super(x, y);
		this.color = color;
	}

	@Override
	public void ispisNaEkran() {
		System.out.println("Ispis piksela ekrana boje " + color + 
				" na kordinati (" + x + "," + y + ")");
//		super.ispisNaEkran();
	}

	public void nekaFunkcija(){
		System.out.println("pozvana");
//		super.ispisNaEkran();
//		super.funkcija();
//		funkcija();
	}
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
