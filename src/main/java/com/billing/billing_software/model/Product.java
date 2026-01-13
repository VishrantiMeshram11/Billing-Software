package com.billing.billing_software.model;

public class Product {
    private int proId;
    private String proName;
    private  int proPrice;
    private double gstPercentage;
    private int stockQuantity;

    public Product (){

    }

    public Product(int proId, String proName, int proPrice,
                   double gstPercentage, int stockQuantity) {
        this.proId = proId;
        this.proName = proName;
        this.proPrice = proPrice;
        this.gstPercentage = gstPercentage;
        this.stockQuantity = stockQuantity;
    }

    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getProPrice() {
        return proPrice;
    }

    public void setProPrice(int proPrice) {
        this.proPrice = proPrice;
    }

    public double getGstPercentage() {
        return gstPercentage;
    }

    public void setGstPercentage(double gstPercentage) {
        this.gstPercentage = gstPercentage;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }
}
