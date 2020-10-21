package com.myshaveden.viewmodels;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WishlistItemModel.Builder.class)
public class WishlistItemModel {
  private final ProductModel productModel;
  private final Integer displayOrder;
  private final LocalDateTime dateCreated;

  private WishlistItemModel(ProductModel productModel, Integer displayOrder, LocalDateTime dateCreated) {
    this.productModel = productModel;
    this.displayOrder = displayOrder;
    this.dateCreated = dateCreated;
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
    private LocalDateTime dateCreated;

    public Builder withDisplayOrder(int displayOrder) {
      this.displayOrder = displayOrder;
      return this;
    }

    public Builder withProduct(ProductModel product) {
      this.productModel = product;
      return this;
    }

    public Builder withDateCreated(LocalDateTime dateCreated) {
      this.dateCreated = dateCreated;
      return this;
    }

    public WishlistItemModel build() {
      return new WishlistItemModel(productModel, displayOrder, dateCreated);
    }
  }
}
