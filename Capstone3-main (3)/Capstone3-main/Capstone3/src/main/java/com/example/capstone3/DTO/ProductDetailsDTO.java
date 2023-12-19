package com.example.capstone3.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ProductDetailsDTO {
    @NotNull
    private Integer product_id;
    @NotNull
    private Integer quantity;
}
