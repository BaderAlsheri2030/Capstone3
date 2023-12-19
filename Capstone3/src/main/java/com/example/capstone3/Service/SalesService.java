package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Sales;
import com.example.capstone3.Repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SalesService {

    private final SalesRepository salesRepository;


    public List<Sales> getSales(){
        return salesRepository.findAll();
    }

    public void addSale(Sales sales){
        salesRepository.save(sales);
    }

    public void updateSale(Integer id,Sales sales){
        Sales sales1 = salesRepository.findSalesById(id);
        if (sales1 == null){
            throw new ApiException("Invalid sale Id");
        }
        sales1.setTotal_Amount(sales.getTotal_Amount());
        salesRepository.save(sales1);
    }

    public void deleteSale(Integer id){
        Sales sales1 = salesRepository.findSalesById(id);
        if (sales1 == null){
            throw new ApiException("invalid id");
        }
        salesRepository.delete(sales1);
    }
}
