package com.koukio.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.koukio.entity.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceTest {

	@Autowired
	EventService eventService;

	@Test
	public void createEvent() throws Exception{
		String action = "create";
		String object = "Dvd";
		Date eventDate = new Date();
		Event event = new Event(action, object, eventDate);
		Event event2 = eventService.createEvent(action, object, eventDate);
		Assert.assertEquals(event, event2);
	}
	
	@Test
	public void filterEvents() throws Exception{
		Date firstDate = new Date(11/4/2017);
		Date lastDate = new Date(9/4/2017);
		String action = "create";
		String object = "customer";
		Date eventDate = new Date();
		eventService.createEvent(action, object, eventDate);
		List<Event> eventfiltred = eventService.filterEvents(firstDate, lastDate);
		Assert.assertNotNull(eventfiltred);
	}
}
