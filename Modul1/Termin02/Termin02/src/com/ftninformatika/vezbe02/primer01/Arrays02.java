package com.ftninformatika.vezbe02.primer01;

public class Arrays02 {

	public static void main(String[] args) {
		int [] A = { 1 , 2 , 3 , 4 ,  5};	//deklaracija, alokacija i inicijalizacija
		
		//prikazi sumu niza A
		int suma = 0;
		for (int i = 0; i < A.length; i++){
			suma += A[i]; // suma = suma + niz[i];
		}
		
		System.out.println("Suma niza A je:" + suma + "\n");
		
		//TODO Pronaci maksimalni element niza 10, 4, 6, 11, 15, 2
	}
}
