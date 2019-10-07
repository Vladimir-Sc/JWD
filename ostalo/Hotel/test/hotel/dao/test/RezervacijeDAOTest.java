package hotel.dao.test;

import static org.junit.Assert.*;

import java.sql.Timestamp;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import hotel.dao.ConnectionManager;
import hotel.dao.RezervacijeDAO;
import hotel.model.Rezervacija;
import hotel.utils.PomocnaKlasaDatumi;

public class RezervacijeDAOTest {

	private static Rezervacija original;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ConnectionManager.open();

		original = RezervacijeDAO.getAll().get(0);
	}

	@Test
	public void test() throws Exception {
		Rezervacija test = RezervacijeDAO.getAll().get(0);

		Timestamp ulazak = new Timestamp(PomocnaKlasaDatumi.DATE_TIME_FORMAT.parse("01.01.1900. 00:00:00").getTime());
		Timestamp izlazak = new Timestamp(PomocnaKlasaDatumi.DATE_TIME_FORMAT.parse("01.02.1900. 01:00:00").getTime());
		test.setUlazak(ulazak);
		test.setIzlazak(izlazak);
		RezervacijeDAO.update(test);

		test = RezervacijeDAO.get(test.getId());
		assertEquals(test.getUlazak(), ulazak);
		assertEquals(test.getIzlazak(), izlazak);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		RezervacijeDAO.update(original);

		ConnectionManager.close();
	}
	
}
