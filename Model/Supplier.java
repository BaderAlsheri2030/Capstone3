package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    @NotEmpty(message = "First Name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(columnDefinition = "varchar(10) not null")
    private String firstName;
    @NotEmpty(message = "Last Name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$")
    @Column(columnDefinition = "varchar(10) not null")
    private String lastName;
    @Email(message = "Enter valid Email ")
    @NotEmpty(message = "email should not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty(message = "phone should not be empty")
    @Column(columnDefinition = "varchar (10) not null")
    private String phone;

// private String Payment_Terms;

   @ManyToOne
   @JsonIgnore
   @JoinColumn(name = "inventory_id",referencedColumnName = "id")
    private inventory inventory;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier")
    private Set<Product> product;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier")
    private Set<Reports> reports;


}
