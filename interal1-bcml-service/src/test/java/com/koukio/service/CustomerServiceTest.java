package com.koukio.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.koukio.controller.CustomerController;
import com.koukio.entity.Customer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;
    
    @Test
    public void createCustomerNotNull() throws Exception {
    	Date date = new Date(16/02/1964);
        Assert.assertNotNull(customerService.createCustomer("Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com"));
    }

    @Test
    public void createCustomerCreated() throws Exception {
    	Date date = new Date(16/02/1964);
    	Customer customer = new Customer(0,"Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com");
    	customerService.createCustomer("Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com");
        Assert.assertEquals(customer, customerService.customers.get(0));
    }
    
    @Test
    public void updateCustomerCreated() throws Exception {
    	Date date = new Date(16/02/1964);
    	customerService.createCustomer("Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com");
    	customerService.updateCustomer(0,"Alberto Perez", "Alberto", "Perez", date, "aperez123@gmail.com");
    	Assert.assertEquals("aperez123@gmail.com", customerService.customers.get(0).getEmail());
    }
}
