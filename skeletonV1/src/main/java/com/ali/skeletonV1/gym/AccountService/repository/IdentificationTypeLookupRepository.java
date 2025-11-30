package com.ali.skeletonV1.gym.AccountService.repository;

import com.ali.skeletonV1.gym.AccountService.entity.IdentificationTypeLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentificationTypeLookupRepository extends JpaRepository<IdentificationTypeLookup, Long> {
}
