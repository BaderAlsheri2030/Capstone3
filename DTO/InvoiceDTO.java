package com.example.capstone3.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InvoiceDTO {
    @NotNull(message = "customer id should not be empty")
    private Integer customer_id;
    @NotNull(message = "product Detail should not be empty")
    private List<ProductDetailsDTO> productDetailDTO;
    @NotNull
    private double totalPrice;

}
