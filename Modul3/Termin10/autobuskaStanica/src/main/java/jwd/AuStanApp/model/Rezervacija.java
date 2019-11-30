package jwd.AuStanApp.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Rezervacija {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Linija linija;

	public Rezervacija() {
		super();
	}
	
	

	public Rezervacija(Linija linija) {
		super();
		this.linija = linija;
	}



	public Linija getLinija() {
		return linija;
	}

	public void setLinija(Linija linija) {
		this.linija = linija;
		if(!linija.getRezervacije().contains(this)){
			linija.getRezervacije().add(this);
		}
	}
	
}
