package primerNasladjivanjaProdavnicaRacunara.readWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import primerNasladjivanjaProdavnicaRacunara.model.KategorijeKomponenti;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class KategorijaKompFile {
	public static ArrayList<KategorijeKomponenti> listaKategorijaKomponenti = new ArrayList<KategorijeKomponenti>();
	public static boolean ocitan = false;
	public static void pisiUFajl() {
		try {
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("kategorija.txt");
			File obrisiKreirajDatoteka = new File(putanja);
			if (!obrisiKreirajDatoteka.exists())
				obrisiKreirajDatoteka.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(putanja));
			for (KategorijeKomponenti kat : listaKategorijaKomponenti) {
				out.println(kat.toFile());
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
			listaKategorijaKomponenti.clear();
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("kategorija.txt");
			File obrisiKreirajDatoteteka = new File(putanja);
			if (!obrisiKreirajDatoteteka.exists()) {
				System.out.println("Fajl sa podacima ne postoji - kat");
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader(putanja));
			String s;
			while ((s = in.readLine()) != null) {
				KategorijeKomponenti komp = new KategorijeKomponenti(s);
				listaKategorijaKomponenti.add(komp);
			}
			ocitan = true;
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static KategorijeKomponenti proveraKategorije(String sifraKat, boolean trueFalse) {
		for (KategorijeKomponenti kat : listaKategorijaKomponenti) {
			if (sifraKat.equalsIgnoreCase(kat.getSifra()) && kat.isObrisano() == trueFalse)
				return kat;
		}
		return null;
	}
	public static void ispisiKategorije(boolean trueFalse){
		for (KategorijeKomponenti kat : listaKategorijaKomponenti) {
			if(kat.isObrisano() == trueFalse){
				System.out.println(kat);
			}
		}
	}
	public static KategorijeKomponenti proveraKategorije(String sifraKat) {
		for (KategorijeKomponenti kat : listaKategorijaKomponenti) {
			if (sifraKat.equalsIgnoreCase(kat.getSifra()))
				return kat;
		}
		return null;
	}

}
