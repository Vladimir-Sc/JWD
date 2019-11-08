package com.ftninformatika.vezbe06.webshop.korisnici;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ftninformatika.vezbe06.webshop.dao.KorisnikDAO;
import com.ftninformatika.vezbe06.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class SviKorisniciServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int[] intArray2 = (int[])(getServletContext().getAttribute("lista"));
		
		try {
			// Ä�itanje svih korisnika iz baze
			List<Korisnik> korisnici = KorisnikDAO.getAll();

			// prikaz svih korisnika (HTML ljustura se nalazi u SviKorisnici.html)
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>Korisnici</title>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<table border=\"1\">\r\n" + 
					"		<caption>Korisnici</caption>\r\n" + 
					"		<tr><th>KorisniÄ�ko ime</th></tr>\r\n"
				);
		for (Korisnik itKorisnik: korisnici) {
			out.write(
					"		<tr><td><a href=\"PrikaziKorisnikaServlet?korisnickoIme=" + itKorisnik.getKorisnickoIme() + "\">" + itKorisnik.getKorisnickoIme() + "</a></td></tr>\r\n"
				);
		}
			out.write(
					"	</table>\r\n" + 
					"	<a href=\"Registracija.html\">Registracija</a><br/>\r\n" + 
					"	<br/>\r\n" + 
					"	<a href=\"PocetnaServlet\">PoÄ�etna strana</a><br/>\r\n" + 
					"</body>\r\n" + 
					"</html>"
				);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		for (int i=0; i<intArray2.length; i++) {
    		
    		System.out.println(intArray2[i]);
    	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
