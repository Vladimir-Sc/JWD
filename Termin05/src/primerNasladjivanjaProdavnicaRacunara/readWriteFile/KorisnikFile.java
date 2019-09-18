package primerNasladjivanjaProdavnicaRacunara.readWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import primerNasladjivanjaProdavnicaRacunara.model.Korisnik;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class KorisnikFile {

	public static ArrayList<Korisnik> sviKorisnici = new ArrayList<Korisnik>();
	public static boolean ocitan = false;
	public static void pisiUFajl() {
		try {
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("korisnici.txt");
			File obrisiKreirajDatoteka = new File(putanja);
			if (!obrisiKreirajDatoteka.exists())
				obrisiKreirajDatoteka.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(putanja));
			for (Korisnik korisnik : sviKorisnici) {
				out.println(korisnik.toFile());
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
			sviKorisnici.clear();
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("korisnici.txt");
			File obrisiKreirajDatoteteka = new File(putanja);
			if (!obrisiKreirajDatoteteka.exists()) {
				System.out.println("Fajl sa podacima ne postoji - korisnik");
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader(putanja));
			String s;
			while ((s = in.readLine()) != null) {
				Korisnik korisnik = new Korisnik(s);
				sviKorisnici.add(korisnik);
			}
			ocitan = true;
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static Korisnik proveraPostojanjaKorisnika(String korisnickoIme) {
		for (Korisnik korisnik : sviKorisnici) {
			if (korisnickoIme.equals(korisnik.getKorisnickoIme())) {
				return korisnik;
			}

		}
		return null;
	}
	public static Korisnik proveraPostojanjaKorisnika(String korisnickoIme, String sifra) {
		for (Korisnik korisnik : sviKorisnici) {
			if (korisnickoIme.equals(korisnik.getKorisnickoIme()) && sifra.equals(korisnik.getLozinka())) {
				return korisnik;
			}

		}
		return null;
	}

}
