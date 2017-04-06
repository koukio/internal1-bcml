package com.koukio.controller;

import com.koukio.entity.Dvd;
import com.koukio.service.DvdService;
import com.koukio.service.DvdServiceInterface;

import java.util.Date;

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
    DvdServiceInterface dvdService;

    // check more documentation at https://spring.io/guides/gs/rest-service/

    @RequestMapping("/dvdping")
    public String ping() {
        return "pong:" + dvdService.ping();
    }

    @RequestMapping("/dvd")
    public Dvd createCustomer(@RequestParam(value="title") String title,
    		@RequestParam(value="description") String description,
    		@RequestParam(value="category") String category,
    		@RequestParam(value="dateCreated") Date dateCreated) throws Exception {
        return  dvdService.createDvd(title, description, category, dateCreated);
    }



}
