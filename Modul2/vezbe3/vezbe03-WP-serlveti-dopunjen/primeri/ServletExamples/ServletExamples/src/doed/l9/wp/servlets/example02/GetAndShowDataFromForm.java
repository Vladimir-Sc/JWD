package doed.l9.wp.servlets.example02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDataForm
 */
public class GetAndShowDataFromForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAndShowDataFromForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// preuzimamo vrednost parametra "ime" iz request objekta
		String ime = request.getParameter("ime");
		// preuzimamo vrednost parametra "prezime" request objekta
		String prezime = request.getParameter("prezime"); 
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Evo sta ste uneli:</h1>");
		//Ispisujemo preuzete vrednosti iz zahteva
		out.println("Ime: "+ime+", "+"Prezime: "+prezime+"<br/>");
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
