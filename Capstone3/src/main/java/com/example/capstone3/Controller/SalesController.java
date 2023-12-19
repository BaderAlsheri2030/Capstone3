package com.example.capstone3.Controller;


import com.example.capstone3.Model.Product;
import com.example.capstone3.Model.Sales;
import com.example.capstone3.Service.ProductService;
import com.example.capstone3.Service.SalesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;


    @GetMapping("/get")
    public ResponseEntity getSales(){
        return ResponseEntity.status(200).body(salesService.getSales());
    }
    @PostMapping("/add")
    public ResponseEntity addSales(@Valid @RequestBody Sales sale){
        salesService.addSale(sale);
        return ResponseEntity.status(200).body("Sales added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateSales(@PathVariable Integer id, @Valid @RequestBody Sales sales){
        salesService.updateSale(id,sales);
        return ResponseEntity.status(200).body("Sales updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteSales(@PathVariable Integer id){
        salesService.deleteSale(id);
        return ResponseEntity.status(200).body("Sales deleted");
    }
}
