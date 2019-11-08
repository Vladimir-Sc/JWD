package Servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class Prijava
 */
public class Prijava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prihvatanje parametara
		String korisnickoIme = request.getParameter("korisnickoIme");
		String lozinka = request.getParameter("lozinka");

		try {
			// Ä�itanje korisnika iz baze
			User korisnik = UserDAO.get(korisnickoIme, lozinka);
			if (korisnik == null) {
				// neuspeÅ¡na prijava
				response.sendRedirect("prijava.html");
				return;
			}

			// pamÄ‡enje korisnika u sesiji
			HttpSession session = request.getSession();
			session.setAttribute("prijavljeniKorisnik", korisnik);

			// uspeÅ¡na prijava
			response.sendRedirect("index.html");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
