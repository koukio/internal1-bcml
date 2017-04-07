package com.koukio.service;


import com.koukio.entity.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * CustomerService
 */
@Component
public class CustomerService {

	List<Customer> customers = new ArrayList<>();
			
	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public Customer createCustomer(String name, String firstName, String lastName, Date birthDate, String email) throws Exception{
		//        throw new NotImplementedException();		
		int customerId=customers.size();
		Customer customer = new Customer(customerId, name, firstName, lastName, birthDate, email);
		customers.add(customer);
		return customer;
	}
	
	public Customer updateCustomer(int customerId, String name, String firstName, String lastName, Date birthDate, String email) {
		//      throw new NotImplementedException();
		Customer customer = new Customer(customerId, name, firstName, lastName, birthDate, email);
		customers.set(customerId,customer);
		return customer;
	}
	
	
}
