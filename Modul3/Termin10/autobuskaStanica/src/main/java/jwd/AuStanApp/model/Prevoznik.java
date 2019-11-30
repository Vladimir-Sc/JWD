package jwd.AuStanApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Prevoznik {
	
	@Id
	@GeneratedValue
	private Long Id;
	
	@Column
	private String naziv;
	
	@Column
	private String adresa;
	
	@Column
	private String PIB;

	public Prevoznik() {
		super();
	}

	public Prevoznik(String naziv, String adresa, String pIB) {
		super();
		this.naziv = naziv;
		this.adresa = adresa;
		PIB = pIB;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getPIB() {
		return PIB;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}
	
	
	
}
