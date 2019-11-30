package jwd.AuStanApp;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jwd.AuStanApp.model.Linija;
import jwd.AuStanApp.model.Prevoznik;
import jwd.AuStanApp.model.Rezervacija;
import jwd.AuStanApp.service.LinijaService;
import jwd.AuStanApp.service.PrevoznikService;
import jwd.AuStanApp.service.RezervacijaService;

@Component
public class TestData {

	@Autowired
	private PrevoznikService prevoznikService;
	
	@Autowired
	private LinijaService linijaService;
	
	@Autowired
	private RezervacijaService rezervacijaService;

	@PostConstruct
	public void init() {

		Prevoznik p1 = new Prevoznik("Lasta", "Fruskogorska 17", "333444");
		Prevoznik p2 = new Prevoznik("Macva Ekspres", "Fruskogorska 18", "444555");
		Prevoznik p3 = new Prevoznik("SirmiumBus", "Fruskogorska 19", "555666");

		prevoznikService.save(p1);
		prevoznikService.save(p2);
		prevoznikService.save(p3);
		
		
		Linija l1 = new Linija(50, 320.25, "14:15", "Savac", p1);
		linijaService.save(l1);
		
	//	Rezervacija r1 = new Rezervacija(l1);
	//	Rezervacija r2 = new Rezervacija(l1);
	//	r1.setLinija(l1);
		
	//	rezervacijaService.save(r1);
	//	rezervacijaService.save(r2);
		
	//	linijaService.save(l1);
		
		
	}

}


// Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. 
// The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.