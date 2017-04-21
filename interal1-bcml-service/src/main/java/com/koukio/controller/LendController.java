package com.koukio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;
import com.koukio.service.LendService;

public class LendController {

	@Autowired
	LendService lendService;

	@RequestMapping("/dvdping")
	public String ping() {
		return "pong:" + lendService.ping();
	}

	@RequestMapping(method=RequestMethod.POST)
	public Lend createLend(@RequestParam(value="customer") Customer customer,
			@RequestParam(value="dvd") Dvd dvd) throws Exception {
		return  lendService.createLend(customer, dvd);
	}

	@RequestMapping(method=RequestMethod.POST)
	public void returnLend(@RequestParam(value="customer") Customer customer,
			@RequestParam(value="dvd") Dvd dvd) throws Exception {
		if (lendService.returnLend(customer, dvd)){
			System.out.println("DVD returned");
		}else System.out.println("error");
	}

	@RequestMapping(method=RequestMethod.POST)
	public void historyLend(@RequestParam(value="customer") Customer customer) throws Exception {
		lendService.historyLend(customer);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void historyCurrentLend(@RequestParam(value="customer") Customer customer) throws Exception {
		lendService.historyCurrentLend(customer);
	}
}
