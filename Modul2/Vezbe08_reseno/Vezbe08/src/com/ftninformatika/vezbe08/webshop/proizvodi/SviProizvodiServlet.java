package com.ftninformatika.vezbe08.webshop.proizvodi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe08.webshop.dao.ProizvodDAO;
import com.ftninformatika.vezbe08.webshop.model.Proizvod;

@SuppressWarnings("serial")
public class SviProizvodiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// čitanje svih proizvoda iz baze
			List<Proizvod> proizvodi = ProizvodDAO.getAll();
			
			// pripremljeni podaci se smeštaju kao atribut request-a
			request.setAttribute("proizvodi", proizvodi);
			// request se prosleđuje na SviProizvodi.jsp
			request.getRequestDispatcher("SviProizvodi.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
