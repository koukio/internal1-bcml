package com.koukio.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.service.CustomerService;

/**
 * CustomerController
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {


	@Autowired
	CustomerService customerService;
	Customer customer;
	// check more documentation at https://spring.io/guides/gs/rest-service/

	@RequestMapping("/ping")
	public String ping() {
		return "pong:" + customerService.ping();
	}

	@RequestMapping(method=RequestMethod.POST)
	public String createCustomer(
			 @RequestBody Customer input) throws Exception {
		if (validateCustomer(customer.getName(), customer.getFisrtName(), customer.getLastName(), customer.getBirthDate(), customer.getEmail())) {
			customerService.createCustomer(customer.getName(), customer.getFisrtName(), customer.getLastName(), customer.getBirthDate(), customer.getEmail());
			return  "Customer created";
		}else return "Error in fields";
	}	

	@RequestMapping(method=RequestMethod.PUT, value = "/{customerId}")
	public String updateCustomer( @PathVariable String userId, @RequestBody Customer input) throws Exception {
		if (validateCustomer(customer.getName(), customer.getFisrtName(), customer.getLastName(), customer.getBirthDate(), customer.getEmail())) {
			customerService.updateCustomer(customer.getCustomerId(), customer.getName(), customer.getFisrtName(), customer.getLastName(), customer.getBirthDate(), customer.getEmail());
			return "Customer update";
		}else return "Error in fields";
	}
	
	@RequestMapping(method=RequestMethod.GET)
    public Iterable<Customer> showCustomerList() throws Exception {
        return  customerService.showCustomerList();
    }

	public boolean validateCustomer(String name, String firstName, String lastName, Date birthDate, String email){
		Date fecha = new Date();
		if (name !="") {
			if (firstName !="") {
				if (lastName!="") {
					if (birthDate.before(fecha)) {
						if (validate(email)) {
							return true;
						}
					}
				}
			}
		}
		return false;

	}

	public boolean validate(String email) {
		char car;
		for (int i = 0; i < email.length(); i++) {
			car=email.charAt(i);
			if (car!='@') {
				continue;
			}else return true;
		}
		return false;
	}


}
