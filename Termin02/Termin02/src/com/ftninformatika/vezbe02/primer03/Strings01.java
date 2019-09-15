package com.ftninformatika.vezbe02.primer03;

public class Strings01 {
	
	public static void izmeni(String a){
		a+="Pera";
//		a="Pera";
	}
	
	public static void main(String[] args) {
		
		//Definisanje promenljive tipa string	
		String a 	= "ovo je tekst";
		String a1	= "OvO JE TeKsT";
		String a2   = new String("OvO JE TeKsT");
						
		//Provera da li su stringovi sadrze isti niz karaktera
		if(a == "ovo je tekst")
			System.out.println("1. String promenljive a i \"ovo je tekst\" su sli\u010Dni");
		else
			System.out.println("1. String promenljive a i \"ovo je tekst\" NISU sli\u010Dni");
		
		if(a1 == a2)
			System.out.println("2. Stringovi promenljiva a1 i a2 su sli\u010Dni sa ==");
		else
			System.out.println("2. Stringovi promenljiva a1 i a2 NISU sli\u010Dni sa ==");

		if(a1.equals(a2))
			System.out.println("3. Stringovi promenljiva a1 i a2 su sli\u010Dni");
		else
			System.out.println("3. Stringovi promenljiva a1 i a2 NISU sli\u010Dni");
						
		if(a.equalsIgnoreCase(a1))
			System.out.println("4. Stringovi promenljiva a i a1 su sli\u010Dni zanemarivsi velika i mala slova");
		else
			System.out.println("4. Stringovi promenljiva a i a1 NISU sli\u010Dni zanemarivsi velika i mala slova");
		
		//prebacivanje velikih u mala slova
		System.out.println("OvO JE TeKsT".toLowerCase());
		
		//podstring
		System.out.println("ovo je tekst".substring(5));
		
		//Provera da li string a zapoceinje sa karakterima iz stringa a1
		if("ovo je tekst".startsWith("ovo je"))
			System.out.println("5. Zapo\u010Dinje");
		else
			System.out.println("5. NE Zapo\u010Dinje");
		
		//Provera da li string a sadrzi rec
		if("ovo je tekst".contains("tekst"))
			System.out.println("6. Sadr\u017Ei re\u010D");
		else
			System.out.println("6. NE Sadr\u017Ei re\u010D");
				
		//leksikografsko poredjenje stringova
		String name = "Aca";
		String name1 = "Ana";
		int broj = name.compareTo(name1);
		if(broj>0)		//razlika pozicija c i n 
			System.out.println("posle, jer je " + broj);
		else if(broj<0)
			System.out.println("pre, jer je " + broj);
		else
			System.out.println("isti, jer je " + broj);
		
		izmeni(name);
		//String je Immutable Objects
		//Immutable Objects je objekat kome se definiše vrednost u trenutku njegovog kreiranja
		//Ne postoje metode, ni na�?ini kako da se ta vrednost promeni
		System.out.println("Izmenjena vrednost " + name);
	}

}
