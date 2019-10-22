package com.ftninformatika.vezbe06.webshop.kategorije;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe06.webshop.model.Kategorija;

@SuppressWarnings("serial")
public class PrikaziKategorijuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// prihvatanje parametara
			long id = Long.parseLong(request.getParameter("id"));
			// čitanje kategorije iz baze
			Kategorija kategorija = KategorijaDAO.get(id);

			// prikaz kategorije (HTML ljustura se nalazi u PrikaziKategoriju.html)
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>Kategorija</title>\r\n" + 
					"	<style type=\"text/css\">\r\n" + 
					"		input[type=\"text\"] {\r\n" + 
					"			width: 150px\r\n" + 
					"		}\r\n" + 
					"		input[type=\"submit\"] {\r\n" + 
					"			width: 75px\r\n" + 
					"		}\r\n" + 
					"		td.labela {\r\n" + 
					"			width: 50px\r\n" + 
					"		}\r\n" + 
					"	</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<form method=\"post\" action=\"IzmeniKategorijuServlet\">\r\n" + 
					"		<input type=\"hidden\" name=\"id\" value=\"" + kategorija.getID() + "\"/>\r\n" + 
					"		<table>\r\n" + 
					"			<caption>Kategorija</caption>\r\n" + 
					"			<tr><td class=\"labela\">Naziv:</td><td><input type=\"text\" name=\"naziv\" value=\"" + kategorija.getNaziv() + "\"/></td></tr>\r\n" + 
					"			<tr><td class=\"labela\"></td><td><input type=\"submit\" value=\"Izmeni\"/></td></tr>\r\n" + 
					"		</table>\r\n" + 
					"	</form>\r\n" + 
					"	<form method=\"post\" action=\"ObrisiKategorijuServlet\">\r\n" + 
					"		<input type=\"hidden\" name=\"id\" value=\"" + kategorija.getID() + "\"/>\r\n" + 
					"		<table>\r\n" + 
					"			<tr><td class=\"labela\"></td><td><input type=\"submit\" value=\"Obriši\"/></td></tr>\r\n" + 
					"		</table>\r\n" + 
					"	</form>\r\n" + 
					"	<a href=\"SveKategorijeServlet\">Kategorije</a>\r\n" + 
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
