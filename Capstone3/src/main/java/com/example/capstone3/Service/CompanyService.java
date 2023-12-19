package com.example.capstone3.Service;

import com.example.capstone3.ApiException.ApiException;
import com.example.capstone3.Model.Company;
import com.example.capstone3.Repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    public List<Company> getCompanies(){
        return companyRepository.findAll();
    }
    public void addCompany(Company company){
        companyRepository.save(company);
    }
    public void updateCompany(Integer id, Company company){
        Company oldCompany=companyRepository.findCompanyById(id);
        if(oldCompany==null){
          throw new ApiException("Company not found");
        }
        oldCompany.setName(company.getName());
        oldCompany.setName(company.getAddress());
        oldCompany.setAddress(company.getAddress());
        oldCompany.setVatNumber(company.getVatNumber());
        companyRepository.save(oldCompany);
    }
    public void deleteCompany(Integer id){
        Company company=companyRepository.findCompanyById(id);
        if(company==null){
            throw new ApiException("Company not found");
        }
        companyRepository.delete(company);
    }
}
