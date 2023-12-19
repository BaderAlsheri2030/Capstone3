package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Employee;
import com.example.capstone3.Model.Expenses;
import com.example.capstone3.Repository.EmployeeRepository;
import com.example.capstone3.Repository.ExpensesRepository;
import com.example.capstone3.Repository.SupplierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExpensesService {
    private final EmployeeRepository employeeRepository;
    private final SupplierRepository supplierRepository;
    private final ExpensesRepository expensesRepository;
    public List<Expenses> getExpenses(){
        return expensesRepository.findAll();
    }
    public void addExpenses(Expenses expenses){
        expensesRepository.save(expenses);
    }
}

