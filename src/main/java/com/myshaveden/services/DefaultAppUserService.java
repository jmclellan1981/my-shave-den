package com.myshaveden.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myshaveden.domain.AppUser;
import com.myshaveden.domain.Wishlist;
import com.myshaveden.repositories.AppUserRepository;
import com.myshaveden.viewmodels.AppUserModel;
import com.myshaveden.viewmodels.RegistrationRequest;
import com.myshaveden.viewmodels.WishlistModel;

@Service
public class DefaultAppUserService implements AppUserService {

  private AppUserRepository userRepository;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public DefaultAppUserService(AppUserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public AppUserModel registerUser(RegistrationRequest registrationRequest) {
    AppUser newUser = new AppUser();
    newUser.setEmail(registrationRequest.getEmail());
    newUser.setUsername(registrationRequest.getUsername());
    newUser.setWishlist(new Wishlist());
    newUser.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
    newUser = userRepository.save(newUser);
    AppUserModel viewModel = new AppUserModel.Builder().withEmail(newUser.getEmail())
        .withUsername(newUser.getUsername()).withWishlist(new WishlistModel.Builder().build())
        .withId(newUser.getId().toString()).build();
    return viewModel;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    AppUser user = userRepository.findByUsername(username);
    boolean enabled = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    UserDetails userDetails = new User(user.getUsername(), user.getPassword(), enabled, accountNonExpired,
        credentialsNonExpired, accountNonLocked, new ArrayList<GrantedAuthority>());
    return userDetails;
  }

  @Override
  public Boolean validateUserEmail(String email) {
    return userRepository.findByEmail(email) == null;
  }

  @Override
  public Boolean validateUsername(String username) {
    return userRepository.findByUsername(username) == null;
  }

}
