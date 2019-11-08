package com.ftninformatika.vezbe10.webshop;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ftninformatika.vezbe10.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class PocetnaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// čitanje prijavljenog korisnika iz sesije
		HttpSession session = request.getSession();
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("prijavljeniKorisnik");

		// kreiranje odgovora
		Map<String, Object> odgovor = new LinkedHashMap<>();
		odgovor.put("status", "uspeh");
		odgovor.put("prijavljen", prijavljeniKorisnik != null);

		// konverzija odgovora u JSON format
		String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
		System.out.println(jsonOdgovor);
		// slanje odgovora
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().write(jsonOdgovor);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
