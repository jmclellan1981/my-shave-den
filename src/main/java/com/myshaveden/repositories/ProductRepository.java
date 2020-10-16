package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.LookupData;
import com.myshaveden.domain.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
  public Product findBySiteAndProductId(LookupData site, String prodcutId);
}
