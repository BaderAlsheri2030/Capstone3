package com.example.capstone3.Repository;

import com.example.capstone3.Model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
    Invoice findInvoiceById(Integer id);
}
