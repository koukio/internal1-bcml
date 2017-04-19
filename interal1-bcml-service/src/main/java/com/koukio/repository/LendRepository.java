package com.koukio.repository;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;
import com.koukio.entity.Customer;
import com.koukio.entity.Lend;

public interface LendRepository extends CrudRepository<Lend, Integer> {

	Page<Lend> findAll(Pageable pageable);

	Lend findByCustomerAllIgnoringCase(Customer customer);
}
