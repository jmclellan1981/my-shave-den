package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.AppUser;
import com.myshaveden.domain.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, UUID> {

  VerificationToken findByToken(String verificationToken);

  VerificationToken findByUser(AppUser user);

}
