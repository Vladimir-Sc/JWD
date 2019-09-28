package menjacnica.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;

public class ValuteDao {

	public static List<Valuta> getAll() throws Exception{
		
		List<Valuta> valute = new ArrayList<Valuta>();
		Statement stm = null;
		ResultSet rs = null;
		try {
			String sql = "select id, oznaka, naziv from valute"; 
			stm = ConnectionManager.getConnection().createStatement();
			rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				int index = 1;
				int id = rs.getInt(index++);
				String oznaka = rs.getString(index++);
				String naziv = rs.getString(index++);
				
				Valuta v = new Valuta(id,oznaka, naziv);
				valute.add(v);
				
			}
			
		}finally{
			try {stm.close();}catch(Exception e) {e.printStackTrace();};
			try {rs.close();}catch(Exception e) {e.printStackTrace();};
		}
		return valute;
		
	}
	
	public static Valuta pronadji (String oznaka)throws Exception {
		Valuta v = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		
		try {
			
			String sql = "select id, oznaka, naziv from valute where oznaka = ?";
			 stm = (PreparedStatement) ConnectionManager.getConnection().prepareStatement(sql);
				stm.setString(1, oznaka);
			rs = stm.executeQuery();
			
			while (rs.next()) {
				int index = 1;
				int id = rs.getInt(index++);
				String oznakaV = rs.getString(index++);
				String nazivV = rs.getString(index++);
				v = new Valuta (id, oznakaV, nazivV );
				//return v;
			}
			
		}finally {
			
			try {stm.close();}catch(Exception e) {e.printStackTrace();};
			try {rs.close();}catch(Exception e) {e.printStackTrace();};
			
		}
		return v;
		
		
		
	}
	
	
}
