package hotel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import hotel.model.Rezervacija;
import hotel.model.Soba;

public class RezervacijeDAO {

	public static Rezervacija get(long id) throws Exception {
		Rezervacija rezervacija = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT re.id, re.ulazak, re.izlazak, re.gost, so.id, so.tip, so.brojKreveta, so.cenaNocenja FROM rezervacije re "
					+ "LEFT JOIN sobe so ON re.soba = so.id "
					+ "WHERE re.id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();

			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				long rezervacijaID = rset.getLong(index++);
				Timestamp rezervacijaUlazak = rset.getTimestamp(index++);
				Timestamp rezervacijaIzlazak = rset.getTimestamp(index++);
				String rezervacijaGost = rset.getString(index++);

				int sobaID = rset.getInt(index++);
				String sobaTip = rset.getString(index++);
				int sobaBrojKreveta = rset.getInt(index++);
				int sobaCenaNocenja = rset.getInt(index++);

				Soba soba = new Soba(sobaID, sobaTip, sobaBrojKreveta, sobaCenaNocenja);
				rezervacija = new Rezervacija(rezervacijaID, rezervacijaUlazak, rezervacijaIzlazak, rezervacijaGost, soba);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return rezervacija;
	}

	public static List<Rezervacija> getAll() throws Exception {
		List<Rezervacija> rezervacije = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT re.id, re.ulazak, re.izlazak, re.gost, so.id, so.tip, so.brojKreveta, so.cenaNocenja FROM rezervacije re "
					+ "LEFT JOIN sobe so ON re.soba = so.id";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long rezervacijaID = rset.getLong(index++);
				Timestamp rezervacijaUlazak = rset.getTimestamp(index++);
				Timestamp rezervacijaIzlazak = rset.getTimestamp(index++);
				String rezervacijaGost = rset.getString(index++);

				int sobaID = rset.getInt(index++);
				String sobaTip = rset.getString(index++);
				int sobaBrojKreveta = rset.getInt(index++);
				int sobaCenaNocenja = rset.getInt(index++);

				Soba soba = new Soba(sobaID, sobaTip, sobaBrojKreveta, sobaCenaNocenja);
				Rezervacija rezervacija = new Rezervacija(rezervacijaID, rezervacijaUlazak, rezervacijaIzlazak, rezervacijaGost, soba);
				rezervacije.add(rezervacija); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return rezervacije;
	}
	
	public static List<Rezervacija> getAll(Timestamp pocetak, Timestamp kraj) throws Exception {
		List<Rezervacija> rezervacije = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT re.id, re.ulazak, re.izlazak, re.gost, so.id, so.tip, so.brojKreveta, so.cenaNocenja FROM rezervacije re "
					+ "LEFT JOIN sobe so ON re.soba = so.id "
					+ "WHERE (re.ulazak >= ? AND re.ulazak <= ?) OR (re.izlazak >= ? AND re.izlazak <= ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setTimestamp(index++, pocetak);
			stmt.setTimestamp(index++, kraj);
			stmt.setTimestamp(index++, pocetak);
			stmt.setTimestamp(index++, kraj);

			rset = stmt.executeQuery();

			while (rset.next()) {
				index = 1;
				long rezervacijaID = rset.getLong(index++);
				Timestamp rezervacijaUlazak = rset.getTimestamp(index++);
				Timestamp rezervacijaIzlazak = rset.getTimestamp(index++);
				String rezervacijaGost = rset.getString(index++);

				int sobaID = rset.getInt(index++);
				String sobaTip = rset.getString(index++);
				int sobaBrojKreveta = rset.getInt(index++);
				int sobaCenaNocenja = rset.getInt(index++);

				Soba soba = new Soba(sobaID, sobaTip, sobaBrojKreveta, sobaCenaNocenja);
				Rezervacija rezervacija = new Rezervacija(rezervacijaID, rezervacijaUlazak, rezervacijaIzlazak, rezervacijaGost, soba);
				rezervacije.add(rezervacija); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return rezervacije;
	}

	public static boolean update(Rezervacija rezervacija) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE rezervacije SET soba = ?, ulazak = ?, izlazak = ?, gost = ? WHERE id = " + rezervacija.getId();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setInt(index++, rezervacija.getSoba().getId());
			stmt.setTimestamp(index++, rezervacija.getUlazak());
			stmt.setTimestamp(index++, rezervacija.getIzlazak());
			stmt.setString(index++, rezervacija.getGost());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
}
