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
	
	
}
