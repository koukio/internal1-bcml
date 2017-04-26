package com.koukio.service;

import com.koukio.entity.Customer;
import com.koukio.entity.Event;
import com.koukio.repository.CustomerRepository;
import com.koukio.repository.EventRepository;
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
	
	@Autowired
	EventRepository eventRepository;
	
	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public Customer createCustomer(String name, String firstName, String lastName, Date birthDate, String email) throws Exception{	
		Customer customer = new Customer(name, firstName, lastName, birthDate, email);
		customerRepository.save(customer);
        Date date = new Date();
        Event event = new Event("Create Customer", String.valueOf(customer.getCustomerId()), date);
        eventRepository.save(event);
		return customer;
	}
	
	public Customer updateCustomer(String name, String firstName, String lastName, Date birthDate, String email) {
		Customer customer = new Customer(name, firstName, lastName, birthDate, email);
		customerRepository.save(customer);
        Date date = new Date();
        Event event = new Event("Update Customer", String.valueOf(customer.getCustomerId()), date);
        eventRepository.save(event);
		return customer;
	}

	public Iterable<Customer> showCustomerList() throws Exception{
    	return customerRepository.findAll();
    }
}
