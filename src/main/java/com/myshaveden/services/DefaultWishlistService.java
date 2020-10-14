package com.myshaveden.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myshaveden.domain.AppUser;
import com.myshaveden.domain.LookupData;
import com.myshaveden.domain.Product;
import com.myshaveden.domain.WishlistItem;
import com.myshaveden.repositories.AppUserRepository;
import com.myshaveden.repositories.LookupDataRepository;
import com.myshaveden.repositories.ProductRepository;
import com.myshaveden.viewmodels.ProductModel;
import com.myshaveden.viewmodels.WishlistItemModel;
import com.myshaveden.viewmodels.WishlistModel;

@Service
public class DefaultWishlistService implements WishlistService {

  private AppUserRepository userRepository;
  private ProductRepository productRepository;
  private LookupDataRepository lookupDataRepository;

  @Autowired
  public DefaultWishlistService(AppUserRepository userRepository, ProductRepository productRepository,
      LookupDataRepository lookupDataRepository) {
    this.userRepository = userRepository;
    this.productRepository = productRepository;
    this.lookupDataRepository = lookupDataRepository;
  }

  @Override
  public void addWishListItem(String username, WishlistItemModel wishlistItemModel) {
    AppUser appUser = userRepository.findByUsername(username);
    WishlistItem wishlistItem = new WishlistItem();
    wishlistItem.setDisplayOrder(wishlistItemModel.getDisplayOrder());
    Product product = findProduct(wishlistItemModel.getProduct());
    wishlistItem.setProduct(product);
    appUser.getWishlist().getWishlistItems().add(wishlistItem);
    wishlistItem.setWishlist(appUser.getWishlist());
    userRepository.save(appUser);
  }

  private Product findProduct(ProductModel productModel) {
    Product product = null;
    if (productModel.getId() != null) {
      product = productRepository.findById(UUID.fromString(productModel.getId())).get();
    } else {
      product = new Product();
      product.setDescription(productModel.getDescription());
      product.setImageSource(productModel.getImageSource());
      product.setProductId(productModel.getProductId());
      product.setProductType(findLookupData(productModel.getProductType()));
      product.setSite(findLookupData(productModel.getSite()));
      product.setTitle(productModel.getTitle());
      product.setUrl(productModel.getUrl());
    }
    return product;
  }

  private LookupData findLookupData(String dataName) {
    LookupData data = null;
    data = lookupDataRepository.findByDataName(dataName);
    return data;
  }

  @Override
  public WishlistModel findWishlist(String username) {
    AppUser appUser = userRepository.findByUsername(username);
    List<WishlistItemModel> wishlistItems = new ArrayList<>();
    for (WishlistItem item : appUser.getWishlist().getWishlistItems()) {
      ProductModel product = new ProductModel.Builder().withDescription(item.getProduct().getDescription())
          .withImageSource(item.getProduct().getImageSource()).withProductId(item.getProduct().getProductId())
          .withProductType(item.getProduct().getProductType().getDataName())
          .withId(item.getProduct().getId().toString()).withUrl(item.getProduct().getUrl())
          .withSite(item.getProduct().getSite().getDataName()).withTitle(item.getProduct().getTitle()).build();
      WishlistItemModel itemModel = new WishlistItemModel.Builder().withDisplayOrder(item.getDisplayOrder())
          .withProduct(product).build();
      wishlistItems.add(itemModel);
    }
    WishlistModel wishlistViewModel = new WishlistModel.Builder().withWishlistItems(wishlistItems).build();
    return wishlistViewModel;
  }

}
