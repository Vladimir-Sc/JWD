package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;



public class UserDAO {

	
	public static User get(String korisnickoIme, String lozinka) throws Exception {
		User korisnik = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT * FROM user WHERE username = ? AND password = ?"; // proveravamo podudaranje direktno u bazi

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnickoIme);
			stmt.setString(index++, lozinka);
			System.out.println(stmt);

			rset = stmt.executeQuery();

			if (rset.next()) {
				korisnik = new User(korisnickoIme, null); // ne vraćamo lozinku iz bezbedonosnih razloga
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return korisnik;
	}
	
	public static User get(String korisnickoIme) throws Exception {
		User korisnik = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT * FROM user WHERE username = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnickoIme);
			System.out.println(stmt);

			rset = stmt.executeQuery();

			if (rset.next()) {
				korisnik = new User(korisnickoIme, null); // ne vraćamo lozinku iz bezbedonosnih razloga
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return korisnik;
	}
	
	public static boolean add(User korisnik) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO user (username, password) VALUES (?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnik.getUsername());
			stmt.setString(index++, korisnik.getPassword());
			System.out.println(stmt);

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	

}
