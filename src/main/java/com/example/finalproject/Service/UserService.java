package com.example.finalproject.Service;

import com.example.finalproject.DTO.CartDTO;
import com.example.finalproject.DTO.ProductDTO;
import com.example.finalproject.ExpectError.InvalidIDException;
import com.example.finalproject.Model.Cart;
import com.example.finalproject.Model.Product;
import com.example.finalproject.Model.User;
import com.example.finalproject.Repositry.CartRepo;
import com.example.finalproject.Repositry.ProductRepo;
import com.example.finalproject.Repositry.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {


    private final CartRepo cartRepo;
    private final UserRepo userRepo;

    private final ProductRepo productRepo;
//    private final UserService userService;



    public List<User> getAllUser() {
        return userRepo.findAll();
    }
    public List<User> getAllUserAdmin() {
        return userRepo.findAll();
    }

    public User getUserById(Integer userId) {
        Optional<User> target_User_Id = userRepo.findById(userId);
        if (target_User_Id.isEmpty()) {
            throw new InvalidIDException("Invalid User ID!");

        }
        return target_User_Id.get();
    }


    public void addUser(User user) {
        String hashedPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setUserPassword(hashedPassword);
        userRepo.save(user);
    }




    public User updateUser(Integer userId, User user) {
        Optional<User> target_userId = userRepo.findById(userId);
        if (target_userId.isEmpty()) {
            throw new InvalidIDException("Invalid User ID!");
        }

        User oldUser = userRepo.findById(userId).get();
        oldUser.setUserAddress(user.getUserAddress());
        oldUser.setUserEmail(user.getUserEmail());
        oldUser.setUserBalance(user.getUserBalance());
        oldUser.setUserPassword(user.getUserPassword());
        oldUser.setUserRole(user.getUserRole());
        oldUser.setUserPhone(user.getUserPhone());
        oldUser.setUsername(user.getUsername());
        return userRepo.save(oldUser);
    }

    public void deleteUser(Integer userId) {
        Optional<User> deleteUser = userRepo.findById(userId);
        if (deleteUser.isEmpty()) {
            throw new InvalidIDException("Invalid User ID!");

        }
        userRepo.deleteById(userId);
    }

    public Object addCartToUser(CartDTO cartDTO) {
        User user = userRepo.findById(cartDTO.getCartID()).orElseThrow(() -> new InvalidIDException("user id is invalid"));
        Cart cart = new Cart(null, cartDTO.getPaymentMethod(), user);
        cartRepo.save(cart);
        userRepo.save(user);
        return userRepo.findAll();

    }

    public Object addProductToUser( ProductDTO productDTO) {
        User user = userRepo.findById(productDTO.getProductID()).get();
        Product product = new Product(null, productDTO.getProductName(), productDTO.getProductPrice(), productDTO.getProductType(), user);
        user.getProductSet().add(product);
        productRepo.save(product);
        return userRepo.findAll();

    }
//    public Object addProductToUser(@Lazy ProductDTO productDTO) {
//        User user = userRepo.findById(productDTO.getProductID()).get();
//        Product product = new Product(null, productDTO.getProductName(), productDTO.getProductPrice(), productDTO.getProductType(), user);
//        user.getProductSet().add(product);
//        productRepo.save(product);
//        return userRepo.findAll();
//
//    }


    public Integer LogIn(Integer userId) {
        User user = new User();
        User target_user = userRepo.findUserRoleByUserId(userId);
        if (target_user.getUserRole().equals(user.getRoleAdmin())) {
            return 0;
        }
             else if (target_user.getUserRole().equals(user.getRoleUser())) {
                return 1;
            }
           else if (target_user.getUserRole() == ""){
                return 2;

    }
        return -1;

    }

    }





