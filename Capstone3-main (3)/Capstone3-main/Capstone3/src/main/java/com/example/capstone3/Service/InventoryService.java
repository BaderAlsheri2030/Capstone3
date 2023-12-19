package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.inventory;
import com.example.capstone3.Repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public List<inventory> getInventory(){
        return  inventoryRepository.findAll();
    }

    public void addInventory(inventory inventory){
        inventoryRepository.save(inventory);
    }

    public void updateInventory(Integer id, inventory inventory){
    inventory inventory1 = inventoryRepository.findInventoryById(id);
    if (inventory1 == null){
        throw new ApiException("invalid inventory id");
    }
    inventory1.setSupplier(inventory.getSupplier());
    inventoryRepository.save(inventory1);
    }

    public void deleteInventory(Integer id){
        inventory inventory = inventoryRepository.findInventoryById(id);
        if (inventory == null){
            throw new ApiException("Inventory doesn't exist");
        }
    }


}
