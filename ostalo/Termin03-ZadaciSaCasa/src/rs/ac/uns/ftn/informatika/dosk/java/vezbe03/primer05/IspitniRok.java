package rs.ac.uns.ftn.informatika.dosk.java.vezbe03.primer05;

import java.util.ArrayList;

public class IspitniRok {
	
	protected int id;
	protected String naziv;
	protected String pocetak;
	protected String kraj;
	//ispitne prijave u isputnom roku
//	protected ArrayList<IspitnaPrijava> ispitnePrijave = new ArrayList<IspitnaPrijava>();

	public IspitniRok(int id, String naziv, String pocetak, String kraj) {
		this.id = id;
		this.naziv = naziv;
		this.pocetak = pocetak;
		this.kraj = kraj;
	}
	
	public IspitniRok(String tekst){
		String [] tokeni = tekst.split(",");
		//npr. 		1,Januarski,2015-01-15,2015-01-29
		//tokeni 	0		1		2		3		
		
		if(tokeni.length!=4){
			System.out.println("Gre\u0161ka pri o\u010Ditavanju ispitnog roka "+tekst);
			//izlazak iz aplikacije
			System.exit(0);
		}
		
		id = Integer.parseInt(tokeni[0]);
		naziv = tokeni[1];
		pocetak = tokeni[2];
		kraj = tokeni[3];
	}
	
	//metode
	public String vratiTekstualnuReprezentacijuZaIspis() {
		String ispis = "Ispitni rok sa id " + id + " \u010Diji je naziv " 
				+ naziv + " odr\u017Eava se " + pocetak + " do " + kraj;
		return ispis;
	}
	
	public String vratiTekstualnuReprezentacijuZaIspisAll() {
		StringBuilder sb = new StringBuilder("Ispitni rok sa id " + id + "\u010Diji je naziv " 
				+ naziv + " odr\u017Eava se " + pocetak + " do " + kraj);
		
//		if(ispitnePrijave != null){
//			sb.append(" i poha\u0111a predmete\n");
//			for (int i = 0; i < ispitnePrijave.size(); i++) {
//				sb.append("\t"+ispitnePrijave.get(i).toString()+"\n");
//			}
//		}
		return sb.toString();
	}

	//dva objekta su ista ako imaju isti id
	public boolean isti(IspitniRok obj) {
		boolean isti = false;
		if(id==obj.id)
			isti = true;
		return isti;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getPocetak() {
		return pocetak;
	}

	public void setPocetak(String pocetak) {
		this.pocetak = pocetak;
	}

	public String getKraj() {
		return kraj;
	}

	public void setKraj(String kraj) {
		this.kraj = kraj;
	}

//	public ArrayList<IspitnaPrijava> getIspitnePrijave() {
//		return ispitnePrijave;
//	}
//
//	public void setIspitnePrijave(ArrayList<IspitnaPrijava> ispitnePrijave) {
//		this.ispitnePrijave = ispitnePrijave;
//	}
}
