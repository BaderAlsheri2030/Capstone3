package com.example.capstone3.Repository;

import com.example.capstone3.Model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer> {

    Sales findSalesById(Integer id);

}
