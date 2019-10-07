package com.ftninformatika.termin08.primer03.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin08.primer03.model.Nastavnik;
import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.model.Student;

// CRUD operacije nad predmetom
public class PredmetDAO {
	
	public static Predmet getPredmetByID(int id) throws Exception {
		Predmet predmet = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT naziv FROM predmeti WHERE predmet_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);
			
			if (rset.next()) {
				String naziv = rset.getString(1);
				predmet = new Predmet(id, naziv);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return predmet;
	}

	public static Predmet getPredmetByNaziv(String naziv) throws Exception {
		Predmet predmet = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT predmet_id FROM predmeti WHERE naziv = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, naziv);
					
			rset = stmt.executeQuery();
			
			if (rset.next()) {
				index = 1;
				int id = rset.getInt(index++);
				predmet = new Predmet(id, naziv);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return predmet;
	}
	
	public static List<Predmet> getAll() throws Exception {
		List<Predmet> predmeti = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT predmet_id, naziv FROM predmeti";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);
	
				List<Student> studentiKojiPohadjajuPredmet = PohadjaDAO.getStudentiByPredmetID(id);
				List<Nastavnik> nastavniciKojiPredajuPredmet = PredajeDAO.getNastavniciByPredmetID(id);
				
				Predmet predmet = new Predmet(id, naziv);
				predmet.getStudenti().addAll(studentiKojiPohadjajuPredmet);
				predmet.getNastavnici().addAll(nastavniciKojiPredajuPredmet);
				predmeti.add(predmet);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return predmeti;
	}

	public static List<Predmet> getAllSortedByNaziv() throws Exception {
		List<Predmet> predmeti = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT predmet_id, naziv FROM predmeti ORDER BY naziv ASC";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);
	
				List<Student> studentiKojiPohadjajuPredmet = PohadjaDAO.getStudentiByPredmetID(id);
				List<Nastavnik> nastavniciKojiPredajuPredmet = PredajeDAO.getNastavniciByPredmetID(id);
				
				Predmet predmet = new Predmet(id, naziv);
				predmet.getStudenti().addAll(studentiKojiPohadjajuPredmet);
				predmet.getNastavnici().addAll(nastavniciKojiPredajuPredmet);
				predmeti.add(predmet);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return predmeti;
	}
	
	public static boolean add(Predmet predmet) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO predmeti (naziv) values (?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, predmet.getNaziv());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean update(Predmet predmet) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE predmeti SET naziv = ? WHERE predmet_id = " + predmet.getId();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, predmet.getNaziv());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean delete(int id) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM predmeti WHERE predmet_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
