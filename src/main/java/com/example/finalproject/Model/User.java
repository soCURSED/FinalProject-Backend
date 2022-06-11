package com.example.finalproject.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.*;


@Getter @Setter
@NoArgsConstructor
@Valid
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = "userName most not be empty")
    @Length(min = 6, max = 20, message = "userName must be between 6 and 20 length range")
    private String username;

    @NotEmpty(message = "userPassword most not be empty")
    private String userPassword;

    @Email(message = "Email most be in Email formate")
    @NotEmpty(message = "userEmail most not be empty")
    private String userEmail;

    @NotNull(message = "userBalance most not be empty")
    @Positive(message = "userBalance Only positive!")
    private Integer userBalance;

    @NotEmpty(message = "Role most not be empty")
    @Pattern(regexp = "(ADMIN|USER)", message = "Only Role (ADMIN|USER)")
    private String userRole;

    @NotEmpty(message = "userAddress most not be empty")
    private String userAddress;

    @Pattern(regexp = "^(009665|9665|/+9665|05|5)[013456789][0-9]{7}$", message = "invalid phone Number")
    private String userPhone;


    private String RoleAdmin = "ADMIN";
    private String RoleUser = "USER";

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(this.getUserRole()));
    }

    @Override
    public String getPassword() {
        return userPassword;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


@OneToMany(mappedBy = "user",cascade=CascadeType.ALL)
private Set<Product> productSet = new HashSet<>();





    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Cart cart;

}