package com.koukio.service;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
    public void createCustomerTest() throws Exception {
    	Date date = new Date(16/02/1964);
    	Customer customer = new Customer(0,"Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com");
        Assert.assertEquals(customer, customerService.createCustomer("Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com"));
    }
    
    @Test
    public void updateCustomerTest() throws Exception {
    	Date date = new Date(16/02/1964);
    	Customer customer2;
    	Customer customer = new Customer(1,"Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com");
    	customer2 = customerService.updateCustomer(1,"Alberto Perez", "Alberto", "Perez", date, "aperez123@gmail.com");
    	Assert.assertNotEquals(customer.getEmail(), customer2.getEmail());
    }
}
