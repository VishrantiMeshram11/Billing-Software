package com.billing.billing_software.service;

import com.billing.billing_software.DTOs.InvoiceRequestDTO;
import com.billing.billing_software.model.Invoice;
import com.billing.billing_software.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InvoiceServiceImplementation implements InvoiceService {

    private final InvoiceRepository repository;
    private static final AtomicInteger ID_GEN = new AtomicInteger(1);

    public InvoiceServiceImplementation(InvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Invoice createInvoice(int customerId,
                                 List<InvoiceRequestDTO.ItemRequestDTO> items,
                                 double discount) {

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(ID_GEN.getAndIncrement());
        invoice.setInvoiceDate(LocalDateTime.now());
        invoice.setCustomerId(customerId);

        List<Integer> productIds = new ArrayList<>();
        double totalAmount = 0;

        for (InvoiceRequestDTO.ItemRequestDTO item : items) {
            productIds.add(item.getProductId());
            totalAmount += item.getQuantity() * 100; // dummy price
        }

        invoice.setProductIds(productIds);
        invoice.setTotalAmount(totalAmount);
        invoice.setDiscount(discount);
        invoice.setFinalAmount(totalAmount - discount);

        repository.save(invoice);
        return invoice;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return repository.findAll();
    }

    @Override
    public Invoice getInvoiceById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<Invoice> getInvoicesByCustomer(int customerId) {
        return repository.findByCustomerId(customerId);
    }
}
