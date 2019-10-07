package svetskaPrvenstva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import svetskaPrvenstva.model.Drzava;

public class DrzavaDAO {
	
	public static Drzava getByID(int id) throws Exception {
		Drzava drzava = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT naziv FROM drzave WHERE id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				String naziv = rset.getString(index++);
				
				drzava = new Drzava(id, naziv);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return drzava;
	}

	public static Drzava getByNaziv(String naziv) throws Exception {
		Drzava drzava = null;

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id FROM drzave WHERE naziv = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setString(1, naziv);

			rset = stmt.executeQuery();

			if (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				
				drzava = new Drzava(id, naziv);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return drzava;
	}
	
	public static List<Drzava> getAll() throws Exception {
		List<Drzava> drzave = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, naziv FROM drzave";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);

				Drzava drzava = new Drzava(id, naziv);
				drzave.add(drzava);
				
				drzava.getListaDomacinPrvenstava().addAll(PrvenstvoDAO.getAllByDrzavaDomacin(drzava));
				drzava.getListaOsvojenihPrvenstava().addAll(PrvenstvoDAO.getAllByDrzavaOsvajac(drzava));
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return drzave;
	}

	public static boolean add(Drzava drzava) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO drzave (naziv) VALUES (?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, drzava.getNaziv());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean update(Drzava drzava) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE drzave SET naziv = ? WHERE id = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, drzava.getNaziv());
			stmt.setInt(index++, drzava.getID());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
}
