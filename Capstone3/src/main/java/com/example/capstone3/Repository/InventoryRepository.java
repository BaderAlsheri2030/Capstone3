package com.example.capstone3.Repository;

import com.example.capstone3.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {

    Inventory findInventoryById(Integer id);
}
