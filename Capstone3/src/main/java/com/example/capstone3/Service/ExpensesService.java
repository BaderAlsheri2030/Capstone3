package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Expenses;
import com.example.capstone3.Repository.ExpensesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ExpensesService {
    private final ExpensesRepository expensesRepository;
    public List<Expenses> getExpenses(){
        return expensesRepository.findAll();
    }
    public void addExpenses(Expenses expenses){
        expensesRepository.save(expenses);
    }
    public void updateExpenses(Integer id ,Expenses expenses){
        Expenses oldExpense=expensesRepository.findExpensesById(id);
        if(oldExpense==null){
            throw new ApiException("Expenses not found");
        }
//        oldExpense.
    }
    public void deleteExpenses(Integer id ){
        Expenses expense=expensesRepository.findExpensesById(id);
        if(expense==null){
            throw new ApiException("Expenses not found");
        }
        expensesRepository.delete(expense);
    }
}

