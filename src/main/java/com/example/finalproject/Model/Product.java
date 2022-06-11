package com.example.finalproject.Model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.persistence.Entity;
import javax.persistence.Id;



@Data
@NoArgsConstructor
@Valid
@Entity

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

//    @NotEmpty(message = "productName most not be empty")
    private String productName;

//    @NotNull(message = "productPrice most not be empty")
    @Positive(message = "Price can only be positive")
    private Integer productPrice;

//    @NotEmpty(message = "productType most not be empty")
    @Pattern(regexp = "(GPU|CPU|CASE|MB|MOUSE|KEYBOARD|MONITOR)", message = "Type can only be GPU|CPU|CASE|MB|MOUSE|KEYBOARD|MONITOR")
    private String productType;

    public Product(Integer productID, String ProductName, Integer ProductPrice,String ProductType,User user) {

        this.productId = productID;
        this.productName = ProductName;
        this.productPrice = ProductPrice;
        this.productType = ProductType;
        this.user = user;
    }

    //    @ManyToOne(cascade = CascadeType.ALL)
//    @MapsId
//    @JoinColumn(name = "user_id")
//    @JsonIgnore
//    private User user;
@ManyToOne(cascade = CascadeType.ALL)
@JsonIgnore
private User user;



}
