package com.ftninformatika.vezbe08.webshop.korisnici;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class OdjavaServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dalja komunikacija sa istim korisnikom će se započeti u novoj sesiji
		HttpSession session = request.getSession();
		session.invalidate();

		// odjava je uvek uspešna
		response.sendRedirect("PocetnaServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
