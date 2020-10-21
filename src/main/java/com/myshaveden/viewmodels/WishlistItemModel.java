package com.myshaveden.viewmodels;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WishlistItemModel.Builder.class)
public class WishlistItemModel {
  private final ProductModel productModel;
  private final Integer displayOrder;

  private WishlistItemModel(ProductModel productModel, Integer displayOrder) {
    this.productModel = productModel;
    this.displayOrder = displayOrder;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public ProductModel getProductModel() {
    return productModel;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private ProductModel productModel;
    private Integer displayOrder;

    public Builder withDisplayOrder(int displayOrder) {
      this.displayOrder = displayOrder;
      return this;
    }

    public Builder withProduct(ProductModel product) {
      this.productModel = product;
      return this;
    }

    public WishlistItemModel build() {
      return new WishlistItemModel(productModel, displayOrder);
    }
  }
}
