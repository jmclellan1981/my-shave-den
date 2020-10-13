package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.WishlistItem;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, UUID> {

}
