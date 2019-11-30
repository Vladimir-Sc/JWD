package jwd.AuStanApp.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.AuStanApp.model.Linija;
import jwd.AuStanApp.web.dto.LinijaDTO;

@Component
public class LinijaToLinijaDTO implements Converter<Linija, LinijaDTO> {

	@Override
	public LinijaDTO convert(Linija source) {

		LinijaDTO retValue = new LinijaDTO();

		retValue.setId(source.getId());
		retValue.setBrojMesta(source.getBrojMesta());
		retValue.setCenaKarte(source.getCenaKarte());
		retValue.setVremePolaska(source.getVremePolaska());
		retValue.setDestinacija(source.getDestinacija());
		retValue.setPrevoznikId(source.getPrevoznik().getId());

		return retValue;
	}

	public List<LinijaDTO> convert(List<Linija> linije) {
		List<LinijaDTO> ret = new ArrayList<>();

		for (Linija linija : linije) {
			ret.add(convert(linija));
		}

		return ret;
	}

}
