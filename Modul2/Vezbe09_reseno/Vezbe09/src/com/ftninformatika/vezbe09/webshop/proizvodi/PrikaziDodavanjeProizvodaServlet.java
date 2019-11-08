package com.ftninformatika.vezbe09.webshop.proizvodi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe09.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe09.webshop.model.Kategorija;

@SuppressWarnings("serial")
public class PrikaziDodavanjeProizvodaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// čitanje svih kategorija iz baze (da bi se mogle ponuditi za odabir)
			List<Kategorija> kategorije = KategorijaDAO.getAll();

			// pripremljeni podaci se smeštaju kao atribut request-a
			request.setAttribute("kategorije", kategorije);
			// request se prosleđuje na SveKategorije.jsp
			request.getRequestDispatcher("PrikaziDodavanjeProizvoda.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
