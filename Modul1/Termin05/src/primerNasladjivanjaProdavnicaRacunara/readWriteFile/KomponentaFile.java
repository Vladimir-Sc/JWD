package primerNasladjivanjaProdavnicaRacunara.readWriteFile;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import primerNasladjivanjaProdavnicaRacunara.model.Komponenta;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class KomponentaFile {

	public static ArrayList<Komponenta> listaKomponenti = new ArrayList<Komponenta>();
	public static boolean ocitan = false;
	public static void pisiUFajl() {
		try {
			String putanja = Utility.vratiRelativnuPutanjuDoFajla("komponente.txt");
			File obrisiKreirajDatoteka = new File(putanja);
			if (!obrisiKreirajDatoteka.exists())
				obrisiKreirajDatoteka.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(putanja));
			for (Komponenta komp : listaKomponenti) {
				out.println(komp.toFile());
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
			listaKomponenti.clear();
			String putanja = Utility.vratiRelativnuPutanjuDoFajla("komponente.txt");
			File obrisiKreirajDatoteteka = new File(putanja);
			if (!obrisiKreirajDatoteteka.exists()) {
				System.out.println("Fajl sa podacima ne postoji - komp");
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader(putanja));
			String s;
			while ((s = in.readLine()) != null) {
				Komponenta komp = new Komponenta(s);
				listaKomponenti.add(komp);
			}
			ocitan = true;
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public static Komponenta proveraPostojanjaKomponente (String sifraKomp, boolean trueFalse){
		for(Komponenta komp: listaKomponenti){
			if(sifraKomp.equals(komp.getSifra()) && komp.isObrisano() == trueFalse)
				return komp;
		}
		
		return null;
	}
	public static Komponenta proveraPostojanjaKomponente (String sifraKomp){
		for(Komponenta komp: listaKomponenti){
			if(sifraKomp.equals(komp.getSifra()))
				return komp;
		}
		
		return null;
	}
	public static void ispisiKomponente(boolean trueFalse){
		for (Komponenta komp : listaKomponenti) {
			if(komp.isObrisano() == trueFalse){
				System.out.println(komp);
			}
			
		}
	}
	public static ArrayList<Komponenta> pronadjiKompOpsegCene(
			double pocetnaCena, double krajnjaCena) {
		ArrayList<Komponenta> listaKomp = new ArrayList<Komponenta>();
		for (Komponenta komp : listaKomponenti) {
			if (komp.getCena() >= pocetnaCena && komp.getCena() <= krajnjaCena) {
				listaKomp.add(komp);

			}
			if (krajnjaCena <= -1 && komp.getCena() >= pocetnaCena) {
				listaKomp.add(komp);
			}
		}
		return listaKomp;
	}
	
	public static ArrayList<Komponenta> pronadjiKompPoKat(String sifraKategorije){
		ArrayList<Komponenta> listaKomp = new ArrayList<Komponenta>();
		for (Komponenta komponenta : listaKomponenti) {
			if((komponenta.getKategorija().getSifra()).equalsIgnoreCase(sifraKategorije)){
				listaKomp.add(komponenta);
			}
		}
		return listaKomp;
	}
	
	
	public static ArrayList<Komponenta> pronadjiKompOpsegKolicina(
			int pocetnaKolicina, int krajnjaKolicina) {
		ArrayList<Komponenta> kompKolicina = new ArrayList<Komponenta>();
		for (Komponenta komp : listaKomponenti) {
			if (komp.getKolicina() >= pocetnaKolicina
					&& komp.getKolicina() <= krajnjaKolicina) {
				kompKolicina.add(komp);
			}
			if (krajnjaKolicina <= -1 && komp.getKolicina() >= pocetnaKolicina) {
				kompKolicina.add(komp);
			}

		}
		return kompKolicina;
	}
	
	public static ArrayList<Komponenta> pronadjiKompPoNazivu(
			String naziv) {
		ArrayList<Komponenta> komponente = new ArrayList<Komponenta>();
		for (Komponenta komp : listaKomponenti) {
			if ((komp.getNaziv().toLowerCase()).contains(naziv.toLowerCase())) {
				komponente.add(komp);
			}
		}
		return komponente;
	}
}
