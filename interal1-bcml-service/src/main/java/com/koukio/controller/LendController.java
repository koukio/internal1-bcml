package com.koukio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.koukio.entity.Lend;
import com.koukio.service.LendService;

public class LendController {

	@Autowired
	LendService lendService;

	@RequestMapping("/ping")
	public String ping() {
		return "pong:" + lendService.ping();
	}

	@RequestMapping(method=RequestMethod.POST)
	public Lend createLend(@RequestParam(value="customerId") int customerId,
			@RequestParam(value="dvdId") int dvdId) throws Exception {
		return  lendService.createLend(customerId, dvdId);
	}

	@RequestMapping(method=RequestMethod.POST)
	public void returnLend(@RequestParam(value="customerId") int customerId,
			@RequestParam(value="dvdId") int dvdId) throws Exception {
		if (lendService.returnLend(customerId, dvdId)){
			System.out.println("DVD returned");
		}else System.out.println("error");
	}

	@RequestMapping(method=RequestMethod.POST)
	public void historyLend(@RequestParam(value="customerId") int customerId) throws Exception {
		lendService.historyLend(customerId);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void historyCurrentLend(@RequestParam(value="customerId") int customerId) throws Exception {
		lendService.historyCurrentLend(customerId);
	}
}
