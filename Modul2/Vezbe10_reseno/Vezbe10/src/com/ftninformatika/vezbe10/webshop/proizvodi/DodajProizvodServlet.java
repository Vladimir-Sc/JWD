package com.ftninformatika.vezbe10.webshop.proizvodi;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftninformatika.vezbe10.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe10.webshop.dao.ProizvodDAO;
import com.ftninformatika.vezbe10.webshop.model.Kategorija;
import com.ftninformatika.vezbe10.webshop.model.Proizvod;

@SuppressWarnings("serial")
public class DodajProizvodServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			String naziv = request.getParameter("naziv");
			double cena = Double.parseDouble(request.getParameter("cena"));
			long kategorijaID = Long.parseLong(request.getParameter("kategorijaID"));

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
			if (cena <= 0.0) {
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

			// čitanje kategorije iz baze
			Kategorija kategorija = KategorijaDAO.get(kategorijaID);

			// kreiranje novog proizvoda
			Proizvod proizvod = new Proizvod(0, naziv, cena, kategorija);
			// upis proizvoda u bazu
			ProizvodDAO.add(proizvod);

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
