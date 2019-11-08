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
public class IzmeniKategorijuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			long id = Long.parseLong(request.getParameter("id"));
			// čitanje kategorije iz baze
			Kategorija kategorija = KategorijaDAO.get(id);

			// prihvatanje parametara za izmenu
			String naziv = request.getParameter("naziv");
			// provere
			if (naziv.equals("")) {
				// neuspešna izmena
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
			// izmena atributa kategorije
			kategorija.setNaziv(naziv);

			// upis izmena u bazu
			KategorijaDAO.update(kategorija);

			// uspešna izmena
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
