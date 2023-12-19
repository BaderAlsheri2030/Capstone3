package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Supplier;
import com.example.capstone3.Repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public List<Supplier> getSupplier(){
        return supplierRepository.findAll();
    }
    public void addSupplier(Supplier supplier){
       supplierRepository.save(supplier);
    }
    public void updateSupplier(Integer id, Supplier supplier){
        Supplier supplier1 = supplierRepository.findSupplierById(id);
        if (supplier1 == null){
            throw new ApiException("Invalid supplier id");
        }
        supplier1.setEmail(supplier.getEmail());
        supplier1.setPhone(supplier.getPhone());
    }
    public void deleteSupplier(Integer id){
        Supplier supplier = supplierRepository.findSupplierById(id);
        if (supplier == null){
            throw new ApiException("invalid id");
        }
        supplierRepository.delete(supplier);
    }

}
