package com.koukio.service;

import com.koukio.entity.Dvd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * DvdService
 */
@Component
public class DvdService {
	List<Dvd> dvdList = new ArrayList<Dvd>();

    public Dvd createDvd(String title, String description, String category, Date dateCreated) throws Exception{
        Dvd dvd = new Dvd(dvdList.size(), title, description, category, dateCreated);
        dvdList.add(dvdList.size(),dvd);
        return dvd;
    }
    
    public Dvd updateDvd(int dvdId, String title, String description, String category, Date dateCreated) throws Exception{
        Dvd dvd = new Dvd(dvdId, title, description, category, dateCreated);
        dvdList.set(dvdId, dvd);
    	return dvd;
    }
    
    public Dvd deleteDvd(int dvdId) throws Exception{
    	dvdList.get(dvdId).setDeleted(true);
    	return dvdList.get(dvdId);
    }
    
    public List<Dvd> showDvdList() throws Exception{
    	return dvdList;
    }
    
    public List<Dvd> searchDvdTitle(String title) throws Exception{
    	List<Dvd> dvdListbyTitle = new ArrayList<>();
    	for (Dvd dvd : dvdList) {
			if (dvd.getTitle().contains(title)){
				dvdListbyTitle.add(dvd);
			}
		}
    	return dvdListbyTitle;
    }

    public List<Dvd> searchDvdKeyword(String keyword) throws Exception{
    	List<Dvd> dvdListbyKeyword = new ArrayList<>();
    	for (Dvd dvd : dvdList) {
			if (dvd.getDescription().contains(keyword)){
				dvdListbyKeyword.add(dvd);
			}
		}
    	return dvdListbyKeyword;
    }
    
    public String ping() {
        return String.valueOf(System.currentTimeMillis());
    }
}
