package com.ftninformatika.vezbe09.webshop.kategorije;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe09.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe09.webshop.model.Kategorija;

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
				response.sendRedirect("DodajKategoriju.html");
				return;
			}

			// kreiranje kategorije
			Kategorija kategorija = new Kategorija(0, naziv);
			// upis kategorije u bazu
			KategorijaDAO.add(kategorija);

			// uspešno dodavanje
			response.sendRedirect("SveKategorijeServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
