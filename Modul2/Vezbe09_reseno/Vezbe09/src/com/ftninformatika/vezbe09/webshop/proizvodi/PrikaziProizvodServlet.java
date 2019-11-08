package com.ftninformatika.vezbe09.webshop.proizvodi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe09.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe09.webshop.dao.ProizvodDAO;
import com.ftninformatika.vezbe09.webshop.model.Kategorija;
import com.ftninformatika.vezbe09.webshop.model.Proizvod;

@SuppressWarnings("serial")
public class PrikaziProizvodServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			long id = Long.parseLong(request.getParameter("id"));
			// čitanje svih proizvoda iz baze
			Proizvod proizvod = ProizvodDAO.get(id);

			// čitanje svih kategorija iz baze (da bi se mogle ponuditi za izmenu)
			List<Kategorija> kategorije = KategorijaDAO.getAll();

			// pripremljeni podaci se smeštaju kao atribut request-a
			request.setAttribute("proizvod", proizvod);
			request.setAttribute("kategorije", kategorije);
			// request se prosleđuje na PrikaziProizvod.jsp
			request.getRequestDispatcher("PrikaziProizvod.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
