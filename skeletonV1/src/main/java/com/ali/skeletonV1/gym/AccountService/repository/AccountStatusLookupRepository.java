package com.ali.skeletonV1.gym.AccountService.repository;

import com.ali.skeletonV1.gym.AccountService.entity.AccountStatusLookup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountStatusLookupRepository extends JpaRepository<AccountStatusLookup, String> {
}
