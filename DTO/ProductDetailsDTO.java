package com.example.capstone3.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDetailsDTO {
    @NotNull(message = "product id should not be empty")
    private Integer product_id;
    @NotNull(message = "quantity should not be empty")
    private Integer quantity;
}
