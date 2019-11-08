package com.ftninformatika.vezbe10.webshop.korisnici;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftninformatika.vezbe10.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe10.webshop.model.Korisnik;

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
				Map<String, Object> odgovor = new LinkedHashMap<>();
				odgovor.put("status", "neuspeh");

				String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
				System.out.println(jsonOdgovor);
				response.setContentType("application/json");
				response.getWriter().write(jsonOdgovor);
				//response.sendRedirect("Registracija.html");
				return;
			}
			if (!lozinka.equals(ponovljenaLozinka)) {
				// neuspešna registracija
				Map<String, Object> odgovor = new LinkedHashMap<>();
				odgovor.put("status", "neuspeh");

				String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
				System.out.println(jsonOdgovor);
				response.setContentType("application/json");
				response.getWriter().write(jsonOdgovor);
				//response.sendRedirect("Registracija.html");
				return;
			}
			if (KorisnikDAO.get(korisnickoIme) != null) {
				// neuspešna registracija
				Map<String, Object> odgovor = new LinkedHashMap<>();
				odgovor.put("status", "neuspeh");

				String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
				System.out.println(jsonOdgovor);
				response.setContentType("application/json");
				response.getWriter().write(jsonOdgovor);

				return;
			}

			// kreiranje novog korisnika
			Korisnik korisnik = new Korisnik(korisnickoIme, lozinka);
			// upis korisnika u bazu
			KorisnikDAO.add(korisnik);

			// uspešna registracija
			Map<String, Object> odgovor = new LinkedHashMap<>();
			odgovor.put("status", "uspeh");

			String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
			System.out.println(jsonOdgovor);
			response.setContentType("application/json");
			response.getWriter().write(jsonOdgovor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}		
	}

}
