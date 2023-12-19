package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.DTO.CustomerDTO;
import com.example.capstone3.Model.Company;
import com.example.capstone3.Model.Customer;
import com.example.capstone3.Repository.CompanyRepository;
import com.example.capstone3.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CompanyRepository companyRepository;
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public void addCustomer(CustomerDTO customerDTO){
        Company company=companyRepository.findCompanyById(customerDTO.getCompany_id());
        if(company==null){
            throw new ApiException("Company not found");
        }
        Customer customer = new Customer(null,customerDTO.getFirstName(),customerDTO.getLastName(),customerDTO.getEmail(),customerDTO.getPhone(),customerDTO.getAddress(),customerDTO.getDiscounts(),company,null,null);
        customerRepository.save(customer);
    }
    public void updateCustomer(Integer id,CustomerDTO customer){
        Customer oldCustomer=customerRepository.findCustomerById(id);
        if(oldCustomer==null){
            throw new ApiException("Customer not found");
        }
        Company company=companyRepository.findCompanyById(customer.getCompany_id());
        if(company==null){
            throw new ApiException("Company not found");
        }
        oldCustomer.setFirstName(customer.getFirstName());
        oldCustomer.setLastName(customer.getLastName());
        oldCustomer.setPhone(customer.getPhone());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setAddress(customer.getAddress());
        oldCustomer.setDiscounts(customer.getDiscounts());
        customerRepository.save(oldCustomer);
    }

    public void deleteCustomer(Integer id){
        Customer customer=customerRepository.findCustomerById(id);
        if(customer==null){
            throw new ApiException("Customer not found");
        }
        customerRepository.delete(customer);
    }
}
