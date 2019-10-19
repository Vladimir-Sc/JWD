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

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("logovaniKorisnik") == null){
			response.sendRedirect("WSLogin.html");
			return;
		}
		
		PrintWriter pout = response.getWriter();
		
//		TO-DO Dodati proveru da li je uopste unet username na osnovu koga treba da se izvrsi brisanje
		
		ArrayList<Korisnik> korisnici = (ArrayList<Korisnik>)getServletContext().getAttribute("korisnici");
		for (Korisnik k : korisnici) {
			if (request.getParameter("username").equals(k.getKorisnickoIme())) {
				korisnici.remove(k);
				pout.println("<p>"+ request.getParameter("username") + " korisnik je obrisan</p>");
				break;
			}
		}
		
//		TO-DO Dodati redirekciju ka prikazu usera kako bi se videla tabela usera nakon brisanja
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
