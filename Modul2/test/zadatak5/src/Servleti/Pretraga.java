package Servleti;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UcesnikDAO;
import model.Ucesnik;



public class Pretraga extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Pretraga() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int km = Integer.parseInt(request.getParameter("predjenikm"));
		try {
			// Ä�itanje svih korisnika iz baze
			List<Ucesnik> korisnici = UcesnikDAO.pretraga(km);
			
			// pripremljeni podaci se smeÅ¡taju kao atribut request-a
			request.setAttribute("pretragaPoKm", korisnici);
			// request se prosleÄ‘uje na SviKorisnici.jsp
			request.getRequestDispatcher("Pretraga.jsp").forward(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
