package com.myshaveden.viewmodels;

import java.util.List;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableWishlistModel.class)
@JsonDeserialize(as = ImmutableWishlistModel.class)
public abstract class WishlistModel {
  public abstract List<WishlistItemModel> wishlistItems();

}
