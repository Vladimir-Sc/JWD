package jwd.wafepa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.wafepa.model.Record;
import jwd.wafepa.repository.RecordRepository;
import jwd.wafepa.service.RecordService;

@Service
public class JpaRecordService 
	implements RecordService {
	
	@Autowired
	private RecordRepository recordRepository;
	

	@Override
	public Record findOne(Long id) {
		
		return recordRepository.findOne(id);
	}

	@Override
	public List<Record> findAll() {
		return recordRepository.findAll();
	}

	@Override
	public Record save(Record activity) {
		return recordRepository.save(activity);
	}

	@Override
	public List<Record> save(List<Record> records) {
		return recordRepository.save(records);
	}

	@Override
	public Record delete(Long id) {
		Record record = recordRepository.findOne(id);
		if(record == null){
			throw new IllegalArgumentException("Tried to delete"
					+ "non-existant activity");
		}
		recordRepository.delete(record);
		return record;
	}

	@Override
	public void delete(List<Long> ids) {
		for(Long id : ids){
			this.delete(id);
		}
	}

}
