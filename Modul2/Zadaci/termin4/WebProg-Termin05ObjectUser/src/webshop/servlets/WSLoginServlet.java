package webshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webshop.beans.Korisnik;

/**
 * Servlet implementation class WSLoginServlet
 */
public class WSLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
//		Ovo mogu da zakomentarisem ako prethodno ucitam Init Servlet
		ArrayList<Korisnik> korisnici = new ArrayList<Korisnik>();
		korisnici.add(new Korisnik("pera", "peric"));
		korisnici.add(new Korisnik("steva", "stevic"));
		korisnici.add(new Korisnik("jova", "jovic"));
		korisnici.add(new Korisnik("mitar", "miric"));
		korisnici.add(new Korisnik("peka", "peka"));
		getServletContext().setAttribute("korisnici", korisnici);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WSLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pout = response.getWriter();
		
		
//		TO-DO Proveri da li je korisnik vec ulogan, ako jeste ne dozvoliti ponovno logovanje
		
//		TO-DO proveriti da li je uneto bilo sta za korsinicko ime/password


		Korisnik k = new Korisnik(request.getParameter("ime"), request.getParameter("lozinka"));

		if(((ArrayList<Korisnik>)getServletContext().getAttribute("korisnici")).contains(k)){
			request.getSession().setAttribute("logovaniKorisnik", k);		
			response.sendRedirect("WebShopServlet");
			return;
		}
		
		response.sendRedirect("WSLogin.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
