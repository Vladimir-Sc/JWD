package domaci;


public class Test {

	public static void main(String[] args) throws Exception {
		Prodavnica.ocitajPodatkeIzFajla();
		
		System.out.println("Rad sa proizvodima");
		Artikl ar = null;
		int odluka = -1;
		while(odluka !=0){
			Prodavnica.ispisiPocetniTekst();
			System.out.print("Opcije: ");
			odluka =Utility.ocitajCeoBroj();
			
			switch (odluka) {
			case 0:
				System.out.println("Izlaz iz programa!!!");
				break;
			case 1:
				//unos podataka o novom proizvodu
				Prodavnica.unosNovogArtikla();
				break;
			case 2:
				//izmena podataka o proizvodu
				Prodavnica.izmenaArtikla();
				break;
			case 3:
				Prodavnica.ispisiSveArtikle();
				break;
			case 4:
				//Opcija broj 4 - ispis podataka o odredenom proizvodu sa njegovim cenama
				ar = Prodavnica.pronadjiArtikal();
				if(ar!=null)
					System.out.println(ar.toStringDetail());
				break;
			case 5:
				//Opcija broj 5 - ispis podataka o proizvodima na akciji
				Prodavnica.ispisiSveArtikleNaAkciji();
				break;
			case 6:
				//Opcija broj 6 - ispis podataka o proizvodima odredjenog proizvodjaca
				Prodavnica.ispisiSveArtikleOdProizvodjaca();
				break;
			default: 
				System.out.println("Nepostojoca komanda!!!");
				break;
			}
		}
		
		Prodavnica.sacuvaPodatkeUFajl();
		System.out.print("Program izvrsen");
	}
}
