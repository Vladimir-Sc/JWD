package com.ftninformatika.vezbe03.primer05;

public class IspitnaPrijava {

	private Student student;
	private Predmet predment;
	private IspitniRok ispitniRok;
	private int teorija;
	private int zadaci;

	public IspitnaPrijava() {

	}

	public IspitnaPrijava(Student student, Predmet predment, IspitniRok ispitniRok) {
		super();
		this.student = student;
		this.predment = predment;
		this.ispitniRok = ispitniRok;
	}

	
	public IspitnaPrijava(Student student, Predmet predment, IspitniRok ispitniRok, int teorija, int zadaci) {
		super();
		this.student = student;
		this.predment = predment;
		this.ispitniRok = ispitniRok;
		this.teorija = teorija;
		this.zadaci = zadaci;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredment() {
		return predment;
	}

	public void setPredment(Predmet predment) {
		this.predment = predment;
	}

	public IspitniRok getIspitniRok() {
		return ispitniRok;
	}

	public void setIspitniRok(IspitniRok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}

	public int getTeorija() {
		return teorija;
	}

	public void setTeorija(int teorija) {
		this.teorija = teorija;
	}

	public int getZadaci() {
		return zadaci;
	}

	public void setZadaci(int zadaci) {
		this.zadaci = zadaci;
	}
	
	@Override
	public String toString() {
		return "IspitnaPrijava [student=" + student + ", predment=" + predment + ", ispitniRok=" + ispitniRok
				+ ", teorija=" + teorija + ", zadaci=" + zadaci + "]";
	}

}
