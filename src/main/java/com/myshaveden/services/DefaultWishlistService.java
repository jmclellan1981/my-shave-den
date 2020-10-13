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
import com.myshaveden.viewmodels.ImmutableProductModel;
import com.myshaveden.viewmodels.ImmutableWishlistItemModel;
import com.myshaveden.viewmodels.ImmutableWishlistModel;
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
    wishlistItem.setDisplayOrder(wishlistItemModel.displayOrder());
    Product product = findProduct(wishlistItemModel.product());
    wishlistItem.setProduct(product);
    appUser.getWishlist().getWishlistItems().add(wishlistItem);
    wishlistItem.setWishlist(appUser.getWishlist());
    userRepository.save(appUser);
  }

  private Product findProduct(ProductModel productModel) {
    Product product = null;
    if (productModel.id() != null) {
      product = productRepository.findById(UUID.fromString(productModel.id())).get();
    } else {
      product = new Product();
      product.setDescription(productModel.description());
      product.setImageSource(productModel.imageSource());
      product.setProductId(productModel.productId());
      product.setProductType(findLookupData(productModel.productType()));
      product.setSite(findLookupData(productModel.site()));
      product.setTitle(productModel.title());
      product.setUrl(productModel.url());
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
      ProductModel product = ImmutableProductModel.builder().description(item.getProduct().getDescription())
          .imageSource(item.getProduct().getImageSource()).productId(item.getProduct().getProductId())
          .productType(item.getProduct().getProductType().getDataName()).id(item.getProduct().getId().toString())
          .url(item.getProduct().getUrl()).site(item.getProduct().getSite().getDataName())
          .title(item.getProduct().getTitle()).build();
      WishlistItemModel itemModel = ImmutableWishlistItemModel.builder().displayOrder(item.getDisplayOrder())
          .product(product).build();
      wishlistItems.add(itemModel);
    }
    WishlistModel wishlistViewModel = ImmutableWishlistModel.builder().wishlistItems(wishlistItems).build();
    return wishlistViewModel;
  }

}
