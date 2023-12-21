package com.example.capstone3.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDTO {

    @NotNull(message = "company id should not be empty")
    private Integer company_id;
    private Integer discounts;
    @NotEmpty(message = "address should not be empty")
    private String address;
    @Email(message = "Enter valid email ")
    @NotEmpty(message = "Email should not be empty")
    private String email;
    @NotEmpty(message = "name should not be empty")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @NotEmpty (message = "Last Name should not be empty")
    @Pattern(regexp = "^05\\d{8}$", message = "Invalid phone number format")
    private String phone;
    @NotEmpty(message = "name should not be empty")
    private String role;




}
