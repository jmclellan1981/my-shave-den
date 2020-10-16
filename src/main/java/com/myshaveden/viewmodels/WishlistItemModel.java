package com.myshaveden.viewmodels;

public class WishlistItemModel {
  private ProductModel productModel;
  private Integer displayOrder;

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public ProductModel getProductModel() {
    return productModel;
  }

  public void setProductModel(ProductModel productModel) {
    this.productModel = productModel;
  }

  public void setDisplayOrder(Integer displayOrder) {
    this.displayOrder = displayOrder;
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
