package com.koukio.service;

import com.koukio.entity.Dvd;
import com.koukio.repository.DvdRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:application-test.properties")
public class DvdServiceTest {

	@Autowired
	DvdService dvdService;
	
	@Autowired
	DvdRepository dvdRepository;


	@Test
	public void updateDvdTest() throws Exception{
		String title = "Kill Bill 2";
		String description = "A revenge of a girl, part 2";
		String category = "Action";
		Date dateCreated =new Date(03/05/2002);
		Dvd dvd= dvdService.createDvd(title, description, category, dateCreated);
		category = "Suspense";
		Dvd dvd2 = dvdService.updateDvd((int) dvdRepository.count(), title, description, category, dateCreated);
		assertNotEquals(dvd, dvd2);
	}

	@Test
	public void deleteDvdTest() throws Exception{
		String title = "Kill Bill";
		String description = "A revenge of a girl";
		String category = "Action";
		Date dateCreated =new Date(03/05/2003);
		Dvd dvd= dvdService.createDvd(title, description, category, dateCreated);
		dvdService.deleteDvd(dvd.getDvdId());
		assertTrue(dvdRepository.findOne(dvd.getDvdId()).isDeleted());
	}

	@Test
	public void searchDvdTitleTest() throws Exception{
		Date dateCreated =new Date(03/05/2004);
		dvdService.createDvd("Kill Bill 2", "A revenge of a girl, part 2",  "Action", dateCreated);
		
		List<Dvd> dvdListbyTitle = new ArrayList<>();
    	for (Dvd dvd1 : dvdRepository.findAll()) {
			if (dvd1.getTitle().contains("Kill Bill 2")){
				dvdListbyTitle.add(dvd1);
			}
		}
		assertEquals(dvdListbyTitle,dvdService.searchDvdTitle("Kill Bill 2"));
	}
	@Test
	public void searchDvdKeywordTest() throws Exception{
		Date dateCreated =new Date(03/05/2005);
		dvdService.createDvd("Kill Bill 2", "A revenge of a girl, part 2",  "Action", dateCreated);
		
		List<Dvd> dvdListbyKeyword = new ArrayList<>();
		for (Dvd dvd1 : dvdRepository.findAll()) {
			if (dvd1.getDescription().contains("revenge")){
				dvdListbyKeyword.add(dvd1);
			}
		}
		assertEquals(dvdListbyKeyword,dvdService.searchDvdKeyword("revenge"));
	}

	@Test
	public void pingTest() {
		Assert.assertNotNull(dvdService.ping());
	}
}
