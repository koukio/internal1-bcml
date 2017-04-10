package com.koukio.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.koukio.entity.Customer;
import com.koukio.entity.Dvd;
import com.koukio.entity.Lend;

public class LendService {

	List<Lend> lends = new ArrayList<>();

	public String ping() {
		return String.valueOf(System.currentTimeMillis());
	}

	public Lend createLend(Customer customer, Dvd dvd,Boolean taken) throws Exception{
		//        throw new NotImplementedException();		
		Lend lend = new Lend(customer,dvd,taken);
		if (validateLend(customer, taken)) {
			lends.add(lend);
		}
		return lend;
	}

	public Boolean returnLend(Customer customer, Dvd dvd,Boolean taken) throws Exception{
		//        throw new NotImplementedException();
		boolean returned = false;
		Lend lend = new Lend(customer,dvd,taken);
		for (Lend lend2 : lends) {
			if (lend.equals(lend2)) {
				lends.remove(lend);
				returned = true;
			}
		}
		return returned;
	}

		public boolean validateLend (Customer customer, boolean taken){
			int cont=0;
			boolean lended = true;
			for (Lend lend : lends) {
				if (customer.equals(lend.getCustomer())) {
					if (taken) {
						cont++;
						if (cont>=3) {
							lended = false;
						}
					}
				}
			}
			return lended;
		}


	}
