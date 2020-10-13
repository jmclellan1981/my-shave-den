package com.myshaveden.viewmodels;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableAppUserModel.class)
@JsonDeserialize(as = ImmutableAppUserModel.class)
public abstract class AppUserModel {
  public abstract String email();

  public abstract String username();

  public abstract String id();

  public abstract WishlistModel wishlist();
}
