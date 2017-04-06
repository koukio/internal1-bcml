package com.koukio.controller;

import com.koukio.entity.Customer;
import com.koukio.service.CustomerServiceInterface;

import java.util.Date;

import org.junit.experimental.categories.CategoryValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * CustomerController
 */
@RestController
public class CustomerController {


	@Autowired
	CustomerServiceInterface customerService;

	// check more documentation at https://spring.io/guides/gs/rest-service/

	@RequestMapping("/ping")
	public String ping() {
		return "pong:" + customerService.ping();
	}

	@RequestMapping("/createCustomer")
	public String createCustomer(
			@RequestParam(value="name") String name,
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="birthDate") Date birthDate,
			@RequestParam(value="email") String email) throws Exception {
		if (validateCustomer(name, firstName, lastName, birthDate, email)) {
			customerService.createCustomer(name, firstName, lastName, birthDate, email);
			return  "Customer created";
		}else return "Error in fields";
	}	

	@RequestMapping("/updatecustomer")
	public String updateCustomer(
			@RequestParam(value="customerId") int customerId,
			@RequestParam(value="name") String name,
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="lastName") String lastName,
			@RequestParam(value="birthDate") Date birthDate,
			@RequestParam(value="email") String email) throws Exception {
		if (validateCustomer(name, firstName, lastName, birthDate, email)) {
			customerService.updateCustomer(customerId, name, firstName, lastName, birthDate, email);
			return "Customer update";
		}else return "Error in fields";
	}

	private boolean validateCustomer(String name, String firstName, String lastName, Date birthDate, String email){
		Date fecha = new Date();
		if (name !="") {
			if (firstName !="") {
				if (lastName!="") {
					if (birthDate.getYear()<fecha.getYear() && birthDate.getMonth()<fecha.getMonth() && birthDate.getDay()<fecha.getDay()) {
						if (validate(email)) {
							return true;
						}
					}
				}
			}
		}
		return false;

	}

	private boolean validate(String email) {
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
