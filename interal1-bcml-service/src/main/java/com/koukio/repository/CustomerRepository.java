package com.koukio.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import com.koukio.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	Page<Customer> findAll(Pageable pageable);
}
