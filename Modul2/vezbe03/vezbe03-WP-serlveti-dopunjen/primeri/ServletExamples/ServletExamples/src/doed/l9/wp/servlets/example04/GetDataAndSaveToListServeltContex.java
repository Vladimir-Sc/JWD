package doed.l9.wp.servlets.example04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowDataForm
 */
public class GetDataAndSaveToListServeltContex extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Osoba osoba= null;
	private ArrayList<Osoba> osobe = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataAndSaveToListServeltContex() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	osobe = new ArrayList<Osoba>();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// preuzimamo vrednost parametra "ime"
		String ime = request.getParameter("ime");
		// preuzimamo vrednost parametra "prezime"
		String prezime = request.getParameter("prezime");
		osoba = new Osoba();
		osoba.setIme(ime);
		osoba.setPrezime(prezime);
		osobe.add(osoba);
		getServletContext().setAttribute("osobe", osobe);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>Evo sta ste uneli:</h1>");
		out.println("Ime: "+ime+",");
		out.println("Prezime: "+prezime+"<br/>");
		out.println("<a href=\"ShowDataFromListServeltContex\">Prkazi Listu</a>");
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
