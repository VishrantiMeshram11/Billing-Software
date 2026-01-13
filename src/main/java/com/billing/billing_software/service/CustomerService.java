package com.billing.billing_software.service;

import com.billing.billing_software.model.Customer;
import com.billing.billing_software.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer addCustomer(Customer customer) {
        repository.saveCustomer(customer);
        return customer;
    }

    public List<Customer> getAllCustomers() {
        return repository.findAllCustomers();
    }

    public Customer getCustomerById(int id) {
        return repository.findCustomerById(id);
    }

    public boolean deleteCustomer(int id) {
        return repository.deleteCustomerById(id) > 0;
    }
}
