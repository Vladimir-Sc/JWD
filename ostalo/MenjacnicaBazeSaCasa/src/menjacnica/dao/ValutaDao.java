package menjacnica.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import menjacnica.model.Valuta;

public class ValutaDao {

	public static List<Valuta> getAll() throws Exception{
		List<Valuta> valute=new ArrayList<Valuta>();
		Statement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select id, oznaka, naziv from valute";
			
			stmt=ConnectionManager.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int index=1;
				int id=rs.getInt(index++);
				String oznaka=rs.getString(index++);
				String naziv=rs.getString(index++);
				
				Valuta v=new Valuta(id, oznaka, naziv);
				valute.add(v);
			}
		}finally {
			try {stmt.close();}catch(Exception e) {e.printStackTrace();};
			try {rs.close();}catch(Exception e) {e.printStackTrace();};
		}
		return valute;
	}
	
	public static Valuta pronadji(String oznaka) throws Exception {
		Valuta v=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select id,oznaka,naziv from valute where oznaka=?";
			stmt=ConnectionManager.getConnection().prepareStatement(sql);
			
			stmt.setString(1, oznaka);
			
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				int index=1;
				int id=rs.getInt(index++);
				String oznakaV=rs.getString(index++);
				String nazivV=rs.getString(index++);
				v=new Valuta(id, oznakaV, nazivV);
				
			}
		}finally {
			try {stmt.close();}catch(Exception e) {e.printStackTrace();};
			try {rs.close();}catch(Exception e) {e.printStackTrace();};
		}
		return v;
	}
}
