package com.koukio.controller;

import com.koukio.entity.Dvd;
import com.koukio.service.DvdService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DvdController
 */
@RestController
public class DvdController {


    @Autowired
    DvdService dvdService;

    // check more documentation at https://spring.io/guides/gs/rest-service/

    @RequestMapping("/dvdping")
    public String ping() {
        return "pong:" + dvdService.ping();
    }

    @RequestMapping("/createDvd")
    public Dvd createDvd(@RequestParam(value="title") String title,
    		@RequestParam(value="description") String description,
    		@RequestParam(value="category") String category,
    		@RequestParam(value="dateCreated") Date dateCreated) throws Exception {
        return  dvdService.createDvd(title, description, category, dateCreated);
    }

    @RequestMapping("/updateDvd")
    public Dvd updateDvd(@RequestParam(value="dvdId") int dvdId,
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String description,
    		@RequestParam(value="category") String category,
    		@RequestParam(value="dateCreated") Date dateCreated) throws Exception {
        return  dvdService.updateDvd(dvdId, title, description, category, dateCreated);
    }
    
    @RequestMapping("/deleteDvd")
    public Dvd deleteDvd(@RequestParam(value="dvdId") int dvdId) throws Exception {
        return  dvdService.deleteDvd(dvdId);
    }
    
    
    @RequestMapping("/showDvdList")
    public List<Dvd> showDvdList() throws Exception {
        return  dvdService.showDvdList();
    }
    
    @RequestMapping("/searchDvdTitle")
    public List<Dvd> searchDvdTitle(@RequestParam(value="title") String title) throws Exception {
        return  dvdService.searchDvdTitle(title);
    }
    
    @RequestMapping("/searchDvdKeyword")
    public List<Dvd> searchDvdKeyword(@RequestParam(value="keyword") String keyword) throws Exception {
        return  dvdService.searchDvdKeyword(keyword);
    }
}
