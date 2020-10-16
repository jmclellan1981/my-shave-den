package com.myshaveden.viewmodels;

import java.util.ArrayList;
import java.util.List;

public class WishlistModel {
  private List<WishlistItemModel> wishlistItems = new ArrayList<>();

  private WishlistModel() {
  }

  public List<WishlistItemModel> getWishlistItems() {
    return wishlistItems;
  }

  public static class Builder {
    WishlistModel model = new WishlistModel();

    public Builder withWishlistItems(List<WishlistItemModel> wishlistItems) {
      model.wishlistItems = wishlistItems;
      return this;
    }

    public WishlistModel build() {
      return model;
    }
  }

}
