package com.example.capstone3.Controller;

import com.example.capstone3.Model.Expenses;
import com.example.capstone3.Service.ExpensesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Expenses")
public class ExpensesController {
    private final ExpensesService expensesService;

    @GetMapping("/getExpenses")
    public ResponseEntity getExpenses(){
        return ResponseEntity.status(HttpStatus.OK).body(expensesService.getExpenses());
    }
    @PostMapping("/addExpenses")
    public ResponseEntity addExpenses(@RequestBody @Valid Expenses expenses){
        expensesService.addExpenses(expenses);
        return ResponseEntity.status(HttpStatus.OK).body("Expenses add");
    }
}
