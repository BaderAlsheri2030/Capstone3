package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Invoice;
import com.example.capstone3.Repository.CustomerRepository;
import com.example.capstone3.Repository.InvoiceRepository;
import com.example.capstone3.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;


    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public void addInvoice(Invoice invoice){

        invoiceRepository.save(invoice);
    }

    public void updateInvoice(Integer id, Invoice invoice){
        Invoice invoice1 = invoiceRepository.findInvoiceById(id);
        if (invoice1 == null){
            throw new ApiException("invalid invoice id");
        }
        invoice1.();
        invoiceRepository.save(invoice1);
    }

    public void  deleteInvoice(Integer id){
        Invoice invoice = invoiceRepository.findInvoiceById(id);
        if (invoice == null){
            throw new ApiException("Invalid Invoice id");
        }
        invoiceRepository.delete(invoice);
    }


}
