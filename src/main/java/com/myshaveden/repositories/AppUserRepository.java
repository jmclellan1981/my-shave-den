package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, UUID> {

  AppUser findByUsername(String username);

  AppUser findByEmail(String email);

}
