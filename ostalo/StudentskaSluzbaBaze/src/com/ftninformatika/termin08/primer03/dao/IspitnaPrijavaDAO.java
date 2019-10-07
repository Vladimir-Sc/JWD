package com.ftninformatika.termin08.primer03.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin08.primer03.model.IspitnaPrijava;
import com.ftninformatika.termin08.primer03.model.IspitniRok;
import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.model.Student;

public class IspitnaPrijavaDAO {

	public static List<IspitnaPrijava> getPrijaveByStudent(Student student) throws Exception {
		List<IspitnaPrijava> ispitnePrijaveStudenta = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT predmet_id, rok_id, teorija, zadaci FROM ispitne_prijave WHERE student_id = " + student.getId();

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int predmetID = rset.getInt(index++);
				int rokID = rset.getInt(index++);
				int teorija = rset.getInt(index++);
				int zadaci = rset.getInt(index++);

				Predmet predmet = PredmetDAO.getPredmetByID(predmetID);
				IspitniRok ispRok = IspitniRokDAO.getIspitniRokByID(rokID);

				IspitnaPrijava ispPrijava = new IspitnaPrijava(predmet, student, ispRok, teorija, zadaci);
				ispitnePrijaveStudenta.add(ispPrijava);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return ispitnePrijaveStudenta;
	}

	public static List<IspitnaPrijava> getPrijaveByPredmet(Predmet predmet) throws Exception {
		List<IspitnaPrijava> ispitnePrijaveZaPredmet = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT student_id, rok_id, teorija, zadaci FROM ispitne_prijave WHERE predmet_id = " + predmet.getId();

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int studentID = rset.getInt(index++);
				int rokID = rset.getInt(index++);
				int teorija = rset.getInt(index++);
				int zadaci = rset.getInt(index++);

				Student student = StudentDAO.getStudentByID(studentID);
				IspitniRok ispRok = IspitniRokDAO.getIspitniRokByID(rokID);

				IspitnaPrijava ispPrijava = new IspitnaPrijava(predmet, student, ispRok, teorija, zadaci);
				ispitnePrijaveZaPredmet.add(ispPrijava);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return ispitnePrijaveZaPredmet;
	}
	
	public static List<IspitnaPrijava> getPrijaveByIspRok(IspitniRok ispRok) throws Exception {
		List<IspitnaPrijava> ispitnePrijaveURoku = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT student_id, predmet_id, teorija, zadaci FROM ispitne_prijave WHERE rok_id = " + ispRok.getId();

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int studentID = rset.getInt(index++);
				int predmetID = rset.getInt(index++);
				int teorija = rset.getInt(index++);
				int zadaci = rset.getInt(index++);

				Student student = StudentDAO.getStudentByID(studentID);
				Predmet predmet = PredmetDAO.getPredmetByID(predmetID);

				IspitnaPrijava ispPrijava = new IspitnaPrijava(predmet, student, ispRok, teorija, zadaci);
				ispitnePrijaveURoku.add(ispPrijava);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return ispitnePrijaveURoku;
	}
	
	public static boolean add(int studentID, int predmetID, int rokID, int teorija, int zadaci) throws Exception {
		Statement stmt = null;
		try {
			String sql = "INSERT INTO ispitne_prijave (student_id, predmet_id, rok_id, teorija, zadaci) "
					+ "VALUES (" + studentID + ", " + predmetID + ", " + rokID + ", " + teorija + ", " + zadaci + ")";

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean update(int studentID, int predmetID, int rokID, int teorija, int zadaci) throws Exception {
		Statement stmt = null;
		try {
			String sql = "UPDATE ispitne_prijave SET teorija = " + teorija + ", zadaci = " + zadaci + 
					" WHERE student_id = " + studentID + 
					" AND predmet_id = " + predmetID + 
					" AND rok_id = " + rokID;

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean delete(int studentID, int predmetID, int rokID) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM ispitne_prijave WHERE student_id = " + studentID + " AND predmet_id = " + predmetID + " AND rok_id = " + rokID;

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
