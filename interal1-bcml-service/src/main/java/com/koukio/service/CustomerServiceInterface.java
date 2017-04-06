package com.koukio.service;

import java.util.Date;

import com.koukio.entity.Customer;

public interface CustomerServiceInterface {

	String ping();

	Customer createCustomer(String name, String firstName, String lastName, Date birthDate,
			String email) throws Exception;

	Customer updateCustomer(int customerId, String name, String firstName, String lastName, Date birthDate,
			String email);

}