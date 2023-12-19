package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.DTO.InvoiceDTO;
import com.example.capstone3.DTO.ProductDetailsDTO;
import com.example.capstone3.Model.Customer;
import com.example.capstone3.Model.Invoice;
import com.example.capstone3.Model.Product;
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
    private final ProductService productService;
    private final ProductRepository productRepository;


    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public void addInvoice(InvoiceDTO invoiceDTO){
        Customer customer=customerRepository.findCustomerById(invoiceDTO.getCustomer_id());
        if(customer==null){
            throw new ApiException("customer id not found");
        }
        List temp=null;
        for ( Product product:productService.getProducts()) {
            for (ProductDetailsDTO p:invoiceDTO.getProductDetailDTO()){
                if(product.getId()==p.getProduct_id()){
                    double totalPrice=0;
                    totalPrice+=p.getQuantity()* product.getPrice();
                    temp.add(p);
                }
            }
        }
        if(temp.size()!=invoiceDTO.getProductDetailDTO().size()){
            throw new ApiException("id not found");
        }
        Invoice invoice=new Invoice(null,customer,null, invoiceDTO.getTotalPrice(), null);
        invoiceRepository.save(invoice);
    }

    public void updateInvoice(Integer id, Invoice invoice){
        Invoice invoice1 = invoiceRepository.findInvoiceById(id);
        if (invoice1 == null){
            throw new ApiException("invalid invoice id");
        }
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
