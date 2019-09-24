package com.ftninformatika.termin07.primer04.ui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin07.primer04.model.Pregled;
import com.ftninformatika.termin07.primer04.utils.PomocnaKlasaDatumi;

public class PregledUI {

	public static void prikazSvih() {
		List<Pregled> pregledi = new ArrayList<>();
		
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String sql = "SELECT id, lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda, tacanDatumVremePregleda, izvestaj "
					+ "FROM pregledi";

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(sql);

			while (rset.next()) {
				int index = 1;
				long id = rset.getLong(index++);
				String lboPacijenta = rset.getString(index++);
				String imePacijenta = rset.getString(index++);
				String prezimePacijenta = rset.getString(index++);
				java.sql.Timestamp datumVremeRodjenjaPacijenta = rset.getTimestamp(index++);
				java.sql.Date datumPregleda = rset.getDate(index++);
				java.sql.Time zakazanoVremePregleda = rset.getTime(index++);
				java.sql.Timestamp tacanDatumVremePregleda = rset.getTimestamp(index++);
				String izvestaj = rset.getString(index++);

				Pregled pregled = new Pregled(id, lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda);
				pregled.setTacanDatumVremePregleda(tacanDatumVremePregleda);
				pregled.setIzvestaj(izvestaj);
				pregledi.add(pregled);
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		} finally {
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		System.out.println();
		for (Pregled itPregled: pregledi) {
			System.out.println(itPregled);
		}
	}

	public static void zakazivanje() {
		System.out.println();
		System.out.print("Unesite LBO pacijenta: ");
		String lboPacijenta = PomocnaKlasaDatumi.ocitajTekst();

		System.out.print("Unesite ime pacijenta: ");
		String imePacijenta = PomocnaKlasaDatumi.ocitajTekst();

		System.out.print("Unesite prezime pacijenta: ");
		String prezimePacijenta = PomocnaKlasaDatumi.ocitajTekst();

		System.out.print("Unesite datum i vreme rodjenja pacijenta (" + PomocnaKlasaDatumi.DATE_TIME_FORMAT.toPattern() + "): ");
		java.sql.Timestamp datumVremeRodjenjaPacijenta = new java.sql.Timestamp(PomocnaKlasaDatumi.ocitajDatumVreme().getTime());

		System.out.print("Unesite datum pregleda (" + PomocnaKlasaDatumi.DATE_FORMAT.toPattern() + "): ");
		java.sql.Date datumPregleda = new java.sql.Date(PomocnaKlasaDatumi.ocitajDatum().getTime());

		System.out.print("Unesite zakazano vreme pregleda (" + PomocnaKlasaDatumi.TIME_FORMAT.toPattern() + "): ");
		java.sql.Time zakazanoVremePregleda = new java.sql.Time(PomocnaKlasaDatumi.ocitajVreme().getTime());

		Pregled pregled = new Pregled(lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda);
		
		PreparedStatement stmt = null;
		try {
			String sql = "INSERT INTO pregledi (lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda, tacanDatumVremePregleda, izvestaj) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

			stmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			stmt.setString(index++, pregled.getLboPacijenta());
			stmt.setString(index++, pregled.getImePacijenta());
			stmt.setString(index++, pregled.getPrezimePacijenta());
			stmt.setTimestamp(index++, pregled.getDatumVremeRodjenjaPacijenta());
			stmt.setDate(index++, pregled.getDatumPregleda());
			stmt.setTime(index++, pregled.getZakazanoVremePregleda());
			stmt.setTimestamp(index++, pregled.getTacanDatumVremePregleda());
			stmt.setString(index++, pregled.getIzvestaj());

			stmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}

	public static void popunjavanje() {
		Pregled pregled = null;

		System.out.println();
		System.out.print("Unesite ID: ");
		long id = PomocnaKlasaDatumi.ocitajLong();

		// citanje
		Statement stmt = null;
		ResultSet rset = null;
		try {
			String query = "SELECT lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda, tacanDatumVremePregleda, izvestaj "
					+ "FROM pregledi "
					+ "WHERE id = " + id;

			stmt = ConnectionManager.getConnection().createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				int index = 1;
				String lboPacijenta = rset.getString(index++);
				String imePacijenta = rset.getString(index++);
				String prezimePacijenta = rset.getString(index++);
				java.sql.Timestamp datumVremeRodjenjaPacijenta = rset.getTimestamp(index++);
				java.sql.Date datumPregleda = rset.getDate(index++);
				java.sql.Time zakazanoVremePregleda = rset.getTime(index++);
				java.sql.Timestamp tacanDatumVremePregleda = rset.getTimestamp(index++);
				String izvestaj = rset.getString(index++);

				pregled = new Pregled(id, lboPacijenta, imePacijenta, prezimePacijenta, datumVremeRodjenjaPacijenta, datumPregleda, zakazanoVremePregleda);
				pregled.setTacanDatumVremePregleda(tacanDatumVremePregleda);
				pregled.setIzvestaj(izvestaj);
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
			return;
		} finally {
			try {rset.close();} catch (Exception ex) {ex.printStackTrace();}
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}

		if (pregled == null) {
			System.out.println("Pogresan ID!");
			return;
		}

		// izmena
		System.out.print("Unesite izvestaj: ");
		String izvestaj = PomocnaKlasaDatumi.ocitajTekst();

		java.sql.Timestamp tacanDatumVremePregleda = new java.sql.Timestamp(new java.util.Date().getTime());

		pregled.setTacanDatumVremePregleda(tacanDatumVremePregleda);
		pregled.setIzvestaj(izvestaj);

		// pisanje
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE pregledi SET tacanDatumVremePregleda = ?, izvestaj = ? "
					+ "WHERE id = ?";

			pstmt = ConnectionManager.getConnection().prepareStatement(sql);
			int index = 1;
			pstmt.setTimestamp(index++, pregled.getTacanDatumVremePregleda());
			pstmt.setString(index++, pregled.getIzvestaj());
			pstmt.setLong(index++, pregled.getID());

			pstmt.executeUpdate();
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		} finally {
			try {stmt.close();} catch (Exception ex) {ex.printStackTrace();}
		}
	}
	
}
