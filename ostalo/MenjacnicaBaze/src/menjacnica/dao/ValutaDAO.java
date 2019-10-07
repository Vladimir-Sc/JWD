package menjacnica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import menjacnica.model.Valuta;

public class ValutaDAO {
	
	public static List<Valuta> getAll() throws Exception {
		List<Valuta> valute = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, oznaka, naziv FROM valute";

			stmt = ConnectionManager.getConnection().createStatement();

			rset = stmt.executeQuery(sql);
			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String oznaka = rset.getString(index++);
				String naziv = rset.getString(index++);

				Valuta valuta = new Valuta(id, oznaka, naziv);
				valute.add(valuta);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}
		
		return valute;
	}

	public static Valuta get(String oznaka) throws Exception {
		Valuta valuta = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, naziv FROM valute WHERE oznaka = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, oznaka);

			rset = stmt.executeQuery();
			if (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);

				valuta = new Valuta(id, oznaka, naziv);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}
		
		return valuta;
	}
	
}
