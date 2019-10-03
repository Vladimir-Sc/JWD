package primerNasladjivanjaProdavnicaRacunara.model;

public class Korisnik {

	protected String korisnickoIme;
	protected String lozinka;
	protected String ime;
	protected String prezime;
	protected String uloga;

	public Korisnik(String korisnickoIme, String lozinka, String ime,
			String prezime, String uloga) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.ime = ime;
		this.prezime = prezime;
		this.uloga = uloga;
	}

	// citanje iz fajla
	public Korisnik(String tekst) {
		String tokeni[] = tekst.split("\\|");

		if (tokeni.length != 5) {
			System.out.println("Greska pri ocitavanju");
			System.out.println(tekst + " netacan broj tokena");
		}
		// mora se namestiti da korisnicko ime ne moze da bude isto
		korisnickoIme = tokeni[0];
		lozinka = tokeni[1];
		ime = tokeni[2];
		prezime = tokeni[3];
		uloga = tokeni[4];

	}

	public String toString() {
		return ime + " " + prezime;
	}

	public String toFile() {
		return korisnickoIme + "|" + lozinka + "|" + ime + "|" + prezime + "|"
				+ uloga;
	}

	// trebace za logovanje

	public boolean equals(Object obj) {
		boolean isti = false;
		if (obj == null) {
			return false;
		}
		if (obj instanceof Korisnik) {
			if (korisnickoIme.equals(((Korisnik) obj).korisnickoIme)) {
				return true;
			}
			return false;
		}
		return isti;

	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getUloga() {
		return uloga;
	}

	public void setUloga(String uloga) {
		this.uloga = uloga;
	}

}
