package com.myshaveden.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Wishlist extends BaseEntity {
  @OneToOne(mappedBy = "wishlist")
  private AppUser user;

  @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL)
  private List<WishlistItem> wishlistItems;

  public AppUser getUser() {
    return user;
  }

  public void setUser(AppUser user) {
    this.user = user;
  }

  public List<WishlistItem> getWishlistItems() {
    return wishlistItems;
  }

  public void setWishlistItems(List<WishlistItem> wishlistItems) {
    this.wishlistItems = wishlistItems;
  }

}
