package com.example.capstone3.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String report_type;
    @NotNull
    @Column(columnDefinition = "DATE")
    private LocalDate date;
    @NotEmpty
    @Column(columnDefinition = "varchar(100) not null")
    private String Summary;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private  String Format;
    @Column(columnDefinition = "varchar(50)")
    private String note;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reports" )
    private Set<Sales> sales;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reports" )
    private Set<Customer> customers;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reports" )
    private Set<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reports" )
    private Set<Product> products;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reports" )
    private Set<Supplier> suppliers;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "reports" )
    private Set<Expenses> expenses;



    @OneToOne(cascade = CascadeType.ALL,mappedBy = "reports")
    private Inventory inventory;







}
