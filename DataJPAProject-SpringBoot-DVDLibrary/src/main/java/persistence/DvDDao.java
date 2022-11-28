package persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.DvD;

@Repository
public interface DvDDao extends JpaRepository<DvD, Integer> {
	
	//List<DvD> findByTitle(String title);
	
	List<DvD> findByDurationGreaterThan(double duration);
	


}
