package Servleti;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;

public class PrikazUcesnika extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrikazUcesnika() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User prijavljeniKorisnik = (User) session.getAttribute("prijavljeniKorisnik");
		
		if (prijavljeniKorisnik == null) {
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<p>Prijavite se ako zelite da vidite listu ucesnika</p>");
			out.println("<br>");
			out.println("<a href=\"prijava.html\">Prijava</a>");
			out.println("</body></html>");
			out.close();
			
		}else {
			response.sendRedirect("PrikazUcesnika.jsp");
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
