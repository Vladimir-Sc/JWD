package com.ftninformatika.vezbe02.primer02;

public class Zad01 {

	/*
	Pozeljno je iznad funkcije napisati kratak komentar
	kojim se objasnjava programska logika i svrha funkcije
	*/
	//	ispis Hello World teksta
	static void pozdrav(){
		System.out.println("Hello World");
	}
	
	static void pozdrav2(){
		pozdrav();
		if(Math.random()>0.7)
			return;
		System.out.println("Hello World2");
	}
	
	public static void main(String[] args) {
		pozdrav();
		pozdrav2();
	}
}
