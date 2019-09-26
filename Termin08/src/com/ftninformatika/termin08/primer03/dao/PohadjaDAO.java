package com.ftninformatika.termin08.primer03.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin08.primer03.model.Predmet;
import com.ftninformatika.termin08.primer03.model.Student;

// CRUD operacije nad veznom tabelom pohadja
public class PohadjaDAO {

	public static List<Predmet> getPredmetiByStudentID(int studentID) throws Exception {
		List<Predmet> predmetiKojeStudentPohadja = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT predmet_id FROM pohadja WHERE student_id = " + studentID;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int predmetID = rset.getInt(1);

				Predmet predmet = PredmetDAO.getPredmetByID(predmetID);
				predmetiKojeStudentPohadja.add(predmet);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return predmetiKojeStudentPohadja;
	}
	
	public static List<Student> getStudentiByPredmetID(int id) throws Exception {
		List<Student> studentiKojiPohadjajuPredmet = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT student_id FROM pohadja WHERE predmet_id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int studentID = rset.getInt(1);

				Student student = StudentDAO.getStudentByID(studentID);
				studentiKojiPohadjajuPredmet.add(student);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return studentiKojiPohadjajuPredmet;
	}
	
	public static boolean add(int studentID, int predmetID) throws Exception {
		Statement stmt = null;
		try {
			String sql = "INSERT INTO pohadja (student_id, predmet_id) VALUES (" + studentID + ", " + predmetID + ")";

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	
	public static boolean delete(int studentID, int predmetID) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM pohadja WHERE student_id = " + studentID + " AND predmet_id = " + predmetID;

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean deletePohadjanjaStudenta(int studentID) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM pohadja WHERE student_id = " + studentID;

			stmt = ConnectionManager.getConnection().createStatement();
			stmt.executeUpdate(sql);
			return true;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean deletePohadjanjaPredmeta(int predmetID) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM pohadja WHERE predmet_id = " + predmetID;

			stmt = ConnectionManager.getConnection().createStatement();
			stmt.executeUpdate(sql);
			return true;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	// update svih pohadjanja jednog studenta
	public static boolean update(Student student) throws Exception {
		Connection conn = ConnectionManager.getConnection();
		try {
			conn.setAutoCommit(false); // iskljucivanje automatske transakcije (pri cemu je svaki upit bio transakcija za sebe)
			conn.commit(); // pocetak transakcije

			// obrisati prethodna pohadjaja
			boolean uspeh = deletePohadjanjaStudenta(student.getId());
			if (!uspeh) // prekid u slucaju neuspelog brisanja
				throw new Exception("Brisanje nije uspelo!");

			// za svaki predmet ovog studenta dodati po jedno pohadjanje
			for (Predmet predmet : student.getPredmeti()) {
				uspeh = add(student.getId(), predmet.getId());
				if (!uspeh) // prekid u slucaju neuspelog dodavanja
					throw new Exception("Dodavanje nije uspelo!");
			}

			conn.commit(); // kraj transakcije
		} catch (Exception ex) {
			try {conn.rollback();} catch (Exception ex1) {ex1.printStackTrace();} // vratiti bazu u stanje pre pocetka transakcije
			
			throw ex;
		} finally {
			try {conn.setAutoCommit(true);} catch (Exception ex) {ex.printStackTrace();} // ukljuciti automatsku tranaskciju
		}

		return true;
	}
	
	// update svih pohadjanja jednog predmeta
	public static boolean update(Predmet predmet) throws Exception {
		Connection conn = ConnectionManager.getConnection();
		try {
			conn.setAutoCommit(false); // iskljucivanje automatske transakcije (pri cemu je svaki upit bio transakcija za sebe)
			conn.commit(); // pocetak transakcije

			// obrisati prethodna pohadjaja
			boolean uspeh = deletePohadjanjaPredmeta(predmet.getId());
			if (!uspeh) // prekid u slucaju neuspelog brisanja
				throw new Exception("Brisanje nije uspelo!");

			// za svakog studenta ovog predmeta dodati po jedno pohadjanje
			for (Student student : predmet.getStudenti()) {
				uspeh = add(student.getId(), predmet.getId());
				if (!uspeh) // prekid u slucaju neuspelog dodavanja
					throw new Exception("Dodavanje nije uspelo!");
			}

			conn.commit(); // kraj transakcije
		} catch (Exception ex) {
			try {conn.rollback();} catch (Exception ex1) {ex1.printStackTrace();} // vratiti bazu u stanje pre pocetka transakcije
			
			throw ex;
		} finally {
			try {conn.setAutoCommit(true);} catch (Exception ex) {ex.printStackTrace();} // ukljuciti automatsku tranaskciju
		}

		return true;
	}
}
