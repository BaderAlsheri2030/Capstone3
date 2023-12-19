package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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


    @ManyToOne
    @JoinColumn(name = "sales_id",referencedColumnName = "id")
    @JsonIgnore
    private Sales sales;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "id")
    @JsonIgnore
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JoinColumn(name = "supplier_id",referencedColumnName = "id")
    @JsonIgnore
    private Supplier supplier;

    @ManyToOne
    @JoinColumn(name = "expenses_id",referencedColumnName = "id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne
    @JoinColumn(name = "inventory_id",referencedColumnName = "id")
    @JsonIgnore
    private Inventory inventory;









}
