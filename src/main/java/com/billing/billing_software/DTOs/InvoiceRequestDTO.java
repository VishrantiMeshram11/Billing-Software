//package com.billing.billing_software.DTOs;
//
//import com.billing.billing_software.model.Customer;
//import com.billing.billing_software.model.InvoiceItem;
//
//import java.util.List;
//
//public class InvoiceRequestDTO {
//    private Customer customer;
//    private List<InvoiceItem> items;
//    private int discount;

package com.billing.billing_software.DTOs;

import java.util.List;

public class InvoiceRequestDTO {

    private String customerId;
    private List<ProductQuantityDTO> products;
    private double discount;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<ProductQuantityDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductQuantityDTO> products) {
        this.products = products;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    // Inner DTO
    public static class ProductQuantityDTO {
        private int productId;
        private int quantity;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}
