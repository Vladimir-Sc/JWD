package com.ftninformatika.vezbe06.webshop.kategorije;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe06.webshop.model.Kategorija;

@SuppressWarnings("serial")
public class SveKategorijeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// čitanje svih kategorija iz baze
			List<Kategorija> kategorije = KategorijaDAO.getAll();

			// prikaz svih kategorija (HTML ljustura se nalazi u SveKategorije.html)
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>Kategorije</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<table border=\"1\">\r\n" + 
					"		<caption>Kategorije</caption>\r\n" + 
					"		<tr><th>naziv</th></tr>\r\n"
				);
		for (Kategorija itKategorija: kategorije) {
			out.write(
					"		<tr><td><a href=\"PrikaziKategorijuServlet?id=" + itKategorija.getID() + "\">" + itKategorija.getNaziv() + "</a></td></tr>\r\n"
				);
		}
			out.write(
					"	</table>\r\n" + 
					"	<a href=\"DodajKategoriju.html\">Dodaj kategoriju</a><br/>\r\n" + 
					"	<br/>\r\n" + 
					"	<a href=\"PocetnaServlet\">Početna strana</a>\r\n" + 
					"</body>\r\n" + 
					"</html>"
				);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
