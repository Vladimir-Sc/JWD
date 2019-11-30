package jwd.AuStanApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.AuStanApp.model.Prevoznik;


@Repository
public interface PrevoznikRepository extends JpaRepository<Prevoznik, Long> {
	
//	@Query("select a from Activity a where a.name = :name")
//	List<Activity> findByName(@Param("name") String name);

	List<Prevoznik> findByNaziv(String naziv);

}
