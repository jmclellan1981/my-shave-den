package com.myshaveden.viewmodels;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ProductModel.Builder.class)
public class ProductModel {

  private final String id;
  private final String url;
  private final String imageSource;
  private final String productId;
  private final String productType;
  private final String site;
  private final String title;

  private ProductModel(String id, String url, String imageSource, String productId, String productType, String site,
      String title) {
    this.id = id;
    this.url = url;
    this.imageSource = imageSource;
    this.productId = productId;
    this.productType = productType;
    this.site = site;
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public String getUrl() {
    return url;
  }

  public String getImageSource() {
    return imageSource;
  }

  public String getProductId() {
    return productId;
  }

  public String getProductType() {
    return productType;
  }

  public String getSite() {
    return site;
  }

  public String getTitle() {
    return title;
  }

  @JsonPOJOBuilder
  public static class Builder {
    private String id;
    private String url;
    private String imageSource;
    private String productId;
    private String productType;
    private String site;
    private String title;

    public Builder withId(String id) {
      this.id = id;
      return this;
    }

    public Builder withUrl(String url) {
      this.url = url;
      return this;
    }

    public Builder withImageSource(String imageSource) {
      this.imageSource = imageSource;
      return this;
    }

    public Builder withProductId(String productId) {
      this.productId = productId;
      return this;
    }

    public Builder withProductType(String productType) {
      this.productType = productType;
      return this;
    }

    public Builder withSite(String site) {
      this.site = site;
      return this;
    }

    public Builder withTitle(String title) {
      this.title = title;
      return this;
    }

    public ProductModel build() {
      return new ProductModel(id, url, imageSource, productId, productType, site, title);
    }
  }
}
