package com.ftninformatika.vezbe06.webshop.proizvodi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KategorijaDAO;
import com.ftninformatika.vezbe06.webshop.dao.ProizvodDAO;
import com.ftninformatika.vezbe06.webshop.model.Kategorija;
import com.ftninformatika.vezbe06.webshop.model.Proizvod;

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
			
			// prikaz proizvoda (HTML ljustura se nalazi u PrikaziProizvod.html)
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>Proizvod</title>\r\n" + 
					"	<style type=\"text/css\">\r\n" + 
					"		input[type=\"text\"] {\r\n" + 
					"			width: 150px\r\n" + 
					"		}\r\n" + 
					"		input[type=\"submit\"] {\r\n" + 
					"			width: 75px\r\n" + 
					"		}\r\n" + 
					"		option {\r\n" + 
					"			width: 130px\r\n" + 
					"		}\r\n" + 
					"		td.labela {\r\n" + 
					"			width: 75px\r\n" + 
					"		}\r\n" + 
					"	</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<form method=\"post\" action=\"IzmeniProizvodServlet\">\r\n" + 
					"		<input type=\"hidden\" name=\"id\" value=\"" + proizvod.getID() + "\"/>\r\n" + 
					"		<table>\r\n" + 
					"			<caption>Proizvod</caption>\r\n" + 
					"			<tr><td class=\"labela\">Naziv:</td><td><input type=\"text\" name=\"naziv\" value=\"" + proizvod.getNaziv() + "\"/></td></tr>\r\n" + 
					"			<tr><td class=\"labela\">Cena:</td><td><input type=\"text\" name=\"cena\" value=\"" + proizvod.getCena() + "\"/></td></tr>\r\n" + 
					"			<tr>\r\n" + 
					"				<td class=\"labela\">Kategorija:</td>\r\n" + 
					"				<td>\r\n" + 
					"					<select name=\"kategorijaID\">\r\n"
					);
	// dodavanje svih kategorija u select tag
	for (Kategorija itKategorija: kategorije) {
		if (itKategorija.equals(proizvod.getKategorija())) {
			// ako tekuća kategorija odgovara proizvodu, ona biva select-ovana
			out.write(
					"						<option value=\"" + itKategorija.getID() + "\" selected>" + itKategorija.getNaziv() + "</option>\r\n"
				);
		} else {
			out.write(
					"						<option value=\"" + itKategorija.getID() + "\">" + itKategorija.getNaziv() + "</option>\r\n"
				);				
		}

	}
			out.write(
					"					</select>\r\n" + 
					"				</td>\r\n" + 
					"			</tr>\r\n" + 
					"			<tr><td class=\"labela\"></td><td><input type=\"submit\" value=\"Izmeni\"/></td></tr>\r\n" + 
					"		</table>\r\n" + 
					"	</form>\r\n" + 
					"	<form method=\"post\" action=\"ObrisiProizvodServlet\">\r\n" + 
					"		<input type=\"hidden\" name=\"id\" value=\"" + proizvod.getID() + "\"/>\r\n" + 
					"		<table>\r\n" + 
					"			<tr><td class=\"labela\"></td><td><input type=\"submit\" value=\"Obriši\"/></td></tr>\r\n" + 
					"		</table>\r\n" + 
					"	</form>\r\n" + 
					"	<a href=\"SviProizvodiServlet\">Proizvodi</a>\r\n" + 
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
