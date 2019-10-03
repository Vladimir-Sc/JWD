package com.ftninformatika.termin06.primer02;

import java.util.ArrayList;
import java.util.List;

import com.ftninformatika.termin06.primer02.model.NeuspesanUpisException;
import com.ftninformatika.termin06.primer02.model.Student;
import com.ftninformatika.termin06.primer02.model.StudijskiProgram;

public class F_DemoNasledjivanjeIzuzetaka {

	public static void main(String[] args) {
		List<Student> studenti = new ArrayList<>();
		studenti.add(new Student("0001", "A", "A"));
		studenti.add(new Student("0002", "B", "B"));
		studenti.add(new Student("0003", "C", "C"));
		studenti.add(new Student("0004", "D", "D"));
		studenti.add(new Student("0005", "E", "E"));
		studenti.add(new Student("0006", "F", "F"));
		studenti.add(new Student("0007", "G", "G"));

		System.out.println("Svi studenti:");
		for (Student itStudent: studenti) {
			System.out.println(itStudent);
		}
		
		StudijskiProgram studijskiProgram = new StudijskiProgram(5);

		System.out.println();
		System.out.println("Pre upisa:");
		System.out.println(studijskiProgram);
		try {
			studijskiProgram.upisi(studenti);
		} catch (NeuspesanUpisException ex) {
			System.out.println();
			System.out.println("Neupisani studenti:");
			for (Student itStudent: ex.getNeupisaniStudenti()) {
				System.out.println(itStudent);
			}
		}

		System.out.println();
		System.out.println("Nakon upisa:");
		System.out.println(studijskiProgram);
	}
	
}
