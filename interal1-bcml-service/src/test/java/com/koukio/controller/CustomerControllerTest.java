package com.koukio.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * CustomerControllerTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class CustomerControllerTest {

    @Autowired
    CustomerController customerController;

    @Test
    public void pingTest() {
        Assert.assertNotNull(customerController.ping());
    }
    
    @Test
    public void ValidateCustomerOk() {
    	Date date = new Date(1984551065);
        Assert.assertTrue(customerController.validateCustomer("Sara Herreros", "Sara", "Herreros", date, "email@outlook.com"));
    }
    
    @Test
    public void ValidateCustomerEmptyField() {
    	Date date = new Date(1984551065);
        Assert.assertFalse(customerController.validateCustomer("Sara Herreros", "Sara", "", date, "email@outlook.com"));
    }
    
    @Test
    public void ValidateCustomerWrongDate() {
    	Date date = new Date(2150/11/07);
        Assert.assertFalse(customerController.validateCustomer("Sara Herreros", "Sara", "Herreros", date, "email@outlook.com"));
    }
    
    @Test
    public void ValidateEmailOk() {
    	Assert.assertTrue(customerController.validate("email@outlook.com"));
    }
    
    @Test
    public void ValidateEmailWrong() {
    	Assert.assertFalse(customerController.validate("emailoutlook.com"));
    }
}
