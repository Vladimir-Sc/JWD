package com.ftninformatika.vezbe06.webshop.korisnici;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe06.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class RegistracijaServlet extends HttpServlet {

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
			if (KorisnikDAO.get(korisnickoIme) != null) {
				// neuspešna registracija
				response.sendRedirect("Registracija.html");
				return;
			}

			// kreiranje novog korisnika
			Korisnik korisnik = new Korisnik(korisnickoIme, lozinka);
			// upis korisnika u bazu
			KorisnikDAO.add(korisnik);

			// uspešna registracija
			response.sendRedirect("SviKorisniciServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

}
