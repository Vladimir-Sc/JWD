package hotel.ui;

import java.util.List;

import hotel.dao.SobeDAO;
import hotel.model.Soba;

public class SobeUI {

	public static void prikazSvih() {
		try {
			List<Soba> sobe = SobeDAO.getAll();

			System.out.println();
			for (Soba itSoba: sobe) {
				System.out.println(itSoba);
			}
		} catch (Exception ex) {
			System.out.println("Greska u radu sa bazom!");

			ex.printStackTrace();
		}
	}

}
