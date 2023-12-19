package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @NotEmpty(message = "address should not be empty")
    @Column(columnDefinition = "varchar(20) not null")
    private String address;
    @NotEmpty(message = "vatNumber should not be empty")
    @Column(columnDefinition = "varchar(30) not null")
    private String vatNumber;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<Customer> customers;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company")
    private Set<Employee> employees;

}
