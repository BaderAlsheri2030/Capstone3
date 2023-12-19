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
@Entity
@Setter
@Getter
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "date")
    private LocalDate date;
    @NotEmpty(message = "salaries should not be empty")
    @Column(columnDefinition = "varchar not null")
    private String salaries;
    @NotEmpty(message = "suppliers should not be empty")
    @Column(columnDefinition = "varchar not null")
    private String suppliers;
    @NotEmpty(message = "totalExpenses should not be empty")
    @Column(columnDefinition = "double")
    private double totalExpenses;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "expenses")
    private Set<Reports> reports;


}
