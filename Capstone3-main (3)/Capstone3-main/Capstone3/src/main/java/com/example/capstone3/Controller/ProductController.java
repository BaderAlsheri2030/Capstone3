package com.example.capstone3.Controller;


import com.example.capstone3.Model.Inventory;
import com.example.capstone3.Model.Product;
import com.example.capstone3.Service.InventoryService;
import com.example.capstone3.Service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;


    @GetMapping("/get")
    public ResponseEntity getProduct(){
        return ResponseEntity.status(200).body(productService.getProducts());
    }
    @PostMapping("/add")
    public ResponseEntity addProduct(@Valid @RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.status(200).body("product added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @Valid @RequestBody Product product){
        productService.updateProduct(id,product);
        return ResponseEntity.status(200).body("product updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProduct(Integer id){
        productService.deleteProduct(id);
        return ResponseEntity.status(200).body("product deleted");

    }
}
