package com.example.capstone3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    @NotNull
    private Integer company_id;
    @Positive
    @Column(columnDefinition = " int")
    private Integer Discounts;
    @NotEmpty
    @Column(columnDefinition = "varchar (20) not null")
    private String address;
    @Email
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null unique")
    private String email;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private String firstName;
    @NotEmpty
    @Column(columnDefinition = "varchar(10) not null")
    private String lastName;
    @NotEmpty
    @Column(columnDefinition = "varchar (10) not null")
    private String phone;




}
