package com.example.finalproject.DTO;

import lombok.*;

import javax.validation.Valid;


@AllArgsConstructor
@NoArgsConstructor
@Data @Valid
public class ProductDTO {
    private Integer productID;
    private String ProductName;
    private Integer ProductPrice;
    private String ProductType;
}

