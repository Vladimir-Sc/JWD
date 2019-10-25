package com.ftninformatika.vezbe07.webshop.korpe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftninformatika.vezbe07.webshop.dao.KorpaDAO;
import com.ftninformatika.vezbe07.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class DodajUKorpuServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// čitanje prijavljenog korisnika iz sesije
		HttpSession session = request.getSession();
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("prijavljeniKorisnik");

		// operacije nad korpom zavise od toga da li postoji prijavljeni korisnik
		if (prijavljeniKorisnik == null) {
			response.sendRedirect("Prijava.html");
			return;
		}
		try {
			// prihvatanje liste parametara
			@SuppressWarnings("unchecked")
			List<String> parameters = new ArrayList<String>(request.getParameterMap().keySet());
			// sortiranje parametara u redosledu prirodnih brojeva (ID-eva proizvoda), umesto u alfanumeričkom redosledu
			Collections.sort(parameters, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					return Long.compare(Long.parseLong(o1), Long.parseLong(o2));
				}
				
			});
			// iteracija kroz sve poslate parametre
			for (String proizvodID: parameters) {
				// prihvatanje parametara
				int komada = Integer.parseInt(request.getParameter(proizvodID));
				// provere
				if (komada <= 0) {
					// preskočiti proizvod
					continue;
				}

				// upis nove stavke korpe u bazu
				KorpaDAO.add(prijavljeniKorisnik, Long.parseLong(proizvodID), komada);
			}

			// prelazak na stranicu za prikaz korpe
			response.sendRedirect("PrikaziKorpuServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
