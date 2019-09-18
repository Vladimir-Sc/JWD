package primerNasladjivanjaProdavnicaRacunara;

import java.util.ArrayList;
import java.util.Collections;

import primerNasladjivanjaProdavnicaRacunara.GUI.Meniji;
import primerNasladjivanjaProdavnicaRacunara.model.ArtikalProdaje;
import primerNasladjivanjaProdavnicaRacunara.model.GotovaKonfiguracija;
import primerNasladjivanjaProdavnicaRacunara.model.KategorijeKomponenti;
import primerNasladjivanjaProdavnicaRacunara.model.Komponenta;
import primerNasladjivanjaProdavnicaRacunara.model.Korisnik;
import primerNasladjivanjaProdavnicaRacunara.model.MemorijaRacunara;
import primerNasladjivanjaProdavnicaRacunara.model.Procesor;
import primerNasladjivanjaProdavnicaRacunara.readWriteFile.GotovaKonfiguracijaFile;
import primerNasladjivanjaProdavnicaRacunara.readWriteFile.KategorijaKompFile;
import primerNasladjivanjaProdavnicaRacunara.readWriteFile.KomponentaFile;
import primerNasladjivanjaProdavnicaRacunara.readWriteFile.KorisnikFile;
import primerNasladjivanjaProdavnicaRacunara.readWriteFile.MemorijaFile;
import primerNasladjivanjaProdavnicaRacunara.readWriteFile.ProcesorFile;
import primerNasladjivanjaProdavnicaRacunara.util.OsnovniSorter;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class ProdavnicaRacunara {

	static ArrayList<Korisnik> SviKorisnici = new ArrayList<Korisnik>();
	static ArrayList<KategorijeKomponenti> SveKategorije = new ArrayList<KategorijeKomponenti>();
	static ArrayList<ArtikalProdaje> SviArtikli = new ArrayList<ArtikalProdaje>();

	public static ArtikalProdaje proveraKomponentiZaKonf(String sifraKomp) {
		for (ArtikalProdaje artikal : SviArtikli) {
			if (artikal instanceof Komponenta || artikal instanceof Procesor
					|| artikal instanceof MemorijaRacunara) {
				if (artikal.getSifra().equalsIgnoreCase(sifraKomp)) {
					return artikal;
				}

			}

		}
		return null;
	}

	public static Komponenta proveraPostojanjaKomponente(String sifraKomp,
			boolean trueFalse) {
		Komponenta retVal = null;
		for (ArtikalProdaje komp : SviArtikli) {
			if (komp instanceof Komponenta
					|| (komp instanceof MemorijaRacunara)
					|| (komp instanceof Procesor)) {
				if (sifraKomp.equalsIgnoreCase(komp.getSifra())
						&& komp.isObrisano() == trueFalse)
					retVal = (Komponenta) komp;
			}
		}
		return retVal;
	}

	public static Komponenta proveraPostojanjaKomponente(String sifraKomp) {
		Komponenta retVal = null;
		for (ArtikalProdaje komp : SviArtikli) {
			if (komp instanceof Komponenta
					|| (komp instanceof MemorijaRacunara)
					|| (komp instanceof Procesor)) {
				if (sifraKomp.equalsIgnoreCase(komp.getSifra()))
					retVal = (Komponenta) komp;
			}
		}
		return retVal;
	}

	public static void ocitajSve() {
		SviKorisnici.clear();
		SveKategorije.clear();
		SviArtikli.clear();
		KorisnikFile.citajIzFajla();
		SviKorisnici.addAll(KorisnikFile.sviKorisnici);
		KategorijaKompFile.citajIzFajla();
		SveKategorije.addAll(KategorijaKompFile.listaKategorijaKomponenti);
		KomponentaFile.citajIzFajla();
		SviArtikli.addAll(KomponentaFile.listaKomponenti);
		MemorijaFile.citajIzFajla();
		SviArtikli.addAll(MemorijaFile.listaMemorija);
		ProcesorFile.citajIzFajla();
		SviArtikli.addAll(ProcesorFile.listaProcesora);
		GotovaKonfiguracijaFile.citajIzFajla();
		SviArtikli.addAll(GotovaKonfiguracijaFile.listaGotovihKonfiguracija);
	}

	public static void sacuvajKorisnike() {
		KorisnikFile.sviKorisnici.clear();
		for (Korisnik user : SviKorisnici) {
			KorisnikFile.sviKorisnici.add((Korisnik) user);
		}
		KorisnikFile.pisiUFajl();
	}

	public static void sacuvajKategorije() {
		KategorijaKompFile.listaKategorijaKomponenti.clear();
		for (KategorijeKomponenti kat : SveKategorije) {
			KategorijaKompFile.listaKategorijaKomponenti
					.add((KategorijeKomponenti) kat);
		}
		KategorijaKompFile.pisiUFajl();
	}

	public static void sacuvajArtikle() {
		KomponentaFile.listaKomponenti.clear();
		GotovaKonfiguracijaFile.listaGotovihKonfiguracija.clear();
		MemorijaFile.listaMemorija.clear();
		ProcesorFile.listaProcesora.clear();
		for (ArtikalProdaje artikl : SviArtikli) {
			if (artikl instanceof Komponenta
					&& !(artikl instanceof MemorijaRacunara)
					&& !(artikl instanceof Procesor)) {
				KomponentaFile.listaKomponenti.add((Komponenta) artikl);
			}
			if (artikl instanceof GotovaKonfiguracija) {
				GotovaKonfiguracijaFile.listaGotovihKonfiguracija
						.add((GotovaKonfiguracija) artikl);
			}
			if (artikl instanceof MemorijaRacunara) {
				MemorijaFile.listaMemorija.add((MemorijaRacunara) artikl);
			}
			if (artikl instanceof Procesor) {
				ProcesorFile.listaProcesora.add((Procesor) artikl);
			}
		}
		KomponentaFile.pisiUFajl();
		MemorijaFile.pisiUFajl();
		ProcesorFile.pisiUFajl();
		GotovaKonfiguracijaFile.pisiUFajl();
	}

	public static ArtikalProdaje pronadjiArtikl(String sifra) {
		ArtikalProdaje retVal = null;
		for (int i = 0; i < SviArtikli.size(); i++) {
			ArtikalProdaje art = SviArtikli.get(i);
			if (art.getSifra().equalsIgnoreCase(sifra)) {
				retVal = art;
				break;
			}
		}
		return retVal;
	}

	public static ArrayList<ArtikalProdaje> pronadjiArtiklPoNazivu(String naziv) {
		ArrayList<ArtikalProdaje> artikal = new ArrayList<ArtikalProdaje>();
		for (ArtikalProdaje art : SviArtikli) {
			if ((art.getNaziv().toLowerCase()).contains(naziv.toLowerCase())) {
				artikal.add(art);
			}
		}
		return artikal;
	}

	// pronalak po sifri
	public static void pronadjiArtiklPoSifri() {
		ArtikalProdaje retVal = null;
		System.out.println("Unesite Sifru Artikla koji trazite");
		String sifra = Utility.ocitajTekst();
		retVal = pronadjiArtikl(sifra);
		if (retVal == null) {
			System.out.println("Artikal sa datom sifrom " + sifra
					+ " ne postoji");
		} else {
			System.out.println(retVal);
		}
	}

	public static void pronadjiArtiklPoNazivu() {
		ArrayList<ArtikalProdaje> retVal = new ArrayList<ArtikalProdaje>();
		System.out.println("Unesi naziv artikla koji zelis da pronadjes ");
		String naziv = Utility.ocitajTekst();
		retVal = pronadjiArtiklPoNazivu(naziv);
		if (retVal.isEmpty()) {
			System.out.println("Ne postoji artikl sa takvom kljucnom reci");
		} else {
			for (ArtikalProdaje artikalProdaje : retVal) {
				System.out.println(artikalProdaje);
			}
		}
	}

	// pretraga opseg cene artikl
	public static ArrayList<ArtikalProdaje> pronadjiArtiklCena(double pocetnaCena,
			double krajnaCena) {
		ArrayList<ArtikalProdaje> Artikli = new ArrayList<ArtikalProdaje>();
		for (ArtikalProdaje art : SviArtikli) {
			if (art.getCena() >= pocetnaCena && art.getCena() <= krajnaCena) {
				Artikli.add(art);
			}
			if (krajnaCena <= -1 && art.getCena() >= pocetnaCena) {
				Artikli.add(art);
			}
		}
		return Artikli;
	}

	public static void pronadjiArtiklPoOpseguCene() {
		ArrayList<ArtikalProdaje> retVal = null;
		System.out.println("Unesi opseg cene");
		System.out.println("Od >>>");
		Double od = Utility.ocitajRealanBroj();
		System.out.println("Do (-1 da nema gornje ogranicenje) >> ");
		Double dokle = Utility.ocitajRealanBroj();
		retVal = pronadjiArtiklCena(od, dokle);
		if (retVal.size() == 0) {
			System.out.println("Artikli sa datim opsegom cena ne postoje");
		} else {
			for (ArtikalProdaje art : retVal) {
				System.out.println(art);
			}
		}
	}

	public static ArrayList<KategorijeKomponenti> pronadjiKatPoNazivu(String naziv) {
		ArrayList<KategorijeKomponenti> lista = new ArrayList<KategorijeKomponenti>();
		for (KategorijeKomponenti kat : SveKategorije) {
			if ((kat.getNaziv().toLowerCase()).contains(naziv.toLowerCase())) {
				lista.add(kat);
			}
		}
		return lista;

	}

	public static void pronadjiKatPoNazivu() {
		ArrayList<KategorijeKomponenti> lista = new ArrayList<KategorijeKomponenti>();
		System.out.println("Unesi naziv kategorije koju zelis da pronadjes ");
		String naziv = Utility.ocitajTekst();
		lista = pronadjiKatPoNazivu(naziv);
		if (lista.isEmpty()) {
			System.out.println("Nijedna kategorija nije pronadjena");
		} else {
			for (KategorijeKomponenti kategorijeKomponenti : lista) {
				System.out.println(kategorijeKomponenti);
			}
		}

	}

	public static KategorijeKomponenti pronadjiKatPoSifri(String sifra) {
		KategorijeKomponenti retVal = null;
		for (int i = 0; i < SveKategorije.size(); i++) {
			KategorijeKomponenti kat = SveKategorije.get(i);
			if (sifra.equals(kat.getSifra())) {
				retVal = kat;
				break;
			}
		}
		return retVal;
	}

	public static void pronadjiKatPoSifri() {
		KategorijeKomponenti retVal = null;
		System.out.println("Unesi sifru kategorije koju zelis da pronadjes ");
		String sifra = Utility.ocitajTekst();
		retVal = pronadjiKatPoSifri(sifra);
		if (retVal == null) {
			System.out.println("Kategorija sa datom sifrom ne postoji");
		} else {
			System.out.println(retVal);
		}
	}

	public static void pronadjiKonfCena() {
		ArrayList<GotovaKonfiguracija> retVal = null;
		System.out.println("Unesi opseg cene");
		System.out.println("Od >> ");
		Double od = Utility.ocitajRealanBroj();
		System.out.println("Do (-1 da nema gornje ogranicenje) >> ");
		Double dokle = Utility.ocitajRealanBroj();
		retVal = GotovaKonfiguracijaFile.pronadjiKonfOpsegCene(od, dokle);
		if (retVal.size() == 0) {
			System.out
					.println("Konfiguracije pod datim opsegom cene ne postoje");
		} else {
			for (GotovaKonfiguracija konf : retVal) {
				System.out.println(konf);
			}
		}

	}

	public static void pronadjiKonfKolicina() {
		ArrayList<GotovaKonfiguracija> retVal = null;
		System.out.println("Unesi opseg kolicine");
		System.out.println("Od >>");
		int od = Utility.ocitajCeoBroj();
		System.out.println("Do (-1 da nema gornje ogranicenje) >>");
		int dokle = Utility.ocitajCeoBroj();
		retVal = GotovaKonfiguracijaFile.pronadjiKonfOpsegKolicina(od, dokle);
		if (retVal.size() == 0) {
			System.out
					.println("Konfiguracija sa datim opsegom kolicine ne postoji");
		} else {
			for (GotovaKonfiguracija konf : retVal) {
				System.out.println(konf);
			}
		}
	}

	public static void pronadjiKompCena() {
		ArrayList<Komponenta> retVal = null;
		System.out.println("Unesi opseg cene");
		System.out.println("Od >> ");
		Double od = Utility.ocitajRealanBroj();
		System.out.println("Do (-1 da nema gornje ogranicenje) >> ");
		Double dokle = Utility.ocitajRealanBroj();
		retVal = pronadjiKompOpsegCene(od, dokle);
		if (retVal.size() == 0) {
			System.out.println("Komponente sa datim opsegom ne postoje");
		} else {
			for (Komponenta komponenta : retVal) {
				System.out.println(komponenta);
			}
		}
	}

	public static ArrayList<Komponenta> pronadjiKompOpsegCene(
			double pocetnaCena, double krajnjaCena) {
		ArrayList<Komponenta> listaKomp = new ArrayList<Komponenta>();
		for (ArtikalProdaje komp : SviArtikli) {
			if (komp.getCena() >= pocetnaCena && komp.getCena() <= krajnjaCena
					&& komp instanceof Komponenta) {
				listaKomp.add((Komponenta) komp);

			}
			if (krajnjaCena <= -1 && komp.getCena() >= pocetnaCena
					&& komp instanceof Komponenta) {
				listaKomp.add((Komponenta) komp);
			} else {

			}
		}
		return listaKomp;
	}

	public static void pronadjiKompKolicina() {
		ArrayList<Komponenta> retVal = null;
		System.out.println("Unesi opseg kolicine");
		System.out.println("Od >> ");
		int od = Utility.ocitajCeoBroj();
		System.out.println("Do (-1 da nema gornje ogranicenje) >> ");
		int dokle = Utility.ocitajCeoBroj();
		retVal = pronadjiKompOpsegKolicina(od, dokle);
		if (retVal.isEmpty()) {
			System.out
					.println("Komponente sa datim opsegom kolicine ne postoje ");
		} else {
			for (Komponenta komponenta : retVal) {
				System.out.println(komponenta);
			}
		}
	}

	public static ArrayList<Komponenta> pronadjiKompOpsegKolicina(
			int pocetnaKolicina, int krajnjaKolicina) {
		ArrayList<Komponenta> kompKolicina = new ArrayList<Komponenta>();
		for (ArtikalProdaje komp : SviArtikli) {
			if (komp.getKolicina() >= pocetnaKolicina
					&& komp.getKolicina() <= krajnjaKolicina
					&& komp instanceof Komponenta) {
				kompKolicina.add((Komponenta) komp);
			}
			if (krajnjaKolicina <= -1 && komp.getKolicina() >= pocetnaKolicina
					&& komp instanceof Komponenta) {
				kompKolicina.add((Komponenta) komp);
			}

		}
		return kompKolicina;
	}

	public static void pronadjiKompKategorija() {
		ArrayList<Komponenta> retVal = null;
		System.out
				.println("Unesi sifru kategorije po kojoj trazite komponente >> ");
		String sifraKat = Utility.ocitajTekst();
		retVal = pronadjiKompPoKat(sifraKat);
		if (retVal.isEmpty()) {
			System.out.println("Komponente pod datom kategorijom ne postoje");
		} else {
			for (Komponenta komponenta : retVal) {
				System.out.println(komponenta);
			}
		}
	}

	public static ArrayList<Komponenta> pronadjiKompPoKat(String sifraKategorije) {
		ArrayList<Komponenta> listaKomp = new ArrayList<Komponenta>();
		ArrayList<Komponenta> listaodakleSeBira = new ArrayList<Komponenta>();
		listaodakleSeBira.addAll(KomponentaFile.listaKomponenti);
		listaodakleSeBira.addAll(ProcesorFile.listaProcesora);
		listaodakleSeBira.addAll(MemorijaFile.listaMemorija);
		for (Komponenta komponenta : listaodakleSeBira) {
			if ((komponenta.getKategorija().getSifra())
					.equalsIgnoreCase(sifraKategorije)) {
				listaKomp.add(komponenta);
			}
		}
		return listaKomp;
	}

	static void pronadjiKompNaziv() {
		ArrayList<Komponenta> listaKomp = new ArrayList<Komponenta>();
		System.out.println("Unesi naziv komponente >> ");
		String naziv = Utility.ocitajTekst();
		listaKomp = pronadjiKompPoNazivu(naziv);
		if (listaKomp.isEmpty()) {
			System.out.println("Komponente sa datim nazivom ne postoji");
		} else {
			for (Komponenta komponenta : listaKomp) {
				System.out.println(komponenta);
			}
		}
	}

	public static ArrayList<Komponenta> pronadjiKompPoNazivu(String naziv) {
		ArrayList<Komponenta> komponente = new ArrayList<Komponenta>();
		for (ArtikalProdaje komp : SviArtikli) {

			if ((komp.getNaziv().toLowerCase()).contains(naziv.toLowerCase())
					&& komp instanceof Komponenta) {
				komponente.add((Komponenta) komp);
			}
		}
		return komponente;
	}

	public static void pronadjiKompSifra() {
		System.out.println("Unesi sifru komponente koju trazis >> ");
		String sifra = Utility.ocitajTekst();
		ArtikalProdaje retVal = proveraKomponentiZaKonf(sifra);
		if (retVal == null) {
			System.out.println("Komponenta sa datom sifrom ne postoji");
		} else {
			System.out.println(retVal);
		}

	}

	public static void ispisiArtikle() {
		for (ArtikalProdaje art : SviArtikli) {
			System.out.println(art);
		}
	}

	public static void ispisiKategorije() {
		for (int i = 0; i < SveKategorije.size(); i++) {
			System.out.println(SveKategorije.get(i));
		}
	}

	// prikaz izbrisanih ili neobrisanih entiteta
	public static void ispisiArtikle(boolean trueFalse) {
		for (int i = 0; i < SviArtikli.size(); i++) {
			ArtikalProdaje art = SviArtikli.get(i);
			if (art.isObrisano() == trueFalse) {
				System.out.println(art);
			}

		}
	}

	public static void ispisiKategorije(boolean trueFalse) {
		for (int i = 0; i < SveKategorije.size(); i++) {
			KategorijeKomponenti kat = SveKategorije.get(i);
			if (kat.isObrisano() == trueFalse) {
				System.out.println(kat);
			}
		}
	}

	// unos nove komponente
	public static void unosNoveKomponente() {
		System.out.println("Unesi sifru:");
		String sifra = Utility.ocitajTekst();
		while (pronadjiArtikl(sifra) != null) {
			System.out.println("Artikl sa indeksom " + sifra + " vec postoji");
			System.out.println("Unesi sifru ponovo");
			sifra = Utility.ocitajTekst();
		}
		System.out.println("Unesi naziv komponente:");
		String naziv = Utility.ocitajTekst();
		System.out.println("Unesi cenu:");
		double cena = Utility.ocitajRealanBroj();
		System.out.println("Unesi kolicinu:");
		int kolicina = Utility.ocitajCeoBroj();
		System.out.println("Unesi opis komponente:");
		String opis = Utility.ocitajTekst();
		System.out.println("Unesi kategoriju komponente:");
		String kategorija = Utility.ocitajTekst();
		while (KategorijaKompFile.proveraKategorije(kategorija, false) == null) {
			System.out.println("Kategorija ne postoji. Unesi ponovo");
			kategorija = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = KategorijaKompFile.proveraKategorije(
				kategorija, false);
		boolean obrisano = false;
		Komponenta komp = new Komponenta(sifra, naziv, cena, kolicina, opis,
				obrisano, kat);
		SviArtikli.add(komp);
	}

	public static void unosNoveMemorije() {
		System.out.println("Unesi sifru:");
		String sifra = Utility.ocitajTekst();
		while (pronadjiArtikl(sifra) != null) {
			System.out.println("Artikl sa indeksom " + sifra + " vec postoji");
			sifra = Utility.ocitajTekst();
		}
		System.out.println("Unesi naziv memorije: ");
		String naziv = Utility.ocitajTekst();
		System.out.println("Unesi cenu: ");
		double cena = Utility.ocitajRealanBroj();
		System.out.println("Unesi kolicinu:");
		int kolicina = Utility.ocitajCeoBroj();
		System.out.println("Unesi opis memorije: ");
		String opis = Utility.ocitajTekst();
		ispisiKategorije(false);
		System.out.println("Unesi sifru kategorije: ");
		String kategorija = Utility.ocitajTekst();
		while (KategorijaKompFile.proveraKategorije(kategorija, false) == null) {
			ispisiKategorije(false);
			System.out.println("Kategorija pod sifrom" + kategorija
					+ " ne postoji");
			System.out.println("Ukucaj ponovo: ");
			kategorija = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = KategorijaKompFile.proveraKategorije(
				kategorija, false);
		System.out.println("Unesi kapacitet memorije: ");
		String kapacitet = Utility.ocitajTekst();
		boolean obrisano = false;
		MemorijaRacunara komp = new MemorijaRacunara(sifra, naziv, cena,
				kolicina, opis, obrisano, kat, kapacitet);
		SviArtikli.add(komp);
	}

	public static void unosNovogProcesora() {
		System.out.println("Unesi sifru:");
		String sifra = Utility.ocitajTekst();
		while (pronadjiArtikl(sifra) != null) {
			System.out.println("Artikl sa indeksom " + sifra + " vec postoji");
			sifra = Utility.ocitajTekst();
		}
		System.out.println("Unesi naziv procesora: ");
		String naziv = Utility.ocitajTekst();
		System.out.println("Unesi cenu: ");
		double cena = Utility.ocitajRealanBroj();
		System.out.println("Unesi kolicinu:");
		int kolicina = Utility.ocitajCeoBroj();
		System.out.println("Unesi opis procesora: ");
		String opis = Utility.ocitajTekst();
		ispisiKategorije(false);
		System.out.println("Unesi sifru kategorije: ");
		String kategorija = Utility.ocitajTekst();
		while (KategorijaKompFile.proveraKategorije(kategorija, false) == null) {
			ispisiKategorije(false);
			System.out.println("Kategorija pod sifrom" + kategorija
					+ " ne postoji");
			System.out.println("Ukucaj ponovo: ");
			kategorija = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = KategorijaKompFile.proveraKategorije(
				kategorija, false);

		System.out.println("Unesi radni takt procesora: ");
		double radniTakt = Utility.ocitajRealanBroj();

		System.out.println("Unesi broj jezgara procesora: ");
		int brojJezgara = Utility.ocitajCeoBroj();

		boolean obrisano = false;
		Procesor proc = new Procesor(sifra, naziv, cena, kolicina, opis,
				obrisano, kat, radniTakt, brojJezgara);
		SviArtikli.add(proc);
	}

	public static void unosNoveKategorije() {
		boolean obrisano = false;
		System.out.println("Unesi sifru:");
		String sifra = Utility.ocitajTekst();
		while (pronadjiKatPoSifri(sifra) != null) {
			System.out.println("Kategorija sa indeksom " + sifra
					+ " vec postoji");
			sifra = Utility.ocitajTekst();
		}
		System.out.println("Unesi naziv kategorija:");
		String naziv = Utility.ocitajTekst();
		System.out.println("Unesi opis kategorije:");
		String opis = Utility.ocitajTekst();
		char odluka = Utility
				.ocitajOdlukuOPotvrdi("da kategorija ima nadKategoriju? ");
		if (odluka == 'Y') {
			System.out.println("Unesi sifru nadKategorije: ");
			String sifraNadkategorije = Utility.ocitajTekst();
			while (pronadjiKatPoSifri(sifraNadkategorije) == null) {
				System.out.println("Kategorija je nepostojeca");
				sifraNadkategorije = Utility.ocitajTekst();
			}
			KategorijeKomponenti izabrano = KategorijaKompFile.proveraKategorije(
					sifraNadkategorije, false);

			KategorijeKomponenti kategorija1 = new KategorijeKomponenti(sifra,
					naziv, opis, izabrano, obrisano);
			SveKategorije.add(kategorija1);
		}
		if (odluka == 'N') {
			KategorijeKomponenti izabrano = null;
			KategorijeKomponenti kategorija = new KategorijeKomponenti(sifra,
					naziv, opis, izabrano, obrisano);
			SveKategorije.add(kategorija);
		}
	}

	public static ArrayList<Komponenta> izdvojNeobrsaneKomp() {
		ArrayList<Komponenta> neobrisano = new ArrayList<Komponenta>();
		for (int i = 0; i < SviArtikli.size(); i++) {
			ArtikalProdaje art = SviArtikli.get(i);
			if (art instanceof Komponenta) {
				Komponenta komp = ((Komponenta) art);
				if (komp.isObrisano() == false) {
					neobrisano.add(komp);
				}
			}
		}
		return neobrisano;
	}

	public static void prikazKomp(ArrayList<Komponenta> komp) {
		for (int i = 0; i < komp.size(); i++) {
			System.out.println(komp.get(i));
		}
	}

	public static void unosNoveKonfiguracije() {
		System.out.println("Unesi sifru:");
		String sifra = Utility.ocitajTekst();
		while (pronadjiArtikl(sifra) != null) {
			System.out.println("Artikl sa indeksom " + sifra + " vec postoji");
			sifra = Utility.ocitajTekst();
		}
		System.out.println("Unesi naziv gotove konfiguracije:");
		String naziv = Utility.ocitajTekst();
		System.out.println("Unesi cenu:");
		double cena = Utility.ocitajRealanBroj();
		System.out.println("Unesi kolicinu:");
		int kolicina = Utility.ocitajCeoBroj();
		System.out.println("Unesi opis gotove konfiguracije:");
		String opis = Utility.ocitajTekst();
		ArrayList<Komponenta> komp = new ArrayList<Komponenta>();
		ArrayList<Komponenta> neobrisane = izdvojNeobrsaneKomp();
		boolean prekid = false;
		while (prekid == false) {
			prikazKomp(neobrisane);
			System.out
					.println("Unesi sifru komponente (ukucaj prekid za prestanjanje unosa) >>");
			String odluka = Utility.ocitajTekst();
			if (odluka.equalsIgnoreCase("prekid")) {
				if (komp.size() == 0) {
					prekid = false;
				} else {
					prekid = true;
				}
			}
			while (proveraKomponentiZaKonf(odluka) == null && prekid == false) {
				prikazKomp(neobrisane);
				if (odluka.equalsIgnoreCase("prekid")) {
					System.out.println("Niste uneli nijednu komponentu");
				} else {
					System.out.println("Komponenta sa sifrom " + odluka
							+ " ne postoji");
				}
				System.out.println("Ukucajte ponovo");
				odluka = Utility.ocitajTekst();
			}

			ArtikalProdaje artikl = proveraKomponentiZaKonf(odluka);
			if (artikl instanceof MemorijaRacunara) {
				MemorijaRacunara memorija = (MemorijaRacunara) artikl;
				komp.add(memorija);
			} else if (artikl instanceof Procesor) {
				Procesor proc = (Procesor) artikl;
				komp.add(proc);
			} else if (artikl instanceof Komponenta) {
				// && !(artikl instanceof MemorijaRacunara)
				// && !(artikl instanceof Procesor)) {
				Komponenta komponenta = (Komponenta) artikl;
				komp.add(komponenta);
			}
		}
		boolean obrisano = false;
		GotovaKonfiguracija konf = new GotovaKonfiguracija(sifra, naziv, cena,
				kolicina, opis, obrisano, komp);
		SviArtikli.add(konf);
	}

	public static void izmenaPodatakaOKomponenti(Komponenta komp) {
		System.out.println("Unesi naziv: ");
		String kompNaziv = Utility.ocitajTekst();

		System.out.println("Unesi novu cenu: ");
		double kompCena = Utility.ocitajRealanBroj();

		System.out.println("Unesi novu kolicinu: ");
		int kompKolicina = Utility.ocitajCeoBroj();

		System.out.println("Unesi opis: ");
		String kompOpis = Utility.ocitajTekst();

		ispisiKategorije(false);
		System.out.println("Izaberi novu kategoriju: ");
		String kompKat = Utility.ocitajTekst();
		while (KategorijaKompFile.proveraKategorije(kompKat, false) == null) {
			ispisiKategorije(false);
			System.out.println("Kategorija sa sifrom " + kompKat
					+ " ne postoji");
			System.out.println("Unesite ponovo >> ");
			kompKat = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = KategorijaKompFile.proveraKategorije(kompKat,
				false);
		komp.setNaziv(kompNaziv);
		komp.setCena(kompCena);
		komp.setKolicina(kompKolicina);
		komp.setOpis(kompOpis);
		komp.setKategorija(kat);
		System.out.println("Izmena uspesno obavljena!");
	}

	public static void izmenaPodatakaOKomponenti() {
		KomponentaFile.ispisiKomponente(false);
		System.out.println("Unesi sifru komponente koju menjas >> ");
		String sifra = Utility.ocitajTekst();
		while (proveraPostojanjaKomponente(sifra, false) == null) {
			System.out.println("Komponenta sa sifrom " + sifra + " ne postoji");
			System.out.println("Ukucajte ponovo >> ");
			sifra = Utility.ocitajTekst();
		}
		izmenaPodatakaOKomponenti(proveraPostojanjaKomponente(sifra, false));
	}

	public static void izmenaPodatakaOGotovojKonf(GotovaKonfiguracija konf) {
		System.out.println("Unesi naziv: ");
		String konfNaziv = Utility.ocitajTekst();

		System.out.println("Unesi novu cenu: ");
		double konfCena = Utility.ocitajRealanBroj();

		System.out.println("Unesi novu kolicinu: ");
		int konfKolicina = Utility.ocitajCeoBroj();

		System.out.println("Unesi opis: ");
		String konfOpis = Utility.ocitajTekst();
		ArrayList<Komponenta> komp = new ArrayList<Komponenta>();
		ArrayList<Komponenta> neobrisane = izdvojNeobrsaneKomp();
		boolean prekid = false;
		while (prekid == false) {
			prikazKomp(neobrisane);
			System.out
					.println("Unesi sifru komponente (ukucaj prekid za prestanjanje unosa) >>");
			String odluka = Utility.ocitajTekst();
			if (odluka.equalsIgnoreCase("prekid")) {
				prekid = true;
			}
			while (proveraKomponentiZaKonf(odluka) == null && prekid == false) {
				prikazKomp(neobrisane);
				System.out.println("Komponenta sa sifrom " + odluka
						+ " ne postoji");
				System.out.println("Ukucajte ponovo");
				odluka = Utility.ocitajTekst();
			}

			ArtikalProdaje artikl = proveraKomponentiZaKonf(odluka);
			if (artikl instanceof MemorijaRacunara) {
				MemorijaRacunara memorija = (MemorijaRacunara) artikl;
				komp.add(memorija);
			} else if (artikl instanceof Procesor) {
				Procesor proc = (Procesor) artikl;
				komp.add(proc);
			} else if (artikl instanceof Komponenta) {
				// && !(artikl instanceof MemorijaRacunara)
				// && !(artikl instanceof Procesor)) {
				Komponenta komponenta = (Komponenta) artikl;
				komp.add(komponenta);
			}
		}
		konf.setNaziv(konfNaziv);
		konf.setCena(konfCena);
		konf.setKolicina(konfKolicina);
		konf.setOpis(konfOpis);
		if (komp.size() != 0) {
			konf.setListeKomponenti(komp);
		}

		System.out.println("Izmena uspesno obavljena!");
	}

	public static void izmenaPodatakaOGotovojKonf() {
		ispisGotoveKonfiguracije(false);
		System.out.println("Unesi sifru gotove konfiguracije koju menjas >> ");
		String sifra = Utility.ocitajTekst();
		while (GotovaKonfiguracijaFile.pronadjiKonfPoSifri(sifra, false) == null) {
			System.out.println("Konfiguracija sa sifrom " + sifra
					+ " ne postoji");
			System.out.println("Ukucajte ponovo >> ");
			sifra = Utility.ocitajTekst();
		}
		GotovaKonfiguracija konf = GotovaKonfiguracijaFile.pronadjiKonfPoSifri(
				sifra, false);
		izmenaPodatakaOGotovojKonf(konf);
	}

	public static void pronadjiKonfPoSifri() {
		System.out.println("Unesi sifru konfiguracije koju trazis >> ");
		String sifra = Utility.ocitajTekst();
		GotovaKonfiguracija konf = GotovaKonfiguracijaFile.pronadjiKonfPoSifri(
				sifra, false);
		GotovaKonfiguracija konfob = GotovaKonfiguracijaFile.pronadjiKonfPoSifri(
				sifra, true);
		if (konf == null && konfob == null) {
			System.out.println("Konfiguracije sa datom sifrom ne postoji ");
		}
		if (konfob == null) {
			System.out.println(konf);
		}
		if (konf == null) {
			System.out.println(konfob);
		}
	}

	public static void pronadjiKonfPoNazivu() {
		ArrayList<GotovaKonfiguracija> konf = new ArrayList<GotovaKonfiguracija>();
		System.out
				.println("Unesi kljucnu rec nazivu po kojem trazis konfiguraciju >>");
		String naziv = Utility.ocitajTekst();
		konf = GotovaKonfiguracijaFile.pronadjiKonfPoNazivu(naziv);
		if (konf.size() == 0) {
			System.out.println("Konfiguracije sa datim nazivom ne postoje ");
		} else {
			for (GotovaKonfiguracija gotovaKonfiguracija : konf) {
				System.out.println(gotovaKonfiguracija);
			}
		}

	}

	static void ispisGotoveKonfiguracije(boolean trueFalse) {
		for (ArtikalProdaje art : SviArtikli) {
			if (art instanceof GotovaKonfiguracija
					&& art.isObrisano() == trueFalse) {
				System.out.println(art);
			}
		}
	}

	static void izmenaPodatakaOProcesoru(Procesor proc) {
		System.out.println("Unesi naziv: ");
		String procNaziv = Utility.ocitajTekst();

		System.out.println("Unesi novu cenu: ");
		double procCena = Utility.ocitajRealanBroj();

		System.out.println("Unesi novu kolicinu: ");
		int procKolicina = Utility.ocitajCeoBroj();

		System.out.println("Unesi opis: ");
		String procOpis = Utility.ocitajTekst();

		ispisiKategorije(false);
		System.out.println("Izaberi novu kategoriju: ");
		String kompKat = Utility.ocitajTekst();
		while (KategorijaKompFile.proveraKategorije(kompKat, false) == null) {
			System.out.println("Kategorija sa sifrom " + kompKat
					+ " ne postoji");
			System.out.println("Ukucajte ponovo >> ");
			kompKat = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = KategorijaKompFile.proveraKategorije(kompKat,
				false);

		System.out.println("Unesi radni takt:");
		double procRadniTakt = Utility.ocitajRealanBroj();

		System.out.println("Unesi broj jezgara: ");
		int procBrojJezgara = Utility.ocitajCeoBroj();

		proc.setNaziv(procNaziv);
		proc.setCena(procCena);
		proc.setKolicina(procKolicina);
		proc.setOpis(procOpis);
		proc.setKategorija(kat);
		proc.setBrojJezgara(procBrojJezgara);
		proc.setRadniTakt(procRadniTakt);
		System.out.println("Izmena uspesno obavljena!");
	}

	static void ispisProcesora(boolean trueFalse) {
		for (ArtikalProdaje art : SviArtikli) {
			if (art instanceof Procesor && art.isObrisano() == trueFalse) {
				System.out.println(art);

			}
		}
	}

	static void izmenaPodatakaOProcesoru() {
		ispisProcesora(false);
		System.out.println("Unesi sifru procesora kojeg menjas >> ");
		String sifra = Utility.ocitajTekst();
		while (ProcesorFile.pronadjiProcesorPoSifri(sifra, false) == null) {
			System.out.println("Procesor sa sifrom " + sifra + " ne postoji");
			System.out.println("Unesite ponovo >> ");
			sifra = Utility.ocitajTekst();
		}
		Procesor proc = ProcesorFile.pronadjiProcesorPoSifri(sifra, false);
		izmenaPodatakaOProcesoru(proc);
	}

	static void izmenaPodatakaOMemoriji(MemorijaRacunara memorija) {
		System.out.println("Unesi naziv: ");
		String memorijaNaziv = Utility.ocitajTekst();

		System.out.println("Unesi novu cenu: ");
		double memorijaCena = Utility.ocitajRealanBroj();

		System.out.println("Unesi novu kolicinu: ");
		int memorijaKolicina = Utility.ocitajCeoBroj();

		System.out.println("Unesi opis: ");
		String memorijaOpis = Utility.ocitajTekst();

		ispisiKategorije(false);
		System.out.println("Izaberi novu kategoriju: ");
		String memorijaKat = Utility.ocitajTekst();
		while (KategorijaKompFile.proveraKategorije(memorijaKat, false) == null) {
			System.out.println("Kategorija sa sifrom " + memorijaKat
					+ " ne postoji");
			System.out.println("Ukucajte ponovo >> ");
			memorijaKat = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = KategorijaKompFile.proveraKategorije(
				memorijaKat, false);

		System.out.println("Unesi kapacitet memorije: ");
		String memorijaKapacitet = Utility.ocitajTekst();

		memorija.setNaziv(memorijaNaziv);
		memorija.setCena(memorijaCena);
		memorija.setKolicina(memorijaKolicina);
		memorija.setOpis(memorijaOpis);
		memorija.setKategorija(kat);
		memorija.setKapacitet(memorijaKapacitet);
		System.out.println("Izmena uspesno obavljena!");
	}

	static MemorijaRacunara proveraPostojanjaMemorije(String sifra) {
		for (ArtikalProdaje art : SviArtikli) {
			if (art instanceof MemorijaRacunara) {
				if (art.getSifra().equalsIgnoreCase(sifra)) {
					return (MemorijaRacunara) art;
				}
			}
		}
		return null;
	}

	static void izmenaPodatakaOMemoriji() {
		MemorijaFile.ispisiMemorije(false);
		System.out.println("Unesi sifru memorije koju menjas >> ");
		String sifra = Utility.ocitajTekst();
		while (proveraPostojanjaMemorije(sifra) == null) {
			System.out.println("Memorija sa sifrom " + sifra + " ne postoji");
			System.out.println("Ukucajte ponovo");
			sifra = Utility.ocitajTekst();
		}
		MemorijaRacunara memorija = proveraPostojanjaMemorije(sifra);
		izmenaPodatakaOMemoriji(memorija);

	}

	static void izmenaPodatakaOKategoriji(KategorijeKomponenti kategorija) {
		System.out.println("Unesi naziv: ");
		String kategorijaNaziv = Utility.ocitajTekst();

		System.out.println("Unesi opis: ");
		String kategorijaOpis = Utility.ocitajTekst();

		ispisiKategorije(false);
		System.out
				.println("Izaberi sifru nadkategorije (ukucaj nema za nista) : ");
		String kategorijaNadKat = Utility.ocitajTekst();
		while (pronadjiKatPoSifri(kategorijaNadKat) == null
				&& !(kategorijaNadKat.equalsIgnoreCase("nema"))) {
			System.out.println("Kategorija pod sifrom " + kategorijaNadKat
					+ " ne postoji");
			System.out.println("Ukucajte ponovo");
			kategorijaNadKat = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = pronadjiKatPoSifri(kategorijaNadKat);
		kategorija.setNaziv(kategorijaNaziv);
		kategorija.setOpis(kategorijaOpis);
		kategorija.setNadKategorija(kat);
		System.out.println("Izmena uspesno obavljena!");
	}

	static void izmenaPodatakaOKategoriji() {
		ispisiKategorije(false);
		System.out.println("Izaberi kategoriju koju brises > ");
		String katSifra = Utility.ocitajTekst();
		while (pronadjiKatPoSifri(katSifra) == null) {
			System.out.println("Kategorija pod sifrom " + "ne postoji");
			System.out.println("Unesi ponovo");
			katSifra = Utility.ocitajTekst();
		}
		izmenaPodatakaOKategoriji(pronadjiKatPoSifri(katSifra));
	}

	static void brisanjeKomp() {
		KomponentaFile.ispisiKomponente(false);
		System.out.println("Unesi sifru komponente>> ");
		String sifra = Utility.ocitajTekst();
		while (KomponentaFile.proveraPostojanjaKomponente(sifra, false) == null) {
			System.out.println("Artikla sa sifrom " + sifra + " ne postoji");
			System.out.println("Ukucajte sifru ponovo");
			sifra = Utility.ocitajTekst();
		}
		Komponenta komp = KomponentaFile
				.proveraPostojanjaKomponente(sifra, false);
		komp.setObrisano(true);
		System.out.println("Brisanje uspesno obavljeno");
	}

	static void brisanjeKategorije() {
		KategorijaKompFile.ispisiKategorije(false);
		System.out.println("Unesi sifru kategorije koju brises >> ");
		String sifra = Utility.ocitajTekst();
		while (pronadjiKatPoSifri(sifra) == null) {
			System.out.println("Kategorija sa sifrom " + sifra + " ne postoji");
			System.out.println("Ukucajte ponovo >> ");
			sifra = Utility.ocitajTekst();
		}
		KategorijeKomponenti kat = pronadjiKatPoSifri(sifra);
		kat.setObrisano(true);
		System.out.println("Brisanje kategorije pod sifrom: " + sifra
				+ " uspesno obavljeno!");
	}

	static void brisanjeGotoveKonfiguracije() {
		GotovaKonfiguracijaFile.ispisiKonf(false);
		System.out.println("Unesi sifru konfiguracije koju brises >> ");
		String sifra = Utility.ocitajTekst();
		while (GotovaKonfiguracijaFile.pronadjiKonfPoSifri(sifra, false) == null) {
			System.out.println("Konfiguracija sa sifrom " + sifra
					+ " ne postoji");
			System.out.println("Ukucajte sifru ponovo >> ");
			sifra = Utility.ocitajTekst();
		}
		GotovaKonfiguracija konf = GotovaKonfiguracijaFile.pronadjiKonfPoSifri(
				sifra, false);
		konf.setObrisano(true);
		System.out.println("Brisanje konfiguracija pod sifrom " + sifra
				+ " uspesno obavljeno!");
	}

	static void brisanjeMemorija() {
		MemorijaFile.ispisiMemorije(false);
		System.out.println("Unesi sifru memorije koju brises >> ");
		String sifra = Utility.ocitajTekst();
		while (MemorijaFile.pronadjiMemPoSifri(sifra, false) == null) {
			System.out.println("Memorija sa sifrom " + sifra + " ne postoji");
			System.out.println("Ukucajte ponovo >> ");
			sifra = Utility.ocitajTekst();
		}
		MemorijaRacunara mem = MemorijaFile.pronadjiMemPoSifri(sifra, false);
		mem.setObrisano(true);
		System.out.println("Brisanje memorija pod sifrom: " + sifra
				+ " uspesno obavljeno!");
	}

	static void brisanjeProcesora() {
		ProcesorFile.ispisProcesora(false);
		System.out.println("Unesi sifru procesora kojeg brises >>");
		String sifra = Utility.ocitajTekst();
		while (ProcesorFile.pronadjiProcesorPoSifri(sifra, false) == null) {
			System.out.println("Procesor sa sifrom " + sifra + " ne postoji");
			System.out.println("Ukucajte ponovo >>> ");
			sifra = Utility.ocitajTekst();
		}
		Procesor proc = ProcesorFile.pronadjiProcesorPoSifri(sifra, false);
		proc.setObrisano(true);
		System.out.println("Brisanje procesora sa sifrom: " + sifra
				+ " uspesno obavljeno!");
	}

	@SuppressWarnings("unchecked")
	static void sortiranjeArtikalaPoNazivu(int direction) {
		Collections.sort(SviArtikli, new OsnovniSorter(direction));
		for (ArtikalProdaje artikal : SviArtikli) {
			System.out.println(artikal);
		}
	}

	static void sortiranjeArtikalaPoCeni(int direction) {
		ArtikalProdaje temp;
		int min;
		for (int i = 0; i < SviArtikli.size() - 1; ++i) {
			min = i;
			for (int j = i + 1; j < SviArtikli.size(); ++j) {
				if (direction
						* SviArtikli.get(min).compareCena(SviArtikli.get(j)) > 0) {
					min = j;
				}
			}
			temp = SviArtikli.get(min);
			SviArtikli.set(min, SviArtikli.get(i));
			SviArtikli.set(i, temp);
		}
		ispisiArtikle();
	}

	public static ArtikalProdaje proveraPostojanjaArtikla(String sifra) {
		for (ArtikalProdaje artikal : SviArtikli) {
			if (artikal.getSifra().equalsIgnoreCase(sifra)) {
				return artikal;
			}
		}
		return null;
	}

	public static ArtikalProdaje proveraPostojanjaArtikla(String sifra,
			boolean trueFalse) {
		for (ArtikalProdaje artikal : SviArtikli) {
			if (artikal.getSifra().equalsIgnoreCase(sifra)
					&& artikal.isObrisano() == trueFalse) {
				return artikal;
			}
		}
		return null;
	}

	public static Korisnik logovanje() {
		System.out.print("Unesi korisnicko ime: ");
		String korisnickoIme = Utility.ocitajTekst();
		System.out.print("Unesi lozinku:");
		String lozinka = Utility.ocitajTekst();
		while (pronadjiKorisnika(korisnickoIme, lozinka) == null) {
			System.out.println("korisnicko ime ili lozinka nije ispravna");
			System.out.println("Ukucajte ponovo");
			System.out.print("Korisnicko ime: ");
			korisnickoIme = Utility.ocitajTekst();
			System.out.print("Lozinka:");
			lozinka = Utility.ocitajTekst();
		}
		Korisnik korisnik = pronadjiKorisnika(korisnickoIme, lozinka);
		return korisnik;
	}

	public static Korisnik pronadjiKorisnika(String korisnickoIme,
			String lozinka) {
		for (Korisnik korisnik : SviKorisnici) {
			if (korisnik.getKorisnickoIme().equals(korisnickoIme)
					&& korisnik.getLozinka().equals(lozinka)) {
				return korisnik;
			}
		}
		return null;
	}

	static void Unos() {
		Meniji.podMeniZaUnosIzmenuIBrisanje();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			unosNoveKomponente();
			break;
		case "2":
			unosNoveKonfiguracije();
			break;
		case "3":
			unosNoveKategorije();
			break;
		case "4":
			unosNoveMemorije();
			break;
		case "5":
			unosNovogProcesora();
			break;
		case "0":
			break;

		}
	}

	static void izmena() {
		Meniji.podMeniZaUnosIzmenuIBrisanje();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			izmenaPodatakaOKomponenti();
			break;
		case "2":
			izmenaPodatakaOGotovojKonf();
			break;
		case "3":
			izmenaPodatakaOKategoriji();
			break;
		case "4":
			izmenaPodatakaOMemoriji();
			break;
		case "5":
			izmenaPodatakaOProcesoru();
			break;
		case "0":
			break;
		}
	}

	static void brisanje() {
		Meniji.podMeniZaUnosIzmenuIBrisanje();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			brisanjeKomp();
			break;
		case "2":
			brisanjeGotoveKonfiguracije();
			break;
		case "3":
			brisanjeKategorije();
			break;
		case "4":
			brisanjeMemorija();
			break;
		case "5":
			brisanjeProcesora();
			break;
		case "0":
			break;
		}
	}

	static void pretragaArtikala() {
		Meniji.podMeniZaPretraguArtikala();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			pronadjiArtiklPoSifri();
			break;
		case "2":
			pronadjiArtiklPoNazivu();

			break;
		case "3":
			pronadjiArtiklPoOpseguCene();
			break;
		case "0":
			break;

		}
	}

	static void pretragaKomponenti() {
		Meniji.podMeniZaPretraguKomponenti();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			pronadjiKompSifra();
			break;
		case "2":
			pronadjiKompNaziv();
			break;
		case "3":
			pronadjiKompCena();
			break;
		case "4":
			pronadjiKompKolicina();
			break;
		case "5":
			pronadjiKompKategorija();
			break;
		case "0":
			break;

		}
	}

	static void pretragaGotovihKonfiguracija() {
		Meniji.podMeniZaPretraguGotovihKonfiguracija();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			pronadjiKonfPoSifri();
			break;
		case "2":
			pronadjiKonfPoNazivu();
			break;
		case "3":
			pronadjiKonfCena();
			break;
		case "4":
			pronadjiKonfKolicina();
			break;
		case "0":
			break;
		}
	}

	static void pretragaKategorija() {
		Meniji.podMeniZaPretraguKategorija();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			pronadjiKatPoSifri();
			break;
		case "2":
			pronadjiKatPoNazivu();
			break;
		case "0":
			break;

		}
	}

	static void pretraga() {
		Meniji.podMeniZaPretragu();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			pretragaArtikala();
			break;
		case "2":
			pretragaKomponenti();
			break;
		case "3":
			pretragaGotovihKonfiguracija();
			break;
		case "4":
			pretragaKategorija();
			break;
		case "5":
			ispisiArtikle();
			break;
		case "6":
			ispisiArtikle(false);
			break;
		case "7":
			ispisiArtikle(true);
			break;

		case "0":
			break;
		}
	}

	static void sortiranje() {
		Meniji.podMeniZaSortiranje();
		String odluka = Utility.ocitajTekst();
		switch (odluka) {
		case "1":
			sortiranjeArtikalaPoNazivu(-1);
			break;
		case "2":
			sortiranjeArtikalaPoNazivu(1);
			break;
		case "3":
			sortiranjeArtikalaPoCeni(-1);
			break;
		case "4":
			sortiranjeArtikalaPoCeni(1);
			break;
		case "0":
			break;

		}
	}

	public static ArrayList<Korisnik> getSviKorisnici() {
		return SviKorisnici;
	}

	public static void setSviKorisnici(ArrayList<Korisnik> sviKorisnici) {
		SviKorisnici = sviKorisnici;
	}

	public static ArrayList<KategorijeKomponenti> getSveKategorije() {
		return SveKategorije;
	}

	public static void setSveKategorije(
			ArrayList<KategorijeKomponenti> sveKategorije) {
		SveKategorije = sveKategorije;
	}

	public static ArrayList<ArtikalProdaje> getSviArtikli() {
		return SviArtikli;
	}

	public static void setSviArtikli(ArrayList<ArtikalProdaje> sviArtikli) {
		SviArtikli = sviArtikli;
	}

	public static void main(String[] args) {
		System.out.println("***************************************");
		System.out.println("         PRODAVNICA RACUNARA           ");
		System.out.println("***************************************");
		ocitajSve();
		String odluka = " ";

		Korisnik ulogovanKorisnik = logovanje();
		System.out.println("Dobro dosli "+ ulogovanKorisnik.getIme()+" !!!");
		if (ulogovanKorisnik.getUloga().equalsIgnoreCase("prodavac")) {
			
			while (!odluka.equals("0")) {
				Meniji.pocetniMeniZaProdavce();
				odluka = Utility.ocitajTekst();
				switch (odluka) {
				case "1":
					Unos();
					break;
				case "2":
					izmena();
					break;
				case "3":
					brisanje();
					break;
				case "4":
					pretraga();
					break;
				case "5":
					sortiranje();
					break;
				case "6":

					break;
				case "7":
					sacuvajArtikle();
					sacuvajKategorije();
					break;
				case "8":
					ocitajSve();
					break;
				case "0":
					break;

				}
			}
		}
		if (ulogovanKorisnik.getUloga().equalsIgnoreCase("menadzer")) {
			while (!odluka.equals("0")) {
				Meniji.pocetniMeniZaMenadzera();
				odluka = Utility.ocitajTekst();
				switch (odluka) {
				case "1":
					Unos();
					break;
				case "2":
					izmena();
					break;
				case "3":
					brisanje();
					break;
				case "4":
					pretraga();
					break;
				case "5":
					sortiranje();
					break;
				case "6":

					break;
				case "7":
					sacuvajArtikle();
					sacuvajKategorije();
					break;
				case "8":
					ocitajSve();
					break;
				case "0":
					break;

				}
			}
		}
		sacuvajArtikle();
		sacuvajKategorije();
	}
}