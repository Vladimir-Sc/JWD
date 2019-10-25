package com.ftninformatika.vezbe06.webshop.korpe;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftninformatika.vezbe06.webshop.dao.KorpaDAO;
import com.ftninformatika.vezbe06.webshop.model.Korisnik;
import com.ftninformatika.vezbe06.webshop.model.Korpa;
import com.ftninformatika.vezbe06.webshop.model.Stavka;

@SuppressWarnings("serial")
public class PrikaziKorpuServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// čitanje prijavljenog korisnika iz sesije
		HttpSession session = request.getSession();
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("prijavljeniKorisnik");

		// operacije nad korpom zavise od toga da li postoji prijavljeni korisnik
		if (prijavljeniKorisnik == null) {
			response.sendRedirect("Prijava.html");
			return;
		}
		try {
			// čitanje korpe iz baze
			Korpa korpa = KorpaDAO.get(prijavljeniKorisnik);

			// prikaz korpe (HTML ljustura se nalazi u PrikaziKorpu.html)
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(
					"<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"	<meta charset=\"UTF-8\">\r\n" + 
					"	<title>Korpa</title>\r\n" + 
					"	<style type=\"text/css\">\r\n" + 
					"		input[type=\"submit\"] {\r\n" + 
					"			width: 75px\r\n" + 
					"		}\r\n" + 
					"	</style>\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"	<table border=\"1\">\r\n" + 
					"		<caption>Korpa</caption>\r\n" + 
					"		<tr>\r\n" + 
					"			<th>Naziv</th>\r\n" + 
					"			<th>Cena</th>\r\n" + 
					"			<th>Kategorija</th>\r\n" + 
					"			<th>Komada</th>\r\n" + 
					"			<th>Ukupna cena</th>\r\n" + 
					"			<th></th>\r\n" + 
					"		</tr>\r\n"
				);
		// iteracija sa indeksom petlje da bi mogao da se ugradi u HTML kao redniBrojStavke
		List<Stavka> stavke = korpa.getStavke();
		for (int redniBrojStavke = 0; redniBrojStavke < stavke.size(); redniBrojStavke++) {
			Stavka itStavka = stavke.get(redniBrojStavke); // tekuća stavka
			out.write(
					"		<tr>\r\n" + 
					"			<td><a href=\"PrikaziProizvodServlet?id=" + itStavka.getProizvod().getID() + "\">" + itStavka.getProizvod().getNaziv() + "</a></td>\r\n" + 
					"			<td>" + itStavka.getProizvod().getCena() + "</td>\r\n" + 
					"			<td><a href=\"PrikaziKategorijuServlet?id=" + itStavka.getProizvod().getKategorija().getID() + "\">" + itStavka.getProizvod().getKategorija().getNaziv() + "</a></td>\r\n" + 
					"			<td>" + itStavka.getKomada() + "</td>\r\n" + 
					"			<td>" + itStavka.getCena() + "</td>\r\n" + 
					"			<td>\r\n" + 
					"				<form method=\"post\" action=\"UkloniIzKorpeServlet\">\r\n" + 
					"					<input type=\"hidden\" name=\"redniBrojStavke\" value=\"" + redniBrojStavke + "\"/>\r\n" + 
					"					<input type=\"submit\" value=\"Ukloni\"/>\r\n" + 
					"				</form>\r\n" + 
					"			</td>\r\n" + 
					"		</tr>\r\n"
				);
		}
			out.write(
					"		<tr>\r\n" + 
					"			<td colspan=\"4\"></td>\r\n" + 
					"			<td>" + korpa.getCena() + "</td>\r\n" + 
					"			<td>\r\n" + 
					"				<form method=\"post\" action=\"IsprazniKorpuServlet\">\r\n" + 
					"					<input type=\"submit\" value=\"Isprazni\"/>\r\n" + 
					"				</form>\r\n" + 
					"			</td>\r\n" + 
					"		</tr>\r\n" + 
					"	</table>\r\n" + 
					"	<br/>\r\n" + 
					"	<a href=\"SviProizvodiServlet\">Proizvodi</a><br/>\r\n" + 
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
