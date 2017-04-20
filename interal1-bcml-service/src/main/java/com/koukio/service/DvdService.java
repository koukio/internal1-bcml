package com.koukio.service;

import com.koukio.entity.Dvd;
import com.koukio.repository.DvdRepository;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * DvdService
 */
@Component
public class DvdService {
	
	@Autowired
	DvdRepository dvdRepository;

    public Dvd createDvd(String title, String description, String category, Date dateCreated) throws Exception{
        Dvd dvd = new Dvd((int) dvdRepository.count(), title, description, category, dateCreated);
        dvdRepository.save(dvd);
        return dvd;
    }
    
    public Dvd updateDvd(int dvdId, String title, String description, String category, Date dateCreated) throws Exception{
        Dvd dvd = new Dvd(dvdId, title, description, category, dateCreated);
        dvdRepository.save(dvd);
    	return dvd;
    }
    
    public Dvd deleteDvd(int dvdId) throws Exception{
        dvdRepository.findOne(dvdId).setDeleted(true);
    	return dvdRepository.findOne(dvdId);
    }
    
    public Iterable<Dvd> showDvdList() throws Exception{
    	return dvdRepository.findAll();
    }
    
    public List<Dvd> searchDvdTitle(String title) throws Exception{	
    	return dvdRepository.findByTitleContainingAndDeletedAllIgnoringCase(title, false);
    }

    public List<Dvd> searchDvdKeyword(String keyword) throws Exception{
    	return dvdRepository.findByTitleContainingAndDeletedAllIgnoringCase(keyword, false);
    }
    
    public String ping() {
        return String.valueOf(System.currentTimeMillis());
    }
}
