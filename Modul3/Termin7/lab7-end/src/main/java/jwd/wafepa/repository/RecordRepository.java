package jwd.wafepa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jwd.wafepa.model.Record;

public interface RecordRepository extends JpaRepository<Record, Long>{

}
