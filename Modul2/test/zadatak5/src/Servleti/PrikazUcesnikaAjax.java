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
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.TipUcesca;
import model.Ucesnik;
import model.User;

public class PrikazUcesnikaAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Ucesnik> listaUcesnika;

	public PrikazUcesnikaAjax() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public void init() throws ServletException {
    	listaUcesnika = new ArrayList<Ucesnik>();
    	//ucesnik = new Ucesnik();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Ä�itanje svih korisnika iz baze
		// List<Korisnik> korisnici = KorisnikDAO.getAll();

		// Ucitanje prijavljenog korisnika iz sesije
		//HttpSession session = request.getSession();
		//User prijavljeniKorisnik = (User) session.getAttribute("prijavljeniKorisnik");

		String imePrezime = request.getParameter("korisnickoIme");
		int kmpredjeni = Integer.parseInt(request.getParameter("kilometri"));
		int vrememin = Integer.parseInt(request.getParameter("vreme"));

		String zavrsioTrku = "";
		if (request.getParameter("zavrseno") == null) {
			zavrsioTrku = "Ne";
		} else if (request.getParameter("zavrseno").equals("zavrseno")) {
			zavrsioTrku = "Da";
		}

		String tipucesnika = request.getParameter("tipUcesnika");

		String napomena = request.getParameter("napomena");

		String tipUcesca = request.getParameter("tipUcesca");

		TipUcesca tipucesca = new TipUcesca(tipUcesca);

		Ucesnik ucesnik = new Ucesnik(imePrezime, kmpredjeni, vrememin, tipucesnika, zavrsioTrku, napomena, tipucesca);

		//	ucesnik.setImePrezime(imePrezime);
		//	ucesnik.setBrKm(kmpredjeni);
		//	ucesnik.setTipUcesca(tipucesca);
		//	ucesnik.setTipUcesnika(tipucesnika);
		//	ucesnik.setVremeMin(vrememin);
		//	ucesnik.setZavrsioTrku(zavrsioTrku);
		//	ucesnik.setNapomena(napomena);

		listaUcesnika.add(ucesnik);
		System.out.println(ucesnik);
		// cuvanje podataka o ucesnicima u contextu
		getServletContext().setAttribute("ucesniciTrke", listaUcesnika);
		
		try {
			
			Map<String, Object> odgovor = new LinkedHashMap<>();
			odgovor.put("status", "uspeh");
			

			String jsonOdgovor = new ObjectMapper().writeValueAsString(odgovor);
			System.out.println(jsonOdgovor);
			response.setContentType("application/json");
			response.getWriter().write(jsonOdgovor);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
