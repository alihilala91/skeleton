package com.ali.skeletonV1.gym.AccountService.repository;

import com.ali.skeletonV1.gym.AccountService.entity.AccountRoleLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRoleLookupRepository extends JpaRepository<AccountRoleLookup, Integer> {
}
