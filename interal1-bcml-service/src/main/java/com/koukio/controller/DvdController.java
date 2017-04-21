package com.koukio.controller;

import com.koukio.entity.Dvd;
import com.koukio.service.DvdService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * DvdController
 */
@RestController
@RequestMapping("/dvd")
public class DvdController {


    @Autowired
    DvdService dvdService;

    // check more documentation at https://spring.io/guides/gs/rest-service/

    @RequestMapping(method = RequestMethod.GET, value="/ping")
    public String ping() {
        return "pong:" + dvdService.ping();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Dvd createDvd(@RequestParam(value="title") String title,
    		@RequestParam(value="description") String description,
    		@RequestParam(value="category") String category,
    		@RequestParam(value="dateCreated") Date dateCreated) throws Exception {
        return  dvdService.createDvd(title, description, category, dateCreated);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{dvdId}")
    public Dvd updateDvd(@PathVariable int dvdId,
    		@RequestParam(value="title") String title,
    		@RequestParam(value="description") String description,
    		@RequestParam(value="category") String category,
    		@RequestParam(value="dateCreated") Date dateCreated) throws Exception {
        return  dvdService.updateDvd(dvdId, title, description, category, dateCreated);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/delete/{dvdId}")
    public Dvd deleteDvd(@PathVariable int dvdId) throws Exception {
        return  dvdService.deleteDvd(dvdId);
    }
    
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Dvd> showDvdList() throws Exception {
        return  dvdService.showDvdList();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
    public List<Dvd> searchDvdTitle(@PathVariable String title) throws Exception {
        return  dvdService.searchDvdTitle(title);
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/keyword/{keyword}")
    public List<Dvd> searchDvdKeyword(@PathVariable String keyword) throws Exception {
        return  dvdService.searchDvdKeyword(keyword);
    }
}
