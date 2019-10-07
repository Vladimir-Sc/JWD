package svetskaPrvenstva.UI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import svetskaPrvenstva.dao.DrzavaDAO;
import svetskaPrvenstva.dao.PrvenstvoDAO;
import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.Prvenstvo;
import svetskaPrvenstva.utils.PomocnaKlasa;

public class DrzavaUI {

	public static void ispisiSve() {
		try {
			List<Drzava> drzave = DrzavaDAO.getAll();

			System.out.println("=================");
			System.out.printf("%-16s", "Drzava");
			System.out.println("\n=================");
			for (Drzava itDrzava: drzave) {
				System.out.printf("%-16s\n", itDrzava.getNaziv());
			}
			System.out.println("=================");
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}	
	}

	public static void unos() {
		System.out.print("Naziv: ");
		String naziv = PomocnaKlasa.ocitajTekst();
		try {
			Drzava dr = DrzavaDAO.getByNaziv(naziv);
			if (dr != null) {
				System.out.println("Drzava sa tim nazivom vec postoji.");
			} else {
				dr = new Drzava(naziv);
				DrzavaDAO.add(dr);
				System.out.println("Drzava je uspesno dodata.");
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}	
	}

	public static void izmena() {
		Drzava dr = pronadji();
		if (dr != null) {
			System.out.print("Unesite novi naziv: ");
			String naziv = PomocnaKlasa.ocitajTekst();

			dr.setNaziv(naziv);
			try {
				DrzavaDAO.update(dr);
				System.out.println("Drzava je uspeno izmenjena.");
			} catch (Exception ex) {
				System.out.println("Greska u radu sa bazom!");
	
				ex.printStackTrace();
			}	
		}
	}
	
	public static Drzava pronadji() {
		System.out.print("Unesi naziv drzave: ");
		String naziv = PomocnaKlasa.ocitajTekst();
		try {
			Drzava drzava = DrzavaDAO.getByNaziv(naziv);
			if (drzava == null) {
				System.out.println("Drzava sa nazivom " + naziv + " ne postoji u evidenciji");
			}
			return drzava;
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		return null;
	}

	public static void statistika() {
		try {
			List<Drzava> drzave = DrzavaDAO.getAll();
	
			Map<Integer, Integer> brojDomacin = new HashMap<>();
			Map<Integer, Integer> brojOsvajac = new HashMap<>();	
			for (Drzava dr : drzave) {
				brojDomacin.put(dr.getID(), 0);
				brojOsvajac.put(dr.getID(), 0);
			}
			
			System.out.println("UNESITE OPSEG GODINA");
			System.out.print("Donja granica godina: ");
			int donjaGr = PomocnaKlasa.ocitajCeoBroj();
			System.out.print("Gornja granica godina: ");
			int gornjaGr = PomocnaKlasa.ocitajCeoBroj();
	
			List<Prvenstvo> prvUOpsegu = PrvenstvoDAO.getAllByGodina(donjaGr, gornjaGr);
			for (Prvenstvo itPrvenstvo: prvUOpsegu) {
				int sifraDomacina = itPrvenstvo.getDomacin().getID();
				int sifraOsvajaca = itPrvenstvo.getOsvajac().getID();
	
				int brojD = brojDomacin.get(sifraDomacina);
				brojD++;
				brojDomacin.put(sifraDomacina, brojD);
	
				int brojO = brojOsvajac.get(sifraOsvajaca);
				brojO++;
				brojOsvajac.put(sifraOsvajaca, brojO);
			}
	
			System.out.println("================================================");
			System.out.printf("%-16s   %10s  %10s", "Drzava", "Domacin", "Osvajac");
			System.out.println("\n=================  ==========  ==========");
			
			for (Drzava itDrzava: drzave) {
				int dom = brojDomacin.get(itDrzava.getID());
				int osv = brojOsvajac.get(itDrzava.getID());
				System.out.printf("%-16s   %10s  %10s\n", itDrzava.getNaziv(),
						dom == 0 ? "" : dom,
						osv == 0 ? "" : osv);
			}
	
			System.out.println("================================================");
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}	
	}

	private static void ispisiTekstOpcije() {	
		System.out.println("Rad sa drzavama - opcije: ");
		System.out.println("\tOpcija broj 1 - prikaz svih drzava");
		System.out.println("\tOpcija broj 2 - unos drzave");
		System.out.println("\tOpcija broj 3 - izmena drzave");
		System.out.println("\tOpcija broj 4 - statisticki prikaz drzava za odredjeni period");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}

	public static void meni() {	
		int odluka = -1;
		while (odluka != 0) {
			ispisiTekstOpcije();
			System.out.print("opcija:");
			odluka = PomocnaKlasa.ocitajCeoBroj();
			switch (odluka) {
				case 0:
					System.out.println("Izlaz");	
					break;
				case 1:
					ispisiSve();
					break;
				case 2:
					unos();
					break;
				case 3:
					izmena();
					break;
				case 4:
					statistika();
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;	
			}
		}
	}

}
