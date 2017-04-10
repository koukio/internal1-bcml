package com.koukio.service;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LendServiceTest {

    @Autowired
    LendService lendService;
    
    @Test
    public void createLendTest() throws Exception {
    	Date dateDvd = new Date(16/02/1964);
    	Date dateCustomer = new Date(16/02/1979);
    	Customer customer = new Customer(0, "Alberto Perez", "Alberto", "Perez", dateCustomer, "aperez@gmail.com");
    	Dvd dvd = new Dvd(0, "a", "s", "d", dateDvd);
    	Lend lend = new Lend(customer, dvd);
    	lendService.createLend(customer, dvd);
        Assert.assertEquals(lend, lendService.lends.get(lendService.lends.size()-1));
    }
    
    @Test
    public void createLendTakenTest() throws Exception {
    	Date dateDvd = new Date(16/02/1964);
    	Date dateCustomer = new Date(16/02/1979);
    	Customer customer = new Customer(0, "Alberto Perez", "Alberto", "Perez", dateCustomer, "aperez@gmail.com");
    	Dvd dvd = new Dvd(0, "a", "s", "d", dateDvd);
    	lendService.createLend(customer, dvd);
    	Assert.assertTrue(lendService.createLend(customer, dvd).getTaken());
    }
    
    @Test
    public void returnLendTrueTest() throws Exception {
    	Date dateDvd = new Date(16/02/1964);
    	Date dateCustomer = new Date(16/02/1979);
    	Customer customer = new Customer(0, "Alberto Perez", "Alberto", "Perez", dateCustomer, "aperez@gmail.com");
    	Dvd dvd = new Dvd(0, "a", "s", "d", dateDvd);
    	lendService.createLend(customer, dvd);
        Assert.assertTrue(lendService.returnLend(customer, dvd));
    }
    
    @Test
    public void returnLendFalseTest() throws Exception {
    	Date dateDvd = new Date(16/02/1964);
    	Date dateCustomer = new Date(16/02/1979);
    	Customer customer = new Customer(0, "Alberto Perez", "Alberto", "Perez", dateCustomer, "aperez@gmail.com");
    	Dvd dvd = new Dvd(0, "a", "s", "d", dateDvd);
    	Dvd dvd2 = new Dvd(1, "w", "e", "r", dateDvd);
    	lendService.createLend(customer, dvd);
        Assert.assertFalse(lendService.returnLend(customer, dvd2));
    }
    
    @Test
    public void validateLendTrueTest() throws Exception {
    	Date dateDvd = new Date(16/02/1964);
    	Date dateCustomer = new Date(16/02/1979);
    	Customer customer = new Customer(0, "Alberto Perez", "Alberto", "Perez", dateCustomer, "aperez@gmail.com");
    	Dvd dvd = new Dvd(0, "a", "s", "d", dateDvd);
    	lendService.createLend(customer, dvd);
        Assert.assertTrue(lendService.validateLend(customer));
    }
    
    @Test
    public void validateLendFalseTest() throws Exception {
    	Date dateDvd = new Date(16/02/1964);
    	Date dateCustomer = new Date(16/02/1979);
    	Customer customer = new Customer(0, "Alberto Perez", "Alberto", "Perez", dateCustomer, "aperez@gmail.com");
    	Dvd dvd = new Dvd(0, "a", "s", "d", dateDvd);
    	Dvd dvd2 = new Dvd(1, "w", "e", "r", dateDvd);
    	Dvd dvd3 = new Dvd(2, "z", "x", "c", dateDvd);
    	lendService.createLend(customer, dvd);
    	lendService.createLend(customer, dvd2);
    	lendService.createLend(customer, dvd3);
        Assert.assertFalse(lendService.validateLend(customer));
    }
}
