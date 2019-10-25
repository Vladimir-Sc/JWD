package com.ftninformatika.vezbe07.webshop.proizvodi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe07.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe07.webshop.dao.ProizvodDAO;
import com.ftninformatika.vezbe07.webshop.model.Kategorija;
import com.ftninformatika.vezbe07.webshop.model.Proizvod;

@SuppressWarnings("serial")
public class IzmeniProizvodServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			long id = Long.parseLong(request.getParameter("id"));
			// čitanje proizvoda iz baze
			Proizvod proizvod = ProizvodDAO.get(id);

			// prihvatanje parametara za izmenu
			String naziv = request.getParameter("naziv");
			double cena = Double.parseDouble(request.getParameter("cena"));
			long kategorijaID = Long.parseLong(request.getParameter("kategorijaID"));
			// provere
			if (naziv.equals("")) {
				// neuspešna izmena
				response.sendRedirect("PrikaziProizvodServlet?id=" + id);
				return;
			}
			if (cena <= 0.0) {
				// neuspešna izmena
				response.sendRedirect("PrikaziProizvodServlet?id=" + id);
				return;
			}

			// čitanje kategorije iz baze
			Kategorija kategorija = KategorijaDAO.get(kategorijaID);

			// izmena atributa proizvoda
			proizvod.setNaziv(naziv);
			proizvod.setCena(cena);
			proizvod.setKategorija(kategorija);
			// upis izmena u bazu
			ProizvodDAO.update(proizvod);

			// uspešna izmena
			response.sendRedirect("SviProizvodiServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}	
	}

}
