package com.myshaveden.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myshaveden.services.WishlistService;
import com.myshaveden.viewmodels.WishlistItemModel;
import com.myshaveden.viewmodels.WishlistModel;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
  private WishlistService service;

  @Autowired
  public WishlistController(WishlistService service) {
    this.service = service;
  }

  @PostMapping("/item")
  public void addWishlistItem(Authentication auth, @RequestBody WishlistItemModel wishlistItem) {
    User user = (User) auth.getPrincipal();
    String username = user.getUsername();
    service.addWishListItem(username, wishlistItem);
  }

  @DeleteMapping("/item/{id}")
  public void deleteWishListItem(@PathVariable("id") String id) {
    service.deleteWishlistItem(id);
  }

  @GetMapping("/item/{site}/{productId}")
  public ResponseEntity<Boolean> itemExists(Authentication auth, @PathVariable("site") String site,
      @PathVariable("productId") String productId) {
    User user = (User) auth.getPrincipal();
    String username = user.getUsername();
    Boolean exists = service.itemExists(username, site, productId);
    return ResponseEntity.ok(exists);
  }

  @GetMapping
  public ResponseEntity<WishlistModel> findWishlist(Authentication auth) {
    User user = (User) auth.getPrincipal();
    String username = user.getUsername();
    WishlistModel wishlistViewModel = service.findWishlist(username);
    return ResponseEntity.ok(wishlistViewModel);
  }

}
