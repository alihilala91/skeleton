package com.ali.skeletonV1.gym.AccountService.repository;

import com.ali.skeletonV1.gym.AccountService.entity.AccountTypeLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTypeLookupRepository extends JpaRepository<AccountTypeLookup, Long> {
}
