package primerNasladjivanjaProdavnicaRacunara.readWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import primerNasladjivanjaProdavnicaRacunara.model.MemorijaRacunara;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class MemorijaFile {

	public static ArrayList<MemorijaRacunara> listaMemorija = new ArrayList<MemorijaRacunara>();
	public static boolean ocitan = false;
	public static void pisiUFajl() {
		try {
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("memorija.txt");
			File obrisiKreirajDatoteka = new File(putanja);
			if (!obrisiKreirajDatoteka.exists())
				obrisiKreirajDatoteka.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(putanja));
			for (MemorijaRacunara memorija : listaMemorija) {
				out.println(memorija.toFile());
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
			listaMemorija.clear();
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("memorija.txt");
			File obrisiKreirajDatoteteka = new File(putanja);
			if (!obrisiKreirajDatoteteka.exists()) {
				System.out.println("Fajl sa podacima ne postoji - memory");
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader(putanja));
			String s;
			while ((s = in.readLine()) != null) {
				MemorijaRacunara memorija = new MemorijaRacunara(s);
				listaMemorija.add(memorija);
			}
			ocitan = true;
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public static MemorijaRacunara pronadjiMemPoSifri(String sifra, boolean trueFalse){
		for (MemorijaRacunara mem : listaMemorija) {
			if(mem.getSifra().equalsIgnoreCase(sifra) && mem.isObrisano() == trueFalse){
				return mem;
			}
			
		}
		return null;
	}
	public static void ispisiMemorije(boolean trueFalse){
		for (MemorijaRacunara mem : listaMemorija) {
			if(mem.isObrisano() == trueFalse){
				System.out.println(mem);
			}
		}
	}
	public static MemorijaRacunara pronadjiMemPoSifri(String sifra){
		for (MemorijaRacunara mem : listaMemorija) {
			if(mem.getSifra().equalsIgnoreCase(sifra)){
				return mem;
			}
			
		}
		return null;
	}

}
