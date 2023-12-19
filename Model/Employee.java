package com.example.capstone3.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "First name should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;
    @Email(message = "Enter valid email")
    @NotEmpty(message = "Email should not be empty")
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty (message = "phone should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String phone;
    @NotEmpty(message = "Position should not be empty")
    @Column(columnDefinition = "varchar(10) not null")
    private String Position;
    @NotNull(message = "salary should not be empty")
    @Column(columnDefinition = "int not null")
    private Integer salary;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "employee")
    private Set<Reports> reports;


}
