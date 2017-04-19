package com.koukio.repository;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;
import com.koukio.entity.Customer;

public interface CustomerRepository extends Repository<Customer, Integer> {

	Page<Customer> findAll(Pageable pageable);

	Customer findByNameAndFisrtNameAllIgnoringCase(String name, String firstName);

}
