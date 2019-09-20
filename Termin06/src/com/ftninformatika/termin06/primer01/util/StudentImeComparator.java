package com.ftninformatika.termin06.primer01.util;

import java.util.Comparator;

import com.ftninformatika.termin06.primer01.model.Student;

public class StudentImeComparator implements Comparator<Student>{

	private int smer = 1;

	public StudentImeComparator(int smer) {
		this.smer = smer;
	}

	@Override
	public int compare(Student student1, Student student2) {
		int rezultat = student1.getIme().compareTo(student2.getIme());
		return rezultat*smer;
	}

}