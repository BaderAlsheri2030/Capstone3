package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "varchar(50) check(role='Company' or role = 'Individual')")
    @NotEmpty(message = "name should not be empty")
    private String role;
    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "varchar(50) not null")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @Email(message = "Enter valid email")
    @NotEmpty(message = "Email should not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "phone should not be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Invalid phone number format")
    @Column(columnDefinition = "varchar (10) not null")
    private String phone;
    @NotEmpty(message = "address should not be empty")
    @Column(columnDefinition = "varchar (20) not null")
    private String address;
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
