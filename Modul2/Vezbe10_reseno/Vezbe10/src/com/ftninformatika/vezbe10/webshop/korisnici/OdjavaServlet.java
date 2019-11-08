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

@SuppressWarnings("serial")
public class OdjavaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dalja komunikacija sa istim korisnikom će se započeti u novoj sesiji
		HttpSession session = request.getSession();
		session.invalidate();

		// odjava je uvek uspešna
		// uspešna prijava
		Map<String, Object> odgovor = new LinkedHashMap<>();
		odgovor.put("status", "uspeh");

		// konverzija odgovora u JSON format
		String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
		System.out.println(jsonOdgovor);
		// slanje odgovora
		response.setContentType("application/json");
		response.getWriter().write(jsonOdgovor);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
