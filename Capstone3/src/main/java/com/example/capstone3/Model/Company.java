package com.example.capstone3.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String address;

    private String vatNumber;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<Customer> customers;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<Employee> employees;

}
