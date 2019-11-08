package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Ucesnik;


public class UcesnikDAO {
	
	public static List<Ucesnik> pretraga (int km) throws Exception{
		List<Ucesnik> korisnici = new ArrayList<>();
		
		PreparedStatement stmt = null;
		ResultSet rset = null;
		
		try {
			String sql = "SELECT ime_i_prezime, broj_predjenih_kilometara FROM ucesnik WHERE broj_predjenih_kilometara >= ?";
			
			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setInt(index++, km);
			System.out.println(stmt);

			rset = stmt.executeQuery();

			while (rset.next()) {
				int i = 1;
				String korisnickoIme = rset.getString(i++);
				int brKm = rset.getInt(i++);

				Ucesnik korisnik = new Ucesnik(korisnickoIme, brKm); // ne vraćamo lozinku iz bezbedonosnih razloga
				korisnici.add(korisnik); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}
		return korisnici;
	}

}
