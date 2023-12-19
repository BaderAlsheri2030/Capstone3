package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Inventory {
    @Id
    private Integer id;

//    private String Description;
//    private String Status;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory")
//    private Set<Product> product;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory")
    private Set<Supplier> supplier;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory")
    private Set<Reports> reports;

}
