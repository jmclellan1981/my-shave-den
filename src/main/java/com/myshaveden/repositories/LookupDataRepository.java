package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.LookupData;

public interface LookupDataRepository extends JpaRepository<LookupData, UUID> {
  public LookupData findByDataName(String dataName);
}
