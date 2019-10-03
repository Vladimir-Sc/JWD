package menjacnica.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import menjacnica.utils.PomocnaKlasaDatumi;

public class KursnaLista {

	private int id;
	private Date datum;
	
	private List<VrednostValute> vrednostiValuta = new ArrayList<>();

	public KursnaLista(int id, Date datum) {
		this.id = id;
		this.datum = datum;
	}

	@Override
	public String toString() {
		String newLine = System.getProperty("line.separator");	
		StringBuilder strVrednosti = new StringBuilder();
		for (VrednostValute itVrednostValute: vrednostiValuta) {
			strVrednosti.append(newLine);
			strVrednosti.append(itVrednostValute);
		}
		
		return "KursnaLista [id=" + id + ", datum=" + PomocnaKlasaDatumi.DATE_FORMAT.format(datum) + "]" + strVrednosti;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KursnaLista other = (KursnaLista) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}
	
	public Date getDatum() {
		return datum;
	}

	public List<VrednostValute> getVrednostiValuta() {
		return vrednostiValuta;
	}
	
}
