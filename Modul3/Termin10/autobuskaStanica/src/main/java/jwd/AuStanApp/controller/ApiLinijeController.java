package jwd.AuStanApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.AuStanApp.model.Linija;
import jwd.AuStanApp.service.LinijaService;
import jwd.AuStanApp.web.dto.LinijaDTO;
import jwd.AuStanApp.support.LinijaToLinijaDTO;

@RestController
@RequestMapping(value = "/api/linije")
public class ApiLinijeController {

	@Autowired
	private LinijaService linijaService;

	@Autowired
	private LinijaToLinijaDTO toDTO;

	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<List<LinijaDTO>> getLinije(@RequestParam(value = "naziv", required = false) String naziv) {

		List<Linija> linije;

		linije = linijaService.findAll();

		return new ResponseEntity<>(toDTO.convert(linije), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	ResponseEntity<LinijaDTO> getLinija(@PathVariable Long id) {
		Linija linija = linijaService.findOne(id);
		if (linija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(toDTO.convert(linija), HttpStatus.OK);
	}

}
