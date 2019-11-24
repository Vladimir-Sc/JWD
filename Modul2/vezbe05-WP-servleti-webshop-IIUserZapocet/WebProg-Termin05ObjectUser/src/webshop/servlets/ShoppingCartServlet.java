package webshop.servlets;

import javax.servlet.http.*;
import java.io.*;

import webshop.beans.Korisnik;
import webshop.beans.Products;
import webshop.beans.ShoppingCart;
import webshop.beans.ShoppingCartItem;

/**
 * Klasa koja obavlja listanje stavki u korpi, a ako je pozvana iz forme, dodaje
 * jednu stavku u korpu, pa onda lista).
 */
public class ShoppingCartServlet extends HttpServlet {

	private static final long serialVersionUID = -8628509500586512294L;

	private static final String SHOPPING_CART_KEY = "ShoppingCart";
	
	// zasto ovako ne valja?
	// obratiti paznju na prirodu http protokola, koji je stateless
	// private ShoppingCart sc = new ShoppingCart();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(request.getSession().getAttribute("logovaniKorisnik") == null ){
			System.out.println("korisnik je: " + request.getSession().getAttribute("logovaniKorisnik"));
			response.sendRedirect("WSLogin.html");
			return;
		}
		
		// TO-DO Onemoguciti kesiranje ovog servleta

		// zasto ovako ne valja?
		// obratiti paznju na prirodu http protokola, koji je stateless
		// ShoppingCart sc = new ShoppingCart();

		// pogledamo da li u tekucoj sesiji postoji objekat ShoppingCart
		HttpSession session = request.getSession();
		
//		Moze ova dva reda umsto jednog ako je jasnije
//		Korisnik k = (Korisnik)session.getAttribute("logovaniKorisnik");
//		ShoppingCart sc = k.getShoppingCart();
		
		ShoppingCart sc = ((Korisnik)session.getAttribute("logovaniKorisnik")).getShoppingCart();
//		if ( sc == null ) {
//			// ako ne postoji, kreiramo ga i dodelimo tekucoj sesiji. Na ovaj
//			// nacin, objekat klase ShoppingCart ce pratiti sesiju.
//			sc = new ShoppingCart();
//			session.setAttribute(SHOPPING_CART_KEY, sc);
//		}

		response.setContentType("text/html");
		
		PrintWriter pout = response.getWriter();
		
		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.print("prijavljen je korisnik: " + request.getSession().getAttribute("logovaniKorisnik")+"<br/>");
		
		if ( request.getParameter("itemId") != null ) {
			// ako smo pozvali ovaj servlet sa parametrima za dodavanje proizvoda u korpu
			try {
				Products products = (Products) getServletContext().getAttribute("products");
				// probamo da ga dodamo
				sc.addItem(products.getProduct(request.getParameter("itemId")),
						Integer.parseInt(request.getParameter("itemCount")));
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		if ( request.getParameter("itemIdDelete") != null ) {
			// ako smo pozvali ovaj servlet sa parametrima za dodavanje proizvoda u korpu
			try {
				Products products = (Products) getServletContext().getAttribute("products");
				
//				Prosledjujem id iz liste
				sc.removeItem(Integer.parseInt(request.getParameter("itemIdDelete")));

			
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		pout.println("Proizvodi u korpi:");
		pout.println("<table><tr bgcolor=\"lightgrey\"><th>Naziv</th><th>Jedinicna cena</th><th>Komada</th><th>Ukupna cena</th><th>Akcije</th></tr>");
		double total = 0;
//		pomocna promenljiva kao index liste
		int idListe = 0;
		for ( ShoppingCartItem i : sc.getItems() ) {
			pout.println("<tr>");
			pout.println("<td>" + i.getProduct().getName() + "</td>");
			pout.println("<td>" + i.getProduct().getPrice() + "</td>");
			pout.println("<td>" + i.getCount() + "</td>");
			double price = i.getProduct().getPrice() * i.getCount();
			pout.println("<td>" + price + "</td>");
			
//			indeks iz liste kao parametar GET ZAHTEVA iz adrese linka
			pout.println("<td>" + "<a href=\"ShoppingCartServlet?itemIdDelete=" + idListe + "\" >delete</a>" + "</td>");
			idListe ++;

			//TO-DO Pokusajte da odradite brisanje preko Posebnog servleta DeleteSCItemServlet
			//TO-DO Pokusajte da odradite brisanje na osnovu id ShoppingCartItem.java - U ovu klasu je neophodno dodati atribut i adekvatnu
//			programsku logiku
			
			pout.println("</tr>");
			pout.println("</form>");
			total += price;
		}
		pout.println("</table>");

		pout.println("<p>");
		pout.println("Ukupno: " + total + " dinara.");
		pout.println("</p>");

		pout.println("<p>");
		pout.println("<a href=\"WebShopServlet\">Povratak</a>");
		// TO-DO Dodati putanju ka pocetnoj stranici
		// TO-DO Dodati putanju ka Logout
		pout.println("</p>");

		pout.println("</body>");
		pout.println("</html>");
	}
}
