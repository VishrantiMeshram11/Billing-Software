package com.billing.billing_software.DTOs;

import com.billing.billing_software.model.Invoice;

public class InvoiceResponseDTO {

    private String message;
    private Invoice invoice;

    public InvoiceResponseDTO(String message, Invoice invoice) {
        this.message = message;
        this.invoice = invoice;
    }

    public String getMessage() { return message; }
    public Invoice getInvoice() { return invoice; }
}
