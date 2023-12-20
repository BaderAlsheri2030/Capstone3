package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.DTO.InvoiceDTO;
import com.example.capstone3.DTO.ProductDetailsDTO;
import com.example.capstone3.Model.Customer;
import com.example.capstone3.Model.Invoice;
import com.example.capstone3.Model.Product;
import com.example.capstone3.Model.ProductDetails;
import com.example.capstone3.Repository.CustomerRepository;
import com.example.capstone3.Repository.InvoiceRepository;
import com.example.capstone3.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final ProductDetailsService productDetailsService;


    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    }

    public void addInvoice(InvoiceDTO invoiceDTO){

        Customer customer=customerRepository.findCustomerById(invoiceDTO.getCustomer_id());

        double totalPrice = 0;
        List<Product> products = productRepository.findAll();
        Set<ProductDetailsDTO> temp = new LinkedHashSet<>();

        if(customer==null){
            throw new ApiException("customer id not found");
        }
        for (Product product:products) {
            for (ProductDetailsDTO p:invoiceDTO.getProductDetailsDTO()){
                productDetailsService.addProductDetails(p);
                if(product.getId().equals(p.getProduct_id())){
                    totalPrice += p.getQuantity() * product.getPrice();
                    temp.add(p);
                }
            }
        }


        List<ProductDetails> s= new ArrayList<>();




        if(temp.size() != invoiceDTO.getProductDetailsDTO().size()){
            throw new ApiException("Invalid input");
        }

        invoiceDTO.setTotalPrice(totalPrice);
        Invoice invoice = new Invoice(null,customer,null, invoiceDTO.getTotalPrice(), null);
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
