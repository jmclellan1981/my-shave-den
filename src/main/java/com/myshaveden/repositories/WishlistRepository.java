package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, UUID> {

}
