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
public class PrikaziKorisnikaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prihvatanje parametara
		String korisnickoIme = request.getParameter("korisnickoIme");

		try {
			// čitanje korisnika iz baze
			Korisnik korisnik = KorisnikDAO.get(korisnickoIme);

			// kreiranje odgovora
			Map<String, Object> odgovor = new LinkedHashMap<>();
			odgovor.put("status", "uspeh");
			odgovor.put("korisnik", korisnik);

			// konverzija odgovora u JSON format
			String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
			System.out.println(jsonOdgovor);
			// slanje odgovora
			response.setContentType("application/json");
			response.getWriter().write(jsonOdgovor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
