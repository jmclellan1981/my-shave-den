package com.myshaveden.viewmodels;

import org.immutables.value.Value;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableProductModel.class)
@JsonDeserialize(as = ImmutableProductModel.class)
public abstract class ProductModel {
  public abstract String id();

  public abstract String url();

  public abstract String imageSource();

  public abstract String productId();

  public abstract String productType();

  public abstract String site();

  public abstract String title();

  public abstract String description();
}
