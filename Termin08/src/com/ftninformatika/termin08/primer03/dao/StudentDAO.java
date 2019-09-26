package com.ftninformatika.termin08.primer03.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.model.Student;

// CRUD operacije nad studentom
public class StudentDAO {
	
	public static Student getStudentByID(int id) throws Exception {
		Student student = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT indeks, ime, prezime, grad FROM studenti WHERE student_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				String indeks = rset.getString(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);
				String grad = rset.getString(index++);
				
				student = new Student(id, indeks, ime, prezime, grad);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return student;
	}
	
	public static Student getStudentByIndeks(String indeks) throws Exception {
		Student student = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT student_id, ime, prezime, grad FROM studenti WHERE indeks = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, indeks);

			rset = stmt.executeQuery();

			if (rset.next()) {
				index = 1;
				int id = rset.getInt(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);
				String grad = rset.getString(index++);
				
				student = new Student(id, indeks, ime, prezime, grad);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return student;
	}
	
	public static List<Student> getAll() throws Exception {
		List<Student> studenti = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT student_id, indeks, ime, prezime, grad FROM studenti";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String indeks = rset.getString(index++);
				String ime = rset.getString(index++);
				String prezime = rset.getString(index++);
				String grad = rset.getString(index++);

				List<Predmet> predmetiKojePohadja = PohadjaDAO.getPredmetiByStudentID(id);

				Student student = new Student(id, indeks, ime, prezime, grad);
				student.getPredmeti().addAll(predmetiKojePohadja);
				studenti.add(student); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return studenti;
	}

	public static boolean add(Student student) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO studenti (indeks, ime, prezime, grad) VALUES (?, ?, ?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, student.getIndeks());
			stmt.setString(index++, student.getIme());
			stmt.setString(index++, student.getPrezime());
			stmt.setString(index++, student.getGrad());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean update(Student student) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE studenti SET indeks = ?, ime = ?, prezime = ?, grad = ? WHERE student_id = " + student.getId();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, student.getIndeks());
			stmt.setString(index++, student.getIme());
			stmt.setString(index++, student.getPrezime());
			stmt.setString(index++, student.getGrad());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean delete(int id) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM studenti WHERE student_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
