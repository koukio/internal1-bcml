package com.koukio.service;

import java.util.Date;
import java.util.List;

import com.koukio.entity.Dvd;

public interface DvdServiceInterface {
    public Dvd createDvd(String title, String description, String category, Date dateCreated) throws Exception;
    
    public Dvd updateDvd(int dvdId, String title, String description, String category, Date dateCreated) throws Exception;
    
    public Dvd deleteDvd(int dvdId) throws Exception;
    
    public List<Dvd> showDvdList() throws Exception;
    
    public List<Dvd> searchDvdTitle(String title) throws Exception;
    
    public List<Dvd> searchDvdKeyword() throws Exception;
    
    public String ping();
}
