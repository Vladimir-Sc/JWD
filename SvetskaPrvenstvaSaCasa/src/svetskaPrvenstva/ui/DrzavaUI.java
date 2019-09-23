package svetskaPrvenstva.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.SvetskoPrvenstvo;
import svetskaPrvenstva.utility.PomocnaKlasa;
import svetskaPrvenstva.utility.StatistikaDrzava;

public class DrzavaUI {
	
	private static Map<String,Drzava> drzave=
			new HashMap<String, Drzava>();
	
	public static void ucitaj() {
		BufferedReader in =  null;
		try {
			in = new BufferedReader(new FileReader("data" + File.separator + "drzave.csv"));

			String linija = in.readLine();
			while (linija != null) {
				String[] tokeni = linija.split(",");
				
				drzave.put(tokeni[0], new Drzava(tokeni[0]));
				
				linija = in.readLine();
			}
			in.close();
		} catch (Exception ex) {
			System.out.println("Greska u ucitavanju drzava!");
		} finally {
			try {in.close();} catch (Exception ex) {}
		}
	}

	public static Drzava getByNaziv(String naziv) {
		return drzave.get(naziv);
	}
	
	public static void prikazSvihDrzava() {
		System.out.println("Prikaz svih drzava");
		for(Drzava d:drzave.values())
		{
			System.out.println(d.getNaziv());
		}
	}

	public static void statistika() {
		System.out.println("Unesite pocetnu vrednost godine");
		int od=PomocnaKlasa.ocitajCeoBroj();
		System.out.println("Unesite krajnju vrednosti godine");
		int doo=PomocnaKlasa.ocitajCeoBroj();
		
		
		Map<String, StatistikaDrzava> statistika=
				new HashMap<String, StatistikaDrzava>();
		for(Drzava d:drzave.values())
		{
			StatistikaDrzava sd=statistika.get(d.getNaziv());
			if(sd==null)
			{
				sd=new StatistikaDrzava(d.getNaziv(), 0,0);
				statistika.put(d.getNaziv(), sd);
			}
			for(SvetskoPrvenstvo sp:SvetskoPrvenstvoUI.getPrvenstva())
			{
				if(sp.getGodina()>od&&sp.getGodina()<doo)
				{
					if(sp.getDomacin().getNaziv().equals(d.getNaziv()))
					{
						sd.setDomacin(sd.getDomacin()+1);
					}
					if(sp.getOsvajac().getNaziv().equals(d.getNaziv()))
					{
						sd.setOsvajac(sd.getOsvajac()+1);
					}
				}
			}
		}
		System.out.printf("%-10s %-10s %-10s %-10s\n","Rd.br.",
				"Naziv","Domacin","Osvajac");
		int rdBr=0;
		for(StatistikaDrzava sd:statistika.values()) {
			String domacin="";
			if(sd.getDomacin()>0)
				domacin=Integer.toString(sd.getDomacin());
			System.out.printf("%-10s %-10s %-10s %-10s\n",
					++rdBr,
			sd.getDrzava(),
			domacin,
			sd.getOsvajac()>0?sd.getOsvajac():"");
			
		}
	}
	
}
