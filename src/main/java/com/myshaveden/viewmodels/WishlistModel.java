package com.myshaveden.viewmodels;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WishlistModel.Builder.class)
public class WishlistModel {
  private final List<WishlistItemModel> wishlistItems;

  private WishlistModel(List<WishlistItemModel> wishlistItems) {
    this.wishlistItems = wishlistItems;
  }

  public List<WishlistItemModel> getWishlistItems() {
    return wishlistItems;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private List<WishlistItemModel> wishlistItems;

    public Builder withWishlistItems(List<WishlistItemModel> wishlistItems) {
      this.wishlistItems = wishlistItems;
      return this;
    }

    public WishlistModel build() {
      return new WishlistModel(wishlistItems);
    }
  }

}
