package com.ftninformatika.vezbe08.webshop.korpe;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftninformatika.vezbe08.webshop.dao.KorpaDAO;
import com.ftninformatika.vezbe08.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class IsprazniKorpuServlet extends HttpServlet {

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
			// brisanje svih stavki iz korpe u bazi
			KorpaDAO.clear(prijavljeniKorisnik);

			// prelazak na stranicu za prikaz korpe
			response.sendRedirect("PrikaziKorpuServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
