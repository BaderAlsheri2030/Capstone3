package com.example.capstone3.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InvoiceDTO {
    @NotNull
    private Integer customer_id;
    @NotNull
    private List<ProductDetailsDTO> productDetailDTO;
    @NotNull
    private double totalPrice;

}
