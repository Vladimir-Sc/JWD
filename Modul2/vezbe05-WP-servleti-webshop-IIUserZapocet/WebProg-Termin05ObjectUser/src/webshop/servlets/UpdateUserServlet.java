package webshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webshop.beans.Korisnik;

/**
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("logovaniKorisnik") == null){
			response.sendRedirect("WSLogin.html");
			return;
		}
//		TO-DO Dodati proveru da li su polja za update popunjena
		


			String oldUsername = request.getParameter("orginalIme");
			String username = request.getParameter("updateIme");
			String passworrd = request.getParameter("updatePassword");

			response.setContentType("text/html");
			PrintWriter pout = response.getWriter();

			ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>)getServletContext().getAttribute("korisnici");

			for (Korisnik k : korisnici ) {
//		TO-DO 		Dodati proveru i za stari password
//			TO-DO 	Porveriti da li je update passwrod/username bas od logovanog korisnika
//				!!! Samo Admin bi trebalo da moze da menja sve usernameove
				if (k.getKorisnickoIme().equals(oldUsername)) {
					k.setKorisnickoIme(username);
					k.setLozinka(passworrd);
					pout.println("<p>korisniku " + oldUsername + " je username promenjen na " + username  + "</p>");
					pout.println("<a href=\"PrikazUsera\">ListAllUsers</a>");
					break;
				}
			}
			
//			Dodaj adekvatan ispis ako ne postoji korisnik sa zadatim username za update
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
