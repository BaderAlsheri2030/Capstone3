package com.example.capstone3.Controller;

import com.example.capstone3.Model.Company;
import com.example.capstone3.Service.CompanyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;
@GetMapping("/getCompany")
    public ResponseEntity getCompany(){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompanies());
    }
    @PostMapping("/addCompany")
    public ResponseEntity addCompany(@RequestBody@Valid Company company){
    companyService.addCompany(company);
    return ResponseEntity.status(HttpStatus.OK).body("company add");
    }
    @PutMapping("/updateCompany/{id}")
    public ResponseEntity updateCompany(@PathVariable Integer id,@RequestBody@Valid Company company){
    companyService.updateCompany(id, company);
    return ResponseEntity.status(HttpStatus.OK).body("company updated");
    }
    @DeleteMapping("/deleteCompany/{id}")
    public ResponseEntity deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return ResponseEntity.status(HttpStatus.OK).body("company deleted");
    }

}
