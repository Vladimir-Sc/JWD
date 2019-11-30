package jwd.AuStanApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.AuStanApp.model.Prevoznik;
import jwd.AuStanApp.service.PrevoznikService;


@RestController
@RequestMapping(value="/api/prevoznici")
public class ApiPrevoznikController {
	
	@Autowired
	private PrevoznikService prevoznikService;
	
	@RequestMapping(method=RequestMethod.GET)
	ResponseEntity<List<Prevoznik>> getPrevoznici(
			@RequestParam(value="naziv", required=false) String naziv){
		
		List<Prevoznik> prevoznici;
		
		if(naziv!=null){
			prevoznici=prevoznikService.findByNaziv(naziv);
		}else{
			prevoznici = prevoznikService.findAll();
		}
		
		System.out.println(prevoznici);
		
		return new ResponseEntity<>(prevoznici, 
				HttpStatus.OK);
	}
	
	

}
