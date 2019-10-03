package com.ftninformatika.termin09.primer02;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ftninformatika.termin09.primer02.dao.ConnectionManager;
import com.ftninformatika.termin09.primer02.dao.StudentDAO;
import com.ftninformatika.termin09.primer02.model.Student;

public class StudentDAOTest {

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
		Student student = new Student(0, "T 1/12", "Pera", "Peric", "Novi Sad");

		assertTrue("add", StudentDAO.add(student));
		student = StudentDAO.getStudentByIndeks("T 1/12");
		assertNotNull("add, getByIndeks", student);

		student.setIndeks("Indeks");
		student.setIme("Ime");
		student.setPrezime("Prezime");
		student.setGrad("Grad");
		assertTrue("update", StudentDAO.update(student));	

		student = StudentDAO.getStudentByID(student.getId());
		assertNotNull("getByID", student);
		assertTrue("update", student.getIndeks().equals("Indeks"));
		assertTrue("update", student.getIme().equals("Ime"));
		assertTrue("update", student.getPrezime().equals("Prezime"));
		assertTrue("update", student.getGrad().equals("Grad"));
	}


	@AfterClass
	public static void tearDown() throws Exception {
		Student student = StudentDAO.getStudentByIndeks("Indeks");
		assertTrue("delete", StudentDAO.delete(student.getId()));
		student = StudentDAO.getStudentByID(student.getId());
		assertTrue("delete", student == null);

		try {
			ConnectionManager.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
	
