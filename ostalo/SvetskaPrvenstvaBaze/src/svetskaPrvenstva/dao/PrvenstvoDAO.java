package svetskaPrvenstva.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import svetskaPrvenstva.model.Drzava;
import svetskaPrvenstva.model.Prvenstvo;

public class PrvenstvoDAO {
	
	public static Prvenstvo getByID(int id) throws Exception {
		Prvenstvo prvenstvo = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT godina, naziv, domacin, osvajac FROM prvenstva WHERE id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				int godina = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int domacinID = rset.getInt(index++);
				int osvajacID = rset.getInt(index++);

				Drzava domacin = DrzavaDAO.getByID(domacinID);
				Drzava osvajac = DrzavaDAO.getByID(osvajacID);

				prvenstvo = new Prvenstvo(id, godina, naziv, domacin, osvajac);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return prvenstvo;
	}
	
	public static Prvenstvo getByGodina(int godina) throws Exception {
		Prvenstvo prvenstvo = null;

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, naziv, domacin, osvajac FROM prvenstva WHERE godina = " + godina;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			if (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int domacinID = rset.getInt(index++);
				int osvajacID = rset.getInt(index++);

				Drzava domacin = DrzavaDAO.getByID(domacinID);
				Drzava osvajac = DrzavaDAO.getByID(osvajacID);

				prvenstvo = new Prvenstvo(id, godina, naziv, domacin, osvajac);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return prvenstvo;
	}

	private static List<Prvenstvo> getAll(String orderBY) throws Exception {
		List<Prvenstvo> prvenstva = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, godina, naziv, domacin, osvajac FROM prvenstva " + orderBY;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				int godina = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int domacinID = rset.getInt(index++);
				int osvajacID = rset.getInt(index++);

				Drzava domacin = DrzavaDAO.getByID(domacinID);
				Drzava osvajac = DrzavaDAO.getByID(osvajacID);

				Prvenstvo prvenstvo = new Prvenstvo(id, godina, naziv, domacin, osvajac);
				prvenstva.add(prvenstvo);
			}
			rset.close();
			stmt.close();
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return prvenstva;
	}
	
	public static List<Prvenstvo> getAllSortedByNaziv() throws Exception {
		return getAll("ORDER BY naziv ASC");
	}

	public static List<Prvenstvo> getAllSortedByGodina() throws Exception {
		return getAll("ORDER BY godina ASC");
	}

	public static List<Prvenstvo> getAll() throws Exception {
		return getAllSortedByGodina();
	}

	public static List<Prvenstvo> getAllByDrzavaDomacin(Drzava domacin) throws Exception {
		List<Prvenstvo> prvenstva = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, godina, naziv, osvajac FROM prvenstva WHERE domacin = " + domacin.getID();

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				int godina = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int osvajacID = rset.getInt(index++);

				Drzava osvajac = DrzavaDAO.getByID(osvajacID);

				Prvenstvo prvenstvo = new Prvenstvo(id, godina, naziv, domacin, osvajac);
				prvenstva.add(prvenstvo);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return prvenstva;
	}

	public static List<Prvenstvo> getAllByDrzavaOsvajac(Drzava osvajac) throws Exception {
		List<Prvenstvo> prvenstva = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, godina, naziv, domacin FROM prvenstva WHERE osvajac = " + osvajac.getID();

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				int godina = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int domacinID = rset.getInt(index++);

				Drzava domacin = DrzavaDAO.getByID(domacinID);

				Prvenstvo prvenstvo = new Prvenstvo(id, godina, naziv, domacin, osvajac);
				prvenstva.add(prvenstvo);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return prvenstva;
	}

	public static List<Prvenstvo> getAllByGodina(int donjaGranica, int gornjaGranica) throws Exception {
		List<Prvenstvo> prvenstva = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, godina, naziv, domacin, osvajac FROM prvenstva WHERE godina >= " + donjaGranica + " AND godina <= " + gornjaGranica;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				int godina = rset.getInt(index++);
				String naziv = rset.getString(index++);
				int domacinID = rset.getInt(index++);
				int osvajacID = rset.getInt(index++);

				Drzava domacin = DrzavaDAO.getByID(domacinID);
				Drzava osvajac = DrzavaDAO.getByID(osvajacID);

				Prvenstvo prvenstvo = new Prvenstvo(id, godina, naziv, domacin, osvajac);
				prvenstva.add(prvenstvo);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return prvenstva;
	}

	public static List<Prvenstvo> getAllByNaziv(String naziv) throws Exception {
		List<Prvenstvo> prvenstva = new ArrayList<>();

		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, godina, naziv, domacin, osvajac FROM prvenstva WHERE naziv LIKE ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, "%" + naziv + "%");

			rset = stmt.executeQuery();

			while (rset.next()) {
				index = 1;
				int id = rset.getInt(index++);
				int godina = rset.getInt(index++);
				naziv = rset.getString(index++);
				int domacinID = rset.getInt(index++);
				int osvajacID = rset.getInt(index++);

				Drzava domacin = DrzavaDAO.getByID(domacinID);
				Drzava osvajac = DrzavaDAO.getByID(osvajacID);

				Prvenstvo prvenstvo = new Prvenstvo(id, godina, naziv, domacin, osvajac);
				prvenstva.add(prvenstvo);
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return prvenstva;
	}
	
	public static boolean add(Prvenstvo prvenstvo) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO prvenstva (godina, naziv, domacin, osvajac) VALUES (?, ?, ?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setInt(index++, prvenstvo.getGodina());
			stmt.setString(index++, prvenstvo.getNaziv());
			stmt.setInt(index++, prvenstvo.getDomacin().getID());
			stmt.setInt(index++, prvenstvo.getOsvajac().getID());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
	public static boolean update(Prvenstvo prvenstvo) throws Exception {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE prvenstva SET naziv = ?, domacin = ?, osvajac = ? WHERE id = " + prvenstvo.getId();

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, prvenstvo.getNaziv());
			stmt.setInt(index++, prvenstvo.getDomacin().getID());
			stmt.setInt(index++, prvenstvo.getOsvajac().getID());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
