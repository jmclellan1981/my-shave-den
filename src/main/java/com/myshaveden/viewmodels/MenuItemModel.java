package com.myshaveden.viewmodels;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = MenuItemModel.Builder.class)
public class MenuItemModel {
  private final String title;
  private final String action;
  private final String path;

  private MenuItemModel(String title, String action, String path) {
    this.title = title;
    this.action = action;
    this.path = path;
  }

  public String getTitle() {
    return title;
  }

  public String getAction() {
    return action;
  }

  public String getPath() {
    return path;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private String title;
    private String action;
    private String path;

    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    public Builder withAction(String action) {
      this.action = action;
      return this;
    }

    public Builder withPath(String path) {
      this.path = path;
      return this;
    }

    public MenuItemModel build() {
      return new MenuItemModel(title, action, path);
    }
  }
}
