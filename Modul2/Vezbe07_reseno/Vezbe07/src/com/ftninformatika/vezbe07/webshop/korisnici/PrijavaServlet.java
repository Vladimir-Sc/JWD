package com.ftninformatika.vezbe07.webshop.korisnici;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftninformatika.vezbe07.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe07.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class PrijavaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prihvatanje parametara
		String korisnickoIme = request.getParameter("korisnickoIme");
		String lozinka = request.getParameter("lozinka");

		try {
			// čitanje korisnika iz baze
			Korisnik korisnik = KorisnikDAO.get(korisnickoIme, lozinka);
			if (korisnik == null) {
				// neuspešna prijava
				response.sendRedirect("Prijava.html");
				return;
			}

			// pamćenje korisnika u sesiji
			HttpSession session = request.getSession();
			session.setAttribute("prijavljeniKorisnik", korisnik);

			// uspešna prijava
			response.sendRedirect("PocetnaServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
