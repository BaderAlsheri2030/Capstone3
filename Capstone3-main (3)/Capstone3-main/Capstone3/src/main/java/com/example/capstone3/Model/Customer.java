package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private String firstName;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private String lastName;
    @Email
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty
    @Column(columnDefinition = "varchar (10) not null")
    private String phone;
    @NotEmpty
    @Column(columnDefinition = "varchar (20) not null")
    private String address;
    @Positive
    @Column(columnDefinition = " int")
    private Integer Discounts;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Reports> reports;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "customer")
    private Set<Invoice> invoices;


}
