package autobuskastanica;

import java.util.ArrayList;

public class Prevoznik {
	
	private int idPrevoznik;
	private String nazivPrevoznik;
	private String sedistePrevoznik;
	private ArrayList<Autobus> autobusi = new ArrayList<Autobus>();

	public Prevoznik(int idPrevoznik, String nazivPrevoznik, String sedistePrevoznik) {
		this.idPrevoznik = idPrevoznik;
		this.nazivPrevoznik = nazivPrevoznik;
		this.sedistePrevoznik = sedistePrevoznik;
	}

	public Prevoznik(int idPrevoznik, String nazivPrevoznik, String sedistePrevoznik, ArrayList<Autobus> autobusi) {
		this.idPrevoznik = idPrevoznik;
		this.nazivPrevoznik = nazivPrevoznik;
		this.sedistePrevoznik = sedistePrevoznik;
		this.autobusi = autobusi;
	}
	
	@Override
	public String toString() {
		
		return "Prevoznik "+nazivPrevoznik + " sa sedištem " + sedistePrevoznik +"("+idPrevoznik+")";
	}
	
	public String toStringAll() {
		StringBuilder sb = new StringBuilder(toString());
		if(autobusi!=null)
			for (Autobus a : autobusi) {
				sb.append("\t"+a.toString()+"\n");
			}
		return sb.toString();
	}
	
	public String toStringSaAutobusima() {
		StringBuilder sb = new StringBuilder(toString()+" ima autobuse:");
		for (int i = 0; i < autobusi.size(); i++) {
			sb.append("\t"+(i+1)+". "+autobusi.get(i).toString()+"\n");
		}
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idPrevoznik;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prevoznik other = (Prevoznik) obj;
		if (idPrevoznik != other.idPrevoznik)
			return false;
		return true;
	}

	public int getIdPrevoznik() {
		return idPrevoznik;
	}

	public void setIdPrevoznik(int idPrevoznik) {
		this.idPrevoznik = idPrevoznik;
	}

	public String getNazivPrevoznik() {
		return nazivPrevoznik;
	}

	public void setNazivPrevoznik(String nazivPrevoznik) {
		this.nazivPrevoznik = nazivPrevoznik;
	}

	public String getSedistePrevoznik() {
		return sedistePrevoznik;
	}

	public void setSedistePrevoznik(String sedistePrevoznik) {
		this.sedistePrevoznik = sedistePrevoznik;
	}

	public ArrayList<Autobus> getAutobusi() {
		return autobusi;
	}

	public void setAutobusi(ArrayList<Autobus> autobusi) {
		this.autobusi = autobusi;
	}
}
