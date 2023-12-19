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
public class ProductDetails {
    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "product_id",referencedColumnName = "id")
    @JsonIgnore
    private Product products;


    @ManyToOne
    @JoinColumn(name = "invoice_id", referencedColumnName = "id")
    @JsonIgnore
    private Invoice invoice;

    @Column
    @NotNull
    private Integer quantity;





}
