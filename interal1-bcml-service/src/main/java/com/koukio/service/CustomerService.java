package com.koukio.service;


import com.koukio.entity.Customer;
import java.util.Date;
import java.util.TreeSet;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * CustomerService
 */
@Component
public class CustomerService {

	TreeSet<Customer> customers = new TreeSet<>();
			
	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public String createCustomer(String name, String firstName, String lastName, Date birthDate, String email) throws Exception{
		//        throw new NotImplementedException();		
		int customerId=customers.size();
		Customer customer = new Customer(customerId, name, firstName, lastName, birthDate, email);
		if (customers.add(customer)) {
			return "Customer Created";
		}else return "This customer already exists";
	}
	
	public String updateCustomer(int customerId, String name, String firstName, String lastName, Date birthDate, String email) {
		//      throw new NotImplementedException();
		Customer customer = new Customer(customerId, name, firstName, lastName, birthDate, email);
		if (customers.add(customer)) {
			return "Customer Update";
		}else return "This customer already exists";
	}
	
	
}
