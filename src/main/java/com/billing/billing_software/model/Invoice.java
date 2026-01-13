package com.billing.billing_software.model;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {

    private int invoiceId;
    private LocalDateTime invoiceDate;
    private int customerId;
    private double totalAmount;
    private double totalTax;
    private double discount;
    private double finalAmount;
    private List<Integer> productIds;

    public Invoice() {}

    public Invoice(int invoiceId, LocalDateTime invoiceDate, int customerId,
                   double totalAmount, double totalTax,
                   double discount, double finalAmount) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.customerId = customerId;
        this.totalAmount = totalAmount;
        this.totalTax = totalTax;
        this.discount = discount;
        this.finalAmount = finalAmount;
    }

    // getters & setters
    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public LocalDateTime getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDateTime invoiceDate) { this.invoiceDate = invoiceDate; }

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getTotalTax() { return totalTax; }
    public void setTotalTax(double totalTax) { this.totalTax = totalTax; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getFinalAmount() { return finalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }

    public List<Integer> getProductIds() { return productIds; }
    public void setProductIds(List<Integer> productIds) { this.productIds = productIds; }
}
