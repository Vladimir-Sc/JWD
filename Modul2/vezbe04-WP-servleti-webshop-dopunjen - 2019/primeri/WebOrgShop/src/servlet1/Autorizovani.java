package servlet1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import servlet1.webshop.User;

/**
 * Servlet implementation class Autorizovani
 */
public class Autorizovani extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><p>Lista sa autorizovanim osobama:</p>");
		int i=1;
		ArrayList<User> autorizovani = (ArrayList<User>) getServletContext().getAttribute("autorizovani");
		System.out.println("Broj elemenata liste: "+ autorizovani.size());
		for(User user: autorizovani){
			out.println(i++ + "." + " Ime: "+user.getPassword() + ", ");
			out.println("Prezime: " + user.getPassword() + "</br>");
		}
		out.println("<a href=\"WebShopServlet\">Povratak</a>");
		out.println("</body></html>");
		out.close();
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
