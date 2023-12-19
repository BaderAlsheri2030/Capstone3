package com.example.capstone3.Controller;

import com.example.capstone3.DTO.EmployeeDTO;
import com.example.capstone3.Model.Employee;
import com.example.capstone3.Service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/getEmployee")
    public ResponseEntity getEmployee(){
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployee());
    }
    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        employeeService.addEmployee(employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Employee add");
    }
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity updateEmployee(@PathVariable Integer id,@RequestBody@Valid EmployeeDTO employeeDTO){
        employeeService.updateEmployee(id, employeeDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Employee updated");
    }
    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Integer id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted");
    }
}
