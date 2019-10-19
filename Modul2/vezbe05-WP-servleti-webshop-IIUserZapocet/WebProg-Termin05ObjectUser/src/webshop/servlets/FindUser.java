package webshop.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webshop.beans.Korisnik;
import webshop.beans.Product;

/**
 * Servlet implementation class FindUser
 */
public class FindUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindUser() {
        super();
        // TODO Auto-generated constructor stub
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
		PrintWriter pout = response.getWriter();
		boolean postoji = false;
		
		
//		TO-DO Napraviti pretragu koja vraca sve korisnike koji pocinju sa zadatim stringom
		
		for(int i=0; i<korisnici.size(); i++){
			if (korisnici.get(i).getKorisnickoIme().equals(request.getParameter("findUserName"))){
				pout.println("<p>"+ request.getParameter("findUserName") + " korisnik postoji</p>");
				postoji = true;
			}
		}
		
		if (postoji == false){
			pout.println("<p>"+ request.getParameter("findUserName") + " korisnik ne postoji</p>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
