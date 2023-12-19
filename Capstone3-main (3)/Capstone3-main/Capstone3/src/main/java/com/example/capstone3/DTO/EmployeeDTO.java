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
    private String firstName;
    @NotEmpty
    private String lastName;
    @Email
    @NotEmpty
    private String email;
    @NotEmpty
    private String phone;
    @NotEmpty
    private String Position;
    @NotNull
    private Integer salary;

}
