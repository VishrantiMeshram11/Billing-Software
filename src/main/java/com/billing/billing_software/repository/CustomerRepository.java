package com.billing.billing_software.repository;

import com.billing.billing_software.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private final List<Customer> customers = new ArrayList<>();
    private int customerId = 1;

    public Customer save(Customer customer) {
        customer.setCustomerId(customerId++);
        customers.add(customer);
        return customer;
    }

    public List<Customer> findAll() {
        return customers;
    }

    public Customer findById(int id) {
        return customers.stream()
                .filter(c -> c.getCustomerId() == id)
                .findFirst()
                .orElse(null);
    }
}

