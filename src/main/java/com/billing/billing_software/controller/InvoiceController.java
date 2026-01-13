package com.billing.billing_software.controller;
import com.billing.billing_software.DTOs.InvoiceRequestDTO;
import com.billing.billing_software.DTOs.InvoiceResponseDTO;
import com.billing.billing_software.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    private final InvoiceService service;

    public InvoiceController(InvoiceService service) {
        this.service = service;
    }

    @PostMapping
    public InvoiceResponseDTO createInvoice(
            @RequestBody InvoiceRequestDTO request) {
        return service.createInvoice(request);
    }

    @GetMapping
    public List<InvoiceResponseDTO> getAllInvoices() {
        return service.getAllInvoices();
    }

    @GetMapping("/{id}")
    public InvoiceResponseDTO getById(@PathVariable int id) {
        return service.getInvoiceById(id);
    }

    @GetMapping("/customer/{customerId}")
    public List<InvoiceResponseDTO> getByCustomer(
            @PathVariable int customerId) {
        return service.getByCustomerId(customerId);
    }
}