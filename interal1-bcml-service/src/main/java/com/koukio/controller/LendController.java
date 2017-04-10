package com.koukio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;
import com.koukio.service.LendService;

public class LendController {

	LendService lendService;

	@RequestMapping("/dvdping")
	public String ping() {
		return "pong:" + lendService.ping();
	}

	@RequestMapping("/lend")
	public Lend createLend(@RequestParam(value="customer") Customer customer,
			@RequestParam(value="dvd") Dvd dvd,
			@RequestParam(value="taken") boolean taken) throws Exception {
		return  lendService.createLend(customer, dvd, taken);
	}

	@RequestMapping("/lend")
	public void returnDvd(@RequestParam(value="customer") Customer customer,
			@RequestParam(value="dvd") Dvd dvd,
			@RequestParam(value="taken") boolean taken) throws Exception {
		if (lendService.returnLend(customer, dvd, taken)){
			System.out.println("DVD returned");
		}else System.out.println("error");
	}

}
