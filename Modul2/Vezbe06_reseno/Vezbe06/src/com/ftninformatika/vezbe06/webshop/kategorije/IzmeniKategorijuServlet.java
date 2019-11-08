package com.ftninformatika.vezbe06.webshop.kategorije;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe06.webshop.model.Kategorija;

@SuppressWarnings("serial")
public class IzmeniKategorijuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			long id = Long.parseLong(request.getParameter("id"));
			// čitanje kategorije iz baze
			Kategorija kategorija = KategorijaDAO.get(id);

			// prihvatanje parametara za izmenu
			String naziv = request.getParameter("naziv");
			// provere
			if (naziv.equals("")) {
				// neuspešna izmena
				response.sendRedirect("PrikaziKategorijuServlet?id=" + id);
				return;
			}
			// izmena atributa kategorije
			kategorija.setNaziv(naziv);

			// upis izmena u bazu
			KategorijaDAO.update(kategorija);

			// uspešna izmena
			response.sendRedirect("SveKategorijeServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
