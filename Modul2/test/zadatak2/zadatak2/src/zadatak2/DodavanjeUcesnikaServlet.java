package zadatak2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TipUcesca;
import model.Ucesnik;

/**
 * Servlet implementation class DodavanjeUcesnikaServlet
 */
public class DodavanjeUcesnikaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Ucesnik ucesnik;
	private ArrayList<Ucesnik> listaUcesnika;
       

	@Override
    public void init() throws ServletException {
    	listaUcesnika = new ArrayList<Ucesnik>();
    	ucesnik = new Ucesnik();
    }
    
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imePrezime = request.getParameter("imeprezime");
		int kmpredjeni = Integer.parseInt(request.getParameter("kmpredjeni"));
		int vrememin = Integer.parseInt(request.getParameter("vrememin"));
		
		String zavrsioTrku = ""; 
		if (request.getParameter("zavtrka") == null) {
			zavrsioTrku = "ucesnik nije zavrsio trku";
		}else if (request.getParameter("zavtrka").equals("zavrseno")){
			zavrsioTrku = "ucesnik je zavrsio trku";
		}
		
		String tipucesnika = request.getParameter("tipUcesnika");
		
		String napomena = request.getParameter("napomena");
		
		String tipUcesca = request.getParameter("tipUcesca");
				
		TipUcesca tipucesca = new TipUcesca(tipUcesca);
		
		ucesnik.setImePrezime(imePrezime);
		ucesnik.setBrKm(kmpredjeni);
		ucesnik.setTipUcesca(tipucesca);
		ucesnik.setTipUcesnika(tipucesnika);
		ucesnik.setVremeMin(vrememin);
		ucesnik.setZavrsioTrku(zavrsioTrku);
		ucesnik.setNapomena(napomena);
		
		listaUcesnika.add(ucesnik);
		
		//cuvanje podataka o ucesnicima u contextu
		getServletContext().setAttribute("ucesniciTrke", listaUcesnika);
		
		//prikaz broja ucesnika
		int brojU = (int) getServletContext().getAttribute("brUc");
		brojU++;
		getServletContext().setAttribute("brUc", brojU);
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("broj ucesnika je: " + getServletContext().getAttribute("brUc"));
		out.println("<br>");
		out.println("<a href=\"index.html\">Prkazi formu</a>");
		out.println("</body></html>");
		out.close();
		
	}

}
