package primerNasladjivanjaProdavnicaRacunara.util;
import java.util.Comparator;

import primerNasladjivanjaProdavnicaRacunara.model.ArtikalProdaje;

@SuppressWarnings("rawtypes")
public class OsnovniSorter implements Comparator {
	
	int direction = 1;
	public OsnovniSorter(int direction) {
		if(direction!=1 && direction!=-1){
			direction = 1;
		}
		this.direction = direction;
	}
	
	public int compare(Object o1, Object o2) {
		int retVal = 0;
		if(o1 != null && o2!= null && o1 instanceof ArtikalProdaje && o2 instanceof ArtikalProdaje){
			ArtikalProdaje objArtikal1 = (ArtikalProdaje)o1;
			ArtikalProdaje objArtikal2 = (ArtikalProdaje)o2;
			retVal = objArtikal1.getNaziv().compareTo(objArtikal2.getNaziv());
		}
		return retVal*direction;
	}
	

}
