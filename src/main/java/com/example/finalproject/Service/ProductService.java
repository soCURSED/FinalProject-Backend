package com.example.finalproject.Service;

import com.example.finalproject.ExpectError.InvalidIDException;
import com.example.finalproject.Model.Product;
import com.example.finalproject.Repositry.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> getAllProduct() {
        return productRepo.findAll();


    }

    public Product getByProductId(Integer productId) {
        Optional<Product> target_Product_Id = productRepo.findById(productId);
        if (target_Product_Id.isEmpty()) {
            throw new InvalidIDException("Invalid Product ID!");

        }
        return target_Product_Id.get();
    }


    public void addProduct(Product product) {
        productRepo.save(product);

    }

    public Product updateProduct(Integer productId, Product product) {
        Optional<Product> target_productId = productRepo.findById(productId);
        if (target_productId.isEmpty()) {
            throw new InvalidIDException("Invalid Product ID!");
        }

        Product oldProduct = productRepo.findById(productId).get();
        oldProduct.setProductName(product.getProductName());
        oldProduct.setProductPrice(product.getProductPrice());
        oldProduct.setProductType(product.getProductType());
        return productRepo.save(oldProduct);
    }

    public void deleteProduct(Integer productId) {
        Optional<Product> delteProduct = productRepo.findById(productId);
        if (delteProduct.isEmpty()) {
            throw new InvalidIDException("Invalid Product ID!");

        }
        productRepo.deleteById(productId);
    }

    public List<Product> listStock() {
return null;

    }
}
