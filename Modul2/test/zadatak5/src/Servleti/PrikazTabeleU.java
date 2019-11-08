package Servleti;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


import model.Ucesnik;

/**
 * Servlet implementation class PrikazTabeleU
 */
public class PrikazTabeleU extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrikazTabeleU() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Ucesnik> ucesnici = (ArrayList<Ucesnik>) getServletContext().getAttribute("ucesniciTrke");
		
		
			try {
			
			Map<String, Object> odgovor = new LinkedHashMap<>();
			odgovor.put("status", "uspeh");
			odgovor.put("korisnici", ucesnici);
	
			String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
			System.out.println(jsonOdgovor);
			response.setContentType("application/json");
			response.getWriter().write(jsonOdgovor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
