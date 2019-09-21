package com.ftninformatika.termin06.primer03;

import org.apache.commons.math3.primes.Primes;

public class A_DemoThirdPartyBiblioteke {

	private static final int KOLIKO = 10;

	public static void main(String[] args) {
		System.out.print("Prvih " + KOLIKO + " prostih brojeva: ");

		int sledeci = 1;
		for (int it = 0; it < KOLIKO; it++) {
			System.out.print(sledeci + " ");
			sledeci = Primes.nextPrime(sledeci + 1);
		}

	}

}
