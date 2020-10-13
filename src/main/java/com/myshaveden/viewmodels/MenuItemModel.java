package com.myshaveden.viewmodels;

import org.immutables.value.Value;
import org.springframework.lang.Nullable;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Value.Immutable
@JsonSerialize(as = ImmutableMenuItemModel.class)
@JsonDeserialize(as = ImmutableMenuItemModel.class)
public abstract class MenuItemModel {
  public abstract String title();

  @Nullable
  public abstract String action();

  public abstract String path();
}
