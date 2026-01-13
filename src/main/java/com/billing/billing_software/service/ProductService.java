package com.billing.billing_software.service;

import com.billing.billing_software.model.Product;
import com.billing.billing_software.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProduct() {
        return repository.findAll();
    }

    public boolean addProduct(Product product) {
        try {
            repository.save(product);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public Product findById(int id) {
        try {
            return repository.findById(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean updateProduct(int id, Product product) {
       return  repository.updateById(id,product);
    }


    public boolean deleteProduct(int id) {
        try {
            repository.deleteProduct(id);
            return true;
        } catch (Exception e) {
            throw e;
        }
    }
}
