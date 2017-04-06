package com.koukio.entity;

import java.util.Date;

/**
 * Customer
 */
public class Customer {
	
	String name;
	String fisrtName;
	String lastName;
	Date birthDate;
	int customerId;
	String email;
	
	public Customer( int customerId, String name, String fisrtName, String lastName, Date birthDate, String email) {
		this.customerId = customerId;
		this.name = name;
		this.fisrtName = fisrtName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
