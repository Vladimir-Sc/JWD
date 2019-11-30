package jwd.AuStanApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jwd.AuStanApp.model.Linija;
import jwd.AuStanApp.model.Rezervacija;
import jwd.AuStanApp.service.LinijaService;
import jwd.AuStanApp.service.RezervacijaService;
import jwd.AuStanApp.support.LinijaDTOToLinija;
import jwd.AuStanApp.support.LinijaToLinijaDTO;
import jwd.AuStanApp.web.dto.LinijaDTO;


@RestController
//@RequestMapping(value = "/api/linije")
public class ApiRezervacijaController {
	
	
	@Autowired
	private LinijaToLinijaDTO toLinijaDTO;
	
	@Autowired
	private LinijaDTOToLinija toLinija;
	
	@Autowired
	private LinijaService linijaService;
	
	@Autowired
	private RezervacijaService rezervacijaService;
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/api/linije/{id}",
			consumes="application/json")
	public ResponseEntity<LinijaDTO> edit(
			@RequestBody LinijaDTO linija,
			@PathVariable Long id){
		
		if(!id.equals(linija.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		Linija linijaPersisted = toLinija.convert(linija);
		
		int brojMesta = linijaPersisted.getBrojMesta();
		
		linijaPersisted.setBrojMesta(brojMesta - 1);
		
		linijaService.save(linijaPersisted);
		
		Rezervacija r1 = new Rezervacija(linijaPersisted);
		
		rezervacijaService.save(r1);
		
		return new ResponseEntity<>(
				toLinijaDTO.convert(linijaPersisted),
				HttpStatus.OK);
	}
	
}
