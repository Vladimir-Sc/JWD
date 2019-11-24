package webshop.beans;

public class Korisnik {
	private ShoppingCart shoppingCart;
	public Korisnik(String korisnickoIme, String lozinka) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.setShoppingCart(new ShoppingCart());
	}
	private String korisnickoIme;
	private String lozinka;
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	@Override
	public String toString() {
		return korisnickoIme + ", " + lozinka;
	}
	
	@Override
	public boolean equals(Object arg0) {
		return korisnickoIme.equals(((Korisnik)arg0).getKorisnickoIme())&&lozinka.equals(((Korisnik)arg0).getLozinka());
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
}
