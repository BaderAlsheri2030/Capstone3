package com.example.capstone3.Repository;

import ch.qos.logback.core.model.INamedModel;
import com.example.capstone3.Model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Integer> {
    Expenses findExpensesById(Integer id);
}
