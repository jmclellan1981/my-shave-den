package com.myshaveden.viewmodels;

public class WishlistItemModel {
  private ProductModel productModel;
  private int displayOrder;

  private WishlistItemModel() {
  }

  public ProductModel getProduct() {
    return productModel;
  }

  public int getDisplayOrder() {
    return displayOrder;
  }

  public static class Builder {
    private WishlistItemModel model = new WishlistItemModel();

    public Builder withDisplayOrder(int displayOrder) {
      model.displayOrder = displayOrder;
      return this;
    }

    public Builder withProduct(ProductModel product) {
      model.productModel = product;
      return this;
    }

    public WishlistItemModel build() {
      return model;
    }
  }
}
