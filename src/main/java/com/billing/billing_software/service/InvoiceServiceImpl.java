//package com.billing.billing_software.service;
//
//import com.billing.billing_software.DTOs.InvoiceRequestDTO;
//import com.billing.billing_software.model.*;
//import com.billing.billing_software.repository.InvoiceRepository;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class InvoiceServiceImpl implements InvoiceServices {
//
//    private final InvoiceRepository invoiceRepository;
//    private final CustomerService customerService;
//    private final ProductService productService;
//
//    private static final double GST_RATE = 0.18;
//
//    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
//                              CustomerService customerService,
//                              ProductService productService) {
//        this.invoiceRepository = invoiceRepository;
//        this.customerService = customerService;
//        this.productService = productService;
//    }
//
//    @Override
//    public Invoice generateInvoice(InvoiceRequestDTO request) {
//
//        Customer customer = customerService.getCustomerById(request.getCustomerId());
//
//        List<InvoiceItem> items = new ArrayList<>();
//        double subTotal = 0;
//        double totalTax = 0;
//        int itemId = 1;
//
//        for (InvoiceRequestDTO.ProductQuantityDTO pq : request.getProducts()) {
//
//            Product product = productService.findById(pq.getProductId());
//            int qty = pq.getQuantity();
//
//            double price = qty * product.getProPrice();
//            double tax = price * GST_RATE;
//            double total = price + tax;
//
//            subTotal += price;
//            totalTax += tax;
//
//            items.add(new InvoiceItem(itemId++, product, qty, price, tax, total));
//        }
//
//        double finalAmount = subTotal + totalTax - request.getDiscount();
//
//        Invoice invoice = new Invoice();
//        invoice.setInvoiceDate(LocalDate.now());
//        invoice.setCustomer(customer);
//        invoice.setItems(items);
//        invoice.setTotalAmount(subTotal);
//        invoice.setTotalTax(totalTax);
//        invoice.setDiscount(request.getDiscount());
//        invoice.setFinalAmount(finalAmount);
//
//        return invoiceRepository.save(invoice);
//    }
//}
