package servlet1;

import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

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
		
		
		HttpSession  session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		if (user == null) {
			
			System.out.println("korisnik nije logovan na sistem ");
			response.sendRedirect("login.html");
			return;
		}
		
		
		// zasto ovako ne valja?
		// obratiti paznju na prirodu http protokola, koji je stateless
		// ShoppingCart sc = new ShoppingCart();

		// pogledamo da li u tekucoj sesiji postoji objekat ShoppingCart
		// HttpSession session = request.getSession();
		
	
		
		
//		ShoppingCart sc = (ShoppingCart) session.getAttribute(SHOPPING_CART_KEY);
//		if ( sc == null ) {
//			// ako ne postoji, kreiramo ga i dodelimo tekucoj sesiji. Na ovaj
//			// nacin, objekat klase ShoppingCart ce pratiti sesiju.
//			sc = new ShoppingCart();
//			session.setAttribute(SHOPPING_CART_KEY, sc);
//		}
		
		//postoji user postoji i korpa

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
				user.getSc().addItem(products.getProduct(request.getParameter("itemId")), //user vec ima sc pa uzimamo iz usera
						Integer.parseInt(request.getParameter("itemCount")));
				
				ArrayList<ShoppingCartItem> korpa = user.getSc().getItems();
				//int h = korpa.size();
				session.setAttribute("korpa", korpa);
				//ArrayList<ShoppingCartItem> korpa2 = (ArrayList<ShoppingCartItem>) session.getAttribute("korpa");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		pout.println("Proizvodi u korpi:");
		pout.println("<table><tr bgcolor=\"lightgrey\"><th>Naziv</th><th>Jedinicna cena</th><th>Komada</th><th>Ukupna cena</th>"
				+ "<th>Ukloni stavku</th></tr>");
		double total = 0;
		//for ( ShoppingCartItem i : user.getSc().getItems() ) {
		ArrayList<ShoppingCartItem> korpa = (ArrayList<ShoppingCartItem>) session.getAttribute("korpa");
		for (int i=0; i < korpa.size(); i++) {	
			pout.println("<tr>");
			pout.println("<form method=\"get\" action=\"UkloniServlet\">");
			pout.println("<td>" + korpa.get(i).getProduct().getName() + "</td>");
			pout.println("<td>" + korpa.get(i).getProduct().getPrice() + "</td>");
			pout.println("<td>" + korpa.get(i).getCount() + "</td>");
			double price = korpa.get(i).getProduct().getPrice() * korpa.get(i).getCount();
			pout.println("<td>" + price + "</td>");
			pout.println("<td align=\"center\">");
			pout.println("<input type=\"hidden\" name=\"scItem\" value=\"" + i + "\">");
			pout.println("<input type=\"submit\" value=\"X\">");
			pout.println("</form>");
			pout.println("</td>");
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
