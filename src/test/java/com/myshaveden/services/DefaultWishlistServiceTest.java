package com.myshaveden.services;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.myshaveden.domain.AppUser;
import com.myshaveden.domain.LookupData;
import com.myshaveden.domain.Product;
import com.myshaveden.domain.Wishlist;
import com.myshaveden.domain.WishlistItem;
import com.myshaveden.repositories.AppUserRepository;
import com.myshaveden.repositories.LookupDataRepository;
import com.myshaveden.repositories.ProductRepository;
import com.myshaveden.viewmodels.ProductModel;
import com.myshaveden.viewmodels.WishlistItemModel;
import com.myshaveden.viewmodels.WishlistModel;

public class DefaultWishlistServiceTest {
  private DefaultWishlistService service;
  private final String MOCK_USERNAME = "MOCK_USERNAME";

  @BeforeEach
  public void setup() {
    service = new DefaultWishlistService(getUserRepository(), getProductRepository(), getLookupDataRepository());
  }

  private ProductRepository getProductRepository() {
    ProductRepository repo = Mockito.mock(ProductRepository.class);
    Product product = Mockito.mock(Product.class);
    Mockito.when(repo.findById(Mockito.any(UUID.class))).thenReturn(Optional.of(product));
    return repo;
  }

  private LookupDataRepository getLookupDataRepository() {
    LookupDataRepository repo = Mockito.mock(LookupDataRepository.class);
    LookupData data = Mockito.mock(LookupData.class);
    Mockito.when(data.getDataName()).thenReturn("TEST");
    Mockito.when(repo.findByDataName(Mockito.any(String.class))).thenReturn(data);
    return repo;
  }

  @Test
  public void testAddWishlistItem() {
    WishlistItemModel wishlistItem = Mockito.mock(WishlistItemModel.class);
    ProductModel productModel = Mockito.mock(ProductModel.class);
    Mockito.when(productModel.getId()).thenReturn(UUID.randomUUID().toString());
    Mockito.when(productModel.getImageSource()).thenReturn("TEST");
    Mockito.when(productModel.getProductId()).thenReturn(UUID.randomUUID().toString());
    Mockito.when(productModel.getProductType()).thenReturn("TEST");
    Mockito.when(productModel.getSite()).thenReturn("TEST");
    Mockito.when(productModel.getTitle()).thenReturn("TEST");
    Mockito.when(productModel.getUrl()).thenReturn("TEST");
    Mockito.when(wishlistItem.getProductModel()).thenReturn(productModel);
    service.addWishListItem(MOCK_USERNAME, wishlistItem);
  }

  @Test
  public void testAddWishlistItem_newProduct() {
    WishlistItemModel wishlistItem = Mockito.mock(WishlistItemModel.class);
    ProductModel productModel = Mockito.mock(ProductModel.class);
    Mockito.when(productModel.getId()).thenReturn(null);
    Mockito.when(productModel.getImageSource()).thenReturn("TEST");
    Mockito.when(productModel.getProductId()).thenReturn(UUID.randomUUID().toString());
    Mockito.when(productModel.getProductType()).thenReturn("TEST");
    Mockito.when(productModel.getSite()).thenReturn("TEST");
    Mockito.when(productModel.getTitle()).thenReturn("TEST");
    Mockito.when(productModel.getUrl()).thenReturn("TEST");
    Mockito.when(wishlistItem.getProductModel()).thenReturn(productModel);
    service.addWishListItem(MOCK_USERNAME, wishlistItem);
  }

  @Test
  public void testFindWishlist() {
    WishlistModel wishlist = service.findWishlist(MOCK_USERNAME);
    assertNotNull(wishlist);
  }

  private AppUserRepository getUserRepository() {
    AppUserRepository repository = Mockito.mock(AppUserRepository.class);
    AppUser user = Mockito.mock(AppUser.class);
    Wishlist wishlist = Mockito.mock(Wishlist.class);
    List<WishlistItem> wishlistItems = new ArrayList<>();
    Product product = Mockito.mock(Product.class);
    Mockito.when(product.getImageSource()).thenReturn("TEST");
    Mockito.when(product.getProductId()).thenReturn("TEST");
    LookupData productType = Mockito.mock(LookupData.class);
    Mockito.when(productType.getDataName()).thenReturn("TEST");
    Mockito.when(product.getProductType()).thenReturn(productType);
    Mockito.when(product.getSite()).thenReturn(productType);
    Mockito.when(product.getTitle()).thenReturn("TEST");
    Mockito.when(product.getUrl()).thenReturn("TEST");
    Mockito.when(product.getId()).thenReturn(UUID.randomUUID());
    for (int i = 0; i < 10; i++) {
      WishlistItem item = Mockito.mock(WishlistItem.class);
      Mockito.when(item.getDisplayOrder()).thenReturn(i);
      Mockito.when(item.getProduct()).thenReturn(product);
      wishlistItems.add(item);
    }
    Mockito.when(wishlist.getWishlistItems()).thenReturn(wishlistItems);
    Mockito.when(user.getWishlist()).thenReturn(wishlist);
    Mockito.when(repository.findByUsername(Mockito.matches(MOCK_USERNAME))).thenReturn(user);
    return repository;
  }
}
