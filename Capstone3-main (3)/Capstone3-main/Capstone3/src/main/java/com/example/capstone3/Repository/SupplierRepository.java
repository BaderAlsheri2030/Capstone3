package com.example.capstone3.Repository;

import com.example.capstone3.Model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
    Supplier findSupplierById(Integer id);
}
