package com.myshaveden.services;

import com.myshaveden.viewmodels.WishlistItemModel;
import com.myshaveden.viewmodels.WishlistModel;

public interface WishlistService {
  public void addWishListItem(String username, WishlistItemModel wishlistItem);

  public WishlistModel findWishlist(String username);

  public Boolean itemExists(String username, String site, String productId);

  public void deleteWishlistItem(String id);
}
