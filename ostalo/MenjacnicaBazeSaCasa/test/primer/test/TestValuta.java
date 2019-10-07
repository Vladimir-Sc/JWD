package primer.test;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import menjacnica.model.Valuta;

public class TestValuta {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected = Exception.class)
	public void test() throws Exception {
		//Oznaka treba da sadrzi tri karaktera
		Valuta v=new Valuta(2, "O", "Test");
	}

}
