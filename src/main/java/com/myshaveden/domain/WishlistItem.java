package com.myshaveden.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class WishlistItem extends BaseEntity {

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "wishlist_id")
  private Wishlist wishlist;

  private int displayOrder;
  private boolean isActive;

  public Wishlist getWishlist() {
    return wishlist;
  }

  public void setWishlist(Wishlist wishlist) {
    this.wishlist = wishlist;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public int getDisplayOrder() {
    return displayOrder;
  }

  public void setDisplayOrder(int displayOrder) {
    this.displayOrder = displayOrder;
  }

  public boolean isActive() {
    return isActive;
  }

  public void setActive(boolean isActive) {
    this.isActive = isActive;
  }

}
