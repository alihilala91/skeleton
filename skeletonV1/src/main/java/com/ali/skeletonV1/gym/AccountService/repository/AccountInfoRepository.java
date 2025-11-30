package com.ali.skeletonV1.gym.AccountService.repository;

import com.ali.skeletonV1.gym.AccountService.entity.AccountInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountInfoRepository extends JpaRepository<AccountInfo, Long> {
}
