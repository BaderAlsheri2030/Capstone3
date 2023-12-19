package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class Product {
    @Id
    private Integer id;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private String product_name;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private String category;
    @NotNull
    @Column(columnDefinition = "double not null")
    private Double price;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer Quantity;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "sales_id",referencedColumnName = "id")
    private Sales sales;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "supplier_id",referencedColumnName = "id")
    private Supplier supplier;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "reports_id",referencedColumnName = "id")
    private Reports reports;
}
