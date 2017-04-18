package com.koukio.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Component;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;

@Component
public class LendService {

	List<Lend> lends = new ArrayList<>();

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
		return lended;
	}

	public List<Lend> historyLend(Customer customer) {
		List<Lend> historyLend = new ArrayList<Lend>();
		for (Lend lend : lends) {
			if (customer.equals(lend.getCustomer())) {
				historyLend.add(lend);
			}
		}
		return historyLend;
	}

	public List<Lend> historyCurrentLend(Customer customer) {
		List<Lend> historyCurrentLend = new ArrayList<Lend>();
		for (Lend lend : lends) {
			if (customer.equals(lend.getCustomer()) && lend.getTaken()) {
				historyCurrentLend.add(lend);
			}
		}
		return historyCurrentLend;
	}
}
