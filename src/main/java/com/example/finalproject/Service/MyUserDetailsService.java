package com.example.finalproject.Service;

import com.example.finalproject.Model.User;
import com.example.finalproject.Repositry.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
private final UserRepo userRepo;

@Override
    public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException{
    User user = userRepo.findUserByUsername(username);
            if (username.isEmpty()){
               throw new  UsernameNotFoundException("Wrong username or password");
            }
    return user;
}


}
