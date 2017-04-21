package com.koukio.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Dvd")
public class Dvd{
	
	@Id
	@Column(name = "Dvd_Id", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dvdId;
	
	@Column(name = "Title", nullable = false)
	private String title;
	
	@Column(name = "Description", nullable = false)
	private String description;
	
	@Column(name = "Category", nullable = false)
	private String category;
	
	@Column(name = "Date_Created", nullable = false)
	private Date dateCreated;
	
	@Column(name = "Deleted", nullable = false)
	private boolean deleted;
	
	public Dvd() {
		this.dvdId = 0;
		this.title = "";
		this.description = "";
		this.category = "";
		this.dateCreated = new Date(1/1/1);
		this.deleted = false;
	}
	
	public Dvd(int dvdId, String title, String description, String category, Date dateCreated) {
		this.dvdId = dvdId;
		this.title = title;
		this.description = description;
		this.category = category;
		this.dateCreated = dateCreated;
		this.deleted = false;
	}
	
	public int getDvdId() {
		return dvdId;
	}
	public void setDvdId(int dvdId) {
		this.dvdId = dvdId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((dateCreated == null) ? 0 : dateCreated.hashCode());
		result = prime * result + (deleted ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + dvdId;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dvd other = (Dvd) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (dateCreated == null) {
			if (other.dateCreated != null)
				return false;
		} else if (!dateCreated.equals(other.dateCreated))
			return false;
		if (deleted != other.deleted)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dvdId != other.dvdId)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
