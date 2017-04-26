package com.koukio.service;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;
import com.koukio.repository.LendRepository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class LendServiceTest {

    @Autowired
    LendService lendService;
    @Autowired
    LendRepository lendRepository;
    
    @Test
    public void returnLendTest() throws Exception {
    	Customer customer = new Customer("nombre","apellido","2apellido",new Date(),"asdf@asd");
    	Dvd dvd = new Dvd("titulo","descripcion","categoria",new Date());
    	Lend lend = new Lend(customer,dvd);
    	lendRepository.save(lend);
        Assert.assertTrue(lendService.returnLend(customer, dvd));
    }
    
    @Test
    public void validateLendTrueTest() throws Exception {
    	Customer customer = new Customer("nombre2","apellido2","2apellido2",new Date(),"asdf@as2d");
    	Dvd dvd = new Dvd("titulo2","descripcion2","categoria2",new Date());
    	Lend lend = new Lend(customer,dvd);
    	lendRepository.save(lend);
        Assert.assertTrue(lendService.validateLend(customer));
    }
    
    @Test
    public void validateLendFalseTest() throws Exception {
    	Customer customer = new Customer("nombre2","apellido2","2apellido2",new Date(),"asdf@as2d");
    	Dvd dvd = new Dvd("titulo3","descripcion2","categoria2",new Date());
    	Dvd dvd2 = new Dvd("titulo4","descripcion2","categoria2",new Date());
    	Dvd dvd3 = new Dvd("titulo5","descripcion2","categoria2",new Date());
    	Lend lend = new Lend(customer,dvd);
    	lendRepository.save(lend);
    	
    	Lend lend2 = new Lend(customer,dvd2);
    	lendRepository.save(lend2);
    	
    	Lend lend3 = new Lend(customer,dvd3);
    	lendRepository.save(lend3);
    	
        Assert.assertFalse(lendService.validateLend(customer));
    }
    
    @Test
    public void historyLendTest() throws Exception {
    	Customer customer = new Customer("nombre3","apellido3","2apellido3",new Date(),"asdf@as3d");
    	Dvd dvd = new Dvd("titulo6","descripcion2","categoria2",new Date());
    	Dvd dvd2 = new Dvd("titulo7","descripcion2","categoria2",new Date());
    	Dvd dvd3 = new Dvd("titulo8","descripcion2","categoria2",new Date());
    	
    	lendService.createLend(customer, dvd);
    	lendService.createLend(customer, dvd2);
    	lendService.createLend(customer, dvd3);
    	
        Assert.assertEquals(3, lendService.historyLend(customer).size());
    }
    
    @Test
    public void historyCurrentLendTest() throws Exception {
    	Customer customer = new Customer("nombre3","apellido3","2apellido3",new Date(),"asdf@as3d");
    	Dvd dvd = new Dvd("titulo9","descripcion2","categoria2",new Date());
    	Dvd dvd2 = new Dvd("titulo17","descripcion2","categoria2",new Date());
    	Dvd dvd3 = new Dvd("titulo81","descripcion2","categoria2",new Date());
    	lendService.createLend(customer, dvd);
    	lendService.createLend(customer, dvd2);    	
    	lendService.createLend(customer, dvd3);
    	
    	lendService.returnLend(customer, dvd);
    	lendService.returnLend(customer, dvd2);

        Assert.assertEquals(1, lendService.historyCurrentLend(customer).size());
    }
}
