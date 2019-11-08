package Servleti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Odjava extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dalja komunikacija sa istim korisnikom Ä‡e se zapoÄ�eti u novoj sesiji
		HttpSession session = request.getSession();
		session.invalidate();

		// odjava je uvek uspeÅ¡na
		//response.sendRedirect("PocetnaServlet");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>Uspesno ste se odjavili sa sistema!</p>");
		out.println("<br>");
		out.println("<a href=\"index.html\">Pocetna strana</a>");
		out.println("</body></html>");
		out.close();
	}

}
