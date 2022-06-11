package com.example.finalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;

@AllArgsConstructor
@NoArgsConstructor
@Data @Valid
public class CartDTO {
    private Integer cartID;
    private String PaymentMethod;
}
