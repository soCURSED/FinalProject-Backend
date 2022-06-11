package com.example.finalproject.Controller;


import com.example.finalproject.Model.Cart;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;
    Logger logs = LoggerFactory.getLogger(CartController.class);


    //get cart
    @GetMapping
    public ResponseEntity getCart() {

        logs.info(">> getCart << in |CartController| Has been used. Your Cart items have been displayed!");
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getCart());

    }

    //get cart by id
    @GetMapping("{cartId}")
    public ResponseEntity getCartById(@PathVariable Integer cartId) {

        logs.info(">> getCartById << in |CartController| Has been used. Your Cart have been displayed!");
        return ResponseEntity.status(HttpStatus.OK).body(cartService.getCartById(cartId));

    }




    //update cart by id
    @PutMapping("/update/{cartid}")
    public ResponseEntity updateCart(@PathVariable Integer cartid, @RequestBody Cart cart) {
        logs.info(">> updateCart << in |CartController| Has been used. The cart has been Updated!");
        cartService.updateCart(cartid, cart);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The cart has been Updated!");
    }

    //delete cart by id
    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity deleteCart(@PathVariable Integer cartId) {
        logs.info(">> delete << in |CartController| Has been used. Your Cart is deleted!");
        cartService.deleteCart(cartId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Removing items..... Your Cart is empty!");
    }


}
