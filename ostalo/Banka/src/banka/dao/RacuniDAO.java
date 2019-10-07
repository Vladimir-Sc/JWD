package banka.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import banka.model.Racun;

public class RacuniDAO {

	public static Racun get(long id) throws Exception {
		Racun racun = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT sifra, vlasnik, stanje, raspolozivoStanje FROM racuni WHERE id = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setLong(index++, id);

			rset = stmt.executeQuery();

			if (rset.next()) {
				index = 1;
				String sifra = rset.getString(index++);
				String vlasnik = rset.getString(index++);
				double stanje = rset.getDouble(index++);
				double raspolozivoStanje = rset.getDouble(index++);
				
				racun = new Racun(id, sifra, vlasnik, stanje, raspolozivoStanje);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return racun;
	}
	
	public static Racun get(String sifra) throws Exception {
		Racun racun = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, vlasnik, stanje, raspolozivoStanje FROM racuni WHERE sifra = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, sifra);

			rset = stmt.executeQuery();

			if (rset.next()) {
				index = 1;
				long id = rset.getLong(index++);
				String vlasnik = rset.getString(index++);
				double stanje = rset.getDouble(index++);
				double raspolozivoStanje = rset.getDouble(index++);
				
				racun = new Racun(id, sifra, vlasnik, stanje, raspolozivoStanje);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return racun;
	}

	public static Racun get(String sifra, Date pocetak, Date kraj) throws Exception {
		Racun racun = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, vlasnik, stanje, raspolozivoStanje FROM racuni WHERE sifra = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, sifra);

			rset = stmt.executeQuery();

			if (rset.next()) {
				index = 1;
				long id = rset.getLong(index++);
				String vlasnik = rset.getString(index++);
				double stanje = rset.getDouble(index++);
				double raspolozivoStanje = rset.getDouble(index++);
				
				racun = new Racun(id, sifra, vlasnik, stanje, raspolozivoStanje);
				racun.getNaloziUplatilac().addAll(NaloziDAO.getAllUplatilac(racun, pocetak, kraj));
				racun.getNaloziPrimalac().addAll(NaloziDAO.getAllPrimalac(racun, pocetak, kraj));
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return racun;
	}
	
	public static List<Racun> getAll() throws Exception {
		List<Racun> racuni = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, sifra, vlasnik, stanje, raspolozivoStanje FROM racuni";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				String sifra = rset.getString(index++);
				String vlasnik = rset.getString(index++);
				double stanje = rset.getDouble(index++);
				double raspolozivoStanje = rset.getDouble(index++);

				Racun racun = new Racun(id, sifra, vlasnik, stanje, raspolozivoStanje);
				racun.getNaloziUplatilac().addAll(NaloziDAO.getAllUplatilac(racun));
				racun.getNaloziPrimalac().addAll(NaloziDAO.getAllPrimalac(racun));
				racuni.add(racun); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return racuni;
	}
	
	public static boolean update(Racun racun) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE racuni SET sifra = ?, vlasnik = ?, stanje = ?, raspolozivoStanje = ? WHERE id = " + racun.getId();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, racun.getSifra());
			stmt.setString(index++, racun.getVlasnik());
			stmt.setDouble(index++, racun.getStanje());
			stmt.setDouble(index++, racun.getRaspolozivoStanje());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static void relizacija() throws Exception {
		Statement stmt = null;
		try {
			String sql = "UPDATE racuni SET stanje = raspolozivoStanje";

			stmt = ConnectionManager.getConnection().createStatement();

			stmt.executeUpdate(sql);
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
