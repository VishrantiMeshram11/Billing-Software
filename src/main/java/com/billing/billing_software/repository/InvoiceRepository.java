package com.billing.billing_software.repository;

import com.billing.billing_software.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private final List<Invoice> invoices = new ArrayList<>();

    public void save(Invoice invoice) {
        invoices.add(invoice);
    }

    public List<Invoice> findAll() {
        return invoices;
    }

    public Invoice findById(int id) {
        return invoices.stream()
                .filter(i -> i.getInvoiceId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Invoice> findByCustomerId(int customerId) {
        return invoices.stream()
                .filter(i -> i.getCustomerId() == customerId)
                .toList();
    }
}

