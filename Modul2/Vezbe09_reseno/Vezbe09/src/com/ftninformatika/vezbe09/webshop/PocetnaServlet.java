package com.ftninformatika.vezbe09.webshop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class PocetnaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ovaj servlet je prikazivao drugačije link-ove u zavisnosti od toga da li je korisnik prijavljen ili nije
		// to dinamičko ponašanje je sad implementirano u Pocetna.jsp
		// s obzirom na to da nema pripreme podataka (čitanje iz baze i sl.), ovaj servlet više ne mora da postoji
		// da se ne bi prepravljali svi link-ovi i redirekcije koji su vodili do ovog servlet-a, da sad vode na Pocetna.jsp, 
		//     jednostavno se svi zahtevi na ovaj servlet prosleđuju na Pocetna.jsp
		request.getRequestDispatcher("Pocetna.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
