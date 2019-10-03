package com.ftninformatika.vezbe03.primer03;



public class ModifikatoriPristupa {
	
	//modifikatori pristupa, sta koji znaci?
	public 		String atribut1;
	protected 	String atribut2;
				String atribut3;
	private 	String atribut4;
	
	public void publicMogucPoziv(){
		System.out.println("public moguc poziv AAAAAAAA");
	}
	
	protected void protectedMogucPoziv(){
		System.out.println("protected moguc poziv BBBBBBBB");
	}
	
	private void privateNemogucPoziv(){
		System.out.println("private nemoguc poziv CCCCCCCC");
	}
	
	public void publicMetodaUmetodi(){
		System.out.println("Poziv unutar metode:");
		privateNemogucPoziv();
	}
	
	//TODO POSTAVI SET i GET metode za ostale atribute
}
