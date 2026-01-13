//package com.billing.billing_software.repository;
//
//import com.billing.billing_software.model.Customer;
//import com.billing.billing_software.service.CustomerService;
//import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@Repository
//public class CustomerRespository {
//
//    private final CustomerService service;
//
//    public CustomerController(CustomerService service) {
//        this.service = service;
//    }
//
//    @GetMapping
//    public List<Customer> getAll(){
//        return service.getAllCustomer();
//    }
//
//    @PostMapping
//    public String addCustomer(@RequestBody Customer customer){
//        if(service.addCustomer(customer)){
//            return "Added Successfully";
//        }
//        return "Failed to Add";
//    }
//
//    @GetMapping("/{id}")
//    public  Customer getById(@PathVariable int id){
//        return  service.findById(id);
//    }
//
//    @PutMapping("/{id}")
//    public String updateCustomer(@PathVariable int id,@RequestBody Customer customer){
//        try {
//            service.updateCustomer(id ,customer);
//            return "update Successfully";
//        } catch (Exception e) {
//            return "Fail to update -> Customer Not Found";
//        }
//    }
////    @DeleteMapping("/{id}")
////    public String deletedCustomer(@PathVariable int id){
////        try {
////            service.deleteCustomer(id);
////            return "Deleted Successfully";
////        } catch (Exception e) {
////            return "Fail to Delete";
////        }
////    }
//}

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



//package com.billing.billing_software.repository;
//
//import com.billing.billing_software.model.Customer;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class CustomerRepository {
//
//    private final List<Customer> customers = new ArrayList<>();
//
//    public Customer addCustomer(Customer customer) {
//        customers.add(customer);
//        return customer;
//    }
//
//    public List<Customer> getAllCustomers() {
//        return customers;
//    }
//
//    public Optional<Customer> findById(String id) {
//        return customers.stream()
//                .filter(c -> c.getCusId().equals(id))
//                .findFirst();
//    }
//
//    public Customer updateCustomer(String id, Customer updatedCustomer) {
//        Optional<Customer> existingOpt = findById(id);
//        if (existingOpt.isPresent()) {
//            Customer existing = existingOpt.get();
//            existing.setCusName(updatedCustomer.getCusName());
//            existing.setCusEmail(updatedCustomer.getCusEmail());
//            existing.setCusPhoneNo(updatedCustomer.getCusPhoneNo());
//            existing.setCusAddress(updatedCustomer.getCusAddress());
//            return existing;
//        }
//        return null;
//    }
//
//    public boolean deleteCustomer(String id) {
//        Optional<Customer> existingOpt = findById(id);
//        if (existingOpt.isPresent()) {
//            customers.remove(existingOpt.get());
//            return true;
//        }
//        return false;
//    }
//}
