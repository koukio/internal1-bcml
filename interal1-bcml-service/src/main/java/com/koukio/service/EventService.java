package com.koukio.service;

import com.koukio.entity.Event;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * EventService
 */
@Component
public class EventService {
	List<Event> eventList = new ArrayList<>();
	
    public Event createEvent(String action, String object, Date eventDate) throws Exception{
        Event event = new Event(action, object, eventDate);
        eventList.add(event);
        return event;
    }
	
    public List<Event> filterEvents(Date firstDate, Date lastDate) throws Exception{
    	List<Event> eventListFiltered = new ArrayList<>();
    	for (Event event : eventList) {
			if (event.eventDate.after(firstDate) && event.eventDate.before(lastDate)){
				eventListFiltered.add(event);
			}
		}
    	return eventListFiltered;
    }
}