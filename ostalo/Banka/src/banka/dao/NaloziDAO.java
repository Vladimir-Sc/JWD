package banka.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import banka.model.Nalog;
import banka.model.Racun;

public class NaloziDAO {

	public static List<Nalog> getAll() throws Exception {
		List<Nalog> nalozi = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, uplatilac, primalac, kreiran, iznos, realizovan FROM nalozi";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				long idUplatioca = rset.getLong(index++);
				long idPrimaoca = rset.getLong(index++);
				Timestamp kreiran = rset.getTimestamp(index++);
				double iznos = rset.getDouble(index++);
				Timestamp realizovan = rset.getTimestamp(index++);

				Racun uplatilac = RacuniDAO.get(idUplatioca);
				Racun primalac = RacuniDAO.get(idPrimaoca);
				Nalog nalog = new Nalog(id, kreiran, iznos, realizovan, uplatilac, primalac);
				nalozi.add(nalog); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nalozi;
	}

	public static List<Nalog> getAllUplatilac(Racun uplatilac) throws Exception {
		List<Nalog> nalozi = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, primalac, kreiran, iznos, realizovan FROM nalozi "
					+ "WHERE uplatilac = " + uplatilac.getId();

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				long idPrimaoca = rset.getLong(index++);
				Timestamp kreiran = rset.getTimestamp(index++);
				double iznos = rset.getDouble(index++);
				Timestamp realizovan = rset.getTimestamp(index++);

				Racun primalac = RacuniDAO.get(idPrimaoca);
				Nalog nalog = new Nalog(id, kreiran, iznos, realizovan, uplatilac, primalac);
				nalozi.add(nalog); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nalozi;
	}

	public static List<Nalog> getAllUplatilac(Racun uplatilac, Date pocetak, Date kraj) throws Exception {
		List<Nalog> nalozi = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, primalac, kreiran, iznos, realizovan FROM nalozi "
					+ "WHERE uplatilac = " + uplatilac.getId() + " AND realizovan BETWEEN ? AND ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setDate(index++, pocetak);
			stmt.setDate(index++, kraj);

			rset = stmt.executeQuery();

			while (rset.next()) {
				index = 1;
				long id = rset.getLong(index++);
				long idPrimaoca = rset.getLong(index++);
				Timestamp kreiran = rset.getTimestamp(index++);
				double iznos = rset.getDouble(index++);
				Timestamp realizovan = rset.getTimestamp(index++);

				Racun primalac = RacuniDAO.get(idPrimaoca);
				Nalog nalog = new Nalog(id, kreiran, iznos, realizovan, uplatilac, primalac);
				nalozi.add(nalog); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nalozi;
	}

	public static List<Nalog> getAllPrimalac(Racun primalac) throws Exception {
		List<Nalog> nalozi = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, uplatilac, kreiran, iznos, realizovan FROM nalozi "
					+ "WHERE primalac = " + primalac.getId();

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				long idUplatioca = rset.getLong(index++);
				Timestamp kreiran = rset.getTimestamp(index++);
				double iznos = rset.getDouble(index++);
				Timestamp realizovan = rset.getTimestamp(index++);

				Racun uplatilac = RacuniDAO.get(idUplatioca);
				Nalog nalog = new Nalog(id, kreiran, iznos, realizovan, uplatilac, primalac);
				nalozi.add(nalog); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nalozi;
	}

	public static List<Nalog> getAllPrimalac(Racun primalac, Date pocetak, Date kraj) throws Exception {
		List<Nalog> nalozi = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, uplatilac, kreiran, iznos, realizovan FROM nalozi "
					+ "WHERE primalac = " + primalac.getId() + " AND realizovan BETWEEN ? AND ?";;

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setDate(index++, pocetak);
			stmt.setDate(index++, kraj);

			rset = stmt.executeQuery();

			while (rset.next()) {
				index = 1;
				long id = rset.getLong(index++);
				long idUplatioca = rset.getLong(index++);
				Timestamp kreiran = rset.getTimestamp(index++);
				double iznos = rset.getDouble(index++);
				Timestamp realizovan = rset.getTimestamp(index++);

				Racun uplatilac = RacuniDAO.get(idUplatioca);
				Nalog nalog = new Nalog(id, kreiran, iznos, realizovan, uplatilac, primalac);
				nalozi.add(nalog); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return nalozi;
	}

	public static boolean add(Nalog nalog) throws Exception {
		Connection conn = null;

		PreparedStatement stmt = null;
		try {
			conn = ConnectionManager.getConnection();
			conn.setAutoCommit(false);
			conn.commit();
			
			String sql = "INSERT INTO nalozi (uplatilac, primalac, kreiran, iznos) VALUES (?, ?, ?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setLong(index++, nalog.getUplatilac().getId());
			stmt.setLong(index++, nalog.getPrimalac().getId());
			stmt.setTimestamp(index++, nalog.getKreiran());
			stmt.setDouble(index++, nalog.getIznos());

			boolean uspeh = stmt.executeUpdate() == 1;
			uspeh = uspeh && RacuniDAO.update(nalog.getUplatilac());
			uspeh = uspeh && RacuniDAO.update(nalog.getPrimalac());
			
			conn.commit();
			
			return uspeh;
		} catch (Exception ex) {
			try {conn.rollback();} catch (Exception ex1) {ex1.printStackTrace();}

			throw ex;
		} finally {
			try {conn.setAutoCommit(true);} catch (Exception ex) {ex.printStackTrace();}
			
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static void realizacija(Timestamp realizovan) throws Exception {
		Connection conn = null;

		PreparedStatement stmt = null;
		try {
			conn = ConnectionManager.getConnection();
			conn.setAutoCommit(false);
			conn.commit();
			
			String sql = "UPDATE nalozi SET realizovan = ? WHERE realizovan IS NULL";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setTimestamp(index++, realizovan);

			stmt.executeUpdate();
			RacuniDAO.relizacija();
			
			conn.commit();
		} catch (Exception ex) {
			try {conn.rollback();} catch (Exception ex1) {ex1.printStackTrace();}

			throw ex;
		} finally {
			try {conn.setAutoCommit(true);} catch (Exception ex) {ex.printStackTrace();}
			
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
}
