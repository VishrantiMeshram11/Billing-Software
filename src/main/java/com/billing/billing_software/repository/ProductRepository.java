package com.billing.billing_software.repository;

import com.billing.billing_software.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private  final ArrayList<Product> list = new ArrayList<>();

    public List<Product> findAll(){
        return list;
    }
    public Product findById(int id){
        return list.stream()
                .filter(p ->p.getProId() == id )
                .findFirst()
                .orElse(null);
    }

    public void save(Product product){
        list.add(product);
    }

    public boolean updateById( int id,Product product){
        Product existingProduct = findById(id);
        if(existingProduct == null) {
            return false;
        }
        existingProduct.setProName(product.getProName());
        existingProduct.setProPrice(product.getProPrice());
        existingProduct.setGstPercentage(product.getGstPercentage());
        existingProduct.setStockQuantity(product.getStockQuantity());
        return  true;
        }

    public void deleteProduct(int id){
        list.removeIf(p -> p.getProId() == id );
    }
    }
