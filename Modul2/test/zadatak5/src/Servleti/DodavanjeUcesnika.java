package Servleti;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.ArrayList;

import model.TipUcesca;
import model.Ucesnik;
import model.User;


public class DodavanjeUcesnika extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private Ucesnik ucesnik;
	private ArrayList<Ucesnik> listaUcesnika;
       

	@Override
    public void init() throws ServletException {
    	listaUcesnika = new ArrayList<Ucesnik>();
    	//ucesnik = new Ucesnik();
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Ucitanje prijavljenog korisnika iz sesije
			HttpSession session = request.getSession();
			User prijavljeniKorisnik = (User) session.getAttribute("prijavljeniKorisnik");
		
		String imePrezime = request.getParameter("imeprezime");
		int kmpredjeni = Integer.parseInt(request.getParameter("kmpredjeni"));
		int vrememin = Integer.parseInt(request.getParameter("vrememin"));
		
		String zavrsioTrku = ""; 
		if (request.getParameter("zavtrka") == null) {
			zavrsioTrku = "Ne";
		}else if (request.getParameter("zavtrka").equals("zavrseno")){
			zavrsioTrku = "Da";
		}
		
		String tipucesnika = request.getParameter("tipUcesnika");
		
		String napomena = request.getParameter("napomena");
		
		String tipUcesca = request.getParameter("tipUcesca");
				
		TipUcesca tipucesca = new TipUcesca(tipUcesca);
		
		Ucesnik ucesnik = new Ucesnik(imePrezime, kmpredjeni, vrememin, tipucesnika, zavrsioTrku,  napomena, tipucesca );
		
//		ucesnik.setImePrezime(imePrezime);
//		ucesnik.setBrKm(kmpredjeni);
//		ucesnik.setTipUcesca(tipucesca);
//		ucesnik.setTipUcesnika(tipucesnika);
//		ucesnik.setVremeMin(vrememin);
//		ucesnik.setZavrsioTrku(zavrsioTrku);
//		ucesnik.setNapomena(napomena);
		
		listaUcesnika.add(ucesnik);
		
		//cuvanje podataka o ucesnicima u contextu
		getServletContext().setAttribute("ucesniciTrke", listaUcesnika);
		
		//prikaz broja ucesnika
		int brojU = (int) getServletContext().getAttribute("brUc");
		brojU++;
		getServletContext().setAttribute("brUc", brojU);
		
		
		System.out.println("Broj ucesnika je: " + getServletContext().getAttribute("brUc"));
		
		if (prijavljeniKorisnik == null) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<p>Prijavite se ako zelite da vidite listu ucesnika </p>");
			out.println("<br>");
			out.println("<a href=\"prijava.html\">Prijava</a>");
			out.println("</body></html>");
			out.close();
			
		}else {
			response.sendRedirect("PrikazUcesnika.jsp");
		}
		
		
		
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<p>Niste prijavljeni, molimo Vas pokusajte ponovo</p>");
//		out.println("<br>");
//		out.println("<a href=\"prijava.html\">Prijava</a>");
//		out.println("</body></html>");
//		out.close();
		
	}

}
