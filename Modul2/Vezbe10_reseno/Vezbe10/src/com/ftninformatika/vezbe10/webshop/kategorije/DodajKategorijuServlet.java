package com.ftninformatika.vezbe10.webshop.kategorije;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftninformatika.vezbe10.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe10.webshop.model.Kategorija;

@SuppressWarnings("serial")
public class DodajKategorijuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prihvatanje parametara
		String naziv = request.getParameter("naziv");

		try {
			// provere
			if (naziv.equals("")) {
				// neuspešno dodavanje
				// kreiranje odgovora
				Map<String, Object> odgovor = new LinkedHashMap<>();
				odgovor.put("status", "neuspeh");

				// konverzija odgovora u JSON format
				String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
				System.out.println(jsonOdgovor);
				// slanje odgovora
				response.setContentType("application/json; charset=UTF-8");
				response.getWriter().write(jsonOdgovor);

				return;
			}

			// kreiranje kategorije
			Kategorija kategorija = new Kategorija(0, naziv);
			// upis kategorije u bazu
			KategorijaDAO.add(kategorija);

			// uspešno dodavanje
			// kreiranje odgovora
			Map<String, Object> odgovor = new LinkedHashMap<>();
			odgovor.put("status", "uspeh");

			// konverzija odgovora u JSON format
			String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
			System.out.println(jsonOdgovor);
			// slanje odgovora
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write(jsonOdgovor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
