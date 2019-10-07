package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.SvetskoPrvenstvo;
import svetskaPrvenstva.utility.SvetstkoPrvenstvoPoGodini;

public class SvetskoPrvenstvoUI {
	private static Map<Integer, SvetskoPrvenstvo> prvenstva=
			new HashMap<Integer, SvetskoPrvenstvo>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "prvenstva.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");

				int godina=Integer.parseInt(tokeni[1]);
				Drzava domacin=DrzavaUI.getByNaziv(tokeni[2]);
				Drzava osvajac=DrzavaUI.getByNaziv(tokeni[3]);
				prvenstva.put(godina, new SvetskoPrvenstvo(godina, tokeni[0], osvajac, domacin));
				linija = in.readLine();
			}
			in.close();
		} catch (Exception ex) {
			System.out.println("Greska u ucitavanju prvenstava!");
		} finally {
			try {in.close();} catch (Exception ex) {}
		}
	}

	public static SvetskoPrvenstvo getByGodina(int godina) {
		return prvenstva.get(godina);
	}
	
	public static void prikazSvihPrvenstavaSaDrzavama() {
		for(SvetskoPrvenstvo sp:prvenstva.values()) {
			System.out.println(sp.getGodina()+" "+sp.getNaziv()+
					" "+sp.getDomacin().getNaziv()+ " "
					+sp.getOsvajac().getNaziv());
		}
	}

	public static void unosPrvenstva() {
		
	}

	public static void izmenaPrvenstva() {
		
	}

	public static void sortiranjePrvenstavaPoNazivu() {
		
	}

	public static void sortiranjePrvenstavaPoGodini() {
		List<SvetskoPrvenstvo> pomocna=
				new ArrayList<SvetskoPrvenstvo>(prvenstva.values());
		Collections.sort(pomocna, new SvetstkoPrvenstvoPoGodini());
		ispisPrvenstava(pomocna);
	}

	private static void ispisPrvenstava(List<SvetskoPrvenstvo> prvenstva) {
		for(SvetskoPrvenstvo sp:prvenstva)
		{
			System.out.println(sp.getGodina()+" "+sp.getNaziv()+
					" "+sp.getDomacin().getNaziv()+
					" "+sp.getOsvajac().getNaziv());
		}
	}
	
	public static Collection< SvetskoPrvenstvo> getPrvenstva() {
		return prvenstva.values();
	}
	

}
