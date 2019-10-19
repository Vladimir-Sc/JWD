package webshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webshop.beans.Korisnik;

/**
 * Servlet implementation class Registracija
 */
public class Registracija extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registracija() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pout = response.getWriter();

		//TO-DO Provera da li je uneta prazna vrednost kao parametar ???
		
		Korisnik k = new Korisnik(request.getParameter("ime"), request.getParameter("lozinka"));
		
//		Radi samo ako je ovo ptrethodno ucitano u kontekst
		
		ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>)getServletContext().getAttribute("korisnici");


		boolean postoji = false;
		
		for(int i=0; i<korisnici.size(); i++){
			if (korisnici.get(i).getKorisnickoIme().equalsIgnoreCase(request.getParameter("ime"))){
				pout.println("<p>korisnicko ime vec postoji</p>");
				pout.print("Ponovite registraciju na <a href=\"index.html\">Registracija</a>");
				postoji = true;
			}
		}
		
		if (postoji == false){
			korisnici.add(k);
//			TO-DO Dodati tacno koji je to korisnik koji se uspesno registrovao
			pout.println("<p>korisnik je uspesno registrovan</p>");
			pout.print("<a href=\"index.html\">Pocetna</a>");
		}
	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
