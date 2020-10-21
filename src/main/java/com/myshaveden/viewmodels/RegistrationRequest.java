package com.myshaveden.viewmodels;

public class RegistrationRequest {
  private final String email;
  private final String password;
  private final String username;

  private RegistrationRequest(String email, String password, String username) {
    this.email = email;
    this.password = password;
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getUsername() {
    return username;
  }

  public static class Builder {
    private String email;
    private String password;
    private String username;

    public Builder withEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder withPassword(String password) {
      this.password = password;
      return this;
    }

    public Builder withUsername(String username) {
      this.username = username;
      return this;
    }

    public RegistrationRequest build() {
      return new RegistrationRequest(email, password, username);
    }
  }
}
