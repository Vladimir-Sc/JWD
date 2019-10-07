package menjacnica.dao;

import java.sql.PreparedStatement;

import menjacnica.model.VrednostValute;

public class VrednostValuteDao {

	public static boolean add(VrednostValute vv) throws Exception {
		PreparedStatement stmt=null;
		try {
			String sql="INSERT INTO vrednostiValuta"
					+ " (valuta, kursnaLista, kupovniKurs, prodajniKurs)"
					+ " VALUES (?,?,?,?)";
			stmt=ConnectionManager.getConnection().prepareStatement(sql);
			int index=1;
			stmt.setInt(index++, vv.getValuta().getId());
			stmt.setInt(index++, vv.getKursnaLista().getId());
			stmt.setDouble(index++, vv.getKupovniKurs());
			stmt.setDouble(index++, vv.getProdajniKurs());
			
			return stmt.executeUpdate()==1;
		}finally {
			try {stmt.close();}catch(Exception e) {e.printStackTrace();};
		}
	}
}
