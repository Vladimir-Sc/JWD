package com.ftninformatika.vezbe09.webshop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.vezbe09.webshop.model.Kategorija;

public class KategorijaDAO {

	public static Kategorija get(long id) throws Exception {
		Kategorija kategorija = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT naziv FROM kategorije WHERE id = " + id;
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				String naziv = rset.getString(index++);

				kategorija = new Kategorija(id, naziv);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return kategorija;
	}

	public static List<Kategorija> getAll() throws Exception {
		List<Kategorija> kategorije = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, naziv FROM kategorije";
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				String naziv = rset.getString(index++);

				Kategorija kategorija = new Kategorija(id, naziv);
				kategorije.add(kategorija); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return kategorije;
	}

	public static boolean add(Kategorija kategorija) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO kategorije (naziv) VALUES (?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, kategorija.getNaziv());
			System.out.println(stmt);

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean update(Kategorija kategorija) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE kategorije SET naziv = ? WHERE id = " + kategorija.getID();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, kategorija.getNaziv());
			System.out.println(stmt);

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean delete(long id) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM kategorije WHERE id = " + id;
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
