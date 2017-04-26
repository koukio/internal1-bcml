package com.koukio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;
import com.koukio.repository.CustomerRepository;
import com.koukio.repository.LendRepository;

@Component
public class LendService {

	@Autowired
	LendRepository lendRepository;	

	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public Lend createLend(Customer customer, Dvd dvd) throws Exception{
						
		Lend lend = new Lend(customer,dvd);
		if (validateLend(customer)) {
			lendRepository.save(lend);
		}
		return lend;
	}

	public boolean returnLend(Customer customer, Dvd dvd) throws Exception{
		boolean returned=false;
		for (Lend lend : lendRepository.findAll()) {
			if(lend.getCustomer().equals(customer) && lend.getDvd().equals(dvd) && lend.getTaken()==true){
				lend.setTaken(false);
				lendRepository.save(lend);
				returned = true;
			}
		}
		return returned;
	}

	public boolean validateLend (Customer customer){
		int cont = 0;
		for (Lend lend : lendRepository.findAll()) {
			if(lend.getCustomer().equals(customer) && lend.getTaken() == true){
				cont +=1;
			}
		}
		if (cont < 3){
			return true;
		}else return false;
	}

	public List<Lend> historyLend(Customer customer) {
		
		List<Lend> historyLend = new ArrayList<Lend>();
		for (Lend lend : lendRepository.findAll()) {
			if (lend.getCustomer().equals(customer)) {
				historyLend.add(lend);
			}
		}
		return historyLend;
	}

	public List<Lend> historyCurrentLend(Customer customer) {
		List<Lend> historyCurrentLend = new ArrayList<Lend>();
		for (Lend lend : lendRepository.findAll()) {
			if (lend.getTaken() == true && lend.getCustomer().equals(customer)) {
				historyCurrentLend.add(lend);
			}
		}
		return historyCurrentLend;
	}
}
