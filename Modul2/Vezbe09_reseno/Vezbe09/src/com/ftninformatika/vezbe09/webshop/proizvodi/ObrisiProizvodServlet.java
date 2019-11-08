package com.ftninformatika.vezbe09.webshop.proizvodi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe09.webshop.dao.ProizvodDAO;

@SuppressWarnings("serial")
public class ObrisiProizvodServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			long id = Long.parseLong(request.getParameter("id"));
			// brisanje proizvoda iz baze
			ProizvodDAO.delete(id);

			// prelaz na stranicu za prikaz svih proizvoda
			response.sendRedirect("SviProizvodiServlet");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
