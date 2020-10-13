package com.myshaveden.services;

import com.myshaveden.viewmodels.WishlistItemModel;
import com.myshaveden.viewmodels.WishlistModel;

public interface WishlistService {
  public void addWishListItem(String username, WishlistItemModel wishlistItem);

  public WishlistModel findWishlist(String username);
}
