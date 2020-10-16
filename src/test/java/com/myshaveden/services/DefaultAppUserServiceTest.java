package com.myshaveden.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myshaveden.domain.AppUser;
import com.myshaveden.domain.Wishlist;
import com.myshaveden.repositories.AppUserRepository;
import com.myshaveden.viewmodels.AppUserModel;
import com.myshaveden.viewmodels.RegistrationRequest;
import com.myshaveden.viewmodels.WishlistModel;

public class DefaultAppUserServiceTest {
  private DefaultAppUserService service;
  private AppUser appUser = Mockito.mock(AppUser.class);
  private AppUserModel appUserViewModel = Mockito.mock(AppUserModel.class);
  private PasswordEncoder passwordEncoder = Mockito.mock(PasswordEncoder.class);
  private RegistrationRequest registrationRequest = Mockito.mock(RegistrationRequest.class);
  private final String MOCK_EMAIL = "MOCK_EMAIL";
  private final String MOCK_PASSWORD = "MOCK_PASSWORD";
  private final String MOCK_USERNAME = "MOCK_USERNAME";
  private final String VALID_USERNAME = "VALID_USERNAME";
  private final String VALID_EMAIL = "VALID_EMAIL";
  private final String INVALID_USERNAME = "INVALID_USERNAME";
  private final String INVALID_EMAIL = "INVALID_EMAIL";

  @BeforeEach
  public void setup() {
    AppUserRepository userRepository = getMockUserRepository();
    Mockito.when(registrationRequest.getEmail()).thenReturn(MOCK_EMAIL);
    Mockito.when(registrationRequest.getPassword()).thenReturn(MOCK_PASSWORD);
    Mockito.when(registrationRequest.getUsername()).thenReturn(MOCK_USERNAME);
    Mockito.when(appUser.getEmail()).thenReturn(MOCK_EMAIL);
    Mockito.when(appUser.getPassword()).thenReturn(MOCK_PASSWORD);
    Mockito.when(appUser.getUsername()).thenReturn(MOCK_USERNAME);
    Mockito.when(appUser.getWishlist()).thenReturn(Mockito.mock(Wishlist.class));
    Mockito.when(appUser.getId()).thenReturn(UUID.randomUUID());
    Mockito.when(appUserViewModel.getEmail()).thenReturn(MOCK_EMAIL);
    Mockito.when(appUserViewModel.getUsername()).thenReturn(MOCK_USERNAME);
    Mockito.when(appUserViewModel.getWishlist()).thenReturn(Mockito.mock(WishlistModel.class));
    service = new DefaultAppUserService(userRepository, passwordEncoder);

  }

  @Test
  public void testRegisterUser() {
    AppUserModel result = service.registerUser(registrationRequest);
    assertNotNull(result);
    assertEquals(MOCK_EMAIL, result.getEmail());
    assertEquals(MOCK_USERNAME, result.getUsername());
    assertNotNull(result.getWishlist());
  }

  @Test
  public void testLoadUserByUsername() {
    UserDetails userDetails = service.loadUserByUsername(MOCK_USERNAME);
    assertNotNull(userDetails);
    assertEquals(MOCK_USERNAME, userDetails.getUsername());
  }

  @Test
  public void testValidateUserEmail_valid() {
    boolean result = service.validateUserEmail(VALID_EMAIL);
    assertTrue(result);
  }

  @Test
  public void testValidateUserEmail_invalid() {
    boolean result = service.validateUserEmail(INVALID_EMAIL);
    assertFalse(result);
  }

  @Test
  public void testValidateUsername_valid() {
    boolean result = service.validateUsername(VALID_USERNAME);
    assertTrue(result);
  }

  @Test
  public void testValidateUsername_invalid() {
    boolean result = service.validateUsername(INVALID_USERNAME);
    assertFalse(result);
  }

  private AppUserRepository getMockUserRepository() {
    AppUserRepository userRepository = Mockito.mock(AppUserRepository.class);
    Mockito.when(userRepository.findByUsername(Mockito.matches(VALID_USERNAME))).thenReturn(null);
    Mockito.when(userRepository.findByUsername(Mockito.matches(INVALID_USERNAME))).thenReturn(appUser);
    Mockito.when(userRepository.findByUsername(Mockito.matches(MOCK_USERNAME))).thenReturn(appUser);
    Mockito.when(userRepository.findByEmail(Mockito.matches(VALID_EMAIL))).thenReturn(null);
    Mockito.when(userRepository.findByEmail(Mockito.matches(INVALID_EMAIL))).thenReturn(appUser);
    Mockito.when(userRepository.save(Mockito.any(AppUser.class))).thenReturn(appUser);

    return userRepository;
  }
}
