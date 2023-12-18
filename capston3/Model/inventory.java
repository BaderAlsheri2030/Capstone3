package com.example.capston3.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class inventory {
    @Id
    private Integer id;
//    private String Description;
//    private String Status;

//    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory")
//    private Set<Product> product;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inventory")
    private Set<Supplier> supplier;


}
