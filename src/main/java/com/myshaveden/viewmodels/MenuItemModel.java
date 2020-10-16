package com.myshaveden.viewmodels;

public class MenuItemModel {
  private String title;
  private String action;
  private String path;

  private MenuItemModel() {

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

  public static class Builder {
    private MenuItemModel model = new MenuItemModel();

    public Builder withTitle(String title) {
      model.title = title;
      return this;
    }

    public Builder withAction(String action) {
      model.action = action;
      return this;
    }

    public Builder withPath(String path) {
      model.path = path;
      return this;
    }

    public MenuItemModel build() {
      return model;
    }
  }
}
