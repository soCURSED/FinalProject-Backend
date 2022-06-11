package com.example.finalproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Valid
@Entity
public class Cart {

    @Id
    private Integer CartId;
    @NotEmpty(message = "name is required")
    @Pattern(regexp = "(Cash|Credit Card)", message = "Payment method most be Cash or Credit Card")
    private String paymentMethod;


    public Cart(Integer cartID, String PaymentMethod, User user) {
        CartId = cartID;
        this.paymentMethod = PaymentMethod;
        this.user = user;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;


    @OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
    private Set<Product> productSet = new HashSet<>();


}
