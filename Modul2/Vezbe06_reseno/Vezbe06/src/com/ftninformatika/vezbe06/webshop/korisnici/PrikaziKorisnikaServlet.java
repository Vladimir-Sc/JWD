package com.ftninformatika.vezbe06.webshop.korisnici;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe06.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class PrikaziKorisnikaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// prihvatanje parametara
		String korisnickoIme = request.getParameter("korisnickoIme");

		try {
			// čitanje korisnika iz baze
			Korisnik korisnik = KorisnikDAO.get(korisnickoIme);
			
			// prikaz korisnika (HTML ljustura se nalazi u PrikaziKorisnika.html)
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
					"	</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<form>\r\n" + 
					"		<table>\r\n" + 
					"			<caption>Korisnik</caption>\r\n" + 
					"			<tr><td>Korisničko ime:</td><td><input type=\"text\" value=\"" + korisnik.getKorisnickoIme() + "\" readonly/></td></tr>\r\n" + 
					"		</table>\r\n" + 
					"	</form>\r\n" + 
					"	<br/>\r\n" + 
					"	<a href=\"SviKorisniciServlet\">Korisnici</a>\r\n" + 
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
