package menjacnica.dao;

import java.sql.Statement;

import menjacnica.model.VrednostValute;

public class VrednostValuteDAO {

	public static boolean add(VrednostValute vrednostValute) throws Exception {
		Statement stmt = null;
		try {
			String query = "INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES ("
					+ vrednostValute.getValuta().getId() + ", " 
					+ vrednostValute.getKursnaLista().getId() + ", " 
					+ vrednostValute.getKupovniKurs() + ", " 
					+ vrednostValute.getProdajniKurs() + ")";

			stmt = ConnectionManager.getConnection().createStatement();
			return stmt.executeUpdate(query) == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

}
