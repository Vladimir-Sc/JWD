package webshop.beans;

import java.util.ArrayList;

/**
 * Reperezentuje korpu za kupovinu. Sadrzi vektor stavki (uredjeni par
 * (proizvod, kolicina)).
 */
public class ShoppingCart {
	
	private ArrayList<ShoppingCartItem> items;

	public ShoppingCart() {
		items = new ArrayList<ShoppingCartItem>();
	}

	public void addItem(Product product, int count) {
		items.add(new ShoppingCartItem(product, count));
	}
	
	
//	Brisanje na osnovu id List
	public void removeItem(int idListe) {
		items.remove(idListe);
	}
	

	
	public ArrayList<ShoppingCartItem> getItems() {
		return items;
	}
}
