package jwd.wafepaAPP.model;

public class Activity {
	
	private Long id; //moze da ima null vrednost, signalizira da ne postoji taj objekat jos uvek
	private String naziv;
	
	
	public Activity() {
		super();
	}

	public Activity(String naziv) {
		super();
		this.naziv = naziv;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	
	
}


//Servis za entitet Activity ce imati samo CRUD operacije
