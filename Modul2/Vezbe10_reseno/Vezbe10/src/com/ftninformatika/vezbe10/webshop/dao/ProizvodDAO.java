package com.ftninformatika.vezbe10.webshop.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.vezbe10.webshop.model.Kategorija;
import com.ftninformatika.vezbe10.webshop.model.Proizvod;

public class ProizvodDAO {

	public static Proizvod get(long id) throws Exception {
		Proizvod proizvod = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT naziv, cena, kategorija_id FROM proizvodi WHERE id = " + id;
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				String naziv = rset.getString(index++);
				double cena = rset.getDouble(index++);
				long kategorijaID = rset.getLong(index++);

				Kategorija kategorija = KategorijaDAO.get(kategorijaID);
				proizvod = new Proizvod(id, naziv, cena, kategorija);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return proizvod;
	}

	public static Proizvod getByKategorija(long kategorijaID) throws Exception {
		Proizvod proizvod = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, naziv, cena FROM proizvodi WHERE kategorija_id = " + kategorijaID;
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				String naziv = rset.getString(index++);
				double cena = rset.getDouble(index++);

				Kategorija kategorija = KategorijaDAO.get(kategorijaID);
				proizvod = new Proizvod(id, naziv, cena, kategorija);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return proizvod;
	}
	
	public static List<Proizvod> getAll() throws Exception {
		List<Proizvod> proizvodi = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, naziv, cena, kategorija_id FROM proizvodi";
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				String naziv = rset.getString(index++);
				double cena = rset.getDouble(index++);
				long kategorijaID = rset.getLong(index++);

				Kategorija kategorija = KategorijaDAO.get(kategorijaID);
				Proizvod proizvod = new Proizvod(id, naziv, cena, kategorija);
				proizvodi.add(proizvod);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return proizvodi;
	}

	public static boolean add(Proizvod proizvod) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO proizvodi (naziv, cena, kategorija_id) VALUES (?, ?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, proizvod.getNaziv());
			stmt.setDouble(index++, proizvod.getCena());
			stmt.setLong(index++, proizvod.getKategorija().getID());
			System.out.println(stmt);

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean update(Proizvod proizvod) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE proizvodi SET naziv = ?, cena = ?, kategorija_id = ? WHERE id = " + proizvod.getID();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, proizvod.getNaziv());
			stmt.setDouble(index++, proizvod.getCena());
			stmt.setLong(index++, proizvod.getKategorija().getID());
			System.out.println(stmt);

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean delete(long id) throws Exception {
		Statement stmt = null;
		try {
			String sql = "DELETE FROM proizvodi WHERE id = " + id;
			System.out.println(sql);

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(sql) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
