package com.myshaveden.viewmodels;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = AppUserModel.Builder.class)
public class AppUserModel {
  private final String email;
  private final String username;
  private final String id;
  private final WishlistModel wishlist;

  private AppUserModel(String email, String username, String id, WishlistModel wishlist) {
    this.email = email;
    this.username = username;
    this.id = id;
    this.wishlist = wishlist;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private String email;
    private String username;
    private String id;
    private WishlistModel wishlist;

    public Builder withEmail(String email) {
      this.email = email;
      return this;
    }

    public Builder withUsername(String username) {
      this.username = username;
      return this;
    }

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public Builder withWishlist(WishlistModel wishlist) {
      this.wishlist = wishlist;
      return this;
    }

    public AppUserModel build() {
      return new AppUserModel(email, username, id, wishlist);
    }
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public String getId() {
    return id;
  }

  public WishlistModel getWishlist() {
    return wishlist;
  }
}
