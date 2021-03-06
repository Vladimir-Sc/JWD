package com.ftninformatika.vezbe06.webshop.proizvodi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftninformatika.vezbe06.webshop.dao.ProizvodDAO;
import com.ftninformatika.vezbe06.webshop.model.Korisnik;
import com.ftninformatika.vezbe06.webshop.model.Proizvod;

@SuppressWarnings("serial")
public class SviProizvodiServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// čitanje prijavljenog korisnika iz sesije
		HttpSession session = request.getSession();
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("prijavljeniKorisnik");

		try {
			// čitanje svih proizvoda iz baze
			List<Proizvod> proizvodi = ProizvodDAO.getAll();
			
			// prikaz svih proizvoda (HTML ljustura se nalazi u SviProizvodi.html)
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>Proizvodi</title>\r\n" + 
					"	<style type=\"text/css\">\r\n" + 
					"		input[type=\"text\"] {\r\n" + 
					"			width: 20px\r\n" + 
					"		}\r\n" + 
					"		input[type=\"submit\"] {\r\n" + 
					"			width: 75px\r\n" + 
					"		}\r\n" + 
					"	</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<table border=\"1\">\r\n" + 
					"		<caption>Proizvodi</caption>\r\n" + 
					"		<tr>\r\n" + 
					"			<th>Naziv</th>\r\n" + 
					"			<th>Cena</th>\r\n" + 
					"			<th>Kategorija</th>\r\n"
				);
		if (prijavljeniKorisnik != null) {
			// prikazati kolonu sa za dodavanje u korpu samo ako je korisnik prijavljen
			out.write(
					"			<th></th>\r\n"
				);
		}
			out.write(
					"		</tr>\r\n"
				);
		for (Proizvod itProizvod: proizvodi) {
			out.write(
					"		<tr>\r\n" + 
					"			<td><a href=\"PrikaziProizvodServlet?id=" + itProizvod.getID() + "\">" + itProizvod.getNaziv() + "</a></td>\r\n" + 
					"			<td>" + itProizvod.getCena() + "</td>\r\n" + 
					"			<td><a href=\"PrikaziKategorijuServlet?id=" + itProizvod.getKategorija().getID() + "\">" + itProizvod.getKategorija().getNaziv() +"</a></td>\r\n" 
				);
		if (prijavljeniKorisnik != null) {
			// prikazati kolonu sa za dodavanje u korpu samo ako je korisnik prijavljen
			out.write(
					"			<td>\r\n" + 
					"				<form method=\"post\" action=\"DodajUKorpuServlet\">\r\n" + 
					"					<input type=\"hidden\" name=\"proizvodID\" value=\"" + itProizvod.getID() + "\"/>\r\n" + 
					"					<input type=\"text\" name=\"komada\" value=\"1\"/>\r\n" + 
					"					<input type=\"submit\" value=\"U korpu\"/>\r\n" + 
					"				</form>\r\n" + 
					"			</td>\r\n"
				);
		}
			out.write(
					"		</tr>\r\n"
				);
		}
			out.write(
					"	</table>\r\n" + 
					"	<a href=\"PrikaziDodavanjeProizvodaServlet\">Dodaj proizvod</a><br/>\r\n" + 
					"	<br/>\r\n" + 
					"	<a href=\"PocetnaServlet\">Početna strana</a><br/>\r\n" + 
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
