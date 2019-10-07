package menjacnica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;

public class KursnaListaDao {
	public static KursnaLista pronadji(Date datum) throws Exception {
		KursnaLista kl=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select k.id,k.datum,vv.kupovniKurs,"
					+ " vv.prodajniKurs,v.id,v.oznaka,v.naziv" + 
					" from kursneListe k left join vrednostiValuta vv"
					+ " on k.id = vv.kursnaLista " + 
					" left join valute v on v.id = vv.valuta"
					+ " where k.datum = ?";
			stmt=ConnectionManager.getConnection().prepareStatement(sql);
			
			stmt.setDate(1, datum);
			
			rs=stmt.executeQuery();
			
			while(rs.next()) {
				int index=1;
				int idKL=rs.getInt(index++);
				Date datumKL=rs.getDate(index++);
				double kk=rs.getDouble(index++);
				double pk=rs.getDouble(index++);
				int idV=rs.getInt(index++);
				String oznaka=rs.getString(index++);
				String naziv=rs.getString(index++);
				if(kl==null)
				{
					kl=new KursnaLista(idKL, datumKL);
				}
				/*
				 * Ako za kursnu listu nema vrednosti valuta
				 * umesto null dobijamo 0 za int, pa ne 
				 * treba da se kreira VrednostValute
				 */
				if(idV!=0)
				{
				
					Valuta v=new Valuta(idV, oznaka, naziv);
					
					
					VrednostValute vv=new VrednostValute(v, kl, kk, pk);
					kl.getVrednostiValuta().add(vv);
				}
			}
		}finally {
			try {stmt.close();}catch(Exception e) {e.printStackTrace();};
			try {rs.close();}catch(Exception e) {e.printStackTrace();};
		}
		return kl;
	}
	
	public static Collection<KursnaLista> getAll() throws Exception {
		Map<Integer, KursnaLista> kursneListe=new HashMap<Integer, KursnaLista>();
		KursnaLista kl=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select k.id,k.datum,vv.kupovniKurs,"
					+ " vv.prodajniKurs,v.id,v.oznaka,v.naziv" + 
					" from kursneListe k left join vrednostiValuta vv"
					+ " on k.id = vv.kursnaLista " + 
					" left join valute v on v.id = vv.valuta";
			stmt=ConnectionManager.getConnection().createStatement();
			
			
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int index=1;
				int idKL=rs.getInt(index++);
				Date datumKL=rs.getDate(index++);
				double kk=rs.getDouble(index++);
				double pk=rs.getDouble(index++);
				int idV=rs.getInt(index++);
				String oznaka=rs.getString(index++);
				String naziv=rs.getString(index++);
				kl=kursneListe.get(idKL);
				if(kl==null)
				{
					kl=new KursnaLista(idKL, datumKL);
					kursneListe.put(idKL, kl);
				}
				/*
				 * Ako za kursnu listu nema vrednosti valuta
				 * umesto null dobijamo 0 za int, pa ne 
				 * treba da se kreira VrednostValute
				 */
				if(idV!=0)
				{
					Valuta v=new Valuta(idV, oznaka, naziv);
					
					
					VrednostValute vv=new VrednostValute(v, kl, kk, pk);
					kl.getVrednostiValuta().add(vv);
				}
			}
		}finally {
			try {stmt.close();}catch(Exception e) {e.printStackTrace();};
			try {rs.close();}catch(Exception e) {e.printStackTrace();};
		}
		return kursneListe.values();
	}
	
	public static int slobodanKljuc() throws Exception {
		Statement stmt=null;
		ResultSet rs=null;
		try {
			String sql="select MAX(id) as id from kursneListe";
			
			stmt=ConnectionManager.getConnection().createStatement();
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				int index=1;
				int id=rs.getInt(index++);
				return ++id;
			}
		}finally {
			try {stmt.close();}catch(Exception e) {e.printStackTrace();};
			try {rs.close();}catch(Exception e) {e.printStackTrace();};
		}
		return 1;
	}
	public static boolean add(KursnaLista kl) throws Exception {
		PreparedStatement stmt=null;
		try {
			String sql="INSERT INTO kursneListe (id, datum)"
					+ " VALUES (?, ?)";
			stmt=ConnectionManager.getConnection().prepareStatement(sql);
			int index=1;
			stmt.setInt(index++, kl.getId());
			stmt.setDate(index++, kl.getDatum());
			
			return stmt.executeUpdate()==1;
		}finally {
			try {stmt.close();}catch(Exception e) {e.printStackTrace();};
		}
	}
}
