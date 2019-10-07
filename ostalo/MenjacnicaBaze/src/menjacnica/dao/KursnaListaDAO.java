package menjacnica.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import menjacnica.model.KursnaLista;
import menjacnica.model.Valuta;
import menjacnica.model.VrednostValute;

public class KursnaListaDAO {

	public static KursnaLista get(Date datum) throws Exception {
		KursnaLista kursnaLista = null;
		
		PreparedStatement stmt = null;
		ResultSet rset = null;
		try {
			String sql = 
					"SELECT kl.id, v.id, v.oznaka, v.naziv, vv.kupovniKurs, vv.prodajniKurs FROM kursneListe kl " + 
					"LEFT JOIN vrednostiValuta vv ON kl.id = vv.kursnaLista " +  
					"LEFT JOIN valute v ON v.id = vv.valuta " + 
					"WHERE kl.datum = ?";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setDate(1, datum);

			rset = stmt.executeQuery();
			while (rset.next()) {
				// kursne liste
				if (kursnaLista == null) {
					int index = 1;
					int id = rset.getInt(index++);

					kursnaLista = new KursnaLista(id, datum);
				}
				int index = 2;
				// valute
				int id = rset.getInt(index++);
				String oznaka = rset.getString(index++);
				String naziv = rset.getString(index++);

				Valuta valuta = new Valuta(id, oznaka, naziv);
				
				// vrednost valute
				double kupovniKurs = rset.getDouble(index++);
				double prodajniKurs = rset.getDouble(index++);

				VrednostValute vrednostValute = new VrednostValute(valuta, kursnaLista, kupovniKurs, prodajniKurs);
//				valuta.getVrednostiValuta().add(vrednostValute);
				kursnaLista.getVrednostiValuta().add(vrednostValute); // azurirati vezu u suprotnom smeru odmah nakon kreiranja veze u jednom smeru
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return kursnaLista;
	}

	public static boolean add(KursnaLista kursnaLista) throws Exception {	
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO kursneListe (datum) VALUES (?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			stmt.setDate(1, kursnaLista.getDatum());

			return stmt.executeUpdate() == 1;
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static Collection<KursnaLista> getAll() throws Exception {
		Map<Integer, KursnaLista> kursneListe = new LinkedHashMap<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = 
					"SELECT kl.id, kl.datum, v.id, v.oznaka, v.naziv, vv.kupovniKurs, vv.prodajniKurs FROM kursneListe kl " + 
					"LEFT JOIN vrednostiValuta vv ON kl.id = vv.kursnaLista " +  
					"LEFT JOIN valute v ON v.id = vv.valuta";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				// kursne liste
				int idKursneListe = rset.getInt(index++);
				
				KursnaLista kursnaLista = kursneListe.get(idKursneListe);
				if (kursnaLista == null) {
					Date datum = rset.getDate(index++);

					kursnaLista = new KursnaLista(idKursneListe, datum);
					kursneListe.put(idKursneListe, kursnaLista);
				}
				index = 3;
				// valute
				int idValute = rset.getInt(index++);
				String oznaka = rset.getString(index++);
				String naziv = rset.getString(index++);

				Valuta valuta = new Valuta(idValute, oznaka, naziv);
				
				// vrednost valute
				double kupovniKurs = rset.getDouble(index++);
				double prodajniKurs = rset.getDouble(index++);

				VrednostValute vrednostValute = new VrednostValute(valuta, kursnaLista, kupovniKurs, prodajniKurs);
//				valuta.getVrednostiValuta().add(vrednostValute);
				kursnaLista.getVrednostiValuta().add(vrednostValute); // azurirati vezu u suprotnom smeru odmah nakon kreiranja veze u jednom smeru
			}
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		return kursneListe.values();
	}
	
}
