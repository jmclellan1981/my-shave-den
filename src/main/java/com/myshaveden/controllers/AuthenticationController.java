package com.myshaveden.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshaveden.services.AppUserService;
import com.myshaveden.services.JwtTokenProvider;
import com.myshaveden.viewmodels.AppUserModel;
import com.myshaveden.viewmodels.JwtAuthResponse;
import com.myshaveden.viewmodels.RegistrationRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
  private AppUserService userService;
  private AuthenticationManager authenticationManager;
  private JwtTokenProvider tokenProvider;

  @Autowired
  public AuthenticationController(AppUserService userService, AuthenticationManager authenticationManager,
      JwtTokenProvider jwtTokenProvider) {
    this.userService = userService;
    this.authenticationManager = authenticationManager;
    this.tokenProvider = jwtTokenProvider;
  }

  @PostMapping("/register")
  public ResponseEntity<AppUserModel> registerUser(@RequestBody RegistrationRequest registrationRequest)
      throws URISyntaxException {
    AppUserModel newUser = userService.registerUser(registrationRequest);
    return ResponseEntity.created(new URI("/" + newUser.id())).body(newUser);
  }

  @PostMapping("/login")
  public ResponseEntity<JwtAuthResponse> signinUser(@RequestBody RegistrationRequest request) {
    Authentication authentication = authenticationManager
        .authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthResponse(jwt));
  }

  @GetMapping("validate/email/{email}")
  public ResponseEntity<Boolean> validateUserEmail(@PathVariable("email") String email) {
    Boolean isValid = userService.validateUserEmail(email);
    return ResponseEntity.ok(isValid);
  }

  @GetMapping("validate/username/{username}")
  public ResponseEntity<Boolean> validateUsername(@PathVariable("username") String username) {
    Boolean isValid = userService.validateUsername(username);
    return ResponseEntity.ok(isValid);
  }
}
