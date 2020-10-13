package com.myshaveden.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.myshaveden.domain.LookupType;

public interface LookupTypeRepository extends JpaRepository<LookupType, UUID> {

}
