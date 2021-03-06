package com.koukio.controller;

import com.koukio.entity.Event;
import com.koukio.service.EventService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * EventController
 */
@RestController
@RequestMapping("/event")
public class EventController {


    @Autowired
    EventService eventService;

    // check more documentation at https://spring.io/guides/gs/rest-service/

    @RequestMapping(method = RequestMethod.POST)
    public Event createEvent(@RequestParam(value="action") String action,
    		@RequestParam(value="object") String object,
    		@RequestParam(value="eventDate") Date eventDate) throws Exception {
        return  eventService.createEvent(action, object, eventDate);
    }

    @RequestMapping(method = RequestMethod.POST,  value = "/filter")
    public List<Event> filterEvents(@RequestParam(value="firstDate") Date firstDate,
    		@RequestParam(value="lastDate") Date lastDate) throws Exception {
        return  eventService.filterEvents(firstDate, lastDate);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Event> showEventList() throws Exception {
        return  eventService.showEventList();
    }
}
