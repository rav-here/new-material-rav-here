package persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.DvD;

@Repository
public interface DvDDao extends JpaRepository<DvD, Integer> {


}
