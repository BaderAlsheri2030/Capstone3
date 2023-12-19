package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @JsonIgnore
    private Customer customer;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "invoice")
    private Set<ProductDetails> productDetails;



    @Column(columnDefinition = "double")
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "sales_id",referencedColumnName = "id")
    @JsonIgnore
    private Sales sales;

}
