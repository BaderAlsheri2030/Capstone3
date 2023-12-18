package com.example.capston3.Model;

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


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<Customer> customer;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<Employee> employee;

}
