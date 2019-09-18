package primerNasladjivanjaProdavnicaRacunara.readWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import primerNasladjivanjaProdavnicaRacunara.model.GotovaKonfiguracija;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class GotovaKonfiguracijaFile {
	public static ArrayList<GotovaKonfiguracija> listaGotovihKonfiguracija = new ArrayList<GotovaKonfiguracija>();
	public static boolean ocitan = false;
	public static void pisiUFajl() {
		try {
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("gotoveKonfiguracije.txt");
			File obrisiKreirajDatoteka = new File(putanja);
			if (!obrisiKreirajDatoteka.exists())
				obrisiKreirajDatoteka.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(putanja));
			for (GotovaKonfiguracija konf : listaGotovihKonfiguracija) {
				out.println(konf.toFile());
			}
			out.flush();
			out.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void citajIzFajla() {
		if(ocitan){
			return;
		}
		try {
			listaGotovihKonfiguracija.clear();
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("gotoveKonfiguracije.txt");
			File obrisiKreirajDatoteteka = new File(putanja);
			if (!obrisiKreirajDatoteteka.exists()) {
				System.out.println("Fajl sa podacima ne postoji- konf");
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader(putanja));
			String s;
			while ((s = in.readLine()) != null) {
				GotovaKonfiguracija konf = new GotovaKonfiguracija(s);
				listaGotovihKonfiguracija.add(konf);
			}
			ocitan = true;
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void ispisiKonf(boolean trueFalse) {
		for (GotovaKonfiguracija konf : listaGotovihKonfiguracija) {
			if (konf.isObrisano() == trueFalse) {
				System.out.println(konf);
			}

		}
	}

	public static GotovaKonfiguracija pronadjiKonfPoSifri(String sifra,
			boolean trueFalse) {
		for (GotovaKonfiguracija konf : listaGotovihKonfiguracija) {
			if (konf.getSifra().equalsIgnoreCase(sifra)
					&& konf.isObrisano() == trueFalse) {
				return konf;
			}

		}
		return null;
	}

	public static ArrayList<GotovaKonfiguracija> pronadjiKonfOpsegCene(
			double pocetnaCena, double krajnjaCena) {
		ArrayList<GotovaKonfiguracija> listaKonf = new ArrayList<GotovaKonfiguracija>();
		for (GotovaKonfiguracija konf : listaGotovihKonfiguracija) {
			if (konf.getCena() >= pocetnaCena && konf.getCena() <= krajnjaCena) {
				listaKonf.add(konf);

			}
			if (krajnjaCena <= -1 && konf.getCena() >= pocetnaCena) {
				listaKonf.add(konf);
			}
		}
		return listaKonf;
	}

	public static ArrayList<GotovaKonfiguracija> pronadjiKonfOpsegKolicina(
			int pocetnaKolicina, int krajnjaKolicina) {
		ArrayList<GotovaKonfiguracija> konfKolicina = new ArrayList<GotovaKonfiguracija>();
		for (GotovaKonfiguracija konf : listaGotovihKonfiguracija) {
			if (konf.getKolicina() >= pocetnaKolicina
					&& konf.getKolicina() <= krajnjaKolicina) {
				konfKolicina.add(konf);
			}
			if (krajnjaKolicina <= -1 && konf.getKolicina() >= pocetnaKolicina) {
				konfKolicina.add(konf);
			}

		}
		return konfKolicina;
	}

	public static ArrayList<GotovaKonfiguracija> pronadjiKonfPoNazivu(
			String naziv) {
		ArrayList<GotovaKonfiguracija> konfiguracije = new ArrayList<GotovaKonfiguracija>();
		for (GotovaKonfiguracija konf : listaGotovihKonfiguracija) {
			if ((konf.getNaziv().toLowerCase()).contains(naziv.toLowerCase())) {
				konfiguracije.add(konf);
			}
		}
		return konfiguracije;
	}

	public static GotovaKonfiguracija proveraPostojanjaGKonfiguracije(
			String sifraKonf) {
		for (GotovaKonfiguracija konf : listaGotovihKonfiguracija) {
			if (sifraKonf.equals(konf.getSifra()))
				return konf;

		}
		return null;

	}
}
