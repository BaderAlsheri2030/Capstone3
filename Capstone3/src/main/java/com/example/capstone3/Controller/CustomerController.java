package com.example.capstone3.Controller;

import com.example.capstone3.Model.Customer;
import com.example.capstone3.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;
    @GetMapping("/getCustomer")
    public ResponseEntity getCustomer(){
        return ResponseEntity.status(HttpStatus.OK).body(customerService.getCustomers());
    }
    @PostMapping("/addCustomer")
    public ResponseEntity addCustomer(@RequestBody @Valid Customer customer){
        customerService.addCustomer(customer);
        return ResponseEntity.status(HttpStatus.OK).body("Customer add");
    }
    @PutMapping("/updateCustomer/{id}")
    public ResponseEntity updateCustomer(@PathVariable Integer id,@RequestBody@Valid Customer customer){
        customerService.updateCustomer(id, customer);
        return ResponseEntity.status(HttpStatus.OK).body("Customer updated");
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(HttpStatus.OK).body("Customer deleted");
    }
}
