package com.myshaveden.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product extends BaseEntity {
  private String url;
  private String imageSource;
  private String productId;
  @ManyToOne
  @JoinColumn(name = "product_type_id")
  private LookupData productType;

  @ManyToOne
  @JoinColumn(name = "site_id")
  private LookupData site;

  private String title;

  public LookupData getProductType() {
    return productType;
  }

  public void setProductType(LookupData productType) {
    this.productType = productType;
  }

  public LookupData getSite() {
    return site;
  }

  public void setSite(LookupData site) {
    this.site = site;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getImageSource() {
    return imageSource;
  }

  public void setImageSource(String imageSource) {
    this.imageSource = imageSource;
  }

  public String getProductId() {
    return productId;
  }

  public void setProductId(String productId) {
    this.productId = productId;
  }

}
