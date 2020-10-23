package com.myshaveden.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.LookupData;
import com.myshaveden.domain.LookupType;

public interface LookupDataRepository extends JpaRepository<LookupData, UUID> {
  public LookupData findByDataName(String dataName);

  public List<LookupData> findDataByLookupType(LookupType lookupType);
}
