package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.MenuItem;

public interface MenuItemRepository extends JpaRepository<MenuItem, UUID> {

}
