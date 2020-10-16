package com.myshaveden.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class AppUser extends BaseEntity {
  private String email;
  private String password;
  private String username;
  private boolean enabled = false;

  public AppUser() {
    super();
    this.enabled = false;
  }

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
  private Wishlist wishlist;

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Wishlist getWishlist() {
    return wishlist;
  }

  public void setWishlist(Wishlist wishlist) {
    this.wishlist = wishlist;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

}
