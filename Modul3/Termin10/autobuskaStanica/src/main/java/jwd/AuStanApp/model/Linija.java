package jwd.AuStanApp.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Linija {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private int brojMesta;
	
	@Column
	private double cenaKarte;
	
	@Column
	private String vremePolaska;
	
	@Column
	private String destinacija;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="prevoznik_id")
	private Prevoznik prevoznik;
	
	@OneToMany(mappedBy="linija", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Rezervacija> rezervacije;

	public Linija() {
		super();
	}

	public Linija(int brojMesta, double cenaKarte, String vremePolaska, String destinacija, Prevoznik prevoznik) {
		super();
		this.brojMesta = brojMesta;
		this.cenaKarte = cenaKarte;
		this.vremePolaska = vremePolaska;
		this.destinacija = destinacija;
		this.prevoznik = prevoznik;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Rezervacija> getRezervacije() {
		return rezervacije;
	}

	

	
	public void setRezervacije(List<Rezervacija> rezervacije) {
		
		this.rezervacije = rezervacije;
	}
	
	
	public void addRezervacija(Rezervacija rezervacija) {
		if(rezervacija.getLinija() != this) {
			rezervacija.setLinija(this);
		}
		rezervacije.add(rezervacija);
		//this.brojMesta = this.brojMesta - 1;
	}

	public int getBrojMesta() {
		return brojMesta;
	}

	public void setBrojMesta(int brojMesta) {
		this.brojMesta = brojMesta;
	}

	public double getCenaKarte() {
		return cenaKarte;
	}

	public void setCenaKarte(double cenaKarte) {
		this.cenaKarte = cenaKarte;
	}

	public String getVremePolaska() {
		return vremePolaska;
	}

	public void setVremePolaska(String vremePolaska) {
		this.vremePolaska = vremePolaska;
	}

	public String getDestinacija() {
		return destinacija;
	}

	public void setDestinacija(String destinacija) {
		this.destinacija = destinacija;
	}

	public Prevoznik getPrevoznik() {
		return prevoznik;
	}

	public void setPrevoznik(Prevoznik prevoznik) {
		this.prevoznik = prevoznik;
	}
	
	
}
