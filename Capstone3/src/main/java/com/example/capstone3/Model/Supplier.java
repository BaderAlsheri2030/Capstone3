package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
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

// private String Payment_Terms;

   @ManyToOne
   @JsonIgnore
   @JoinColumn(name = "inventory_id",referencedColumnName = "id")
    private Inventory inventory;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "supplier")
    private Set<Product> product;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "expenses_id",referencedColumnName = "id")
    private Expenses expenses;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "reports_id",referencedColumnName = "id")
    private Reports reports;

}
