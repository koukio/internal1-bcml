package com.koukio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.koukio.entity.Customer;
import com.koukio.entity.Lend;

public interface LendRepository extends CrudRepository<Lend, Integer> {

	Page<Lend> findAll(Pageable pageable);

	Lend findByCustomerAllIgnoringCase(Customer customer);
	int countByCustomerAndTakenAllIgnoringCase(Customer customer, boolean taken);
	Lend findByCustomerAndTakenAllIgnoringCase(Customer customer, boolean taken);

}