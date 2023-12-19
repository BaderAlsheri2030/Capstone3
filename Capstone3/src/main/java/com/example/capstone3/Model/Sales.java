package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date")
    private LocalDate Date;
    @NotEmpty
    @Column(columnDefinition = "double not null")
    private double Total_Amount;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sales")
    private Set<Product> product ;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "sales")
    private Set<Customer> customer;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "reports_id",referencedColumnName = "id")
    private Reports reports;


}
