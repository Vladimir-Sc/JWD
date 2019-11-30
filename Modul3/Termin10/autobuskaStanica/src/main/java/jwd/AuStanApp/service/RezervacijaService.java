package jwd.AuStanApp.service;

import java.util.List;

import jwd.AuStanApp.model.Linija;
import jwd.AuStanApp.model.Rezervacija;

public interface RezervacijaService {
	
	Rezervacija findOne(Long id);
	
	/**
	 *  
	 * @return List of all existing activities.
	 */
	List<Rezervacija> findAll();
	
	/**
	 * Persists an activity. If activity's id is null,
	 * a new id will be assigned automatically.
	 * @param activity
	 * @return Activity state after persisting. 
	 */
	Rezervacija save(Rezervacija rezervacija);
	
	/**
	 * Persist a list of activities
	 * @param activities
	 * @return
	 */
	List<Rezervacija> save(List<Rezervacija> rezervacije);
	
	/**
	 * Deletes an activity having specified ID.
	 * @param id ID of the activity to be removed. 
	 * @return Removed activity if removal is successful. 
	 * If the activity was not found, an {@link IllegalArgumentException}
	 * is thrown.
	 */
	Rezervacija delete(Long id);
	

}
