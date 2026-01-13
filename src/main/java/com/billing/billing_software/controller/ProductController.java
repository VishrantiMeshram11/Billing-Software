package com.billing.billing_software.controller;

import com.billing.billing_software.model.Product;
import com.billing.billing_software.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final  ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<Product> getAll(){
        return service.getAllProduct();
    }

    @PostMapping
    public String addProduct(@RequestBody Product product){
        if(service.addProduct(product)){
            return "Added Successfully";
        }
        return "Failed to Add";
    }

    @GetMapping("/{id}")
    public  Product getById(@PathVariable int id){
        return  service.findById(id);
    }

    @PutMapping("/{id}")
    public String updateProduct(@PathVariable int id,@RequestBody Product product){
        try {
            service.updateProduct(id ,product);
            return "update Successfully";
        } catch (Exception e) {
            return "Fail to update -> Product Not Found";
        }
    }
    @DeleteMapping("/{id}")
    public String deletedProduct(@PathVariable int id){
        try {
            service.deleteProduct(id);
            return "Deleted Successfully";
        } catch (Exception e) {
            return "Fail to Delete";
        }
    }
}
