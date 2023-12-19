package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.DTO.EmployeeDTO;
import com.example.capstone3.Model.Company;
import com.example.capstone3.Model.Employee;
import com.example.capstone3.Repository.CompanyRepository;
import com.example.capstone3.Repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    public void addEmployee(EmployeeDTO employeeDTO){
        Company company=companyRepository.findCompanyById(employeeDTO.getCompany_id());
        if(company==null){
            throw new ApiException("Company not found");
        }

        Employee employee = new Employee(null,employeeDTO.getFirstName(),employeeDTO.getLastName(),employeeDTO.getEmail(),employeeDTO.getPhone(),employeeDTO.getPosition(),employeeDTO.getSalary(),company,null);
        employeeRepository.save(employee);
    }
    public void updateEmployee(Integer id,EmployeeDTO employeeDTO){
        Employee oldEmployee=employeeRepository.findEmployeeById(id);
        if(oldEmployee==null){
            throw new ApiException("Employee not found");
        }
        Company company=companyRepository.findCompanyById(employeeDTO.getCompany_id());
        if(company==null){
            throw new ApiException("Company not found");
        }
       oldEmployee.setFirstName(employeeDTO.getFirstName());
        oldEmployee.setLastName(employeeDTO.getLastName());
        oldEmployee.setEmail(employeeDTO.getEmail());
        oldEmployee.setPhone(employeeDTO.getPhone());
        oldEmployee.setPosition(employeeDTO.getPosition());
        oldEmployee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(oldEmployee);
    }

    public void deleteEmployee(Integer id){
        Employee employee=employeeRepository.findEmployeeById(id);
        if(employee==null){
            throw new ApiException("Employee not found");
        }
        employeeRepository.delete(employee);
    }
}
