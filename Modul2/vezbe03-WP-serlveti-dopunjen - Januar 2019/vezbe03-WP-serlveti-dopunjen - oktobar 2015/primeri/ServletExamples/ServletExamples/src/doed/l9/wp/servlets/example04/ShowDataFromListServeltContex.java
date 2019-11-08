package doed.l9.wp.servlets.example04;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class ShowDataFromList
 */
public class ShowDataFromListServeltContex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDataFromListServeltContex() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body><p>Lista sa unetim osobama:</p>");
		int i=1;
		ArrayList<Osoba> osobe = (ArrayList<Osoba>) getServletContext().getAttribute("osobe");
		System.out.println("Broj elemenata liste: "+ osobe.size());
		for(Osoba oso: osobe){
			out.println(i++ + "." + " Ime: "+oso.getIme() + ", ");
			out.println("Prezime: " + oso.getPrezime() + "</br>");
		}
		out.println("<a href=\"InputFormToGetDataAndSaveToListServeltContex\">Unesi novu osobu</a>");
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
