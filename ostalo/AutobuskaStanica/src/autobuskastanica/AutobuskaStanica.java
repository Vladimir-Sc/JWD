package autobuskastanica;

import java.util.ArrayList;

public class AutobuskaStanica {
	
	private int idAutStanica;
	private String sedisteAutStanica;
	private ArrayList <Peron> peroni = new ArrayList<Peron>();
	
	public AutobuskaStanica(int idAutStanica, String sedisteAutStanica) {
		this.idAutStanica = idAutStanica;
		this.sedisteAutStanica = sedisteAutStanica;
	}

	public AutobuskaStanica(int idAutStanica, String sedisteAutStanica, ArrayList<Peron> peroni) {
		this.idAutStanica = idAutStanica;
		this.sedisteAutStanica = sedisteAutStanica;
		this.peroni = peroni;
	}

	@Override
	public String toString() {
		
		return "Autobuska stanica "+sedisteAutStanica +"("+idAutStanica+")";
	}
	
	public String toStringSaPeronima() {
		StringBuilder sb = new StringBuilder(toString()+" ima perone:");
		for (int i = 0; i < peroni.size(); i++) {
			sb.append("\t"+(i+1)+". "+peroni.get(i).toString()+"\n");
		}
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAutStanica;
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
		AutobuskaStanica other = (AutobuskaStanica) obj;
		if (idAutStanica != other.idAutStanica)
			return false;
		return true;
	}

	public int getIdAutStanica() {
		return idAutStanica;
	}

	public void setIdAutStanica(int idAutStanica) {
		this.idAutStanica = idAutStanica;
	}

	public String getSedisteAutStanica() {
		return sedisteAutStanica;
	}

	public void setSedisteAutStanica(String sedisteAutStanica) {
		this.sedisteAutStanica = sedisteAutStanica;
	}

	public ArrayList<Peron> getPeroni() {
		return peroni;
	}

	public void setPeroni(ArrayList<Peron> peroni) {
		this.peroni = peroni;
	}
}
