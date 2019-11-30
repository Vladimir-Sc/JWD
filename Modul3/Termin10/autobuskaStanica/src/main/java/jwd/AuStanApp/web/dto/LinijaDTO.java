package jwd.AuStanApp.web.dto;


public class LinijaDTO {
	
	private Long id;
	
	private int brojMesta;
	
	private double cenaKarte;
	
	
	private String vremePolaska;
	
	
	private String destinacija;
	
	
	private Long prevoznikId;


	public LinijaDTO() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public Long getPrevoznikId() {
		return prevoznikId;
	}


	public void setPrevoznikId(Long prevoznikId) {
		this.prevoznikId = prevoznikId;
	}
	
	
	

}
