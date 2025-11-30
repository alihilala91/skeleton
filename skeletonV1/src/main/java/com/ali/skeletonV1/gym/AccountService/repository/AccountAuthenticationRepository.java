package com.ali.skeletonV1.gym.AccountService.repository;

import com.ali.skeletonV1.gym.AccountService.entity.AccountAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountAuthenticationRepository extends JpaRepository<AccountAuthentication, Long> {
}
