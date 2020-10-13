package com.myshaveden.viewmodels;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableWishlistItemModel.class)
@JsonDeserialize(as = ImmutableWishlistItemModel.class)
public abstract class WishlistItemModel {
  public abstract ProductModel product();

  public abstract int displayOrder();
}
