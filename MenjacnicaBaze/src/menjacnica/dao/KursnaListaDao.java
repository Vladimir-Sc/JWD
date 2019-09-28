package menjacnica.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;

public class KursnaListaDao {

	public static KursnaLista pronadji(Date datum) throws Exception {
		KursnaLista kl = null;

		PreparedStatement stm = null;
		ResultSet rs = null;

		try {

			String sql = "select k.id, k.datum, vv.valuta, vv.kupovniKurs, vv.prodajniKurs, v.id, v.oznaka, v.naziv "
					+ "from kursneListe k " + "left join vrednostiValuta vv " + "on k.id = vv.kursnaLista "
					+ "left join valute v on v.id = vv.valuta where k.datum = ?";
			stm = (PreparedStatement) ConnectionManager.getConnection().prepareStatement(sql);
			stm.setDate(1, datum);
			rs = stm.executeQuery();

			while (rs.next()) {
				int index = 1;
				int idKL = rs.getInt(index++);
				Date datumKL = rs.getDate(index++);
				double kupovniKurs = rs.getDouble(index++);
				double prodajniKurs = rs.getDouble(index++);

				int idValute = rs.getInt(index++);
				String oznakaV = rs.getString(index++);
				String nazivV = rs.getString(index++);

				if (kl == null) {

					kl = new KursnaLista(idKL, datum);

				}

				Valuta v = new Valuta(idValute, oznakaV, nazivV);

				VrednostValute vv = new VrednostValute(v, kl, kupovniKurs, prodajniKurs);

				kl.getVrednostiValuta().add(vv);
			}

		} finally {

			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			};
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			};

		}
		return kl;
	}

	
	
	//KursnaLista getAll() - treba uraditi metodu
	
	public static int slobodanKluc() throws Exception {

		Statement stm = null;
		ResultSet rs = null;
		try {
			String sql = "select MAX(id) as id from kursneListe";
			stm = ConnectionManager.getConnection().createStatement();
			rs = stm.executeQuery(sql);

			while (rs.next()) {
				int index = 1;
				int id = rs.getInt(index++);

				return ++id;

			}

		} finally {
			try {
				stm.close();
			} catch (Exception e) {
				e.printStackTrace();
			};
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			};
		}

		return 1;
	}
	
	public static boolean add (KursnaLista kl) throws SQLException, Exception {

		
		PreparedStatement stm = null;
		// ResultSet rs = null;
		
		try {
			
			String sql = "INSERT INTO kursneListe (id, datum) VALUES (?, ? )";
			 stm = (PreparedStatement) ConnectionManager.getConnection().prepareStatement(sql);
			 
			 int index = 1 ;
			 
			 
			 stm.setInt(index++, kl.getId());
			 stm.setDate(index++,  kl.getDatum());
			
			 
			return stm.executeUpdate() == 1 ;
		
			
		}finally {
			
			try {stm.close();}catch(Exception e) {e.printStackTrace();};
			// try {rs.close();}catch(Exception e) {e.printStackTrace();};
			
		}
		
		
	}
	
	
	

}
