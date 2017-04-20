package com.koukio.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;
import com.koukio.repository.LendRepository;

@Component
public class LendService {

	List<Lend> lends = new ArrayList<>();
	Lend lend;

	@Autowired
	LendRepository lendRepository;

	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public Lend createLend(Customer customer, Dvd dvd) throws Exception{
		//        throw new NotImplementedException()
		int id = lends.size();
		Lend lend = new Lend(customer,dvd, id);
		if (validateLend(customer)) {
			lends.add(lend);
		}
		lendRepository.save(lend);
		return lend;
	}

	public Boolean returnLend(Customer customer, Dvd dvd) throws Exception{
		//        throw new NotImplementedException();
		boolean returned = false;
		int id = lends.size();
		Lend lend = new Lend(customer,dvd, id);
		for (Lend lend2 : lends) {
			if (lend.equals(lend2)) {
				lend2.setTaken(false);
				returned = true;
			}
		}
		if(lendRepository.exists(lend.getCustomer().getCustomerId())){
			returned = true;
		}
		return returned;
	}

	public boolean validateLend (Customer customer){
		int cont=0;
		boolean lended = true;
		for (Lend lend : lends) {
			if (customer.equals(lend.getCustomer())) {
				if (lend.getTaken()) {
					cont++;
					if (cont>=3) {
						lended = false;
					}
				}
			}
		}
		if(lendRepository.countByCustomerAndTakenAllIgnoringCase(customer, lend.getTaken())>3){
			lended = false;
		}
		return lended;
	}

	public List<Lend> historyLend(Customer customer) {
		List<Lend> historyLend = new ArrayList<Lend>();
		for (Lend lend : lends) {
			if (customer.equals(lend.getCustomer())) {
				historyLend.add(lend);
			}
		}
		lendRepository.findByCustomerAllIgnoringCase(customer);
		return historyLend;
	}

	public List<Lend> historyCurrentLend(Customer customer) {
		List<Lend> historyCurrentLend = new ArrayList<Lend>();
		for (Lend lend : lends) {
			if (customer.equals(lend.getCustomer()) && lend.getTaken()) {
				historyCurrentLend.add(lend);
			}
		}
		lendRepository.findByCustomerAndTakenAllIgnoringCase(customer, lend.getTaken());
		return historyCurrentLend;
	}
}
