package com.koukio.entity;

public class Lend {

	Customer customer;
	Dvd dvd;
	Boolean taken;
	
	public Lend(Customer customer, Dvd dvd, Boolean taken) {
		super();
		this.customer = customer;
		this.dvd = dvd;
		this.taken = taken;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Dvd getDvd() {
		return dvd;
	}
	public void setDvd(Dvd dvd) { 
		this.dvd = dvd;
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
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((dvd == null) ? 0 : dvd.hashCode());
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
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (dvd == null) {
			if (other.dvd != null)
				return false;
		} else if (!dvd.equals(other.dvd))
			return false;
		if (taken == null) {
			if (other.taken != null)
				return false;
		} else if (!taken.equals(other.taken))
			return false;
		return true;
	}
	
}
