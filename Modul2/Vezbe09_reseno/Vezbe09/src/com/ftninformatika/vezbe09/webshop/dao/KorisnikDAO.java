package com.ftninformatika.vezbe09.webshop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.vezbe09.webshop.model.Korisnik;

public class KorisnikDAO {

	public static Korisnik get(String korisnickoIme, String lozinka) throws Exception {
		Korisnik korisnik = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT * FROM korisnici WHERE korisnicko_ime = ? AND lozinka = ?"; // proveravamo podudaranje direktno u bazi

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnickoIme);
			stmt.setString(index++, lozinka);
			System.out.println(stmt);

			rset = stmt.executeQuery();

			if (rset.next()) {
				korisnik = new Korisnik(korisnickoIme, null); // ne vraćamo lozinku iz bezbedonosnih razloga
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return korisnik;
	}

	public static Korisnik get(String korisnickoIme) throws Exception {
		Korisnik korisnik = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT * FROM korisnici WHERE korisnicko_ime = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnickoIme);
			System.out.println(stmt);

			rset = stmt.executeQuery();

			if (rset.next()) {
				korisnik = new Korisnik(korisnickoIme, null); // ne vraćamo lozinku iz bezbedonosnih razloga
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return korisnik;
	}
	
	public static List<Korisnik> getAll() throws Exception {
		List<Korisnik> korisnici = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT korisnicko_ime FROM korisnici";
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				String korisnickoIme = rset.getString(index++);

				Korisnik korisnik = new Korisnik(korisnickoIme, null); // ne vraćamo lozinku iz bezbedonosnih razloga
				korisnici.add(korisnik); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return korisnici;
	}

	public static boolean add(Korisnik korisnik) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO korisnici (korisnicko_ime, lozinka) VALUES (?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnik.getKorisnickoIme());
			stmt.setString(index++, korisnik.getLozinka());
			System.out.println(stmt);

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean update(Korisnik korisnik) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE korisnici SET lozinka = ? WHERE korisnicko_ime = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnik.getLozinka());
			stmt.setString(index++, korisnik.getKorisnickoIme());
			System.out.println(stmt);

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean delete(long id) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM korisnici WHERE id = " + id;
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
