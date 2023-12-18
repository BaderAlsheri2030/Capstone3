package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
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
    @Column(columnDefinition = "varchar(10) not null")
    private String phone;
    @NotEmpty
    @Column(columnDefinition = "varchar(10)")
    private String Position;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "expenses_id",referencedColumnName = "id")
    private Expenses expenses;
}
