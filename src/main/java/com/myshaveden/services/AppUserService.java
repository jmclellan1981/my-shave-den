package com.myshaveden.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myshaveden.viewmodels.AppUserModel;
import com.myshaveden.viewmodels.RegistrationRequest;

public interface AppUserService extends UserDetailsService {

  // public UserDetails findUserByUsername(String username);

  public AppUserModel registerUser(RegistrationRequest registrationRequest);

  public Boolean validateUserEmail(String email);

  public Boolean validateUsername(String username);
}
