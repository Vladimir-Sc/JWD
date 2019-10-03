package com.ftninformatika.termin09.primer02;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ftninformatika.termin09.primer02.dao.ConnectionManager;
import com.ftninformatika.termin09.primer02.dao.PohadjaDAO;
import com.ftninformatika.termin09.primer02.dao.PredmetDAO;
import com.ftninformatika.termin09.primer02.dao.StudentDAO;
import com.ftninformatika.termin09.primer02.model.Predmet;
import com.ftninformatika.termin09.primer02.model.Student;

public class PohadjaDAOTest {
	
	@BeforeClass
	public static void setUp() throws Exception {
		try {
			ConnectionManager.open();
		} catch (Exception ex) {
			ex.printStackTrace();

			// kraj testa
			fail("Neuspela konekcija na bazu!");
		}

		// dodavanje studenata
		Student s1 = new Student(0, "T 1/12", "Pera", "Peric", "Novi Sad");
		Student s2 = new Student(0, "T 2/12", "Mika", "Mikic", "Novi Sad");					
		assertTrue(StudentDAO.add(s1));	
		assertTrue(StudentDAO.add(s2));
		
		// dodavanje predmeta
		Predmet p1 = new Predmet(0, "Matematika1");
		Predmet p2 = new Predmet(0, "Matematika2");
		assertTrue(PredmetDAO.add(p1));
		assertTrue(PredmetDAO.add(p2));
	}

	@Test
	public void testAll() throws Exception {
		// moraju da postoje prvo studenti i predmeti da bismo testirali pohadjanja
		Student s1 = StudentDAO.getStudentByIndeks("T 1/12");
		assertNotNull(s1);
		Student s2 = StudentDAO.getStudentByIndeks("T 2/12");
		assertNotNull(s2);
		
		Predmet p1 = PredmetDAO.getPredmetByNaziv("Matematika1");
		assertNotNull(p1);
		Predmet p2 = PredmetDAO.getPredmetByNaziv("Matematika2");
		assertNotNull(p2);

		assertTrue("add", PohadjaDAO.add(s1.getId(), p1.getId()));	
		assertTrue("add", PohadjaDAO.add(s1.getId(), p2.getId()));
		assertTrue("add", PohadjaDAO.add(s2.getId(), p1.getId()));
		
		List<Predmet> predmeti1 = PohadjaDAO.getPredmetiByStudentID(s1.getId());
		assertEquals("getPredmetiByStudentID", 2, predmeti1.size());

		List<Predmet> predmeti2 = PohadjaDAO.getPredmetiByStudentID(s2.getId());
		assertEquals("getPredmetiByStudentID", 1, predmeti2.size());
		
		List<Student> studenti1 = PohadjaDAO.getStudentiByPredmetID(p1.getId());
		assertEquals("getStudentiByPredmetID", 2, studenti1.size());

		List<Student> studenti2 = PohadjaDAO.getStudentiByPredmetID(p2.getId());
		assertEquals("getStudentiByPredmetID", 1, studenti2.size());

		assertTrue(PohadjaDAO.delete(s1.getId(), p1.getId()));
		assertTrue(PohadjaDAO.delete(s1.getId(), p2.getId()));
		assertTrue(PohadjaDAO.delete(s2.getId(), p1.getId()));

		predmeti1 = PohadjaDAO.getPredmetiByStudentID(s1.getId());
		assertEquals("delete", 0, predmeti1.size());

		predmeti2 = PohadjaDAO.getPredmetiByStudentID(s2.getId());
		assertEquals("delete", 0, predmeti2.size());
		
		studenti1 = PohadjaDAO.getStudentiByPredmetID(p1.getId());
		assertEquals("delete", 0, studenti1.size());

		studenti2 = PohadjaDAO.getStudentiByPredmetID(p2.getId());
		assertEquals("delete", 0, studenti2.size());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		Student s1 = StudentDAO.getStudentByIndeks("T 1/12");
		assertTrue(StudentDAO.delete(s1.getId()));

		Student s2 = StudentDAO.getStudentByIndeks("T 2/12");
		assertTrue(StudentDAO.delete(s2.getId()));

		Predmet p1 = PredmetDAO.getPredmetByNaziv("Matematika1");
		assertTrue(PredmetDAO.delete(p1.getId()));

		Predmet p2 = PredmetDAO.getPredmetByNaziv("Matematika2");
		assertTrue(PredmetDAO.delete(p2.getId()));

		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
