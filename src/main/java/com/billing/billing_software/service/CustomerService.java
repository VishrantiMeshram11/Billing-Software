package com.billing.billing_software.service;

import com.billing.billing_software.exception.ResourseNotFoundException;
import com.billing.billing_software.model.Customer;
import com.billing.billing_software.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

    @Service
    public class CustomerService {

        private final CustomerRepository repo;

        public CustomerService(CustomerRepository repo) {
            this.repo = repo;
        }

        public Customer add(Customer customer) {
            return repo.save(customer);
        }

        public List<Customer> getAll() {
            return repo.findAll();
        }

        public Customer getById(int id) {
            Customer c = repo.findById(id);
            if (c == null) {
                throw new ResourseNotFoundException("Customer not found");
            }
            return c;
        }

        public Customer update(int id, Customer updated) {
            Customer c = getById(id);
            c.setCustomerName(updated.getCustomerName());
            c.setCustomerPhoneNo(updated.getCustomerPhoneNo());
            c.setCustomerEmail(updated.getCustomerEmail());
            c.setCustomerAddress(updated.getCustomerAddress());
            return c;
        }
}
