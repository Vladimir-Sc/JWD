package jwd.AuStanApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.AuStanApp.model.Linija;

@Repository
public interface LinijaRepository extends JpaRepository<Linija, Long> {
	

}
