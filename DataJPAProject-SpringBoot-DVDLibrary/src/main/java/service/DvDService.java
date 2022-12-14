package service;
import java.util.Collection;
import java.util.List;

import entity.DvD;

public interface DvDService {
	
	Collection<DvD> getAllDvDs();
	
	DvD searchDvDbyID(int Id);
	
	boolean addDvD(DvD dvd);
	
	int deleteDvD(int Id);
	
//	DvD searchDvDbyTitle(String title);
	
	boolean editDvD(int Id);
	
	boolean updateDvD(DvD dvd);
	
	List<DvD> getDvDByDurationGT(double duration);
	

}
