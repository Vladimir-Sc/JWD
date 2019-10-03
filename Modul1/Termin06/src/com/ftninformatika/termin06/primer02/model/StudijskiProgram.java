package com.ftninformatika.termin06.primer02.model;

import java.util.List;

public class StudijskiProgram {

	private Student[] studenti;
	private int popunjeno = 0;

	public StudijskiProgram(int kapacitet) {
		this.studenti = new Student[kapacitet];
	}
	
	public void upisi(List<Student> studenti) throws NeuspesanUpisException {
		int brojUpisanih = Math.min(studenti.size(), this.studenti.length - popunjeno);

		List<Student> upisaniStudenti = studenti.subList(0, brojUpisanih);
		for (int it = 0; it < upisaniStudenti.size(); it++) {
			this.studenti[popunjeno] = upisaniStudenti.get(it);
			popunjeno++;
		}

		List<Student> neupisaniStudenti = studenti.subList(brojUpisanih, studenti.size());
		if (neupisaniStudenti.size() > 0) {
			throw new NeuspesanUpisException(neupisaniStudenti);
		}
	}

	@Override
	public String toString() {
		StringBuilder studijskiProgram = new StringBuilder();
		studijskiProgram.append("Studijski program" + System.lineSeparator());
		studijskiProgram.append("----------------------------------------" + System.lineSeparator());
		for (Student itStudent: studenti) {
			if (itStudent == null) {
				studijskiProgram.append("<slobodno>" + System.lineSeparator());
			} else {
				studijskiProgram.append(itStudent + System.lineSeparator());
			}

		}
		return studijskiProgram.toString();
	}

	
	
}
