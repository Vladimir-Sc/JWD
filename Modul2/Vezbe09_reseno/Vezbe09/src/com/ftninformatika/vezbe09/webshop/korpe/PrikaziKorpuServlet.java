package com.ftninformatika.vezbe09.webshop.korpe;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftninformatika.vezbe09.webshop.dao.KorpaDAO;
import com.ftninformatika.vezbe09.webshop.model.Korisnik;
import com.ftninformatika.vezbe09.webshop.model.Korpa;

@SuppressWarnings("serial")
public class PrikaziKorpuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// čitanje prijavljenog korisnika iz sesije
		HttpSession session = request.getSession();
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("prijavljeniKorisnik");

		// operacije nad korpom zavise od toga da li postoji prijavljeni korisnik
		if (prijavljeniKorisnik == null) {
			response.sendRedirect("Prijava.html");
			return;
		}
		try {
			// čitanje korpe iz baze
			Korpa korpa = KorpaDAO.get(prijavljeniKorisnik);

			// pripremljeni podaci se smeštaju kao atribut request-a
			request.setAttribute("korpa", korpa);
			// request se prosleđuje na PrikaziKorpu.jsp
			request.getRequestDispatcher("PrikaziKorpu.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
