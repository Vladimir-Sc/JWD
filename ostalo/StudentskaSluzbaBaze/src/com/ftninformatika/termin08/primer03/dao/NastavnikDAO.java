package com.ftninformatika.termin08.primer03.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin08.primer03.model.Nastavnik;
import com.ftninformatika.termin08.primer03.model.Predmet;

public class NastavnikDAO {
	
	public static Nastavnik getNastavnikByID(int id) throws Exception {
		Nastavnik nastavnik = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT ime, prezime, zvanje FROM nastavnici WHERE nastavnik_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);
				String zvanje = rset.getString(index++);

				List<Predmet> predmetiKojePohadja = PredajeDAO.getPredmetiByNastavnkID(id);

				nastavnik = new Nastavnik(id, ime, prezime, zvanje);
				nastavnik.getPredmeti().addAll(predmetiKojePohadja);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nastavnik;
	}
	
	public static List<Nastavnik> getAll() throws Exception {
		List<Nastavnik> nastavnici = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT nastavnik_id, ime, prezime, zvanje FROM nastavnici";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);
				String zvanje = rset.getString(index++);

				List<Predmet> predmetiKojePohadja = PredajeDAO.getPredmetiByNastavnkID(id);

				Nastavnik nastavnik = new Nastavnik(id, ime, prezime, zvanje);
				nastavnik.getPredmeti().addAll(predmetiKojePohadja);
				nastavnici.add(nastavnik); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nastavnici;
	}

	public static boolean add(Nastavnik nastavnik) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO nastavnici (ime, prezime, zvanje) VALUES (?, ?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, nastavnik.getIme());
			stmt.setString(index++, nastavnik.getPrezime());
			stmt.setString(index++, nastavnik.getZvanje());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean update(Nastavnik nastavnik) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE nastavnici SET ime = ?, prezime = ?, zvanje = ? WHERE nastavnik_id = " + nastavnik.getId();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, nastavnik.getIme());
			stmt.setString(index++, nastavnik.getPrezime());
			stmt.setString(index++, nastavnik.getZvanje());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean delete(int id) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM nastavnici WHERE nastavnik_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
