package com.koukio.repository;

import org.springframework.data.repository.CrudRepository;
import com.koukio.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
