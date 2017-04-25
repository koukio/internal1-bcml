package com.koukio.entity;

import javax.persistence.*;

@Entity
public class Lend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int lendId;

	@Column(nullable = false)
	private int customerId;
	
	@Column(nullable = false)
	private int dvdId;
	
	@Column(nullable = false)
	private Boolean taken;
	
	public Lend(){}
	
	public Lend(int customerId, int dvdId) {
		this.customerId = customerId;
		this.dvdId = dvdId;
		this.taken = true;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDvdId() {
		return dvdId;
	}

	public void setDvdId(int dvdId) {
		this.dvdId = dvdId;
	}
	
	public Boolean getTaken() {
		return taken;
	}
	
	public void setTaken(Boolean taken) {
		this.taken = taken;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerId;
		result = prime * result + dvdId;
		result = prime * result + lendId;
		result = prime * result + ((taken == null) ? 0 : taken.hashCode());
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
		Lend other = (Lend) obj;
		if (customerId != other.customerId)
			return false;
		if (dvdId != other.dvdId)
			return false;
		if (lendId != other.lendId)
			return false;
		if (taken == null) {
			if (other.taken != null)
				return false;
		} else if (!taken.equals(other.taken))
			return false;
		return true;
	}

	
}
