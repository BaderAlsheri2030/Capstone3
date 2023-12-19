package com.example.capstone3.Controller;

import com.example.capstone3.Model.Sales;
import com.example.capstone3.Model.Supplier;
import com.example.capstone3.Service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/supplier")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;



    @GetMapping("/get")
    public ResponseEntity getSupplier(){
        return ResponseEntity.status(200).body(supplierService.getSupplier());
    }
    @PostMapping("/add")
    public ResponseEntity addSupplier(@Valid @RequestBody Supplier supplier){
        supplierService.addSupplier(supplier);
        return ResponseEntity.status(200).body("Sales added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSupplier(@PathVariable Integer id, @Valid @RequestBody Supplier supplier){
        supplierService.updateSupplier(id,supplier);
        return ResponseEntity.status(200).body("Sales updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSupplier(@PathVariable Integer id){
        supplierService.deleteSupplier(id);
        return ResponseEntity.status(200).body("Sales deleted");
    }

}
