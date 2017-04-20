package com.koukio.service;

import com.koukio.entity.Event;
import com.koukio.repository.EventRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * EventService
 */
@Component
public class EventService {
	
	@Autowired
	EventRepository eventRepository;
	
    public Event createEvent(String action, String object, Date eventDate) throws Exception{
        Event event = new Event(action, object, eventDate);
        eventRepository.save(event);
        return event;
    }
	
    public List<Event> filterEvents(Date firstDate, Date lastDate) throws Exception{
    	List<Event> eventListFiltered = new ArrayList<>();
    	for (Event event : eventRepository.findAll()) {
			if (event.eventDate.after(firstDate) && event.eventDate.before(lastDate)){
				eventListFiltered.add(event);
			}
		}
    	return eventListFiltered;
    }
}