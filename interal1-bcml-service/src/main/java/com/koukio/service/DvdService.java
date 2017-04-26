package com.koukio.service;

import com.koukio.entity.Dvd;
import com.koukio.entity.Event;
import com.koukio.repository.DvdRepository;
import com.koukio.repository.EventRepository;

import java.util.Date;
import java.util.List;

import org.hibernate.jpa.criteria.expression.function.CurrentTimestampFunction;
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
	
	@Autowired
	EventRepository eventRepository;

    public Dvd createDvd(String title, String description, String category, Date dateCreated) throws Exception{
        Dvd dvd = new Dvd(title, description, category, dateCreated);
        dvdRepository.save(dvd);
        Date date = new Date();
        Event event = new Event("Create Dvd", String.valueOf(dvd.getDvdId()), date);
        eventRepository.save(event);
        return dvd;
    }
    
    public Dvd updateDvd(int dvdId, String title, String description, String category, Date dateCreated) throws Exception{
    	Dvd dvd = new Dvd();
    	dvd = dvdRepository.findOne(dvdId);
    	dvd.setTitle(title);
    	dvd.setDescription(description);
    	dvd.setCategory(category);
    	dvd.setDateCreated(dateCreated);
        dvdRepository.save(dvd);
        Date date = new Date();
        Event event = new Event("Update Dvd", String.valueOf(dvd.getDvdId()), date);
        eventRepository.save(event);
    	return dvd;
    }
    
    public Dvd deleteDvd(int dvdId) throws Exception{
        Dvd dvd = dvdRepository.findOne(dvdId);
        dvd.setDeleted(true);
        dvdRepository.save(dvd);
        Date date = new Date();
        Event event = new Event("Delete Dvd", String.valueOf(dvd.getDvdId()), date);
        eventRepository.save(event);
    	return dvdRepository.findOne(dvdId);
    }
    
    public Iterable<Dvd> showDvdList() throws Exception{
    	return dvdRepository.findAll();
    }
    
    public List<Dvd> searchDvdTitle(String title) throws Exception{	
    	return dvdRepository.findByTitleContainingAndDeletedAllIgnoringCase(title, false);
    }

    public List<Dvd> searchDvdKeyword(String keyword) throws Exception{
    	return dvdRepository.findByDescriptionContainingAndDeletedAllIgnoringCase(keyword, false);
    }
    
    public String ping() {
        return String.valueOf(System.currentTimeMillis());
    }
}
