package com.myshaveden.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.myshaveden.services.AppUserService;
import com.myshaveden.services.JwtTokenProvider;
import com.myshaveden.viewmodels.AppUserModel;
import com.myshaveden.viewmodels.ImmutableAppUserModel;
import com.myshaveden.viewmodels.ImmutableWishlistModel;
import com.myshaveden.viewmodels.JwtAuthResponse;
import com.myshaveden.viewmodels.RegistrationRequest;
import com.myshaveden.viewmodels.WishlistItemModel;

public class AuthenticationControllerTest {
  private AuthenticationController controller;
  private final String MOCK_USERNAME = "MOCK_USERNAME";
  private final String MOCK_PASSWORD = "MOCK_PASSWORD";
  private final String MOCK_EMAIL = "MOCK_EMAIL";
  private final UUID MOCK_ID = UUID.randomUUID();
  private final String INVALID_USERNAME = "INVALID_USERNAME";
  private final String INVALID_EMAIL = "INVALID_EMAIL";

  @BeforeEach
  public void setup() {
    AppUserService userService = getMockUserService();
    AuthenticationManager authenticationManager = getMockAuthenticationManager();
    JwtTokenProvider jwtTokenProvider = getMockJwtTokenProvider();
    controller = new AuthenticationController(userService, authenticationManager, jwtTokenProvider);
  }

  @Test
  public void testValidateUserEmail_invalid() {
    ResponseEntity<Boolean> result = controller.validateUserEmail(INVALID_EMAIL);
    assertNotNull(result);
    assertFalse(result.getBody());
  }

  @Test
  public void testValidateUserEmail_valid() {
    ResponseEntity<Boolean> result = controller.validateUserEmail(MOCK_EMAIL);
    assertNotNull(result);
    assertTrue(result.getBody());
  }

  @Test
  public void testValidateUsername_invalid() {
    ResponseEntity<Boolean> result = controller.validateUsername(INVALID_USERNAME);
    assertNotNull(result);
    assertFalse(result.getBody());
  }

  @Test
  public void testValidateUsername_valid() {
    ResponseEntity<Boolean> result = controller.validateUsername(MOCK_USERNAME);
    assertNotNull(result);
    assertTrue(result.getBody());
  }

  @Test
  public void testRegisterUser() throws URISyntaxException {
    RegistrationRequest registrationRequest = new RegistrationRequest();
    registrationRequest.setEmail(MOCK_EMAIL);
    registrationRequest.setPassword(MOCK_PASSWORD);
    registrationRequest.setUsername(MOCK_USERNAME);
    ResponseEntity<AppUserModel> response = controller.registerUser(registrationRequest);
    assertNotNull(response);
    assertEquals(201, response.getStatusCodeValue());
    AppUserModel responseViewModel = response.getBody();
    assertEquals(MOCK_USERNAME, responseViewModel.username());
    assertEquals(MOCK_EMAIL, responseViewModel.email());
  }

  @Test
  public void testSigninUser() {
    RegistrationRequest request = new RegistrationRequest();
    request.setEmail(MOCK_EMAIL);
    request.setPassword(MOCK_PASSWORD);
    request.setUsername(MOCK_USERNAME);
    ResponseEntity<JwtAuthResponse> response = controller.signinUser(request);
    assertNotNull(response);
  }

  private JwtTokenProvider getMockJwtTokenProvider() {
    JwtTokenProvider mock = Mockito.mock(JwtTokenProvider.class);
    return mock;
  }

  private AuthenticationManager getMockAuthenticationManager() {
    AuthenticationManager authenticationManager = new AuthenticationManager() {

      @Override
      public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = new User(MOCK_USERNAME, MOCK_PASSWORD, new ArrayList<GrantedAuthority>());
        Authentication auth = new Authentication() {
          private static final long serialVersionUID = 1L;

          @Override
          public String getName() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public Collection<? extends GrantedAuthority> getAuthorities() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public Object getCredentials() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public Object getDetails() {
            // TODO Auto-generated method stub
            return null;
          }

          @Override
          public Object getPrincipal() {
            return user;
          }

          @Override
          public boolean isAuthenticated() {
            // TODO Auto-generated method stub
            return true;
          }

          @Override
          public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
            // TODO Auto-generated method stub

          }

        };
        return auth;
      }

    };
    return authenticationManager;
  }

  private AppUserService getMockUserService() {
    return new AppUserService() {

      @Override
      public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username, MOCK_PASSWORD, null);
      }

      @Override
      public AppUserModel registerUser(RegistrationRequest registrationRequest) {
        AppUserModel model = ImmutableAppUserModel.builder().email(registrationRequest.getEmail())
            .username(registrationRequest.getUsername())
            .wishlist(ImmutableWishlistModel.builder().wishlistItems(new ArrayList<WishlistItemModel>()).build())
            .id(UUID.randomUUID().toString()).build();
        return model;
      }

      @Override
      public Boolean validateUserEmail(String email) {
        return MOCK_EMAIL.equals(email);
      }

      @Override
      public Boolean validateUsername(String username) {
        return MOCK_USERNAME.equals(username);
      }

    };
  }
}
