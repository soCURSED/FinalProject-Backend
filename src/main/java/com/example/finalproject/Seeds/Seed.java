//package com.example.finalproject.Seeds;
//import com.example.finalproject.Model.Product;
//import com.example.finalproject.Model.User;
//import com.example.finalproject.Repositry.ProductRepo;
//import com.example.finalproject.Repositry.UserRepo;
//import lombok.RequiredArgsConstructor;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//@Component
//@RequiredArgsConstructor
//public class Seed implements CommandLineRunner {
//    Logger logger = LoggerFactory.getLogger(Seed.class);
//    private final ProductRepo productRepo;
//    private final UserRepo userRepo;
//    @Override
//    public void run(String... args) throws Exception {
//        loadData();
//    }
//    private void loadData() {
//        logger.info("starting load Product Data from Seed");
//        if (productRepo.count() == 0) {
//            for (int i = 1; i < 10; i++) {
//                Random rand = new Random();
//                int n = rand.nextInt(1000,2999);
//             Product product = new Product();
//                product.setProductName("Card #" + i);
//                product.setProductType("GPU");
//                product.setProductPrice(n);
//                productRepo.save(product);
//
//
//        }}}}
//
