package Apoteka;

public class NarudzbenicaStavka {

	protected Narudzbenica nar;
	protected Lek naruceniLek;
	protected double cenaLekaOdDobavljaca;
	protected int kolicina;
	
	public NarudzbenicaStavka() {
		super();
	}

	public NarudzbenicaStavka(Narudzbenica nar, Lek naruceniLek, double cenaLekaOdDobavljaca,
			int kolicina) {
		super();
		this.nar = nar;
		this.naruceniLek = naruceniLek;
		this.cenaLekaOdDobavljaca = cenaLekaOdDobavljaca;
		this.kolicina = kolicina;
	}
	
	/**
	 * NAPOMENA!!!!!!!!!!
	 	Lekovi moraju da su vec ucitani
	 */
	public NarudzbenicaStavka(String red) {
		String[] tokeni = red.split(",");
		//trazenje reference na Lek
		//id narudzbenice, id leka, cena, kolicina 
		//0					1		2		3	
		//001,004,333.00,5
		
		nar = Test.pronadjiNarudzbenicu(tokeni[0]);
		naruceniLek = Test.pronadjiLek(tokeni[1]);
		cenaLekaOdDobavljaca = Double.parseDouble(tokeni[2]);
		kolicina = Integer.parseInt(tokeni[3]);
		
		//KLJUČNI KORAK POVEZIVANJE NarudzbenicaStavka sa Narudzbenica
		//TJ. DODAVANJE STAVKI NARUDŽBENICE U NARUDŽBENICU
		
		nar.getStavke().add(this);
		naruceniLek.stavkeNarudzbenice.add(this);
		
		//NA TAJ ISTI NAČIN BI POVEZALI I
		//OČITANU ISPITNU PRIJAVU SA VEĆ POTOJEĆIM ISPITNIM ROKOM
		//OČITANU ISPITNU PRIJAVU SA VEĆ POTOJEĆIM STUDENTOM
		
	}
	
	public String toFileRepresentation(){
		return naruceniLek.getSifra() + "," + cenaLekaOdDobavljaca+ ","+kolicina; 
	}

	@Override
	public String toString() {
		return "NarudzbenicaStavka [naruceniLek=" + naruceniLek.getNaziv()
				+ ", cenaLekaOdDobavljaca=" + cenaLekaOdDobavljaca
				+ ", kolicina=" + kolicina + "]";
	}

	public Lek getNaruceniLek() {
		return naruceniLek;
	}

	public void setNaruceniLek(Lek naruceniLek) {
		this.naruceniLek = naruceniLek;
	}

	public double getCenaLekaOdDobavljaca() {
		return cenaLekaOdDobavljaca;
	}

	public void setCenaLekaOdDobavljaca(double cenaLekaOdDobavljaca) {
		this.cenaLekaOdDobavljaca = cenaLekaOdDobavljaca;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
}
