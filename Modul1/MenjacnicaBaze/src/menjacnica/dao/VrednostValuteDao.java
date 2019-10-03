package menjacnica.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;

public class VrednostValuteDao {
	
	public static boolean add (VrednostValute vv) throws SQLException, Exception {

		
		PreparedStatement stm = null;
		//ResultSet rs = null;
		
		try {
			
			String sql = "INSERT INTO vrednostiValuta (valuta, kursnaLista, kupovniKurs, prodajniKurs) VALUES (?, ?, ?, ?);";
			 stm = (PreparedStatement) ConnectionManager.getConnection().prepareStatement(sql);
			 
			 int index = 1 ;
			 
			 
			 stm.setInt(index++, vv.getValuta().getId());
			 
			 stm.setInt(index++, vv.getKursnaLista().getId());
			 
			 stm.setDouble(index++, vv.getKupovniKurs());
			 
			 stm.setDouble(index++, vv.getProdajniKurs());
			 
			return stm.executeUpdate() == 1 ;
		
			
		}finally {
			
			try {stm.close();}catch(Exception e) {e.printStackTrace();};
			//try {rs.close();}catch(Exception e) {e.printStackTrace();};
			
		}
		
		
	}
			
			
	
	
	

}
