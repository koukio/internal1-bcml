package com.koukio.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Event")
public class Event {
	
	@Id
	@Column(name = "Event_Id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eventId;
	
	@Column(name = "Action", nullable = false)
	public String action;
	
	@Column(name = "Object", nullable = false)
	public String object;
	
	@Column(name = "Event_Date", nullable = false)
	public Date eventDate;
	
	
	public Event() {
	}
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((eventDate == null) ? 0 : eventDate.hashCode());
		result = prime * result + ((object == null) ? 0 : object.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Event))
			return false;
		Event other = (Event) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (eventDate == null) {
			if (other.eventDate != null)
				return false;
		} else if (!eventDate.equals(other.eventDate))
			return false;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		return true;
	}
}
