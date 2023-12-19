package com.example.capstone3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.IntToDoubleFunction;

@Data
@AllArgsConstructor
public class EmployeeDTO {
    @NotNull
    private Integer company_id;
    @NotEmpty(message = "First name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;
    @NotEmpty(message = "Last name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;
    @Email(message = "Enter valid email")
    @NotEmpty(message = "Email should not be empty")
    private String email;
    @NotEmpty (message = "phone should not be empty")
    private String phone;
    @NotEmpty(message = "Position should not be empty")
    private String Position;
    @NotNull(message = "salary should not be empty")
    private Integer salary;

}
