package com.koukio.service;


import com.koukio.entity.Customer;
import com.koukio.repository.CustomerRepository;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CustomerService
 */
@Component
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public Customer createCustomer(String name, String firstName, String lastName, Date birthDate, String email) throws Exception{	
		int customerId=(int) customerRepository.count();
		Customer customer = new Customer(customerId, name, firstName, lastName, birthDate, email);
		customerRepository.save(customer);
		return customer;
	}
	
	public Customer updateCustomer(int customerId, String name, String firstName, String lastName, Date birthDate, String email) {
		Customer customer = new Customer(customerId, name, firstName, lastName, birthDate, email);
		customerRepository.save(customer);
		return customer;
	}

	public Iterable<Customer> showCustomerList() throws Exception{
    	return customerRepository.findAll();
    }
}
