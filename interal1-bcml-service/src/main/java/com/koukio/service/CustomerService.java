package com.koukio.service;

import com.koukio.entity.Customer;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * CustomerService
 */
@Component
public class CustomerService {

    public Customer createCustomer(String name) throws Exception{
        throw new NotImplementedException();
    }

    public String ping() {
        return String.valueOf(System.currentTimeMillis());
    }
}
