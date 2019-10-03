package primerNasladjivanjaProdavnicaRacunara.readWriteFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import primerNasladjivanjaProdavnicaRacunara.model.Procesor;
import primerNasladjivanjaProdavnicaRacunara.util.Utility;

public class ProcesorFile {
	public static ArrayList<Procesor> listaProcesora = new ArrayList<Procesor>();
	public static boolean ocitan = false;
	public static void pisiUFajl() {
		try {
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("procesori.txt");
			File obrisiKreirajDatoteka = new File(putanja);
			if (!obrisiKreirajDatoteka.exists())
				obrisiKreirajDatoteka.createNewFile();
			PrintWriter out = new PrintWriter(new FileWriter(putanja));
			for (Procesor procesor : listaProcesora) {
				out.println(procesor.toFile());
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
			listaProcesora.clear();
			String putanja = Utility
					.vratiRelativnuPutanjuDoFajla("procesori.txt");
			File obrisiKreirajDatoteteka = new File(putanja);
			if (!obrisiKreirajDatoteteka.exists()) {
				System.out.println("Fajl sa podacima ne postoji - procesor");
				return;
			}
			BufferedReader in = new BufferedReader(new FileReader(putanja));
			String s;
			while ((s = in.readLine()) != null) {
				Procesor procesor = new Procesor(s);
				listaProcesora.add(procesor);
			}
			ocitan = true;
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static Procesor pronadjiProcesorPoSifri(String sifra,
			boolean trueFalse) {
		for (Procesor proc : listaProcesora) {
			if (proc.isObrisano() == trueFalse
					&& proc.getSifra().equalsIgnoreCase(sifra)) {
				return proc;
			}

		}
		return null;
	}

	public static void ispisProcesora(boolean trueFalse) {
		for (Procesor proc : listaProcesora) {
			if (proc.isObrisano() == trueFalse) {
				System.out.println(proc);
			}

		}
	}

	public static Procesor pronadjiProcesorPoSifri(String sifra) {
		for (Procesor proc : listaProcesora) {
			if (proc.getSifra().equalsIgnoreCase(sifra)) {
				return proc;
			}

		}
		return null;
	}

}
