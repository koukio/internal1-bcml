package com.koukio.repository;

import java.awt.print.Pageable;

import org.springframework.data.domain.*;
import org.springframework.data.repository.*;
import com.koukio.entity.Customer;
import com.koukio.entity.Lend;

public interface LendRepository extends Repository<Lend, Integer> {

	 Page<Lend> findAll(Pageable pageable);

	    Lend findByCustomerAllIgnoringCase(Customer customer);
}
