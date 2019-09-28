package com.ftninformatika.termin09.primer02;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ftninformatika.termin09.primer02.dao.ConnectionManager;
import com.ftninformatika.termin09.primer02.dao.PredmetDAO;
import com.ftninformatika.termin09.primer02.model.Predmet;

public class PredmetDAOTest {

	@BeforeClass
	public static void setUp() throws Exception {
		try {
			ConnectionManager.open();
		} catch (Exception ex) {
			ex.printStackTrace();

			// kraj testa
			fail("Neuspela konekcija na bazu!");
		}
	}

	@Test
	public void testAll() throws Exception {
		Predmet predmet = new Predmet(0, "Matematika");

		assertTrue("add", PredmetDAO.add(predmet));	
		predmet = PredmetDAO.getPredmetByNaziv("Matematika");
		assertNotNull("add, getByNaziv", predmet);

		predmet.setNaziv("Naziv");
		assertTrue("update", PredmetDAO.update(predmet));

		predmet = PredmetDAO.getPredmetByID(predmet.getId());
		assertNotNull("getByID", predmet);
		assertTrue("update", predmet.getNaziv().equals("Naziv"));
	}

	@AfterClass
	public static void tearDown() throws Exception {
		Predmet predmet = PredmetDAO.getPredmetByNaziv("Naziv");
		assertTrue("delete", PredmetDAO.delete(predmet.getId()));
		predmet = PredmetDAO.getPredmetByID(predmet.getId());
		assertTrue("delete", predmet == null);

		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
