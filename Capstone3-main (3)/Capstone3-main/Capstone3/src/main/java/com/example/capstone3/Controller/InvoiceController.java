package com.example.capstone3.Controller;

import com.example.capstone3.DTO.InvoiceDTO;
import com.example.capstone3.Service.InvoiceService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/invoice")
@RequiredArgsConstructor
public class InvoiceController {
    private final InvoiceService invoiceService;
    @GetMapping("/getInvoice")
    public ResponseEntity getCompany(){
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.getInvoices());
    }
    @PostMapping("/addInvoice")
    public ResponseEntity addInvoice(@RequestBody @Valid InvoiceDTO invoiceDTO){
        invoiceService.addInvoice(invoiceDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Invoice add");
    }

    @DeleteMapping("/deleteInvoice/{id}")
    public ResponseEntity deleteInvoice(@PathVariable Integer id){
        invoiceService.deleteInvoice(id);
        return ResponseEntity.status(HttpStatus.OK).body("Invoice deleted");
    }
}
