package com.myshaveden.viewmodels;

public class AppUserModel {
  private String email;
  private String username;
  private String id;
  private WishlistModel wishlist;
  public static Builder builder;

  private AppUserModel() {

  }

  public static class Builder {
    AppUserModel model = new AppUserModel();

    public Builder withEmail(String email) {
      model.email = email;
      return this;
    }

    public Builder withUsername(String username) {
      model.username = username;
      return this;
    }

    public Builder withId(String id) {
      model.id = id;
      return this;
    }

    public Builder withWishlist(WishlistModel wishlist) {
      model.wishlist = wishlist;
      return this;
    }

    public AppUserModel build() {
      return model;
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
