package svetskaPrvenstva.UI;

import java.util.List;

import svetskaPrvenstva.dao.PrvenstvoDAO;
import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.Prvenstvo;
import svetskaPrvenstva.utils.PomocnaKlasa;

public class PrvenstvoUI {

	public static void ispisiSve() {
		try {
			List<Prvenstvo> prvenstva = PrvenstvoDAO.getAll();

			System.out.println("==========================================");
			System.out.printf("%-5s %-16s   %-16s", "God", "Naziv", "Domacin SP");
			System.out.println("\n====  =================  =================");
			for (Prvenstvo itPrvenstvo: prvenstva) {
				System.out.printf("%4d  %-16s   %-16s\n", itPrvenstvo.getGodina(), itPrvenstvo.getNaziv(),
						itPrvenstvo.getDomacin().getNaziv());
			}
			System.out.println("==========================================");
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}	
	}

	public static void unos() {
		System.out.print("Godina odrzavanja: ");
		int godina = PomocnaKlasa.ocitajCeoBroj();
		try {
			Prvenstvo pr = PrvenstvoDAO.getByGodina(godina);
			if (pr != null) {
				System.out.println("Svetsko prvenstvo sa tom godinom vec postoji.");
			} else {
				System.out.print("Naziv: ");
				String prNaziv = PomocnaKlasa.ocitajTekst();

				Drzava drDomacin = null;
				while (drDomacin == null) {
					System.out.println("PRIKAZ SVIH DRZAVA:");
					DrzavaUI.ispisiSve();

					System.out.println();
					System.out.println("Unos drzave domacina: ");
					drDomacin = DrzavaUI.pronadji();
				}

				Drzava drOsvajac = null;
				while (drOsvajac == null) {
					System.out.println("PRIKAZ SVIH DRZAVA:");
					DrzavaUI.ispisiSve();

					System.out.println();
					System.out.println("Unos drzave osvajaca: ");
					drOsvajac = DrzavaUI.pronadji();
				}

				pr = new Prvenstvo(godina, prNaziv, drDomacin, drOsvajac);
				PrvenstvoDAO.add(pr);
				System.out.println("Svetsko prvenstvo je uspesno dodato.");
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void izmena() {
		System.out.print("Godina odrzavanja: ");
		int godina = PomocnaKlasa.ocitajCeoBroj();
		try {
			Prvenstvo pr = PrvenstvoDAO.getByGodina(godina);
			if (pr == null) {
				System.out.println("Ne postoji Svetsko prvenstvo sa tom godinom.");
			} else {
				System.out.print("Unesite novi naziv: ");
				String prNaziv = PomocnaKlasa.ocitajTekst();

				Drzava drDomacin = null;
				while (drDomacin == null) {
					System.out.println("PRIKAZ SVIH DRZAVA:");
					DrzavaUI.ispisiSve();

					System.out.println();
					System.out.println("Unos drzave domacina: ");
					drDomacin = DrzavaUI.pronadji();
				}

				Drzava drOsvajac = null;
				while (drOsvajac == null) {
					System.out.println("PRIKAZ SVIH DRZAVA:");
					DrzavaUI.ispisiSve();

					System.out.println();
					System.out.println("Unos drzave osvajaca: ");
					drOsvajac = DrzavaUI.pronadji();
				}

				pr.setNaziv(prNaziv);
				pr.setDomacin(drDomacin);
				pr.setOsvajac(drOsvajac);
				PrvenstvoDAO.update(pr);
				System.out.println("Prvenstvo je uspesno izmenjeno.");
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static Prvenstvo pronadji() {
		System.out.print("Unesi godinu odrzavanja prvenstva: ");
		int godina = PomocnaKlasa.ocitajCeoBroj();
		try {
			Prvenstvo prvenstvo = PrvenstvoDAO.getByGodina(godina);
			if (prvenstvo == null) {
				System.out.println("Prvenstvo sa godinom " + godina + " ne postoji u evidenciji");
			}
			return prvenstvo;
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}

		return null;
	}
	
	public static void ispisiTekstSortiranjeOpcije() {
		System.out.println("Rad sa prvenstvima - opcije:");
		System.out.println("\tOpcija broj 1 - sortiranje prvenstava po nazivu");
		System.out.println("\tOpcija broj 2 - sortiranje prvenstava po godini odrzavanja");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");
	}

	public static void meniSortiranje() {
		ispisiTekstSortiranjeOpcije();
		System.out.print("opcija: ");
		int sortOpcija = PomocnaKlasa.ocitajCeoBroj();
		try {
			switch (sortOpcija) {
				case 0:
					System.out.println("Izlaz");
					break;
				case 1: {
					List<Prvenstvo> prvenstva = PrvenstvoDAO.getAllSortedByNaziv();
	
					System.out.println("==========================================");
					System.out.printf("%-5s %-16s   %-16s", "God", "Naziv", "Domacin SP");
					System.out.println("\n====  =================  =================");
					for (Prvenstvo itPrvenstvo: prvenstva) {
						System.out.printf("%4d  %-16s   %-16s\n", itPrvenstvo.getGodina(), itPrvenstvo.getNaziv(),
								itPrvenstvo.getDomacin().getNaziv());
					}
					System.out.println("==========================================");
					break;
				}
				case 2: {
					List<Prvenstvo> prvenstva = PrvenstvoDAO.getAllSortedByGodina();
	
					System.out.println("==========================================");
					System.out.printf("%-5s %-16s   %-16s", "God", "Naziv", "Domacin SP");
					System.out.println("\n====  =================  =================");
					for (Prvenstvo itPrvenstvo: prvenstva) {
						System.out.printf("%4d  %-16s   %-16s\n", itPrvenstvo.getGodina(), itPrvenstvo.getNaziv(),
								itPrvenstvo.getDomacin().getNaziv());
					}
					System.out.println("==========================================");
					break;
				}
				default:
					break;
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

	public static void pretraga() {
		System.out.println("Unesite naziv za pretragu: ");
		String naziv = PomocnaKlasa.ocitajTekst();
		try {
			List<Prvenstvo> prvenstva = PrvenstvoDAO.getAllByNaziv(naziv);
			
			System.out.println("==========================================");
			System.out.printf("%-5s %-16s   %-16s", "God", "Naziv", "Domacin SP");
			System.out.println("\n====  =================  =================");
			for (Prvenstvo itPrvenstvo: prvenstva) {
				System.out.printf("%4d  %-16s   %-16s\n", itPrvenstvo.getGodina(), itPrvenstvo.getNaziv(),
						itPrvenstvo.getDomacin().getNaziv());
			}
			System.out.println("==========================================");
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}
	
	public static void ispisiTekstOpcije() {	
		System.out.println("Rad sa prvenstvima - opcije:");
		System.out.println("\tOpcija broj 1 - prikaz svih prvenstava");
		System.out.println("\tOpcija broj 2 - unos prvenstva");
		System.out.println("\tOpcija broj 3 - izmena prvenstva");
		System.out.println("\tOpcija broj 4 - sortiranje i prikaz prvenstava");
		System.out.println("\tOpcija broj 5 - pretraga i prikaz svetskih prvenstava");
		System.out.println("\t\t ...");
		System.out.println("\tOpcija broj 0 - IZLAZ");	
	}

	public static void meni() {	
		int odluka = -1;
		while (odluka != 0) {
			ispisiTekstOpcije();
			System.out.print("opcija: ");
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
					meniSortiranje();
					break;
				case 5:
					pretraga();
					break;
				default:
					System.out.println("Nepostojeca komanda");
					break;	
			}
		}
	}

}
