package com.example.capstone3.Repository;

import com.example.capstone3.Model.inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<inventory,Integer> {

    inventory findInventoryById(Integer id);
}
