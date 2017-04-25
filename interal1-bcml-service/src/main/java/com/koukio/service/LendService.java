package com.koukio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koukio.entity.Lend;
import com.koukio.repository.LendRepository;

@Component
public class LendService {

	@Autowired
	LendRepository lendRepository;

	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public Lend createLend(int customerId, int dvdId) throws Exception{
		Lend lend = new Lend(customerId,dvdId);
		if (validateLend(customerId)) {
			lendRepository.save(lend);
		}
		
		return lend;
	}

	public boolean returnLend(int customerId, int dvdId) throws Exception{
		for (Lend lend : lendRepository.findAll()) {
			if(lend.getCustomerId()==customerId && lend.getDvdId()==dvdId && lend.getTaken()==true){
				lend.setTaken(false);
				lendRepository.save(lend);
				return true;
			}
		}
		return false;
	}

	public boolean validateLend (int customerId){
		int cont = 0;
		for (Lend lend : lendRepository.findAll()) {
			if(lend.getCustomerId() == customerId && lend.getTaken() == true){
				cont +=1;
			}
		}
		if (cont >= 3){
			return false;
		}else return true;
	}

	public List<Lend> historyLend(int customerId) {
		
		List<Lend> historyLend = new ArrayList<Lend>();
		for (Lend lend : lendRepository.findAll()) {
			if (lend.getCustomerId() == customerId) {
				historyLend.add(lend);
			}
		}
		return historyLend;
	}

	public List<Lend> historyCurrentLend(int customerId) {
		List<Lend> historyCurrentLend = new ArrayList<Lend>();
		for (Lend lend : lendRepository.findAll()) {
			if (lend.getTaken() == true && lend.getCustomerId() == customerId) {
				historyCurrentLend.add(lend);
			}
		}
		return historyCurrentLend;
	}
}
