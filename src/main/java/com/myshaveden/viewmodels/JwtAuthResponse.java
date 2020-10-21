package com.myshaveden.viewmodels;

public class JwtAuthResponse {
  private final String accessToken;
  private final String tokenType = "Bearer";

  public JwtAuthResponse(String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public String getTokenType() {
    return tokenType;
  }
}
