package com.Inv.InventoryMgtSystem.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDTO {

    private Long id;
    private String name;
    private String sku;
    private Double price;
    private Integer stockQuantity;
    private String description;
    private LocalDateTime expiryDate;
    private String imageUrl;
    private LocalDateTime createdAt;

    // Simplified Category information
    private Long categoryId;
    private Long productId;
    private Long supplierId;
}