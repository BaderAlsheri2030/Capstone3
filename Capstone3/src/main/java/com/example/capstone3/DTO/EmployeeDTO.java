package com.example.capstone3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.IntToDoubleFunction;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    @NotNull
    private Integer company_id;
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
}
