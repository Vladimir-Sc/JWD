package com.ftninformatika.vezbe06.webshop.proizvodi;

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
public class PrikaziDodavanjeProizvodaServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// čitanje svih kategorija iz baze (da bi se mogle ponuditi za odabir)
			List<Kategorija> kategorije = KategorijaDAO.getAll();

			// HTML ljustura se nalazi u PrikaziDodavanjeProizvoda.html
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>Dodavanje proizvoda</title>\r\n" + 
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
					"	</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<form method=\"post\" action=\"DodajProizvodServlet\">\r\n" + 
					"		<table>\r\n" + 
					"			<caption>Dodavanje proizvoda</caption>\r\n" + 
					"			<tr><td>Naziv:</td><td><input type=\"text\" name=\"naziv\"/></td></tr>\r\n" + 
					"			<tr><td>Cena:</td><td><input type=\"text\" name=\"cena\"/></td></tr>\r\n" + 
					"			<tr>\r\n" + 
					"				<td>Kategorija:</td>\r\n" + 
					"				<td>\r\n" + 
					"					<select name=\"kategorijaID\">\r\n"
				);
			for (Kategorija itKategorija: kategorije) {
				out.write(
					"						<option value=\"" + itKategorija.getID() + "\">" + itKategorija.getNaziv() + "</option>\r\n"
				);
			}
				out.write(
					"					</select>\r\n" + 
					"				</td>\r\n" + 
					"			</tr>\r\n" + 
					"			<tr><td></td><td><input type=\"submit\" value=\"Dodaj\"/></td></tr>\r\n" + 
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
