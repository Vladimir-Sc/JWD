package autobuskastanica;

import java.util.ArrayList;

public class Autobus {
	
	private String regBrAutobus;
	private Prevoznik prevoznik;
	private TipAutobus tip;
	private ArrayList<Dogadjaj> sviDogadjajiZaAutobus = new ArrayList<Dogadjaj>();
	
	public Autobus(String regBrAutobus, Prevoznik prevoznik, TipAutobus tip) {
		this.regBrAutobus = regBrAutobus;
		this.prevoznik = prevoznik;
		this.tip = tip;
	}
	
	public Autobus(String regBrAutobus, Prevoznik prevoznik, TipAutobus tip,ArrayList<Dogadjaj> sviDogadjajiZaAutobus) {
		this.regBrAutobus = regBrAutobus;
		this.prevoznik = prevoznik;
		this.tip = tip;
		this.sviDogadjajiZaAutobus = sviDogadjajiZaAutobus;
	}

	@Override
	public String toString() {
		return "Autobus "+regBrAutobus +" je "+tip.getNazivTipAutobus();
	}
	
	public String toStringAllDogadjaji() {
		StringBuilder sb = new StringBuilder(toString());
		if(sviDogadjajiZaAutobus!=null)
			for (int i = 0; i < sviDogadjajiZaAutobus.size(); i++) {
				sb.append("\t"+(i+1)+". "+sviDogadjajiZaAutobus.get(i).toString()+"\n");
			}
		return sb.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((regBrAutobus == null) ? 0 : regBrAutobus.hashCode());
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
		Autobus other = (Autobus) obj;
		if (regBrAutobus == null) {
			if (other.regBrAutobus != null)
				return false;
		} else if (!regBrAutobus.equals(other.regBrAutobus))
			return false;
		return true;
	}

	public String getRegBrAutobus() {
		return regBrAutobus;
	}

	public void setRegBrAutobus(String regBrAutobus) {
		this.regBrAutobus = regBrAutobus;
	}

	public Prevoznik getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}

	public TipAutobus getTip() {
		return tip;
	}

	public void setTip(TipAutobus tip) {
		this.tip = tip;
	}

	public ArrayList<Dogadjaj> getSviDogadjajiZaAutobus() {
		return sviDogadjajiZaAutobus;
	}

	public void setSviDogadjajiZaAutobus(ArrayList<Dogadjaj> sviDogadjajiZaAutobus) {
		this.sviDogadjajiZaAutobus = sviDogadjajiZaAutobus;
	}
}
