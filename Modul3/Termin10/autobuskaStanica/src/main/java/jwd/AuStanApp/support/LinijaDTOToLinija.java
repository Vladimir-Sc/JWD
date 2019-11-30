package jwd.AuStanApp.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.AuStanApp.model.Linija;
import jwd.AuStanApp.model.Prevoznik;
import jwd.AuStanApp.service.LinijaService;
import jwd.AuStanApp.service.PrevoznikService;
import jwd.AuStanApp.web.dto.LinijaDTO;

@Component
public class LinijaDTOToLinija implements Converter<LinijaDTO, Linija> {

	@Autowired
	private LinijaService linijaService;

	@Autowired
	private PrevoznikService prevoznikService;

	@Override
	public Linija convert(LinijaDTO source) {

		Prevoznik prevoznik = prevoznikService.findOne(source.getPrevoznikId());

		if (prevoznik != null) {

			Linija linija = null;

			if (source.getId() != null) {
				linija = linijaService.findOne(source.getId());
			} else {
				linija = new Linija();
			}

			linija.setId(source.getId());
			linija.setBrojMesta(source.getBrojMesta());
			linija.setCenaKarte(source.getCenaKarte());
			linija.setDestinacija(source.getDestinacija());
			linija.setPrevoznik(prevoznik);
			linija.setVremePolaska(source.getVremePolaska());

			return linija;
		} else {
			throw new IllegalStateException("Trying to attach to non-existant entities");
		}

	}

}
