package Servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.User;

@SuppressWarnings("serial")
public class Registracija extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prihvatanje parametara
		String korisnickoIme = request.getParameter("korisnickoIme");
		String lozinka = request.getParameter("lozinka");
		String ponovljenaLozinka = request.getParameter("ponovljenaLozinka");

		try {
			// provere
			if (!korisnickoIme.matches("^[a-zA-Z0-9]+$")) {
				// neuspešna registracija
				response.sendRedirect("Registracija.html");
				return;
			}
			if (!lozinka.equals(ponovljenaLozinka)) {
				// neuspešna registracija
				response.sendRedirect("Registracija.html");
				return;
			}
			if (UserDAO.get(korisnickoIme) != null) {
				// neuspešna registracija
				response.sendRedirect("Registracija.html");
				return;
			}

			// kreiranje novog korisnika
			User korisnik = new User(korisnickoIme, lozinka);
			// upis korisnika u bazu
			UserDAO.add(korisnik);

			// uspešna registracija
			response.sendRedirect("index.html");
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

}