package jwd.AuStanApp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.AuStanApp.model.Rezervacija;
import jwd.AuStanApp.repository.RezervacijaRepository;
import jwd.AuStanApp.service.RezervacijaService;

@Service
@Transactional
public class JpaRezervacijaService implements RezervacijaService{

	
	@Autowired
	private RezervacijaRepository rezervacijaRepository;
	
	
	@Override
	public Rezervacija findOne(Long id) {
		
		return rezervacijaRepository.findOne(id);
	}

	@Override
	public List<Rezervacija> findAll() {
		
		return rezervacijaRepository.findAll();
	}

	@Override
	public Rezervacija save(Rezervacija rezervacija) {
		
		return rezervacijaRepository.save(rezervacija);
	}

	@Override
	public List<Rezervacija> save(List<Rezervacija> rezervacije) {
		
		return rezervacijaRepository.save(rezervacije);
	}

	@Override
	public Rezervacija delete(Long id) {
		
		Rezervacija rezervacija = rezervacijaRepository.findOne(id);
		if(rezervacija == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		rezervacijaRepository.delete(rezervacija);
		return rezervacija;
		
		
	}

}
