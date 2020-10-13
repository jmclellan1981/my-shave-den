package com.myshaveden.controllers;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;

import com.myshaveden.services.WishlistService;
import com.myshaveden.viewmodels.ImmutableWishlistModel;
import com.myshaveden.viewmodels.WishlistItemModel;
import com.myshaveden.viewmodels.WishlistModel;

public class WishlistControllerTest {
  private WishlistController controller;
  private final String MOCK_USERNAME = "MOCK_USERNAME";

  @BeforeEach
  public void setup() {
    controller = new WishlistController(getMockWishlistService());
  }

  @Test
  public void testAddWishlistItem() {
    Authentication auth = Mockito.mock(Authentication.class);
    User user = Mockito.mock(User.class);
    Mockito.when(user.getUsername()).thenReturn(MOCK_USERNAME);
    Mockito.when(auth.getPrincipal()).thenReturn(user);
    WishlistItemModel wishlistItem = Mockito.mock(WishlistItemModel.class);
    controller.addWishlistItem(auth, wishlistItem);
  }

  @Test
  public void testFindWishlist() {
    Authentication auth = Mockito.mock(Authentication.class);
    User user = Mockito.mock(User.class);
    Mockito.when(user.getUsername()).thenReturn(MOCK_USERNAME);
    Mockito.when(auth.getPrincipal()).thenReturn(user);
    ResponseEntity<WishlistModel> response = controller.findWishlist(auth);
    assertNotNull(response);
  }

  private WishlistService getMockWishlistService() {
    return new WishlistService() {

      @Override
      public void addWishListItem(String username, WishlistItemModel wishlistItem) {
        // TODO Auto-generated method stub

      }

      @Override
      public WishlistModel findWishlist(String username) {
        WishlistModel model = ImmutableWishlistModel.builder().build();
        return model;
      }

    };
  }
}
