package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Inventory;
import com.example.capstone3.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<Inventory> getInventory(){
        return  inventoryRepository.findAll();
    }

    public void addInventory(Inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void updateInventory(Integer id, Inventory inventory){
    Inventory inventory1 = inventoryRepository.findInventoryById(id);
    if (inventory1 == null){
        throw new ApiException("invalid inventory id");
    }
    inventory1.setSupplier(inventory.getSupplier());
    inventoryRepository.save(inventory1);
    }

    public void deleteInventory(Integer id){
        Inventory inventory = inventoryRepository.findInventoryById(id);
        if (inventory == null){
            throw new ApiException("Inventory doesn't exist");
        }
    }


}
