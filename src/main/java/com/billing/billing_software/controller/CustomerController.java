package com.billing.billing_software.controller;

import com.billing.billing_software.model.Customer;
import com.billing.billing_software.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody Customer customer) {
        try {
            Customer savedCustomer = service.addCustomer(customer);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedCustomer);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAllCustomers());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
        Customer customer = service.getCustomerById(id);
        if (customer == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Customer not found");
        }
        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        boolean deleted = service.deleteCustomer(id);
        if (deleted) {
            return ResponseEntity.ok("Customer deleted successfully");
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Customer not found");
    }
}
