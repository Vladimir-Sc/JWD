package doed.l9.wp.servlets.example04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetData
 */
public class InputFormToGetDataAndSaveToListServeltContex extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputFormToGetDataAndSaveToListServeltContex() {
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
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Primer sa formom</title>");
		out.println("<body>");
		out.println("<h1>Unesite podatke</h1>");
		out.println("<form action=\"GetDataAndSaveToListServeltContex\">");
		out.println("Ime:<input type=\"text\" name=\"ime\">");
		out.println("Prezime:<input type=\"text\" name=\"prezime\">");
		out.println("<input type=\"submit\" value=\"Posalji\">");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
