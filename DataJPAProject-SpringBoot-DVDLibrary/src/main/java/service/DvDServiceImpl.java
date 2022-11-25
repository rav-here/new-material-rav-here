package service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import entity.DvD;
import persistence.DvDDao;

@Component("service")
public class DvDServiceImpl implements DvDService {
	
	@Autowired
	private DvDDao dvdDao;
	

	@Override
	public Collection<DvD> getAllDvDs() {
		// find all method returns a list of all objects in the database
		return dvdDao.findAll();
	}
	
	@Override
	public DvD searchDvDbyID(int Id) {
		//find by Id method returns a DvD object via searching for its Id
		return dvdDao.findById(Id).orElse(null);
	}

	@Override
	public boolean addDvD(DvD dvd) {
		// if the DvD object being searched for does not exist
		if (searchDvDbyID(dvd.getId()) == null) {
			// add it to the database
			dvdDao.save(dvd);
			// return true
			return true;
		}
		// if t does exist, do not add it and return false
		return false;

	}

	@Override
	public int deleteDvD(int Id) {
		// if the DvD object we want to delete exists in the database
		if (searchDvDbyID(Id) != null) {
			// delete it 
			dvdDao.deleteById(Id);
			// return 1
			return 1;
		}
		// if object does not exist, do nothing and return 0
		return 0;
	}

//	@Override
//	public DvD searchDvDbyTitle(String title) {
//		return dvdDao.findByTitle(title);
//	}

	@Override
	public boolean editDvD(int Id) {
		// if the DvD object exists, delete it and add a new updated one
		if (searchDvDbyID(Id) != null) {
			return true;
		}
		// if DvD object dne do nothing
		return false;
	}
	
	@Override 
	public boolean updateDvD(DvD dvd) {
		// update and save the dvd object 
		dvdDao.save(dvd);
		return true;
		
	}
	
	
	

}
