package jwd.AuStanApp.service;

import java.util.List;

import jwd.AuStanApp.model.Prevoznik;


public interface PrevoznikService {

	/**
	 * Returns an activity with specified ID.
	 * @param id ID of the activity
	 * @return Activity, if activity with such ID
	 * exists, {@code null} if activity is not found.
	 */
	Prevoznik findOne(Long id);
	
	/**
	 *  
	 * @return List of all existing activities.
	 */
	List<Prevoznik> findAll();
	
	/**
	 * Persists an activity. If activity's id is null,
	 * a new id will be assigned automatically.
	 * @param activity
	 * @return Activity state after persisting. 
	 */
	Prevoznik save(Prevoznik prevoznik);
	
	/**
	 * Persist a list of activities
	 * @param activities
	 * @return
	 */
	List<Prevoznik> save(List<Prevoznik> prevoznici);
	
	/**
	 * Deletes an activity having specified ID.
	 * @param id ID of the activity to be removed. 
	 * @return Removed activity if removal is successful. 
	 * If the activity was not found, an {@link IllegalArgumentException}
	 * is thrown.
	 */
	Prevoznik delete(Long id);
	
	/**
	 * Remove a list of activities.
	 * @param ids A {@link List} of activity IDs (each ID is of type {@link Long})
	 */
	void delete(List<Long> ids);
	
	/**
	 * 
	 * @param name
	 * @return List of Activities who's name equals the string
	 * given in the {@code name} parameter.
	 */
	List<Prevoznik> findByNaziv(String naziv);
	
	
}
