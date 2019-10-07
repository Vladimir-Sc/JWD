package hotel.dao;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hotel.model.Soba;

public class SobeDAO {

	public static List<Soba> getAll() throws Exception {
		List<Soba> sobe = new ArrayList<>();

		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, tip, brojKreveta, cenaNocenja FROM sobe";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				int id = rset.getInt(index++);
				String tip = rset.getString(index++);
				int brojKreveta = rset.getInt(index++);
				int cenaNocenja = rset.getInt(index++);

				Soba soba = new Soba(id, tip, brojKreveta, cenaNocenja);
				sobe.add(soba); 
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return sobe;
	}

}
