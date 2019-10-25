package com.ftninformatika.vezbe06.webshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ftninformatika.vezbe06.webshop.model.Korisnik;

@SuppressWarnings("serial")
public class PocetnaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// čitanje prijavljenog korisnika iz sesije
		HttpSession session = request.getSession();
		Korisnik prijavljeniKorisnik = (Korisnik) session.getAttribute("prijavljeniKorisnik");

		// prikaz početne stranice (HTML ljuštura se nalazi u Pocenta.html)
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write(
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"	<meta charset=\"UTF-8\">\r\n" + 
				"	<title>Web shop</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	<h3>Web shop</h3>\r\n" + 
				"	<a href=\"SveKategorijeServlet\">Kategorije</a><br/>\r\n" + 
				"	<a href=\"SviProizvodiServlet\">Proizvodi</a>&nbsp;<a href=\"SviProizvodiServlet2\">Proizvodi2</a><br/>\r\n" + 
				"	<a href=\"SviKorisniciServlet\">Korisnici</a><br/>\r\n" + 
				"	<br/>\r\n"
		);
	// ako prijavljeni korisnik ne postoji u sesiji, prikazati mu link za prijavu
	if (prijavljeniKorisnik == null) {
		out.write(
				"	<a href=\"Prijava.html\">Prijava</a><br/>\r\n"
		);
	// ako prijavljeni korisnik postoji u sesiji, prikazati mu link do korpe i link za odjavu
	} else {
		out.write(
				"	<a href=\"PrikaziKorpuServlet\">Korpa</a><br/>\r\n" + 
				"	<a href=\"OdjavaServlet\">Odjava</a>\r\n"
		);
	}
		out.write(
				"</body>\r\n" + 
				"</html>"
		);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
