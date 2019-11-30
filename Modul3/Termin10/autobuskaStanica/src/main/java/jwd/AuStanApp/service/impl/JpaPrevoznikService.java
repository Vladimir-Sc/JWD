package jwd.AuStanApp.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.AuStanApp.model.Prevoznik;
import jwd.AuStanApp.repository.PrevoznikRepository;
import jwd.AuStanApp.service.PrevoznikService;



@Service
@Transactional
public class JpaPrevoznikService implements PrevoznikService{

	
	@Autowired
	private PrevoznikRepository prevoznikRepository;
	
	
	@Override
	public Prevoznik findOne(Long id) {
		return prevoznikRepository.findOne(id);
	}

	@Override
	public List<Prevoznik> findAll() {
		
		 return prevoznikRepository.findAll();
	}

	@Override
	public Prevoznik save(Prevoznik prevoznik) {
		
		return prevoznikRepository.save(prevoznik);
	}

	@Override
	public List<Prevoznik> save(List<Prevoznik> prevoznici) {
		
		return prevoznikRepository.save(prevoznici);
	}

	@Override
	public Prevoznik delete(Long id) {
		
		Prevoznik prevoznik = prevoznikRepository.findOne(id);
		if(prevoznik == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		prevoznikRepository.delete(prevoznik);
		return prevoznik;
	}
		
	
	@Override
	public void delete(List<Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Prevoznik> findByNaziv(String naziv) {
		// TODO Auto-generated method stub
		return null;
	}

}
