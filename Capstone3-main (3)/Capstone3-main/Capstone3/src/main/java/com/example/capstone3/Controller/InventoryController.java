package com.example.capstone3.Controller;

import com.example.capstone3.Model.inventory;
import com.example.capstone3.Service.InventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;


    @GetMapping("/get")
    public ResponseEntity getInventory(){
       return ResponseEntity.status(200).body(inventoryService.getInventory());
    }
    @PostMapping("/add")
    public ResponseEntity addInventory(@Valid @RequestBody inventory inventory){
        inventoryService.addInventory(inventory);
        return ResponseEntity.status(200).body("Inventory added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateInventory(@PathVariable Integer id, @Valid @RequestBody inventory inventory){
        inventoryService.updateInventory(id,inventory);
        return ResponseEntity.status(200).body("inventory updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteInventory(Integer id){
        inventoryService.deleteInventory(id);
        return ResponseEntity.status(200).body("inventory deleted");
    }
}
