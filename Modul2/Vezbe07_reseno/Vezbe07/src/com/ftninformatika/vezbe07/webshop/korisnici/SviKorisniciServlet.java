package com.ftninformatika.vezbe07.webshop.korisnici;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe07.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe07.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class SviKorisniciServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// čitanje svih korisnika iz baze
			List<Korisnik> korisnici = KorisnikDAO.getAll();
			
			// pripremljeni podaci se smeštaju kao atribut request-a
			request.setAttribute("korisnici", korisnici);
			// request se prosleđuje na SviKorisnici.jsp
			request.getRequestDispatcher("SviKorisnici.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
