package com.koukio.entity;

import java.util.Date;

public class Event {
	public String action;
	public String object;
	public Date eventDate;
	
	public Event(String action, String object, Date eventDate) {
		this.action = action;
		this.object = object;
		this.eventDate = eventDate;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}
	
	public String toString(){
		return this.action + ", " + this.object + ", " + this.eventDate.toString();
	}
}
