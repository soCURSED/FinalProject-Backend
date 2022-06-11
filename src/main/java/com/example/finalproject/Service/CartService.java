package com.example.finalproject.Service;

import com.example.finalproject.ExpectError.InvalidIDException;
import com.example.finalproject.Model.Cart;
import com.example.finalproject.Model.Product;
import com.example.finalproject.Repositry.CartRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepo cartRepo;
    private final ProductService productService;

    public List<Cart> getCart() {
        return cartRepo.findAll();
    }


    public void addCart(Cart cart) {
        cartRepo.save(cart);
    }

    public Cart getCartById(Integer cartId) {
        Optional<Cart> target_Cart_Id = cartRepo.findById(cartId);
        if (target_Cart_Id.isEmpty()) {
            throw new InvalidIDException("Invalid User ID!");
        }
//        Product product = new Product();
//        productService.getByProductId(cartId);

        return target_Cart_Id.get();
    }

    public void deleteCart(Integer CartId) {

        cartRepo.deleteById(CartId);
    }

    public void updateCart(Integer cartId, Cart cart) {

            Optional<Cart> target_cartId = cartRepo.findById(cartId);
            if (target_cartId.isEmpty()) {
                throw new InvalidIDException("Invalid CART ID!");
            }

            Cart oldCart = cartRepo.findById(cartId).get();
        oldCart.setPaymentMethod(cart.getPaymentMethod());
            cartRepo.save(oldCart);
        }

    }

