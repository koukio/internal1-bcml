package com.koukio.service;

import com.koukio.entity.Event;
import com.koukio.repository.EventRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class EventServiceTest {

	@Autowired
	EventService eventService;
	
	@Autowired
	EventRepository eventRepository;

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
		Date lastDate = new Date(22/4/2017);
		String action = "create";
		String object = "customer";
		Date eventDate = new Date();
		eventService.createEvent(action, object, eventDate);
		List<Event> eventfiltred = eventService.filterEvents(firstDate, lastDate);
		Assert.assertNotNull(eventfiltred);
	}
}
