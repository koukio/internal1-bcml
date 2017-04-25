package com.koukio.service;

import com.koukio.entity.Lend;
import com.koukio.repository.LendRepository;

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
    public void createLendTest() throws Exception {
    	int customerId=0;
    	int dvdId=0;
    	Lend lend = new Lend(customerId,dvdId);
        Assert.assertEquals(lend.getCustomerId(), lendService.createLend(customerId, dvdId).getCustomerId());
    }
    
    @Test
    public void createLendTakenTest() throws Exception {
    	int customerId=1;
    	int dvdId=1;
    	Assert.assertTrue(lendService.createLend(customerId, dvdId).getTaken());
    }
    
    @Test
    public void returnLendTest() throws Exception {
    	int customerId=2;
    	int dvdId=2;
    	Lend lend = new Lend(customerId,dvdId);
    	lendRepository.save(lend);
        Assert.assertTrue(lendService.returnLend(customerId, dvdId));
    }
    
    @Test
    public void validateLendTrueTest() throws Exception {
    	int customerId=3;
    	int dvdId=3;
    	Lend lend = new Lend(customerId,dvdId);
    	lendRepository.save(lend);
        Assert.assertTrue(lendService.validateLend(customerId));
    }
    
    @Test
    public void validateLendFalseTest() throws Exception {
    	int customerId=5;
    	int dvdId=5;
    	int dvdId2=6;
    	int dvdId3=7;
    	Lend lend = new Lend(customerId,dvdId);
    	lendRepository.save(lend);
    	
    	Lend lend2 = new Lend(customerId,dvdId2);
    	lendRepository.save(lend2);
    	
    	Lend lend3 = new Lend(customerId,dvdId3);
    	lendRepository.save(lend3);
    	
        Assert.assertFalse(lendService.validateLend(customerId));
    }
    
    @Test
    public void historyLendTest() throws Exception {
    	int customerId=6;
    	int dvdId = 8;
    	int dvdId2= 9;
    	int dvdId3 = 10;
    	lendService.createLend(customerId, dvdId);
    	lendService.createLend(customerId, dvdId2);
    	lendService.createLend(customerId, dvdId3);
    	
        Assert.assertEquals(3, lendService.historyLend(customerId).size());
    }
    
    @Test
    public void historyCurrentLendTest() throws Exception {
    	int customerId=7;
    	int dvdId = 13;
    	int dvdId2= 14;
    	int dvdId3 = 15;
    	lendService.createLend(customerId, dvdId);
    	lendService.createLend(customerId, dvdId2);    	
    	lendService.createLend(customerId, dvdId3);
    	
    	lendService.returnLend(customerId, dvdId);
    	lendService.returnLend(customerId, dvdId2);

        Assert.assertEquals(1, lendService.historyCurrentLend(customerId).size());
    }
}
