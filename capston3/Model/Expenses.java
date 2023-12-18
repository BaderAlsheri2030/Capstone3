package com.example.capston3.Model;

import jakarta.persistence.*;
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

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "expenses")
    private Set<Employee> employee;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "expenses")
    private Set<Supplier> suppliers;
}
