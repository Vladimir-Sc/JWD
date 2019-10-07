package autobuskastanica;

public class Dogadjaj {
	
	private long idPolazakDolazak; 
	
	private Autobus auto;
	private Peron per;
	private String vreme;
	
	private String destinacija;
	private boolean dolazak;
	
	public Dogadjaj(long idPolazakDolazak, boolean dolazak, String vreme, String destinacija, Autobus auto, Peron per) {
		super();
		this.idPolazakDolazak = idPolazakDolazak;
		this.dolazak = dolazak;
		this.vreme = vreme;
		this.destinacija = destinacija;
		this.auto = auto;
		this.per = per;
	}

	@Override
	public String toString() {
		
		return "Autobus " + auto.getRegBrAutobus() + (dolazak==true?"dolazi iz ":"polazi za ")+
				destinacija + " u vremenu "+vreme + " sa perona "+per.getRedBrPerona()+"("+idPolazakDolazak+")";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idPolazakDolazak ^ (idPolazakDolazak >>> 32));
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
		Dogadjaj other = (Dogadjaj) obj;
		if (idPolazakDolazak != other.idPolazakDolazak)
			return false;
		return true;
	}

	public long getIdPolazakDolazak() {
		return idPolazakDolazak;
	}

	public void setIdPolazakDolazak(long idPolazakDolazak) {
		this.idPolazakDolazak = idPolazakDolazak;
	}

	public boolean isDolazak() {
		return dolazak;
	}

	public void setDolazak(boolean dolazak) {
		this.dolazak = dolazak;
	}

	public String getVreme() {
		return vreme;
	}

	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public Autobus getAuto() {
		return auto;
	}

	public void setAuto(Autobus auto) {
		this.auto = auto;
	}

	public Peron getPer() {
		return per;
	}

	public void setPer(Peron per) {
		this.per = per;
	}
}
