package com.ftninformatika.termin06.primer02.model;

import java.util.List;

@SuppressWarnings("serial")
public class NeuspesanUpisException extends Exception {

	private List<Student> neupisaniStudenti;
	
	public NeuspesanUpisException(List<Student> neupisaniStudenti) {
		this.neupisaniStudenti = neupisaniStudenti;
	}

	public List<Student> getNeupisaniStudenti() {
		return neupisaniStudenti;
	}

}
