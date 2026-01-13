package com.billing.billing_software.controller;

import com.billing.billing_software.DTOs.InvoiceRequestDTO;
import com.billing.billing_software.model.Invoice;
import com.billing.billing_software.service.InvoiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> generateInvoice(@RequestBody InvoiceRequestDTO dto) {
        try {
            Invoice invoice = service.createInvoice(
                    dto.getCustomerId(),
                    dto.getItems(),
                    dto.getDiscount()
            );
            return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        return ResponseEntity.ok(service.getAllInvoices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInvoiceById(@PathVariable int id) {
        Invoice invoice = service.getInvoiceById(id);
        if (invoice == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Invoice not found");
        }
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Invoice>> getInvoicesByCustomer(@PathVariable int customerId) {
        return ResponseEntity.ok(service.getInvoicesByCustomer(customerId));
    }
}
