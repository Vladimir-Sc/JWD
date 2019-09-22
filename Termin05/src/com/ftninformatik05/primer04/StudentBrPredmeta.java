package com.ftninformatik05.primer04;

import java.util.Comparator;

import com.ftninformatik05.primer05.model.Student;

public class StudentBrPredmeta implements Comparator<Student> {
	
	@Override
	public int compare(Student ob1, Student ob2) {
		int retVal = 0;
		if(ob1!= null && ob2!=null){
			retVal = ob1.getIndeks().compareTo(ob2.getIndeks());
		}
//		System.out.println(ob1.getIme());
//		System.out.println(ob2.getIme());
		System.out.println(retVal);
		
		return retVal * -1;
		
		
	}

}
