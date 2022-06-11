package com.example.finalproject.Controller;

import com.example.finalproject.DTO.API;
import com.example.finalproject.DTO.CartDTO;
import com.example.finalproject.DTO.ProductDTO;
import com.example.finalproject.Model.User;
import com.example.finalproject.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    Logger logs = LoggerFactory.getLogger(UserController.class);



    //get all users
    @GetMapping
    public ResponseEntity getAllUser() {

        logs.info(">> getAllUsers << in |UserController| Has been used. All Users have been displayed!");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUser());

    }

    //get a user by ID
    @GetMapping("/{userId}")
    public ResponseEntity getUserById(@PathVariable Integer userId) {
        logs.info(">> getUserById << in |UserController| Has been used. A User by ID has been displayed!");

        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(userId));

    }

    // Register/Add user
    @PostMapping("/register")
    public ResponseEntity Register(@RequestBody @Valid User user, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("A User ID: " + user.getUserId() + " has been Added!");
    }


    //update a user
    @PutMapping("/update/{userId}")
    public ResponseEntity updateUser(@PathVariable Integer userId, @RequestBody User user) {
        logs.info(">> updateUser << in |UserController| Has been used. The User has been Updated!");
        userService.updateUser(userId, user);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The User has been Updated!");
    }


    //delete a user
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity deleteUser(@PathVariable Integer userId) {
        logs.info(">> deleteUser << in |UserController| Has been used. A product has been Deleted!");
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The User has been Deleted!");
    }

// create cart for user
    @PutMapping("/cart")
    public ResponseEntity addCartToUser(@RequestBody CartDTO cartDTO) {
        logs.info(">> addCartToUser << in |UserController| Has been used. Cart has been Added!");
        userService.addCartToUser(cartDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Cart ID: ("+cartDTO.getCartID()+"), Payment Method: ("+cartDTO.getPaymentMethod()+") has been added to User!");

    }

    // add product to user and cart
    @PostMapping("/product")
    public ResponseEntity addProductToUser(@RequestBody ProductDTO productDTO) {
        logs.info(">> addProductToUser << in |UserController| Has been used. Cart has been Added!");
        userService.addProductToUser(productDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Product ID: ("+productDTO.getProductID()+"), has been added to User!");
    }


// Login Auth if admin or user
    @GetMapping("/login/{userId}")
    public ResponseEntity login(@PathVariable Integer userId) {
        logs.info(">> login << in |UserController| Has been used. Login!");

        User user = new User();
        Integer RoleCase = userService.LogIn(userId);
        switch (RoleCase) {
            case -1:
                return ResponseEntity.status(400).body(new API("You are not ADMIN OR USER",200));
            case 0:
                return ResponseEntity.status(200).body(new API("Hello ADMIN ",200));
            case 1:
                return ResponseEntity.status(200).body(new API("Hello USER",200));
            case 2:
                return ResponseEntity.status(200).body(new API("Hello NoOne",200));
            default:
                return ResponseEntity.status(400).body(new API("default",400));
        }
    }



}
