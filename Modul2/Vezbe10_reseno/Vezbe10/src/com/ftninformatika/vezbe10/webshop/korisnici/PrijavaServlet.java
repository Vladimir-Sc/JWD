package com.ftninformatika.vezbe10.webshop.korisnici;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftninformatika.vezbe10.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe10.webshop.model.Korisnik;

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
				Map<String, Object> odgovor = new LinkedHashMap<>();
				odgovor.put("status", "neuspeh");

				// konverzija odgovora u JSON format
				String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
				System.out.println(jsonOdgovor);
				// slanje odgovora
				response.setContentType("application/json");
				response.getWriter().write(jsonOdgovor);

				return;
			}

			// pamćenje korisnika u sesiji
			HttpSession session = request.getSession();
			session.setAttribute("prijavljeniKorisnik", korisnik);

			// uspešna prijava
			Map<String, Object> odgovor = new LinkedHashMap<>();
			odgovor.put("status", "uspeh");

			// konverzija odgovora u JSON format
			ObjectMapper mapper = new ObjectMapper();
			String jsonOdgovor = mapper.writeValueAsString(odgovor);
			System.out.println(jsonOdgovor);
			// slanje odgovora
			response.setContentType("application/json");
			response.getWriter().write(jsonOdgovor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
