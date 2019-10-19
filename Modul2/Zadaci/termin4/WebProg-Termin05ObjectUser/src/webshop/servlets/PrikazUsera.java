package webshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webshop.beans.Korisnik;

/**
 * Servlet implementation class PrikazUsera
 */
public class PrikazUsera extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazUsera() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("logovaniKorisnik") == null){
			response.sendRedirect("WSLogin.html");
			return;
		}
		
		ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>)getServletContext().getAttribute("korisnici");

		
		
		response.setContentType("text/html");
		
		PrintWriter pout = response.getWriter();
		
		pout.println("<html>");
		pout.println("<head>");
		pout.println("</head>");
		pout.println("<body>");
		pout.print("prijavljen je korisnik: " + request.getSession().getAttribute("logovaniKorisnik")+"<br/>");
		pout.println("Postojeci korisnici:");
		
//		TO - DO Pokusajte da napravite akcije update usera i brisanje usera na istom servletu
		
		pout.println("<table border=\"1\"><tr bgcolor=\"lightgrey\"><th>Ime</th><th>Prezime</th><th colspan=\"2\">Akcije</th></tr>");
	
		for ( Korisnik k : korisnici ) {
			pout.println("<tr>");
			pout.println("<td>" + k.getKorisnickoIme() + "</td>");
			pout.println("<td>" + k.getLozinka() + "</td>");
			pout.println("<td><a href=\"PrikazUsera?listPod=" + "\">delete</a></td>"); //ovde treba dodati id na osnovu koga se brise slicno kao kod korpe
			pout.println("<td><a href=\"PrikazUsera?updateParam=" + k.getKorisnickoIme() + "\">update</a></td>");
			pout.println("</tr>");

		}
		pout.println("</table>");
		
		
		
		pout.println("<p>");
		pout.println("<a href=\"WebShopServlet\">Povratak na Kupovinu </a>");
		pout.println("</p>");
		pout.println("<a href=\"PrikazUsera\">Prikaz Svih</a>");
		pout.println("</body>");
		pout.println("<html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
