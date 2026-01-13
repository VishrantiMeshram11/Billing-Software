package com.billing.billing_software.repository;

import com.billing.billing_software.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private final List<Invoice> invoices = new ArrayList<>();
    private int counter = 1;

    public Invoice save(Invoice invoice) {
        invoice.setInvoiceId(counter++);
        invoices.add(invoice);
        return invoice;
    }

    public List<Invoice> findAll() {
        return invoices;
    }
}
