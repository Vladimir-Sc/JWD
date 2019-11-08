package com.ftninformatika.vezbe09.webshop.korisnici;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe09.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe09.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class PrikaziKorisnikaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prihvatanje parametara
		String korisnickoIme = request.getParameter("korisnickoIme");

		try {
			// čitanje korisnika iz baze
			Korisnik korisnik = KorisnikDAO.get(korisnickoIme);

			// pripremljeni podaci se smeštaju kao atribut request-a
			request.setAttribute("korisnik", korisnik);
			// request se prosleđuje na PrikaziKorisnika.jsp
			request.getRequestDispatcher("PrikaziKorisnika.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
