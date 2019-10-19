package webshop.servlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import webshop.beans.Product;
import webshop.beans.Products;

/**
 * Osnovni servlet koji lista raspolozive proizvode i omogucuje njihovo
 * dodavanje u korpu.
 */
public class WebShopServlet extends HttpServlet {

	private static final long serialVersionUID = 6593194247788949676L;
	

	/**
	 * Atribut se dodaje u application scope, da bi se video iz klase ShoppingCartServlet.
	 */
	private Products products;

	/*
	 * Obratiti paznju da se metod init() zove samo jednom, prilikom prvo pokretanja (inicijalziacije)
	 * servleta.
	 * => Ukoliko bismo u products.txt dodali novi proizvod, bez restartovanja web servera, a prethodno
	 * je servlet vec bio pokrenut, novi proizvod se nece biti procitan.
	 */
	@Override
	public void init(ServletConfig cfg) {
		try {
			// obavezan poziv super metode, kako bi se korektno izvrsila inicijalizacija
			super.init(cfg);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		ServletContext ctx = getServletContext();
		products = new Products(ctx.getRealPath(""));
		ctx.setAttribute("products", products);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if(request.getSession().getAttribute("logovaniKorisnik") == null){
			response.sendRedirect("WSLogin.html");
			return;
		}
		
		// TO-DO Onemoguciti kesiranje ovog servleta
		
		PrintWriter pout = response.getWriter();

		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.print("prijavljen je korisnik: " + request.getSession().getAttribute("logovaniKorisnik")+"<br/>");
		pout.println("Raspolozivi proizvodi:");
		
		pout.println("<table border=\"1\"><tr bgcolor=\"lightgrey\"><th>Naziv</th><th>Cena</th><th>&nbsp;</th></tr>");
		for ( Product p : products.values() ) {
			pout.println("<tr>");
			pout.println("<form method=\"get\" action=\"ShoppingCartServlet\">");
			pout.println("<td>" + p.getName() + "</td>");
			pout.println("<td>" + p.getPrice() + "</td>");
			pout.println("<td>");
			pout.println("<input type=\"text\" size=\"3\" name=\"itemCount\">");
			pout.println("<input type=\"hidden\" name=\"itemId\" value=\"" + p.getId() + "\">");
			pout.println("<input type=\"submit\" value=\"Dodaj\">");
			pout.println("</td>");
			pout.println("</form>");
			pout.println("</tr>");
		}
		pout.println("</table>");

		pout.println("<p>");
		pout.println("<a href=\"ShoppingCartServlet\">Pregled sadrzaja korpe</a>");
		pout.println("<a href=\"LogOut\">Logout</a>");
		// TO-DO Dodati putanju ka pocetnoj stranici
		pout.println("</p>");

		pout.println("<p>");
		pout.println("<a href=\"PrikazUsera\">Pregled postojecih</a>");
		pout.println("</p>");
		
		pout.println("</body>");
		pout.println("</html>");
	}
}