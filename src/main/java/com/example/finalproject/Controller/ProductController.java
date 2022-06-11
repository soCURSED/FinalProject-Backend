package com.example.finalproject.Controller;

import com.example.finalproject.Model.Product;
import com.example.finalproject.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    Logger logs = LoggerFactory.getLogger(ProductController.class);


    //get all product
    @GetMapping
    public ResponseEntity getAllProduct() {

        logs.info(">> getAllProduct << in |ProductController| Has been used. All Products have been displayed!");
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProduct());

    }

    //get a product by ID
    @GetMapping("/{productId}")
    public ResponseEntity getProductById(@PathVariable Integer productId) {
        logs.info(">> getProductById << in |ProductController| Has been used. A Products by ID has been displayed!");

        return ResponseEntity.status(HttpStatus.OK).body(productService.getByProductId(productId));

    }


    //update a product by id
    @PutMapping("/update/{productId}")
    public ResponseEntity updateProduct(@PathVariable Integer productId, @RequestBody Product product) {
        logs.info(">> updateProduct << in |ProductController| Has been used. A product has been Updated!");
        productService.updateProduct(productId, product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The Product has been Updated!");
    }


    //delete a product by id
    @DeleteMapping("/delete/{productId}")
    public ResponseEntity deleteProduct(@PathVariable Integer productId) {
        logs.info(">> deleteProduct << in |ProductController| Has been used. A product has been Deleted!");
        productService.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("The Product has been Deleted!");
    }

}
