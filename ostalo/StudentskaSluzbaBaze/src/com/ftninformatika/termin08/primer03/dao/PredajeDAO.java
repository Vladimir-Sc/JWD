package com.ftninformatika.termin08.primer03.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin08.primer03.model.Nastavnik;
import com.ftninformatika.termin08.primer03.model.Predmet;

public class PredajeDAO {

	public static List<Predmet> getPredmetiByNastavnkID(int nastavnikID) throws Exception {
		List<Predmet> predmetiKojeNastavnikPredaje = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT predmet_id FROM predaje WHERE nastavnik_id = " + nastavnikID;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int predmetID = rset.getInt(1);

				Predmet predmet = PredmetDAO.getPredmetByID(predmetID);
				predmetiKojeNastavnikPredaje.add(predmet);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return predmetiKojeNastavnikPredaje;
	}
	
	public static List<Nastavnik> getNastavniciByPredmetID(int id) throws Exception {
		List<Nastavnik> nastavniciKojiPredajuPredmet = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT nastavnik_id FROM predaje WHERE predmet_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int studentID = rset.getInt(1);

				Nastavnik nastavnik = NastavnikDAO.getNastavnikByID(studentID);
				nastavniciKojiPredajuPredmet.add(nastavnik);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nastavniciKojiPredajuPredmet;
	}
	
	public static boolean add(int nastavnikID, int predmetID) throws Exception {
		Statement stmt = null;
		try {
			String sql = "INSERT INTO predaje (nastavnik_id, predmet_id) VALUES (" + nastavnikID + ", " + predmetID + ")";

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	
	public static boolean delete(int nastavnikID, int predmetID) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM predaje WHERE nastavnik_id = " + nastavnikID + " AND predmet_id = " + predmetID;

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
