package com.koukio.service;

import com.koukio.entity.Customer;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;
    
    @Test
    public void createCustomerNotNull() throws Exception {
    	Date date = new Date(16/02/1964);
        Assert.assertNotNull(customerService.createCustomer("Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com"));
    }
    
    @Test
    public void updateCustomerTest() throws Exception {
    	Date date = new Date(16/02/1964);
    	Customer customer2;
    	Customer customer = new Customer("Alberto Perez", "Alberto", "Perez", date, "aperez@gmail.com");
    	customer2 = customerService.updateCustomer("Alberto Perez", "Alberto", "Perez", date, "aperez123@gmail.com");
    	Assert.assertNotEquals(customer.getEmail(), customer2.getEmail());
    }
}
