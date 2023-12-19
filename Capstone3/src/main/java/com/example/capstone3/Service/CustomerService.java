package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Customer;
import com.example.capstone3.Repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }
    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }
    public void updateCustomer(Integer id,Customer customer){
        Customer oldCustomer=customerRepository.findCustomerById(id);
        if(oldCustomer==null){
            throw new ApiException("Customer not found");
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
