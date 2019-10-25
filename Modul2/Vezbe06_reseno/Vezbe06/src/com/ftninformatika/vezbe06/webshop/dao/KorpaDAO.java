package com.ftninformatika.vezbe06.webshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ftninformatika.vezbe06.webshop.model.Korisnik;
import com.ftninformatika.vezbe06.webshop.model.Korpa;
import com.ftninformatika.vezbe06.webshop.model.Proizvod;
import com.ftninformatika.vezbe06.webshop.model.Stavka;

public class KorpaDAO {

	public static Korpa get(Korisnik korisnik) throws Exception {
		Korpa korpa = new Korpa();

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT proizvod_id, komada FROM korpe WHERE korisnicko_ime = ? ORDER BY redni_broj_stavke ASC";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnik.getKorisnickoIme());
			System.out.println(stmt);

			rset = stmt.executeQuery();

			while (rset.next()) {
				index = 1;
				long proizvodID = rset.getLong(index++);
				int komada = rset.getInt(index++);

				Proizvod proizvod = ProizvodDAO.get(proizvodID);	
				korpa.dodaj(proizvod, komada);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return korpa;
	}

	public static boolean add(Korisnik korisnik, long proizvodID, int komada) throws Exception {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			// izračunati redni broj sledeće stavke
			String sql = "SELECT COUNT(*) FROM korpe WHERE korisnicko_ime = ?";

			stmt = conn.prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnik.getKorisnickoIme());
			System.out.println(stmt);

			rset = stmt.executeQuery();
			if (rset.next()) {
				index = 1;
				int redni_broj_stavke = rset.getInt(index++);
				stmt.close();

				// dodati novu stavku
				sql = "INSERT INTO korpe (korisnicko_ime, redni_broj_stavke, proizvod_id, komada) VALUES (?, ?, ?, ?)";

				stmt = conn.prepareStatement(sql);
				index = 1;
				stmt.setString(index++, korisnik.getKorisnickoIme());
				stmt.setInt(index++, redni_broj_stavke);
				stmt.setLong(index++, proizvodID);
				stmt.setInt(index++, komada);
				System.out.println(stmt);

				return stmt.executeUpdate() == 1;
			}

			return false;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static boolean remove(Korisnik korisnik, int redniBrojStavke) throws Exception {
		Connection conn = ConnectionManager.getConnection();

		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false); // isključivanje automatske transakcije (pri čemu je svaki upit bio transakcija za sebe)
			conn.commit(); // početak transakcije

			// obrisati stavku
			String sql = "DELETE FROM korpe WHERE korisnicko_ime = ? AND redni_broj_stavke = " + redniBrojStavke;

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnik.getKorisnickoIme());
			System.out.println(stmt);

			boolean success = stmt.executeUpdate() == 1;
			stmt.close();

			if (success) {
				// ažurirati redne brojeve svih stavki iza obrisane
				sql = "UPDATE korpe SET redni_broj_stavke = redni_broj_stavke - 1 WHERE korisnicko_ime = ? AND redni_broj_stavke > " + redniBrojStavke;

				stmt = ConnectionManager.getConnection().prepareStatement(sql);
				index = 1;
				stmt.setString(index++, korisnik.getKorisnickoIme());
				System.out.println(sql);

				success = success && stmt.executeUpdate() == 1;
			}
			conn.commit(); // kraj transakcije
			
			return success;
		} catch (Exception ex) {
			try {conn.rollback();} catch (Exception ex1) {ex1.printStackTrace();} // vratiti bazu u stanje pre pocetka transakcije
			
			throw ex;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}

			try {conn.setAutoCommit(true);} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean clear(Korisnik korisnik) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM korpe WHERE korisnicko_ime = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, korisnik.getKorisnickoIme());
			System.out.println(stmt);

			return stmt.executeUpdate() > 0;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public boolean update(Korisnik korisnik, Korpa korpa) throws Exception {
		Connection conn = ConnectionManager.getConnection();
		try {
			conn.setAutoCommit(false); // isključivanje automatske transakcije (pri čemu je svaki upit bio transakcija za sebe)
			conn.commit(); // početak transakcije

			// obrisati sve stavke korpe
			boolean success = clear(korisnik);

			if (success) {
				// ponovo dodati sve stavke korpe
				for (Stavka itStavka: korpa.getStavke()) {
					success = success && add(korisnik, itStavka.getProizvod().getID(), itStavka.getKomada());
				}
			}
			conn.commit(); // kraj transakcije
			
			return success;
		} catch (Exception ex) {
			try {conn.rollback();} catch (Exception ex1) {ex1.printStackTrace();} // vratiti bazu u stanje pre pocetka transakcije
			
			throw ex;
		} finally {
			try {conn.setAutoCommit(true);} catch (Exception ex) {ex.printStackTrace();}
		}
	}	

}
