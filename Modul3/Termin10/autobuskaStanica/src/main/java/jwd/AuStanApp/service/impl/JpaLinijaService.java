package jwd.AuStanApp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.AuStanApp.model.Linija;
import jwd.AuStanApp.model.Prevoznik;
import jwd.AuStanApp.repository.LinijaRepository;

import jwd.AuStanApp.service.LinijaService;


@Service
@Transactional
public class JpaLinijaService implements LinijaService{

	
	@Autowired
	private LinijaRepository linjaRepository;
	
	@Override
	public Linija findOne(Long id) {
		
		return linjaRepository.findOne(id);
	}

	@Override
	public List<Linija> findAll() {
		
		return linjaRepository.findAll();
	}

	@Override
	public Linija save(Linija linija) {
		
		return linjaRepository.save(linija);
	}

	@Override
	public List<Linija> save(List<Linija> linije) {
		
		return linjaRepository.save(linije);
	}

	@Override
	public Linija delete(Long id) {
		
		Linija linija = linjaRepository.findOne(id);
		if(linija == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		linjaRepository.delete(linija);
		return linija;
	}

	@Override
	public void delete(List<Long> ids) {
		
		
	}

}
