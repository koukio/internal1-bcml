package com.koukio.controller;

import com.koukio.entity.Customer;
import com.koukio.service.CustomerService;
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
    CustomerService customerService;

    // check more documentation at https://spring.io/guides/gs/rest-service/

    @RequestMapping("/ping")
    public String ping() {
        return "pong:" + customerService.ping();
    }

    @RequestMapping("/ping")
    public Customer createCustomer(@RequestParam(value="name") String name) throws Exception {
        return  customerService.createCustomer(name);
    }



}
