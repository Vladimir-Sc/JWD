package com.ftninformatik05.primer04;

import java.util.Comparator;

import com.ftninformatik05.primer05.model.Student;

public class StudentImeKomparator implements Comparator<Student>{

	int direction = 1;
	
	public StudentImeKomparator(int direction) {
		if(direction!=1 && direction!=-1){
			direction = 1;
		}
		this.direction = direction;
	}

	@Override
	public int compare(Student ob1, Student ob2) {
		int retVal = 0;
		if(ob1!= null && ob2!=null){
			retVal = ob1.getIme().compareTo(ob2.getIme());
		}
		System.out.println(ob1.getIme());
		System.out.println(ob2.getIme());
		System.out.println(retVal);
		
		return retVal * direction;
	}
}