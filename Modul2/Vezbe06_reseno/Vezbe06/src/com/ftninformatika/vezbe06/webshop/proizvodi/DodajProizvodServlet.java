package com.ftninformatika.vezbe06.webshop.proizvodi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe06.webshop.dao.ProizvodDAO;
import com.ftninformatika.vezbe06.webshop.model.Kategorija;
import com.ftninformatika.vezbe06.webshop.model.Proizvod;

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
				response.sendRedirect("PrikaziDodavanjeProizvodaServlet");
				return;
			}
			if (cena <= 0.0) {
				// neuspešno dodavanje
				response.sendRedirect("PrikaziDodavanjeProizvodaServlet");
				return;
			}

			// čitanje kategorije iz baze
			Kategorija kategorija = KategorijaDAO.get(kategorijaID);

			// kreiranje novog proizvoda
			Proizvod proizvod = new Proizvod(0, naziv, cena, kategorija);
			// upis proizvoda u bazu
			ProizvodDAO.add(proizvod);

			// uspešno dodavanje
			response.sendRedirect("SviProizvodiServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

}
