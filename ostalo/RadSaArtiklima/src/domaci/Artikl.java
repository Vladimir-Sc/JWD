package domaci;

public class Artikl {
	
	/* Atributi klase */
	protected String  sifra;
	protected String  naziv;
	protected String  proizvodjac;
	protected double  cena;
	protected String  akcija;
	protected String  datum;
	
	public Artikl() {
		super();
	}

	public Artikl(String sifra, String naziv, String proizvodjac,
			double cena, String akcija, String datum) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.proizvodjac = proizvodjac;
		this.cena = cena;
		this.akcija = akcija;
		this.datum = datum;
	}
	
	public Artikl(String tekst){
		String [] tokeni = tekst.split(",");	
		if(tokeni.length!=6){
			System.out.println("Greska pri ocitavanju 1-Artikli");
			System.exit(0);
		}
		
		this.sifra = tokeni[0];
		this.naziv = tokeni[1];
		this.proizvodjac = tokeni[2];
		this.cena = Double.parseDouble(tokeni[3]);
		this.akcija = tokeni[4];
		this.datum = tokeni[5];
			
	}
	
	public String toFile() {
		return  sifra + "," + naziv
				+ "," + proizvodjac + "," + cena+ "," + akcija + "," + datum ;
	}
	
	@Override
	public String toString() {
		return  sifra + "," + naziv
				+ "," + proizvodjac + "," + cena;
	}

	public String toStringDetail() {
		return  sifra + "," + naziv
				+ "," + proizvodjac + "," + cena+ "," + akcija + "," + datum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artikl other = (Artikl) obj;
		if (sifra == null) {
			if (other.sifra != null)
				return false;
		} else if (!sifra.equals(other.sifra))
			return false;
		return true;
	}

	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public String getAkcija() {
		return akcija;
	}
	public void setAkcija(String akcija) {
		this.akcija = akcija;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}	
}
