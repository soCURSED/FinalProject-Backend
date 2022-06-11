//package com.example.finalproject.Controller;
//
//import com.example.finalproject.Model.Product;
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.PropertyNamingStrategy;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
///*
//site: https://api.bestbuy.com/v1/products?apiKey=qhqws47nyvgze2mq3qx4jadt
//api link: https://api.bestbuy.com/v1/products(categoryPath.id=abcat0501000)?apiKey=qhqws47nyvgze2mq3qx4jadt&sort=name.asc&show=name,customerReviewAverage,color,type&facet=name&pageSize=40&format=json
//
//gpu search:
//https://api.bestbuy.com/v1/products(search=graphic&search=card)?apiKey=qhqws47nyvgze2mq3qx4jadt&format=json
//
//monitor:
//https://api.bestbuy.com/v1/products(search=monitor)?apiKey=qhqws47nyvgze2mq3qx4jadt&format=json
//*/
//
//
//@RestController
//public class ProductController_API {
//
//public static final String monitro = "https://api.bestbuy.com/v1/products(search=monitor)?apiKey=qhqws47nyvgze2mq3qx4jadt&show=name,upc,regularPrice,manufacturer,type,sku,categoryPath.id&format=json";
//
//    @GetMapping("/Test")
//    public ResponseEntity getInfo() throws JsonProcessingException {
//
//        //the api URL call
//        String url = "https://api.bestbuy.com/v1/products(search=graphic&search=card)?apiKey=qhqws47nyvgze2mq3qx4jadt&format=json";
//
//        //getting the json string from the url
//        WebClient webClient = WebClient.create(url);
//        Mono<String> body = webClient.get().retrieve().bodyToMono(String.class);
//        String resultJsonAsString = body.block();
//
//        //mapping the json string to java object
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // disable not found
//        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
//
//
//        Product product = objectMapper.readValue(resultJsonAsString, Product.class);
//
//        System.out.println(product.getName());
//        String allproduct = product.getName();
//        System.out.println(allproduct);
//        ObjectMapper objectMapper2 = new ObjectMapper();
//        objectMapper2.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES); // disable not found
//        objectMapper2.setPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CAMEL_CASE);
//        product = objectMapper2.readValue(resultJsonAsString, Product.class);
//
//
//        //check the object
//        System.out.println("****************************************************");
//        System.out.println(product.toString());
//        System.out.println("****************************************************");
//        return ResponseEntity.status(201).body("done");
//    }
//}
