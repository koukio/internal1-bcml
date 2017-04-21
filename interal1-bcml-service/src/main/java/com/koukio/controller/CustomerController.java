package com.koukio.controller;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.koukio.entity.Customer;
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
	public Customer createCustomer(
			@RequestParam(value="name") String name,
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="birthDate") Date birthDate,
			@RequestParam(value="email") String email) throws Exception {
		if (validateCustomer(name, firstName, lastName, birthDate, email)) {
			return  customerService.createCustomer(name, firstName, lastName, birthDate, email);
		}else return customer = new Customer( 0, "", "", "",new Date(1/1/1), "");
	}	

	@RequestMapping(method=RequestMethod.PUT, value = "/{customerId}")
	public Customer updateCustomer(
	@RequestParam(value="customerId") int customerId,
	@RequestParam(value="name") String name,
	@RequestParam(value="firstName") String firstName,
	@RequestParam(value="lastName") String lastName,
	@RequestParam(value="birthDate") Date birthDate,
	@RequestParam(value="email") String email) throws Exception {
		if (validateCustomer(name, firstName, lastName, birthDate,email)) {
			return customerService.updateCustomer(customerId, name, firstName, lastName, birthDate,email);
		}else return customer = new Customer( 0, "", "", "",new Date(1/1/1), "");
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
