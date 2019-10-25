package com.ftninformatika.vezbe07.webshop.kategorije;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe07.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe07.webshop.model.Kategorija;

@SuppressWarnings("serial")
public class PrikaziKategorijuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			long id = Long.parseLong(request.getParameter("id"));
			// čitanje kategorije iz baze
			Kategorija kategorija = KategorijaDAO.get(id);

			// pripremljeni podaci se smeštaju kao atribut request-a
			request.setAttribute("kategorija", kategorija);
			// request se prosleđuje na PrikaziKategoriju.jsp
			request.getRequestDispatcher("PrikaziKategoriju.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
