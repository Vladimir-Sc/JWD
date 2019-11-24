package servlet1;

import javax.servlet.http.*;
import java.io.*;

import servlet1.webshop.*;

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
		// zasto ovako ne valja?
		// obratiti paznju na prirodu http protokola, koji je stateless
		// ShoppingCart sc = new ShoppingCart();

		// pogledamo da li u tekucoj sesiji postoji objekat ShoppingCart
		HttpSession session = request.getSession();
		User us = (User) session.getAttribute("user");
		if (us==null) {
			response.sendRedirect("login.html");
			return;
		}	
		ShoppingCart sc = us.getSc();
//		ShoppingCart sc = (ShoppingCart) session.getAttribute(SHOPPING_CART_KEY);
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
		pout.println("Ulogovani korsnik je:" + us.toString()+ "<br/>");
		pout.println("Proizvodi u korpi:");
		pout.println("<table><tr bgcolor=\"lightgrey\"><th>Naziv</th><th>Jedinicna cena</th><th>Komada</th><th>Ukupna cena</th></tr>");
		double total = 0;
		for ( ShoppingCartItem i : sc.getItems() ) {
			pout.println("<tr>");
			pout.println("<td>" + i.getProduct().getName() + "</td>");
			pout.println("<td>" + i.getProduct().getPrice() + "</td>");
			pout.println("<td>" + i.getCount() + "</td>");
			double price = i.getProduct().getPrice() * i.getCount();
			pout.println("<td>" + price + "</td>");
			pout.println("</tr>");
			total += price;
		}
		pout.println("</table>");

		pout.println("<p>");
		pout.println("Ukupno: " + total + " dinara.");
		pout.println("</p>");

		pout.println("<p>");
		pout.println("<a href=\"WebShopServlet\">Povratak</a>");
		pout.println("</p>");

		pout.println("</body>");
		pout.println("</html>");
	}
}
