package primer.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import menjacnica.dao.ConnectionManager;
import menjacnica.dao.ValutaDao;
import menjacnica.model.Valuta;

public class TestValuteDAO {

	@Before
	public void setUp() throws Exception {
//		Valuta valuta=new Valuta(10, "VAL", "Valuta test");
//		ValutaDao.add(valuta);
		ConnectionManager.open();
	}

	@After
	public void tearDown() throws Exception {
//		ValutaDao.remove(10);
		ConnectionManager.close();
	}

	@Test
	public void testPronadji() {
		Valuta v=null;
		try {
			v = ValutaDao.pronadji("USD");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull("Valuta mora biti pronadjena",v);
	}
	
	@Test
	public void testPronadjiNijeUspesan() {
		Valuta v=null;
		try {
			v = ValutaDao.pronadji("US1");
			assertNull("Valuta ne treba da bude pronadjena",v);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
