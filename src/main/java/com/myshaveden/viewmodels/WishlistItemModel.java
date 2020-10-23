package com.myshaveden.viewmodels;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = WishlistItemModel.Builder.class)
public class WishlistItemModel {
  private final ProductModel productModel;
  private final Integer displayOrder;
  private final LocalDateTime dateCreated;
  private final String id;

  private WishlistItemModel(ProductModel productModel, Integer displayOrder, LocalDateTime dateCreated, String id) {
    this.productModel = productModel;
    this.displayOrder = displayOrder;
    this.dateCreated = dateCreated;
    this.id = id;
  }

  public Integer getDisplayOrder() {
    return displayOrder;
  }

  public ProductModel getProductModel() {
    return productModel;
  }

  public LocalDateTime getDateCreated() {
    return dateCreated;
  }

  public String getId() {
    return id;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private ProductModel productModel;
    private Integer displayOrder;
    private LocalDateTime dateCreated;
    private String id;

    public Builder withDisplayOrder(int displayOrder) {
      this.displayOrder = displayOrder;
      return this;
    }

    public Builder withProductModel(ProductModel productModel) {
      this.productModel = productModel;
      return this;
    }

    public Builder withDateCreated(LocalDateTime dateCreated) {
      this.dateCreated = dateCreated;
      return this;
    }

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public WishlistItemModel build() {
      return new WishlistItemModel(productModel, displayOrder, dateCreated, id);
    }
  }
}
