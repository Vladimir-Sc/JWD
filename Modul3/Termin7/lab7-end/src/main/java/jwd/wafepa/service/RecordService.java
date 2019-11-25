package jwd.wafepa.service;

import java.util.List;

import jwd.wafepa.model.Record;

public interface RecordService {
	
	/**
	 * Returns an record with specified ID.
	 * @param id ID of the record
	 * @return Record, if record with such ID
	 * exists, {@code null} if record is not found.
	 */
	Record findOne(Long id);
	
	/**
	 *  
	 * @return List of all existing records.
	 */
	List<Record> findAll();
	
	/**
	 * Persists an record. If record's id is null,
	 * a new id will be assigned automatically.
	 * @param record
	 * @return Record state after persisting. 
	 */
	Record save(Record record);
	
	/**
	 * Persist a list of records
	 * @param record
	 * @return
	 */
	List<Record> save(List<Record> records);
	
	/**
	 * Deletes an record having specified ID.
	 * @param id ID of the record to be removed. 
	 * @return Removed record if removal is successful. 
	 * If the record was not found, an {@link IllegalArgumentException}
	 * is thrown.
	 */
	Record delete(Long id);
	
	/**
	 * Remove a list of records.
	 * @param ids A {@link List} of record IDs (each ID is of type {@link Long})
	 */
	void delete(List<Long> ids);
	
//	/**
//	 * 
//	 * @param name
//	 * @return List of Record who's name equals the string
//	 * given in the {@code name} parameter.
//	 */
//	List<Record> findByName(String name);
	

}
