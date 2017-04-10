package com.koukio.controller;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CustomerControllerTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerControllerTest {

    @Autowired
    CustomerController customerController;

    @Test
    public void pingTest() {
        Assert.assertNotNull(customerController.ping());
    }
    
    @Test
    public void ValidateCustomerOk() {
    	Date date = new Date(07/11/1983);
        Assert.assertTrue(customerController.validateCustomer("Sara Herreros", "Sara", "Herreros", date, "email@outlook.com"));
    }
    
    @Test
    public void ValidateCustomerEmptyField() {
    	Date date = new Date(07/11/1983);
        Assert.assertFalse(customerController.validateCustomer("Sara Herreros", "Sara", "", date, "email@outlook.com"));
    }
    
    @Test
    public void ValidateCustomerWrongDate() {
    	Date date = new Date(07/11/2150);
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
