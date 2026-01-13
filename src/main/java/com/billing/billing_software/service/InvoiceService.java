package com.billing.billing_software.service;

import com.billing.billing_software.DTOs.InvoiceRequestDTO;
import com.billing.billing_software.model.Invoice;

import java.util.List;

public interface InvoiceService {

    Invoice createInvoice(int customerId,
                          List<InvoiceRequestDTO.ItemRequestDTO> items,
                          double discount);

    List<Invoice> getAllInvoices();

    Invoice getInvoiceById(int id);

    List<Invoice> getInvoicesByCustomer(int customerId);
}
