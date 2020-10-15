package com.myshaveden.viewmodels;

public class ProductModel {

  private String id;
  private String url;
  private String imageSource;
  private String productId;
  private String productType;
  private String site;
  private String title;
  private String description;

  public void setId(String id) {
    this.id = id;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public void setImageSource(String imageSource) {
    this.imageSource = imageSource;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

  public void setProductType(String productType) {
    this.productType = productType;
  }

  public void setSite(String site) {
    this.site = site;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
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

  public String getDescription() {
    return description;
  }

  public static class Builder {
    private ProductModel model = new ProductModel();

    public Builder withId(String id) {
      model.id = id;
      return this;
    }

    public Builder withUrl(String url) {
      model.url = url;
      return this;
    }

    public Builder withImageSource(String imageSource) {
      model.imageSource = imageSource;
      return this;
    }

    public Builder withProductId(String productId) {
      model.productId = productId;
      return this;
    }

    public Builder withProductType(String productType) {
      model.productType = productType;
      return this;
    }

    public Builder withSite(String site) {
      model.site = site;
      return this;
    }

    public Builder withDescription(String description) {
      model.description = description;
      return this;
    }

    public Builder withTitle(String title) {
      model.title = title;
      return this;
    }

    public ProductModel build() {
      return model;
    }
  }
}
