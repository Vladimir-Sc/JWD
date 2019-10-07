package raspored.ftn;

import java.util.ArrayList;

public class KatalogTermina {

	ArrayList<Termin> termini = new ArrayList<Termin>();

	public void dodajTermin(Termin termin){
		termini.add(termin);
	}

	public void preklapanjeZauzecaKabineta(){
		System.out.println("U ovim terminima dolazi do preklapanja zauzeca kabineta: " + "\n");
		for(Termin nextTermin : termini){
			for(Termin nextTermin2 : termini){
				if(nextTermin.getDan().equals(nextTermin2.getDan())){
					if(nextTermin.getKabinet().equals(nextTermin2.getKabinet())){
						outerloop:
							for(int i=nextTermin.getPocetnoVreme(); i<nextTermin.getZavrsnoVreme(); i++){			
								for(int j=nextTermin2.getPocetnoVreme(); j<nextTermin2.getZavrsnoVreme(); j++){
									if(i==j){
										if(!nextTermin.equals(nextTermin2)){
											if(nextTermin.getRedniBrojOglasa()<nextTermin2.getRedniBrojOglasa()){
												System.out.println("Kabinet " + nextTermin.getKabinet());
												System.out.println("\t" + nextTermin);
												System.out.println("\t" + nextTermin2);
												System.out.println("");
												break outerloop;
											}
										}
									}
								}
							}
					}
				}
			}
		}
	}

	public void preklapanjeZauzecaNastavnika(){	
		System.out.println("U ovim terminima dolazi do preklapanja predavaca " + "\n");
		for(Termin nextTermin : termini){				
			for(Termin nextTermin2 : termini){
				if(nextTermin.getDan().equals(nextTermin2.getDan())){				
					if(nextTermin.getPredavac().equals(nextTermin2.getPredavac())){
						outerloop:
							for(int i=nextTermin.getPocetnoVreme(); i<nextTermin.getZavrsnoVreme()+15; i++){
								if(nextTermin.getMesto().equals("FTN") && nextTermin2.getMesto().equals("FTN")){
									for(int j=nextTermin2.getPocetnoVreme(); j<nextTermin2.getZavrsnoVreme()+15; j++){
										if(i==j){
											if(!nextTermin.equals(nextTermin2)){
												if(nextTermin.getRedniBrojOglasa()<nextTermin2.getRedniBrojOglasa()){
													System.out.println("Predavac: " + nextTermin.getPredavac());
													System.out.println("\t" + nextTermin);
													System.out.println("\t" + nextTermin2);
													System.out.println("");
													break outerloop;
												}
											}
										}
									}

								}else{
									for(int j=nextTermin2.getPocetnoVreme(); j<nextTermin2.getZavrsnoVreme()+180; j++){
										if(i==j){
											if(!nextTermin.equals(nextTermin2)){
												if(nextTermin.getRedniBrojOglasa()<nextTermin2.getRedniBrojOglasa()){
													System.out.println("Predavac: " + nextTermin.getPredavac());
													System.out.println("\t" + nextTermin);
													System.out.println("\t" + nextTermin2);
													System.out.println("");
													break outerloop;
												}
											}
										}
									}
								}
							}
					}
				}
			}
		}
	}
}
