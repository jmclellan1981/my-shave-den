package com.myshaveden.services;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

public class JwtTokenProviderTest {
  private JwtTokenProvider provider = new JwtTokenProvider();
  private final String MOCK_USERNAME = "MOCK_USERNAME";

  @BeforeEach
  public void setup() {
    provider.jwtSecret = "SECRET";
    provider.jwtExpirationInMs = 604800000;
  }

  @Test
  public void testGenerateToken() {
    Authentication authentication = Mockito.mock(Authentication.class);
    User user = Mockito.mock(User.class);
    Mockito.when(user.getUsername()).thenReturn(MOCK_USERNAME);
    Mockito.when(authentication.getPrincipal()).thenReturn(user);
    String result = provider.generateToken(authentication);
    assertNotNull(result);
  }
}
