//package com.billing.billing_software.model;
//
//import java.util.Date;
//
//public class Invoice {
//
//    private String invoiceId;
//    private Date invoiceDate;
//    private Customer customer;
//    private double totalAmountl;
//    private double totalTax;
//    private double discount;
//    private  double finalAmount;
//
//    public Invoice(String invoiceId, Date invoiceDate, Customer customer, double totalAmountl,
//                   double totalTax, double discount, double finalAmount) {
//        this.invoiceId = invoiceId;
//        this.invoiceDate = invoiceDate;
//        this.customer = customer;
//        this.totalAmountl = totalAmountl;
//        this.totalTax = totalTax;
//        this.discount = discount;
//        this.finalAmount = finalAmount;
//    }
//
//    public String getInvoiceId() {
//        return invoiceId;
//    }
//
//    public void setInvoiceId(String invoiceId) {
//        this.invoiceId = invoiceId;
//    }
//
//    public Date getInvoiceDate() {
//        return invoiceDate;
//    }
//
//    public void setInvoiceDate(Date invoiceDate) {
//        this.invoiceDate = invoiceDate;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
//
//    public double getTotalAmountl() {
//        return totalAmountl;
//    }
//
//    public void setTotalAmountl(double totalAmountl) {
//        this.totalAmountl = totalAmountl;
//    }
//
//    public double getTotalTax() {
//        return totalTax;
//    }
//
//    public void setTotalTax(double totalTax) {
//        this.totalTax = totalTax;
//    }
//
//    public double getDiscount() {
//        return discount;
//    }
//
//    public void setDiscount(double discount) {
//        this.discount = discount;
//    }
//
//    public double getFinalAmount() {
//        return finalAmount;
//    }
//
//    public void setFinalAmount(double finalAmount) {
//        this.finalAmount = finalAmount;
//    }
//}

package com.billing.billing_software.model;

import java.time.LocalDate;
import java.util.List;

public class Invoice {

    private int invoiceId;
    private LocalDate invoiceDate;
    private Customer customer;
    private List<InvoiceItem> items;
    private double totalAmount;
    private double totalTax;
    private double discount;
    private double finalAmount;

    public Invoice() {}

    // Getters & Setters
    public int getInvoiceId() { return invoiceId; }
    public void setInvoiceId(int invoiceId) { this.invoiceId = invoiceId; }

    public LocalDate getInvoiceDate() { return invoiceDate; }
    public void setInvoiceDate(LocalDate invoiceDate) { this.invoiceDate = invoiceDate; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<InvoiceItem> getItems() { return items; }
    public void setItems(List<InvoiceItem> items) { this.items = items; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getTotalTax() { return totalTax; }
    public void setTotalTax(double totalTax) { this.totalTax = totalTax; }

    public double getDiscount() { return discount; }
    public void setDiscount(double discount) { this.discount = discount; }

    public double getFinalAmount() { return finalAmount; }
    public void setFinalAmount(double finalAmount) { this.finalAmount = finalAmount; }
}

