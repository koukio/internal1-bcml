package com.koukio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;
import com.koukio.service.LendService;

/**
 * LendController
 */
@RestController
@RequestMapping("/lend")
public class LendController {

	@Autowired
	LendService lendService;

	@RequestMapping("/ping")
	public String ping() {
		return "pong:" + lendService.ping();
	}

	@RequestMapping(method=RequestMethod.POST)
	public Lend createLend(@RequestBody Customer customer,
			@RequestBody Dvd dvd) throws Exception {
		return lendService.createLend(customer, dvd);
	}

	@RequestMapping(method=RequestMethod.GET)
	public void returnLend(@RequestBody Customer customer,
			@RequestBody Dvd dvd) throws Exception {
		if (lendService.returnLend(customer, dvd)){
			System.out.println("DVD returned");
		}else System.out.println("error");
	}

	@RequestMapping(method=RequestMethod.GET, value ="history/")
	public void historyLend(@RequestBody Customer customer) throws Exception {
		lendService.historyLend(customer);
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="currentHistory/")
	public void historyCurrentLend(@RequestBody Customer customer) throws Exception {
		lendService.historyCurrentLend(customer);
	}
}
