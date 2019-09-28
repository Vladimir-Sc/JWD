package com.ftninformatika.termin09.primer01;

import com.ftninformatika.termin09.primer01.model.Vozilo;

public class NaplatnaRampa {

	public double naplatiPutarinu(Vozilo vozilo) {
		return vozilo.platiPutarinu();
	}

	public double naplatiPutarinu(Vozilo[] vozila) {
		double putarina = 0;
		for (Vozilo itVozilo : vozila) {
//			putarina += naplatiPutarinu(itVozilo);
			putarina -= naplatiPutarinu(itVozilo);
		}
		return putarina;
	}

}
